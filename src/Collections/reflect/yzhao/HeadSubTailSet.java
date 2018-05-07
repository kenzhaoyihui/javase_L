package Collections.reflect.yzhao;

import java.util.SortedSet;
import java.util.TreeSet;

public class HeadSubTailSet {

    public static void main(String[] args){
        SortedSet<String> names = new TreeSet<>();

        names.add("HTML");
        names.add("Java");
        names.add("SQL");
        names.add("Python");
        names.add("CSS");


        System.out.println("Sorted Set: " + names);
        System.out.println("First: " + names.first());
        System.out.println("Last: " + names.last());

        System.out.println("Headset: " + names.headSet("HTML"));
        System.out.println(("Headset: " + names.headSet("HTML\0")));

        System.out.println("TailSet: " + names.tailSet("HTML"));
        System.out.println("TailSet: " + names.tailSet("HTML\0"));

        System.out.println("Subnet: " + names.subSet("HTML", "Python"));
    }
}
