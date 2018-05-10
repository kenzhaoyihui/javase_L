package thread.redhat.com;

public class ThreadDaemon {
    public static void main(String[] args){
        Thread t = new Thread(() -> {
            print();
        });
        t.setDaemon(true);
        t.start();
//        try{
//            t.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        System.out.println(t.isDaemon());
        System.out.println("Exiting the main method...");
    }

    public static void print(){
        int count = 1;
        while (true){
            try{
                System.out.println("Count: " + count++);
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
