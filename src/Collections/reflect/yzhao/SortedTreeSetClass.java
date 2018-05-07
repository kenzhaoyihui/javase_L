package Collections.reflect.yzhao;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedTreeSetClass {

    public static void main(String[] args){
        TreeSet<String> treeSet1 = new TreeSet<>();

        treeSet1.add("Java");
        treeSet1.add("Python");
        treeSet1.add("C");
        treeSet1.add("C++");

        System.out.println(treeSet1);
    }
}