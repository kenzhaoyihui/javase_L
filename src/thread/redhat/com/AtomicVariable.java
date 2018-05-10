package thread.redhat.com;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Atomic
 * Lock
 * Synchronized
 * Cuncurrent
 *
 * java.util.concurrent
 * java.util.concurrent.atomic
 * java.util.concurrent.locks
 *
 */


public class AtomicVariable {
    private AtomicInteger value = new AtomicInteger(1);

    public  int next(){
        return value.incrementAndGet();
    }

    public static void main(String[] args){
        AtomicVariable atomicVariable = new AtomicVariable();
        for (int i=0;i<10;i++){
            System.out.println(atomicVariable.next() + ", " + i);
        }
    }
}
