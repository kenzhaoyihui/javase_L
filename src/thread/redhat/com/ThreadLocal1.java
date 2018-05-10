package thread.redhat.com;

class CallTracker{
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void call(){
        int count = 0;

        Integer countObject = threadLocal.get();

        if (countObject == null){
            count = 1;
        }else{
            count = countObject.intValue();
            System.out.println("Count init: " + count );
            count++;
        }

        threadLocal.set(count);
        String threadName = Thread.currentThread().getName();
        System.out.println("Call count for: " +threadName + "==" + count);
    }
}

public class ThreadLocal1 {

    public static void run(){
        int count = 4;
        System.out.println(Thread.currentThread().getName() + " generated counter: " +count);

        for (int i=0; i<count; i++){
            CallTracker.call();
        }
    }

    public static void main(String[] args){
        Thread t1 = new Thread(ThreadLocal1::run);
        Thread t2 = new Thread(ThreadLocal1::run);
        Thread t3 = new Thread(ThreadLocal1::run);
        t1.start();
        t2.start();
        t3.start();
    }
}
