package nowcode_hw;

import java.util.Scanner;

public class hw_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().toUpperCase();
        char c = scanner.next().toUpperCase().charAt(0);

        int i = num(str, c);
        System.out.println(i);
    }

    public static int num(String s1, char c) {
        int count = 0;
        if (s1 != null && s1.length()>0) {
            for(int i=0; i<s1.length(); i++) {
                if (c==s1.charAt(i)){
                    count++;
                }
            }
        }else{
            count = 0;
        }
        return count;
    }
}
