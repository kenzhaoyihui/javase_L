package thread.redhat.com;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable{
    private int taskId;

    public CallableTask(int taskId){
        this.taskId = taskId;
    }

    @Override
    public Object call() {
        //return null;
        int total = taskId;
        for(int i=0;i<5;i++){
            try{
                System.out.println("Task #" + this.taskId + ", " + i);
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            total += taskId;
        }
//        try{
//            System.out.println("Task #" + this.taskId);
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        total += taskId;
        return total;
    }
}
public class Executor2 {
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newFixedThreadPool(3);

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<10;i++){
            CallableTask task = new CallableTask(i);
            Future<Integer> submitted = exec.submit(task);
            arrayList.add(submitted.get());
        }

        //Integer result = submitted.get();


        System.out.println("Task's total sleep time:" + arrayList + " seconds");

        exec.shutdown();
    }
}
