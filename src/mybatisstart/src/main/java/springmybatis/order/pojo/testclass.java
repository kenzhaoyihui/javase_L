package springmybatis.order.pojo;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class testclass {

    public static void main(String[] args){
        List<String> list1 = new ArrayList<String>();
        list1.add("java");
        list1.add("python");
        list1.add("C++");
        list1.add("R");

        System.out.println(list1);

        Iterator iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.println("Elem: " + iterator.next());
        }

        System.out.println("-----------------");
        ListIterator listIterator = list1.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
            //System.out.println(listIterator.previous());
        }

        System.out.println("For ......");
        for(String s: list1){
            System.out.println(s);
        }



        Set<String> set1 = new HashSet<String>();
        set1.add("hello1");
        set1.add("hello2");
        set1.add("hello3");
        System.out.println(set1);



        for(String ss: set1){
            System.out.println(ss);
        }

        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }


        Map<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "zyh");
        map1.put(2, "lj");
        map1.put(4,"mma");
        map1.put(6, "caonima");
        map1.put(7, "lj");

        System.out.println(map1);

        Set<Integer> keys = map1.keySet();
        Collection<String> values = map1.values();
        for(Integer i : keys){
            System.out.println(i);
        }

        for(String name: values){
            System.out.println("name: " + name);
        }

        System.out.println("----------------------------");


//        Set<Map.Entry<Integer, String>> entries = map1.entrySet();
//        entries.forEach((Map.Entry<Integer, String> entry) -> {
//            Integer key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println("key=" + key + ",  value=" + value);
//        });

    }
}
