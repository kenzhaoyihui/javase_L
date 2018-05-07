package Collections.reflect.yzhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class List1 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        List<String> list1 = new LinkedList<>();


        list.add("Java");
        list.add("CSS");
        list.add("HTML");
        list.add("Python");
        list.add("XML");

        list1.add("Java");
        list1.add("CSS");
        list1.add("HTML");
        list1.add("Python");
        list1.add("XML");



        System.out.println("List: " + list);
        System.out.println("List size: " + list.size());

        System.out.println("List1: "  + list1);

        for(String n: list){
            System.out.println(n);
        }

        List<String> list2  = list.subList(1, 3);
        System.out.println(list2);

        System.out.println("----------------------------");

        ListIterator<String> listIterator = list.listIterator();

        while(listIterator.hasNext()){
            int intIndex = listIterator.nextIndex();
            String name = listIterator.next();
            System.out.println("Index: " + intIndex + " , Name: " + name);
        }

        while(listIterator.hasPrevious()){
            int index = listIterator.previousIndex();
            String name = listIterator.previous();
            System.out.println("Index: " + index + ", Name: " + name);
        }

    }
}
