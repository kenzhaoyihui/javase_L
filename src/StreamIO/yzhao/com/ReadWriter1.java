package StreamIO.yzhao.com;

import java.io.*;

public class ReadWriter1 {
    public static void main(String[] args){
        String filename = "test3.txt";

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.append("test1");
            bw.newLine();
            bw.append("zyh");
            bw.append(" lj");
            bw.newLine();
            bw.append("xx");
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String text = null;
            while ((text = br.readLine()) != null){
                System.out.println(text);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
