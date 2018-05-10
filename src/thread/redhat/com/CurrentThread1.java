package thread.redhat.com;

/**
 * @author kenzhaoyihui
 * @version 0.1
 */

class Test1 extends Thread{
    public Test1(String name){
        super(name);
    }

    @Override
    public void run() {
        //super.run();
        Thread t = Thread.currentThread();
        //String name = t.getName();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(t.getName());
//        System.out.println("Inside run() method: " + stringBuilder.toString());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(t.getName());
        System.out.println("Inside run() method: " + stringBuffer.toString());
    }
}


public class CurrentThread1 {
    public static void main(String[] args){
        Test1 t1 = new Test1("Thread-1");
        Test1 t2 = new Test1("Thread-2");
        t1.start();
        t2.start();

        Thread t = Thread.currentThread();
        //String threadName = t.getName();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(t.getName());
//        System.out.println("Inside main() method: " + stringBuilder.toString());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(t.getName());
        System.out.println("Inside main() method: " + stringBuffer.toString());
    }
}
