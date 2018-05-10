package thread.redhat.com;


import java.util.Random;
import java.util.concurrent.Semaphore;

class Restaurant{
    private Semaphore tables;

    public Restaurant(int tableCount){
        this.tables = new Semaphore(tableCount);
    }

    public void getTable(int customerID){
        try{
            System.out.println("Customer #" + customerID + " is trying to get a table");
            tables.acquire();
            System.out.println("Customer #" + customerID + " got a table");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void returnTable (int customerID){
        System.out.println("Customer #" + customerID + " returned a table");
        tables.release();
    }
}


class SyncSemaphores1 extends Thread{
    private Restaurant r;
    private int customerId;
    private static final Random random = new Random();

    public SyncSemaphores1(Restaurant r, int customerId){
        this.r = r;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        //super.run();
        r.getTable(this.customerId);
        try{
            int eatingTime = random.nextInt(30) + 1;
            System.out.println("Customer #" + this.customerId + " will eat for " + eatingTime + "seconds");
            Thread.sleep(2000);
            System.out.println("Customer #" + this.customerId + " is done eating." );
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            r.returnTable(this.customerId);
        }
    }
}


public class SyncSemaphores{
    public static void main(String[] args){
        Restaurant r = new Restaurant(2);
        for(int i=0;i<10;i++){
            SyncSemaphores1 syncSemaphores1 = new SyncSemaphores1(r, i);
            syncSemaphores1.start();
        }
    }
}
