package StreamIO.yzhao.com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream1 {
    public static void main(String[] args){
        String fileName = "test1.txt";

        String lineSepartor = System.getProperty("line.separator");
        String line = "test";
        String line1 = "test1";
        String line2 = "test2";

        try {
            FileOutputStream start1 = new FileOutputStream(fileName);
            start1.write(line.getBytes());
            start1.write(lineSepartor.getBytes());
            start1.write(line1.getBytes());
            start1.write(lineSepartor.getBytes());
            start1.write(line2.getBytes());
            start1.write(lineSepartor.getBytes());
            start1.flush();
            start1.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
