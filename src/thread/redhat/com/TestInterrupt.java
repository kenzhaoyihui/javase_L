package thread.redhat.com;

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("#1: " + Thread.interrupted());

        Thread t = Thread.currentThread();
        t.interrupt();

        //System.out.println("#2: " + Thread.interrupted());

        System.out.println("#3: " + t.isInterrupted());


        //First Thread.interrupted is true and the later neither Thread.interrupted and t.isInterrupted is false
        System.out.println("#4: " + Thread.interrupted());

        System.out.println("##4: " + Thread.interrupted());

        System.out.println("#5: " + t.isInterrupted());



        System.out.println("--------------------------------");

        Thread thread = new Thread(TestInterrupt::run);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();

    }

    public static void run(){
        int count = 0;
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("Count: " + count++);
            }catch (InterruptedException e){
                System.out.println("I am interrupted!");
                break;
            }
        }
    }
}
