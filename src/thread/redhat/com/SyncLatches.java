package thread.redhat.com;

import java.util.concurrent.CountDownLatch;

class LatchHelperService extends Thread{
    private int id;
    private CountDownLatch latch;

    public LatchHelperService(int id, CountDownLatch latch){
        this.id = id;
        this.latch = latch;
    }

    public void run(){
        try{
            Thread.sleep(3000);
            System.out.println("Service #" + id + " has started...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            this.latch.countDown();
        }
    }
}

class LatchMainService extends Thread{
    private CountDownLatch latch;

    public LatchMainService(CountDownLatch latch){
        this.latch = latch;
    }

    public void run(){
        try{
            System.out.println("waiting for services to start.");
            this.latch.await();
            System.out.println("Started.");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


public class SyncLatches {
    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(30);
        LatchMainService ms = new LatchMainService(latch);

        ms.start();

        for(int i=0;i<=30;i++){
            LatchHelperService hs = new LatchHelperService(i, latch);
            hs.start();
        }

    }
}
