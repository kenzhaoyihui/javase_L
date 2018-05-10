package thread.redhat.com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyResult {
    private int taskId;
    private int result;

    public MyResult(int taskId, int result) {
        this.taskId = taskId;
        this.result = result;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getResult() {
        return result;
    }

    public String toString() {
        return "Task  Name: Task  #" + taskId + ", Task  Result:" + result
                + "  seconds";
    }
}

class SleepingTask implements Callable<MyResult> {
    private int taskId;
    private int loopCounter;
    public SleepingTask(int taskId, int loopCounter) {
        this.taskId = taskId;
        this.loopCounter = loopCounter;
    }

    public MyResult call() throws InterruptedException {
        int totalSleepTime = 0;
        for (int i = 1; i <= loopCounter; i++) {
            try {
                System.out.println("Task #" + this.taskId + "  - Iteration #"
                        + i);
                Thread.sleep(1000);
                totalSleepTime = totalSleepTime + 1000;
            } catch (InterruptedException e) {
                System.out.println("Task #" + this.taskId
                        + "  has  been  interupted.");
                throw e;
            }
        }
        return new MyResult(taskId, totalSleepTime);
    }
}

public class Executor3 {
    public static void main(String[] args) throws Exception {
        // Get an executor with three threads in its thread pool
        ExecutorService exec = Executors.newFixedThreadPool(3);

        // Completed task returns an object of the TaskResult class
        ExecutorCompletionService<MyResult> completionService = new ExecutorCompletionService<>(
                exec);
        for (int i = 1; i <= 5; i++) {
            SleepingTask task = new SleepingTask(i, 3);
            completionService.submit(task);
        }
        for (int i = 1; i <= 5; i++) {
            Future<MyResult> completedTask = completionService.take();
            MyResult result = completedTask.get();
            System.out.println("Completed a  task - " + result);
        }
        exec.shutdown();
    }
}
