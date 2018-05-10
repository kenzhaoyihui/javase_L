package thread.redhat.com;

public class Valatile1 extends Thread{
    //关键字volatile可以保持线程的工作内存中的变量值与它们在主存储器中的值同步
    private volatile boolean keepRunning = true;

    @Override
    public void run() {
        //super.run();
        System.out.println("Thread starting...");
        while(keepRunning){
            try{
                System.out.println("Going to sleep...");
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Thread stop...");
    }

    public void stopThread(){
        this.keepRunning = false;
    }

    public static void main(String[] args) throws InterruptedException{
        Valatile1 v = new Valatile1();
        v.start();

        Thread.sleep(3000);
        System.out.println("Sleep flag is true, please set false!");
        v.stopThread();
    }
}

