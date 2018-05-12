package StreamIO.yzhao.com;

import java.io.*;

public class RedirectInStream {
    public static void main(String[] args) throws Exception{
//        File outFile = new File("stdout.txt");
//        PrintStream ps = new PrintStream(new FileOutputStream(outFile));
//        System.out.println(outFile.getAbsolutePath());
//
//        System.setOut(ps);
//
//        System.out.println("hello world");
//        System.out.println("java i/o is cool");

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = "q";
        while (true){
            System.out.println("Please input the words: ");
            text = br.readLine();
            if (text.equalsIgnoreCase("q")){
                System.out.println("Exit");
                break;
            }else{
                System.out.println("We typed: " + text);
            }
        }
        */

        Console console = System.console();
        if(console != null){
            console.printf("Console is available");
        }else{
            System.out.println("Console is not available");
            return;
        }

        String username = console.readLine("Username: ");
        char[] passChars = console.readPassword("Password: ");
        String passString = new String(passChars);

        if (passString.equals("admin")){
            console.printf("Hello %s", username);
        }else{
            console.printf("Invalid passworld");
        }
    }
}
