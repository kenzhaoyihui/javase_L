package StreamIO.yzhao.com;

import java.util.Scanner;

public class Scanner1 {
    public static int operate(int i, int j, String operation){
        switch (operation){
            case "+":
                return i+j;
            case "-":
                return i-j;
            case "*":
                return i*j;
            case "/":
                return i/j;
//                default:
//                    System.out.println("Fuck");
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println("Please input your words: ");
        Scanner scanner = new Scanner(System.in);

        int n1 = 0;
        int n2 = 0;
        String operation = null;
        while(true){
            try{
                n1 = scanner.nextInt();
                operation = scanner.next();
                n2 = scanner.nextInt();

                int result = operate(n1, n2, operation);
                System.out.printf("%d %s %d = %d", n1, operation, n2, result);
            }catch (Exception e){
                System.out.println("An invalid expression.");
            }
        }

    }
}
