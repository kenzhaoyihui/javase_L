package StreamIO.yzhao.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStream1 {
    public static void main(String[] args) {
        String destFile = "test2.txt";

        try (PrintStream ps = new PrintStream(destFile)) {
            ps.println("test");
            ps.println("test1");
            ps.println("test2");
            ps.print("test3");

            // flush the print stream
            ps.flush();

            System.out.println("Text has  been  written to "
                    + (new File(destFile).getAbsolutePath()));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
