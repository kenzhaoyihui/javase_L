package StreamIO.yzhao.com.NIOTEST;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteChannel1 {
    public static void main(String[] args){
        File file = new File("test4.txt");

        try(FileChannel fileChannel = new FileOutputStream(file).getChannel()){

            String text = getText();

            byte[] byteData = text.getBytes("UTF-8");

            ByteBuffer buffer = ByteBuffer.wrap(byteData);

            fileChannel.write(buffer);

        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            FileChannel sourceChannel = new FileInputStream("test4.txt").getChannel();
            FileChannel sinkChannel = new FileOutputStream("test4copy.txt").getChannel();

            sourceChannel.transferTo(0, sourceChannel.size(), sinkChannel);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getText(){
        String lineSeparator = System.getProperty("line.separator");

        StringBuilder sb = new StringBuilder();

        sb.append("text1");
        sb.append(lineSeparator);

        sb.append("text2");
        sb.append(lineSeparator);

        sb.append("text5");
        sb.append(lineSeparator);

        return sb.toString();



    }
}
