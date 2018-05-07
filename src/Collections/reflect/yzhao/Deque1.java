package Collections.reflect.yzhao;

import java.util.Deque;
import java.util.LinkedList;

public class Deque1 {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("Oracle");
        deque.offerLast("Java");
        deque.offerLast("CSS");
        deque.offerLast("XML");

        System.out.println("Deque: " + deque);

        // remove elements from the Deque until it is empty
        while (deque.peekFirst() != null) {
            System.out.println("Head  Element: " + deque.peekFirst());
            deque.removeFirst();
            System.out.println("Removed one  element from  Deque");
            System.out.println("Deque: " + deque);
        }

        // the Deque is empty. Try to call its peekFirst(),
        // getFirst(), pollFirst() and removeFirst() methods
        System.out.println("deque.isEmpty(): " + deque.isEmpty());

        System.out.println("deque.peekFirst(): " + deque.peekFirst());
        System.out.println("deque.pollFirst(): " + deque.pollFirst());



        deque.add("Python");

        String str = deque.getFirst();
        System.out.println("deque.getFirst(): " + str);
        str = deque.removeFirst();
        System.out.println("deque.removeFirst(): " + str);

    }
}