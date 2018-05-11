package StreamIO.yzhao.com;

import java.io.*;

/**
 * InputStream
 * -- FileInputStream
 * -- ByteArrayInputStream
 * -- PipedInputStream
 * -- FilterInputStream
 * -- BufferedInputStream
 * -- PushbackInputStream
 * -- DataInputStream
 * -- ObjectInputStream
 *
 * @author kenzhaoyihui
 */

public class InputStream1 {
    public static void main(String[] args) throws IOException{
        String name = "test1.txt";

        try{
            FileInputStream fin = new FileInputStream(name);

            byte byteData;

            while((byteData = (byte) fin.read()) != -1){
                System.out.print((char) byteData);
            }

            fin.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("\n----------------------------------");
        try{
            BufferedInputStream fin1 = new BufferedInputStream(new FileInputStream(name));

            byte byteData;

            while((byteData = (byte) fin1.read()) != -1){
                System.out.print((char) byteData);
            }

            fin1.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("\n----------------------------------");
        try{
            PushbackInputStream fin2 = new PushbackInputStream(new FileInputStream(name));

            byte byteData;

            while((byteData = (byte) fin2.read()) != -1){
                System.out.print((char) byteData);
                fin2.unread(byteData);
                byteData = (byte) fin2.read();
                System.out.print((char) byteData);
            }

            fin2.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
