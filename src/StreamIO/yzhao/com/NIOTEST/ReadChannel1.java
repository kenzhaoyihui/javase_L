package StreamIO.yzhao.com.NIOTEST;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadChannel1 {

    public static void main(String[] args){
        File file = new File("test1.txt");
        if (!(file.exists())){
            System.out.println("File is not exists");
            return;
        }

        try(FileChannel fileChannel = new FileInputStream(file).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while(fileChannel.read(buffer) > 0){
                buffer.flip();
                while(buffer.hasRemaining()){
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                buffer.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
