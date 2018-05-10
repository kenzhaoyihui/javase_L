package thread.redhat.com;

public class ThreadInterrup {
    public static void main(String[] args){
        Thread t = new Thread(ThreadInterrup::run);
        t.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t.interrupt();
    }

    public static void run(){
        int count = 0;
        while(!Thread.interrupted()){
            count++;
            System.out.println("Count: " + count);
        }

        System.out.println("End Count: " + count);
    }
}
