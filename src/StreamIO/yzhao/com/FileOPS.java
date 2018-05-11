package StreamIO.yzhao.com;

import java.io.File;
import java.io.FileFilter;

public class FileOPS {
    public static void main(String[] args){
        String dirPath = "/home/yzhao_sherry";
        File dir = new File(dirPath);

        FileFilter fileFilter = file -> {
          if (file.isFile()){
              String filename = file.getName().toLowerCase();
              if (filename.endsWith(".py")){
                  return false;
              }
          }
          return true;
        };

        File[] list = dir.listFiles(fileFilter);

        for (File f: list){
            if(f.isFile()){
                System.out.println(f.getPath() + " (File) ");
            }else if(f.isDirectory()){
                System.out.println(f.getPath() + " (Directory)");
            }
        }
    }
}
