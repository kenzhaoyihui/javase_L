package Collections.reflect.yzhao;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStack {

    public static void main(String[] args){
        Deque<String> deque = new ArrayDeque<>();

        deque.push("Oracle");
        deque.push("C++");
        deque.push("CSS");
        deque.push("XML");

        System.out.println("Stack: " + deque);


        while(deque.peek() != null){
            System.out.println("Element at top: " + deque.peek());
            System.out.println("Pop: " + deque.pop());
            System.out.println("Stack: " + deque);
        }


        System.out.println("Stack is empty: " + deque.isEmpty());
    }
}
