package transient1;

public class testvolatile {
    static volatile int i;

    public static void main(String[] args){
        i = 10;

        System.out.println("I: " + i);
    }
}

