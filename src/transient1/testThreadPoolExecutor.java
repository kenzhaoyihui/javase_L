package transient1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyTask implements Runnable{
    private int taskNum;

    public MyTask(int taskNum){
        this.taskNum = taskNum;
    }

    public void run() {
        System.out.println("Now running the task: " + taskNum);
        try{
            Thread.currentThread().sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Task: " + taskNum + " is finished...");
    }
}


public class testThreadPoolExecutor {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10));


        for(int i=0;i<20;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("The number of te pool: " + executor.getPoolSize() + " , the wait task number in queue: "
                    + executor.getQueue().size() + " , finished tasks numbers is: " + executor.getCompletedTaskCount());
        }

        executor.shutdown();
    }
}
