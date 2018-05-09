package Collections.reflect.yzhao;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TreeMap1 {
    public static void main(String[] args){

        Comparator<String> comparator = Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase);

        SortedMap<String, String> map = new TreeMap<>(comparator);
        map.put("CSS", "Style");
        map.put("HTML", "Mark up ");
        map.put("Oracle", "database");
        map.put("XML" , "Data");
        map.put("Python", "Language");
        map.put("Java", "Language");

        System.out.println(map);

        SortedMap<String, String> submap = map.subMap("CSS", "Oracle");
        System.out.println(submap);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        System.out.println("--------------------");

        ConcurrentMap<String, String> cMap = new ConcurrentHashMap<>();

        cMap.put("CSS", "Style");
        cMap.put("HTML", "Mark up ");
        cMap.put("Oracle", "database");
        cMap.put("XML" , "Data");
        cMap.put("Python", "Language");
        cMap.put("Java", "Language");

        System.out.println(cMap.putIfAbsent("CSS", "syyyyy"));
        System.out.println(cMap.putIfAbsent("C++", "Languages"));

        System.out.println(cMap);

        System.out.println(cMap.remove("CSS", "syyyy"));
        System.out.println(cMap);

        System.out.println(cMap.replace("CSS", "xxxxyyyy"));
        System.out.println(cMap);


    }
}
