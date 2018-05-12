package StreamIO.yzhao.com;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.FilterReader;
import java.io.IOException;

class LowerCaseReader extends FilterReader {
    public LowerCaseReader(Reader in) {
        super(in);
    }
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int count = super.read(cbuf, off, len);
        if (count != -1) {
            // Convert all read characters to lowercase
            int limit = off + count;
            for (int i = off; i < limit; i++) {
                cbuf[i] = Character.toLowerCase(cbuf[i]);
            }
        }
        return count;
    }
}
public class ReadWriter2 {
    public static void main(String[] args) throws Exception {
        String fileName = "test3.txt";
        LowerCaseReader lcr = new LowerCaseReader(new FileReader(fileName));
        int c = -1;
        while ((c = lcr.read()) != -1) {
            System.out.print((char) c);
        }
        lcr.close();

        System.out.println("\n=========================");
        BufferedReader br = new BufferedReader(new LowerCaseReader(new FileReader(
                fileName)));
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();
    }
}