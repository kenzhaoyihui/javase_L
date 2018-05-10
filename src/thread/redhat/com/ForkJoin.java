package thread.redhat.com;

// Create a thread pool to execute

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool -- an instance as thread pool
 * ForkJoinTask -- an instance as a task
 * RecursiveAction extends ForkJoinTask, don't return result, provide abstract "compute" method
 * RecursiveTask extends ForkJoinTask, return result, provide abstract "compute" method
 * CountedCompleter extends ForkJoinTask , maybe don't return result or return result
 *
 */

class IntSum extends RecursiveTask<Integer>{
    private int count;

    public IntSum(int count){
        this.count = count;
    }

    @Override
    protected Integer compute() {
        //return null;
        int result = 0;
        if (this.count <= 0 ){
            return 0;
        }else if (this.count == 1){
            return this.getRandomInteger();
        }

        List<RecursiveTask<Integer>> forks = new ArrayList<>();
        for(int i=0; i< this.count; i++){
            IntSum subTask = new IntSum(1);
            subTask.fork();
            forks.add(subTask);
        }
        //all subTasks finish and combine the result

        for(RecursiveTask<Integer> subTask : forks){
            result = result + subTask.join();
        }

        return result;
    }

    public int getRandomInteger(){
        return 2;
    }
}
public class ForkJoin {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        IntSum intSum = new IntSum(3);
        int sum = pool.invoke(intSum);
        System.out.println("Sum is: " + sum);
    }
}
