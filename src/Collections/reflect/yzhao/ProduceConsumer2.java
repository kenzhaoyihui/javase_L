package Collections.reflect.yzhao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class ProduceConsumer2 {
    public static void main(String[] args){
        final Queue sharedQ = new LinkedList();

        Producer1 producer1 = new Producer1(sharedQ);
        Consumer1 consumer1 = new Consumer1(sharedQ);

        producer1.start();
        consumer1.start();
    }



}

class Consumer1 extends Thread{
    //private static final Logger logger = LogManager.getLogger(Consumer1.class);

    private final Queue sharedQ;


    public Consumer1(Queue sharedQ){
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        //super.run();

        while (true){
            synchronized (sharedQ){
                while(sharedQ.size() == 0){
                    try{
                        //logger.debug("Queue is empty, waiting");
                        System.out.println("Queue is empty, waiting...");
                        sharedQ.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                Integer number = (Integer) sharedQ.poll();
                //logger.debug("Consuming :" + number);
                System.out.println("Consuming: " + number);

                sharedQ.notify();

                if(number == 3){break;}
            }
        }
    }
}


class Producer1 extends Thread{
    //private static final Logger logger = LogManager.getLogger(Producer1.class);
    private final Queue sharedQ;

    public Producer1(Queue sharedQ){
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        //super.run();
        for (int i=0;i<4;i++){
            synchronized (sharedQ){
                while(sharedQ.size() >= 1){
                    try{
                        //logger.debug("Queue is full, waiting");
                        System.out.println("Queue is full, waiting...");
                        sharedQ.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //logger.debug("Produce: " + i);
                System.out.println("Produce: " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}
