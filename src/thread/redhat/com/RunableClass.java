package thread.redhat.com;

class RunableImpl implements Runnable{

    private Thread t;
    private  String threadName;

    public RunableImpl(String name){
        this.threadName = name;
        System.out.println("Creating: " + this.threadName);
    }


    @Override
    public void run() {
        System.out.println("Running: " + threadName);
        try{
            for(int i=5; i>0;i--){
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("Thread " + threadName + " interrupted " + e.getMessage() );
        }

        System.out.println("Thread " + threadName + " exiting");
    }


    public void start(){
        System.out.println("Starting " + threadName);
        if (t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class RunableClass {
    public static void main(String[] args){
        RunableImpl r =  new RunableImpl("Thread-1");
        r.run();

        RunableImpl r1 = new RunableImpl("Thread-2");
        r1.run();
    }
}
