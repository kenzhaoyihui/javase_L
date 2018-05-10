package thread.redhat.com;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

class ExchangeProducer extends Thread{
    private Exchanger<ArrayList<Integer>> exchanger;
    private ArrayList<Integer> buffer = new ArrayList<>();

    public ExchangeProducer(Exchanger<ArrayList<Integer>> exchanger){
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        //super.run();
        while(true){
            try{
                System.out.println("Producerrrrrrrrrr");
                Thread.sleep(1000);
                fillBuffer();
                System.out.println("Producer has produced and waiting: " + buffer);
                buffer = exchanger.exchange(buffer);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void fillBuffer(){
        for (int i=0;i<=3;i++){
            buffer.add(i);
        }
    }
}

class ExchangeConsumer extends Thread{
    private Exchanger<ArrayList<Integer>> exchanger;
    private ArrayList<Integer> buffer = new ArrayList<>();

    public ExchangeConsumer(Exchanger<ArrayList<Integer>> exchanger){
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        //super.run();
        while(true){
            try{
                System.out.println("Consumerrrrrrrrrrrrrrrrr");
                buffer = exchanger.exchange(buffer);
                System.out.println("Consumer has received: " + buffer);
                Thread.sleep(1000);
                System.out.println("eating: " + buffer);
                buffer.clear();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


public class SyncExchangers {
    public static void main(String[] args){
        Exchanger<ArrayList<Integer>> exchanger = new Exchanger<>();
        ExchangeProducer producer = new ExchangeProducer(exchanger);
        ExchangeConsumer consumer = new ExchangeConsumer(exchanger);

        producer.start();
        consumer.start();
    }
}
