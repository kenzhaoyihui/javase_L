package thread.redhat.com;

public class Thread1 {
    private static int myValue = 1;

    public static void main(String[] args){
        Thread t = new Thread(() -> {
            while (true){
                updateBalance();
            }
        });

        t.start();

        Thread t1 = new Thread(() -> {
            while(true){
                monitorBalance();
            }
        });

        t1.start();
    }

    public static synchronized void updateBalance(){
        System.out.println("Start: " + myValue);
        myValue += 1;
        myValue -= 1;
        System.out.println("End: " + myValue);
    }

    public static synchronized void monitorBalance(){
        int b = myValue;
        if (b != 1){
            System.out.println("Balance changed: " + b);
            System.exit(1);
        }
    }
}
