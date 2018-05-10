package thread.redhat.com;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableTask implements Runnable{
    private int taskId;
    private int loopCounter;

    public RunnableTask(int taskId, int loopCounter){
        this.loopCounter = loopCounter;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        for(int i=0;i<loopCounter;i++){
            try{
                System.out.println("Task #" + this.taskId + " - Iteration #" + i);
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("Task #" + this.taskId + " has been interrupted");
                break;
            }
        }
    }
}


public class Executor1 {
    public static void main(String[] args){
        final int THREAD_COUNT = 5;
        final int LOOP_COUNT = 3;
        final int TASK_COUNT = 5;

        ExecutorService exec = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i=0;i<TASK_COUNT; i++){
            RunnableTask task = new RunnableTask(i, LOOP_COUNT);
            exec.submit(task);
        }

        exec.shutdown();
    }
}
