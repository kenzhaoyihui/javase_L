package Collections.reflect.yzhao;

//import sun.util.resources.cldr.te.TimeZoneNames_te;
//
//import java.util.concurrent.LinkedTransferQueue;
//import java.util.concurrent.TransferQueue;
//import java.util.concurrent.atomic.AtomicInteger;
//
//class TQProducer extends Thread{
//    private String name;
//    private TransferQueue<Integer> tQueue;
//    private AtomicInteger sequence;
//
//    public TQProducer(String name, TransferQueue<Integer> tQueue, AtomicInteger sequence){
//        this.name = name;
//        this.tQueue = tQueue;
//        this.sequence = sequence;
//    }
//
//    @Override
//    public void run() {
//        //super.run();
//        while (true){
//            try{
//                Thread.sleep(4000);
//                int nextNum = this.sequence.incrementAndGet();
//                if (nextNum % 2 == 0){
//                    System.out.format("%s:  Enqueuing: %d%n", name, nextNum);
//                    tQueue.put(nextNum);
//                }else{
//                    System.out.format("%s: Handing off: %d%n", name, nextNum);
//                    System.out.format("%s: has a waiting consumer: %b%n", name, tQueue.hasWaitingConsumer() );
//                    tQueue.transfer(nextNum);
//                }
//
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class TQConsumer extends Thread{
//    private final String name;
//    private final TransferQueue<Integer> tQueue;
//
//    public TQConsumer(String name, TransferQueue<Integer> tQueue){
//        this.name = name;
//        this.tQueue = tQueue;
//    }
//
//    @Override
//    public void run() {
//        //super.run();
//        while (true){
//            try{
//                Thread.sleep(3000);
//                int item = tQueue.take();
//                System.out.format("%s removed: %d%n, name, item");
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//
//public class TransferQueue1 {
//    public static void main(String[] args){
//        final TransferQueue<Integer> transferQueue = new LinkedTransferQueue<>();
//        final AtomicInteger sequence = new AtomicInteger();
//
//        for(int i=0; i<10; i++){
//            try{
//                transferQueue.put(sequence.incrementAndGet());
//                System.out.println("Initial queue: " + transferQueue);
//
//                new TQProducer("Producer-1", transferQueue, sequence).start();
//                new TQConsumer("Consumer-1", transferQueue).start();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}


import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

class TQProducer extends Thread {
    private String name;
    private TransferQueue<Integer> tQueue;
    private AtomicInteger sequence;
    public TQProducer(String name, TransferQueue<Integer> tQueue,
                      AtomicInteger sequence) {
        this.name = name;
        this.tQueue = tQueue;
        this.sequence = sequence;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(4000);
                int nextNum = this.sequence.incrementAndGet();
                if (nextNum % 2 == 0) {
                    System.out.format("%s:  Enqueuing: %d%n", name, nextNum);
                    tQueue.put(nextNum); // Enqueue
                } else {
                    System.out.format("%s: Handing  off: %d%n", name, nextNum);
                    System.out.format("%s: has  a  waiting  consumer: %b%n", name,
                            tQueue.hasWaitingConsumer());
                    tQueue.transfer(nextNum); // A hand off
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TQConsumer extends Thread {
    private final String name;
    private final TransferQueue<Integer> tQueue;

    public TQConsumer(String name, TransferQueue<Integer> tQueue) {
        this.name = name;
        this.tQueue = tQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);

                int item = tQueue.take();
                System.out.format("%s removed:  %d%n", name, item);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TransferQueue1 {
    public static void main(String[] args) {
        final TransferQueue<Integer> tQueue = new LinkedTransferQueue<>();
        final AtomicInteger sequence = new AtomicInteger();

        for (int i = 0; i < 5; i++) {
            try {
                tQueue.put(sequence.incrementAndGet());
                System.out.println("Initial queue: " + tQueue);

                new TQProducer("Producer-1", tQueue, sequence).start();
                new TQConsumer("Consumer-1", tQueue).start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}