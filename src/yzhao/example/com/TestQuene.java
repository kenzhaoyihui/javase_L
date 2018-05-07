package yzhao.example.com;

class Queue<E>{
    private E[] elements;
    private int head, tail = 0;

    Queue(int size){
        elements = (E[]) new Object[size];
    }

    void insert(E element) throws QueueFullException{
        if (isFull()){
            throw new QueueFullException();
        }
        elements[tail] = element;
        tail = (tail + 1) % elements.length;

    }

    E remove() throws QueueEmptyException{
        if(isEmpty()){
            throw  new QueueEmptyException();
        }

        E element = elements[head];
        head = (head + 1) % elements.length;
        return element;
    }

    boolean isEmpty(){
        return head == tail;
    }

    boolean isFull(){
        return (tail + 1) % elements.length == head;
    }
}

class QueueEmptyException extends Exception{}
class QueueFullException extends Exception{}


public class TestQuene {
    public static void main(String[] args) throws QueueEmptyException, QueueFullException{
        Queue<String> queue = new Queue<>(6);
        System.out.println("Empty: " + queue.isEmpty());
        System.out.println("Full: " + queue.isFull());

        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        //queue.insert("F");

        System.out.println("Empty: " + queue.isEmpty());
        System.out.println("Full: " + queue.isFull());

        System.out.println("Rrmove: " + queue.remove());

        while(!queue.isEmpty()){
            System.out.println("Removing:" + queue.remove());
        }

        System.out.println("Empty: " + queue.isEmpty());
        System.out.println("Full: " + queue.isFull());

    }
}
