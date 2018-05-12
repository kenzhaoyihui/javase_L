package StreamIO.yzhao.com;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class StreamTokenizer1 {

    public static void main(String[] args){
        String str = "This is a test, 2000.89 which is simple 50";
        StringReader read = new StringReader(str);

        StreamTokenizer st = new StreamTokenizer(read);

        try{
            while (st.nextToken() != StreamTokenizer.TT_EOF){
                switch (st.ttype){
                    case StreamTokenizer.TT_WORD:
                        System.out.println("String value: " + st.sval);
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Number value: " + st.nval);
                        break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
