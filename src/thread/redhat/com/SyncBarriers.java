package thread.redhat.com;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Barrier extends Thread{
    private CyclicBarrier c;
    private int id;
    private final static Random random = new Random();

    public Barrier(CyclicBarrier c, int id){
        this.c  = c;
        this.id = id;
    }

    @Override
    public void run() {
        //super.run();
        int workTime = random.nextInt(30) + 1;
        try{
            System.out.println("Worker #" + id + " is trying to get a work...");
            Thread.sleep(workTime * 100);
            this.c.await();
            System.out.println("Worker #" + id + " finish the work");
        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}

public class SyncBarriers {
    public static void main(String[] args){
        Runnable runnable = () -> {
            for(int i=0; i<5; i++){
                System.out.println("Work finish");
            }
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, runnable);

        for (int i=1;i<=20;i++){
            Barrier barrier = new Barrier(cyclicBarrier, i);
            barrier.start();
        }
    }
}
