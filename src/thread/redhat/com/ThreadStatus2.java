package thread.redhat.com;

//public class ThreadStatus2 extends Thread {
//    private volatile boolean keepRunning = true;
//    private boolean supended = false;
//
//    public synchronized void stopThread(){
//        this.keepRunning = false;
//        //this.notify();
//    }
//
//    public synchronized void supendThread(){
//        this.supended = true;
//    }
//
//    public synchronized void resumeThread(){
//        this.supended = false;
//        this.notify();
//    }
//
//    @Override
//    public void run() {
//        //super.run();
//        System.out.println("Thread starting...");
//        while(keepRunning){
//            try{
//                System.out.println("Going to sleep...");
//                Thread.sleep(1000);
//                synchronized (this){
//                    while(supended){
//                        System.out.println("Supended...");
//                        this.wait();
//                        System.out.println("Resume...");
//                    }
//                }
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static void main(String[] args) throws InterruptedException{
//        ThreadStatus2 threadStatus2 = new ThreadStatus2();
//        threadStatus2.start();
//        Thread.sleep(5000);
//
//        threadStatus2.supendThread();
//        Thread.sleep(5000);
//
//        threadStatus2.resumeThread();
//        Thread.sleep(5000);
//
//        threadStatus2.stopThread();
//
//
//    }
//}


public class ThreadStatus2 extends Thread{
    private volatile boolean keepRunning = true;
    private volatile boolean supended = false;

    public synchronized void stopThread(){
        this.keepRunning = false;
    }

    public synchronized void supendThread(){
        this.supended = true;
    }

    public synchronized void resumeThread(){
        this.supended = false;
        this.notify();
    }

    @Override
    public void run() {
        //super.run();
        System.out.println("Thread starting...");
        while(keepRunning){
            try{
                System.out.println("Hello lj!");
                Thread.sleep(1000);
                synchronized (this){
                    while(supended){
                        System.out.println("Thread supended...");
                        this.wait();
                        System.out.println("Thread resume...");
                    }
                }
//                while(supended){
//                        System.out.println("Thread supended...");
//                        this.wait();
//                        System.out.println("Thread resume...");
//                    }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Thread stoped...");
    }

    public static void main(String[] args) throws InterruptedException{
        ThreadStatus2 threadStatus2 = new ThreadStatus2();
        threadStatus2.start();
        Thread.sleep(2000);

        threadStatus2.supendThread();
        Thread.sleep(2000);

        threadStatus2.resumeThread();
        Thread.sleep(2000);

        threadStatus2.stopThread();


    }


}