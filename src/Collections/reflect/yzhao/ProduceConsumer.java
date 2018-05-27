package Collections.reflect.yzhao;

import java.util.Random;

public class ProduceConsumer {
    public static void main(String[] args){
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}


class Producer extends Thread{
    private Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //super.run();
        Random rand = new Random();
        while(true){
            int n = rand.nextInt();
            buffer.produce(n);
        }
    }
}

class Consumer extends Thread{
    private Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //super.run();
        while (true){
            int data;
            data = buffer.consum();
        }
    }
}

class Buffer{
    private int data;
    private boolean empty;

    public Buffer(){
        this.empty = true;
    }

    public synchronized void produce(int newData){
        while(!this.empty){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        this.data = newData;
        this.empty = false;
        this.notify();

        System.out.println("Produced: " + newData);
    }

    public synchronized int consum(){
        while(this.empty){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            this.empty = true;
            this.notify();
            System.out.println("Consumed: " + data);
            //return data;
        }
        return data;
    }
}
