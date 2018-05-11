package StreamIO.yzhao.com;


import java.io.File;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws IOException{
        File dumpFile = new File("test1.txt");
        boolean fileExists = dumpFile.exists();

        boolean fileCreated = dumpFile.createNewFile();

        System.out.println(fileCreated);
        //dumpFile.delete();

        dumpFile = new File("/home/yzhao_sherry/1.py");
        boolean fileExists2 = dumpFile.exists();

        System.out.println(fileExists + " , " + fileExists2);
    }

}
