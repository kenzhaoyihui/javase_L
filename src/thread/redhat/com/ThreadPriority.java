package thread.redhat.com;


public class ThreadPriority {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("main Thread  Priority:" + t.getPriority());

        Thread t1 = new Thread();
        System.out.println("Thread(t1) Priority:" + t1.getPriority());

        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("main Thread  Priority:" + t.getPriority());

        Thread t2 = new Thread();
        System.out.println("Thread(t2) Priority:" + t2.getPriority() + ", Thread(t1): " + t1.getPriority());

        Thread t3 = new Thread();
        System.out.println("Thread(t3):" + t3.getPriority());

        t.setPriority(6);
        Thread t4 = new Thread();
        System.out.println("Thread(t4): " + t4.getPriority());

        // Change thread t2 priority to minimum
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Thread(t2) Priority:" + t2.getPriority());
    }
}
