package thread.redhat.com;

import java.util.Random;

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
        int data;
        while(true){
            data = buffer.consumer();
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

    public synchronized int consumer(){
        while(this.empty){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        this.empty = true;
        this.notify();

        System.out.println("Consumed: " + data);
        return data;
    }

}


public class PSClass {
    public static void main(String [] args){
        Buffer buffer = new Buffer();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}
