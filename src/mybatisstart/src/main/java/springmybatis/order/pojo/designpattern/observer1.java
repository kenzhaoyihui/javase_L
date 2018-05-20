package springmybatis.order.pojo.designpattern;

import javafx.print.Printer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class MyValue{
    private List<Observer> observerList = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observerList.add(observer);
    }

    public void notifyAllObservers(){
        for(Observer observer: observerList){
            observer.update();
        }
    }
}

abstract class Observer{
    protected MyValue subject;
    public abstract void update();
}

class EmailObserver extends Observer{
    public EmailObserver(MyValue subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Email: " + subject.getState());
    }
}

class FileObserver extends Observer{
    public FileObserver(MyValue subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("File: " + subject.getState());
    }
}

class PrinterObserver extends Observer{
    public PrinterObserver (MyValue subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Printer: " + subject.getState());
    }
}


public class observer1 {

    public static void main(String[] args){
        MyValue myValue = new MyValue();
        PrinterObserver printerObserver = new PrinterObserver(myValue);
        FileObserver observer = new FileObserver(myValue);
        EmailObserver emailObserver = new EmailObserver(myValue);

        myValue.setState(120);
        myValue.setState(110);
        myValue.setState(100);
    }
}
