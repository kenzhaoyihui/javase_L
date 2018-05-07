package yzhao.example.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTravel {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("yzhao");
        names.add("lj");
        names.add("ourchild");

        Iterator<String> nameIterable = names.iterator();
        //nameIterable.forEachRemaining(System.out::println);

//        while (nameIterable.hasNext()){
//            String name = nameIterable.next();
//            System.out.println(name);
//            //nameIterable.remove();
//
//        }

        for(String name: names){
            System.out.println(name);
        }

        names.forEach(System.out::println);
        System.out.println(names);

    }
}
