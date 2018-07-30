package thread.redhat.com.ccs;

import java.util.concurrent.CountDownLatch;

public class Countdownlatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread() {
            public void run() {
                try {
                    System.out.println("Child thread: " + Thread.currentThread().getName() + " is working");
                    Thread.sleep(3000);
                    System.out.println("Child thread: " + Thread.currentThread().getName() + " is finished");
                    latch.countDown();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();


        new Thread() {
            public void run() {
                try {
                    System.out.println("Child thread " + Thread.currentThread().getName() + " is working");
                    Thread.sleep(3000);
                    System.out.println("Child thread " + Thread.currentThread().getName() + " is finished");
                    latch.countDown();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();


        try {
            System.out.println("Wait for the 2 threads finished...");
            latch.await();
            System.out.println("2 threads are finished");
            System.out.println("Continue to execute the main thread");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
