package Collections.reflect.yzhao;

import java.util.*;
import java.lang.Iterable;

public class Map1 {

    public static void printDetail(Map<String, String> map){
        String usage = map.get("CSS");
        System.out.println("Map: " + map);
        System.out.println("Map size: " + map.size());
        System.out.println("Map is empty: " + map.isEmpty());
        System.out.println("Map contains key: " + map.containsKey("CSS"));
        System.out.println("Map contains value: " + map.containsValue("Data"));
        System.out.println("Usage: " + usage);
        System.out.println("Removed : " + map.remove("CSS"));

    }

    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();

        map.put("CSS", "Style");
        map.put("HTML", "Mark up ");
        map.put("Oracle", "database");
        map.put("XML" , "Data");
        map.put("Python", "Language");
        map.put("Java", "Language");

        Set<String> keys = map.keySet();
        Collection<String> values = map.values();

        Set<Map.Entry<String, String>> set1 = map.entrySet();

        System.out.println(keys);
        keys.forEach(System.out::println);

        System.out.println("--------------------");
        System.out.println(values);
        values.forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println(set1);

        set1.forEach(System.out::println);


        System.out.println("------------------------");
        set1.forEach((Map.Entry<String, String> entry) -> {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key=" + key + ", Value=" + value);
        });

        map.forEach((String key, String value) -> {
            System.out.println("key: " + key + ", value: " + value );
        });
        //printDetail(map);
        //map.clear();
        //printDetail(map);


        System.out.println("-----------------------");

        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = iter.next();
            System.out.println("Key: " + entry.getKey() + " , Value: " + entry.getValue());
        }


    }
}
