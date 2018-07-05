package nowcode_hw;

import java.util.Scanner;

public class hw_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        findlastword(s);
    }

    public static void findlastword(String s) {
        String[] str = s.split(" ");
        int length = str.length;
        System.out.println(str[length-1].length());
    }
}
