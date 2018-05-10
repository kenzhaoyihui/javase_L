package thread.redhat.com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Person{
    private Lock leftLock;
    private Lock rightLock;
    private String name;

    public Person(Lock leftLock, Lock rightLock, String name){
        this.leftLock = leftLock;
        this.rightLock = rightLock;
        this.name = name;
    }

    public void think(){
        System.out.println(name + " is thinking...");
    }

    public void eat(){
        if (leftLock.tryLock()){
            try{
                if (rightLock.tryLock()){
                    try{
                        System.out.println(name + " is eating");
                    }finally {
                        rightLock.unlock();
                    }
                }
            }finally {
                leftLock.unlock();
            }
        }
    }
}


public class Lock1 {
    public static void main(String[] args){
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Person person = new Person(lock1, lock2, "ZYH");
        person.eat();

    }
}
