package Collections.reflect.yzhao;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueProduceConsumer {
    public static void main(String[] args){
        int capacity = 5;
        boolean fair = true;
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(capacity, fair);

        new BQProducer1(queue, "Producer1").start();
        new BQProducer1(queue, "Producer2").start();
        new BQProducer1(queue, "Producer3").start();

        new BQConsumer1(queue, "Consumer1").start();
        new BQConsumer1(queue, "Consumer2").start();
        new BQConsumer1(queue, "Consumer3").start();
    }
}

class BQProducer1 extends Thread{
    private final BlockingQueue<String> queue;

    private final String name;

    public BQProducer1(BlockingQueue<String> queue, String name){
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        //super.run();
        while(true){
            try{
                this.queue.put(UUID.randomUUID().toString());
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}

class BQConsumer1 extends Thread{
    private final BlockingQueue<String> queue;

    private final String name;

    public BQConsumer1(BlockingQueue<String> queue, String name){
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        //super.run();
        while(true){
            try{
                String str = this.queue.take();
                System.out.println(name + " took: " + str);
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
