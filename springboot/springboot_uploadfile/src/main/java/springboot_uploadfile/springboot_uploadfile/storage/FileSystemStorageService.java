package springboot_uploadfile.springboot_uploadfile.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void init() {

        try {
            // 创建上传目录
            Files.createDirectories(rootLocation);
        }catch (IOException e) {
            //e.printStackTrace();
            throw new StorageException("Couldn't initialize storage", e);
        }
    }

    @Override
    public Path load(String filename) {
        //return null;
        /**
         * rootLocation is the root directory
         * filename is the file in the root directory
         */
        // 组合一个新的 Path 对象, 如: filename = "gus" rootLocation="a/b", 执行后结果为 "a/b/gus"
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        //return null;
        try {
            Path file = load(filename);
            // file.toUri 将 Path 转换为 uri
            // 如: path = "upload-dir/1.jpg" toUrl 后结果为 "file:///home/maiyo/project/upload-files/upload-dir/1.jpg"
            // 通过 UrlResource 创建一个 Srping Resource 对象
            Resource resource = new UrlResource(file.toUri());

            // 判断资源是否存在与可读
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }else {
                throw new StorageFileNotFoundException("Couldn't read file" + filename);
            }
        }catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Couldn't read file" + filename, e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        //return null;

        // 通过给定的目录和深度来遍历，返回 Stream (集合中包含给定的路径)
        // filter 过滤掉指定的路径
        // map 将路径处理为相对路径，如: rootLocation = "a/b" path = "a/b/c/img.png" relativize 后，结果为 "c/img.png"
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
            /**
             * Path p1 = Paths.get("/home/yzhao_sherry/work1/")
             * Path p2 = Paths.get("/home/yzhao_sherry/work2/")
             * System.out.println(p1.relativize(p2));  --> p1 to p2  ("../work2")
             * System.out.println(p2.relativize(p1));  --> p2 to p1  ("../work1")
             *
             */
        }catch (IOException e){
            throw new StorageException("Failed to read stored files", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                //throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
                throw new StorageException("Failed to store empty file " + filename);
            }

            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException("Cannot store file with relative path outside current directory " + filename);
            }
            // 从 file 输入流复制到目标位置
            //Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            //throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
            throw new StorageException("Failed to store file " + filename, e);
        }

    }

    @Override
    public void deleteAll() {
        // 删除该目录下所有文件
        FileSystemUtils.deleteRecursively(rootLocation.toFile());

    }
}
