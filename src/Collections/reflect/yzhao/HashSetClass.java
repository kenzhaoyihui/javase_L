package Collections.reflect.yzhao;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetClass {

    public static void main(String[] args){

        Set<String> s1 = new HashSet<>();

        s1.add("AA");
        s1.add("CC");
        s1.add("EE");
        s1.add("DD");
        s1.add("AA");


        Set<String> s2 = new HashSet<>(s1);
        s2.add("Java");
        s2.add("Python");
        s2.add("C++");
        s2.add(null);
        s2.add(null);
        s2.add("Java");


        Set<String> s3 = new HashSet<>();
        s3.add("zz");
        s3.add("xx");
        s3.add("yy");
        s3.add("AA");


        System.out.println("Original Set3: " + s3);
        //s3.addAll(s1);
        //s3.retainAll(s1);

        //s2.removeAll(s1);


        System.out.println("Set1: " + s1);
        System.out.println("Set1 Size: " + s1.size());

        System.out.println("Set2: " +  s2);
        System.out.println("Set2 size: " + s2.size());

        System.out.println(s1.equals(s2));

        System.out.println("Set3 : " + s3);

        System.out.println(s2.containsAll(s3));
    }
}
