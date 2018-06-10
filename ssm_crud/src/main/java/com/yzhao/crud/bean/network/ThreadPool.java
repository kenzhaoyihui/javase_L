package com.yzhao.crud.bean.network;

import java.io.Serializable;
import java.util.concurrent.*;

public class ThreadPool {

    private static int produceTaskSleepTime = 2;
    private static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.DiscardOldestPolicy());


        for (int i=1; i<=produceTaskMaxNumber; i++){
            try{
                String task = "task@" + i;
                System.out.println("Put: " + task);

                //threadPoolExecutor.execute(new ThreadPoolTask1(task));
                Future future = threadPoolExecutor.submit(new ThreadPoolTask2(task));



                System.out.println("Result: " + future.get());

                Thread.sleep(produceTaskSleepTime);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        threadPoolExecutor.shutdown();
    }
}


class ThreadPoolTask1 implements Runnable, Serializable {

    private static final long serialVersionUID = 1L;
    private static int consumeTaskSleepTime = 2000;

    // 保存任务所需要的数据
    private Object threadPoolTaskData;

    public ThreadPoolTask1 (Object task) {
        this.threadPoolTaskData = task;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
        System.out.println("start .." + threadPoolTaskData);

        try{
            Thread.sleep(consumeTaskSleepTime);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Catch1: " + e.getMessage());
        }

        threadPoolTaskData = null;
    }

    public Object getThreadPoolTaskData() {
        return threadPoolTaskData;
    }
}

class ThreadPoolTask2 implements Callable{
    private static final long serialVersionUID = 1L;
    private static int consumeTaskSleepTime = 2000;

    // 保存任务所需要的数据
    private Object threadPoolTaskData;

    public ThreadPoolTask2 (Object task) {
        this.threadPoolTaskData = task;
    }

    @Override
    public Object call() {

        System.out.println(Thread.currentThread().getName());
        System.out.println("start .." + threadPoolTaskData);

        try{
            Thread.sleep(consumeTaskSleepTime);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Catch2: " + e.getMessage());
        }

        //threadPoolTaskData = null;
       return "Hello";
    }

    public Object getThreadPoolTaskData() {
        return threadPoolTaskData;
    }

}
