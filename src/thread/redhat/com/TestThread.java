package thread.redhat.com;

class ThreadDemo extends Thread{
    private Thread t;
    private String threadName;

    public ThreadDemo(String name){
        this.threadName = name;
        System.out.println("Creating Thread: " + threadName);
    }

    @Override
    public void run() {
        //super.run();
        System.out.println("Running the Thread: " + threadName);
        try{
            for(int i=5;i>0; i--){
                System.out.println("Thread: " + threadName +" , " + i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("Thread interrupted: " + threadName + " , " + e.getMessage());
        }

        System.out.println("Thread exiting: " + threadName);

    }

//    public void start(){
//        System.out.println("Starting :" + threadName);
//        if (t == null){
//            t = new Thread(this, threadName);
//            t.start();
//        }
//    }
}

public class TestThread {
    public static void main(String[] args){
        ThreadDemo t1 = new ThreadDemo("Thread-1");
        t1.start();

        ThreadDemo t2 = new ThreadDemo("Thread-2");
        t2.start();
    }
}
