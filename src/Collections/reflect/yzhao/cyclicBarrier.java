package Collections.reflect.yzhao;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Worker extends Thread {
    private CyclicBarrier barrier;
    private int ID;
    private static Random random = new Random();

    public Worker(int ID, CyclicBarrier barrier) {
        this.ID = ID;
        this.barrier = barrier;
    }
    public void run() {
        try {
            int workTime = random.nextInt(30) + 1;
            System.out.println("Thread #" + ID + " is going to work for " + workTime + "  seconds");
            Thread.sleep(workTime * 1000);
            System.out.println("Thread #" + ID + " is waiting at the barrier.");
            this.barrier.await();
            System.out.println("Thread #" + ID + " passed the barrier.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Barrier is broken.");
        }
    }

}
public class cyclicBarrier {
    public static void main(String[] args) {
        Runnable barrierAction = () -> System.out.println("We are ready.");
        CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);
        for (int i = 1; i <= 3; i++) {
            Worker t = new Worker(i, barrier);
            t.start();
        }
    }
}
