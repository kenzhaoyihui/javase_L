package Collections.reflect.yzhao;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args){
        Queue<String> queue = new LinkedList<>();
        queue.offer("SQL");
        queue.offer("Java");
        queue.offer("XML");

        System.out.println("Queue: " + queue);

        while (queue.peek() != null){
            System.out.println("Head Element: " + queue.peek());
            queue.remove();

            System.out.println("Queue: " + queue);
        }


        System.out.println("Quesu empty: " + queue.isEmpty());
        System.out.println("Quesu peek : " + queue.peek());

        System.out.println("Quesu poll: " + queue.poll());

        try{
            String str = queue.element();
            System.out.println("Quesu elememt: " + str);

            str = queue.remove();
            System.out.println("Queue remove: " + str);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("queue remove : Queue is empty " );
        }
    }
}
