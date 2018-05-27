package Collections.reflect.yzhao;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveListElem {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("bbb");
        list.add("aaa");
        list.add("aba");
        list.add("aaa");

//        Set set = new HashSet();
//        List newList = new ArrayList();
//
//        for(String s: list){
//            if(set.add(s)){
//                newList.add(s);
//            }
//        }
//        System.out.println(newList);




//        Set set = new HashSet();
//        List newList = new ArrayList();
//
//        for (String s: list){
//            if(!newList.contains(s)){
//                newList.add(s);
//            }
//        }
//        System.out.println(newList);



//        Set set = new TreeSet();
//        List newList = new ArrayList();
//
//        set.addAll(list);
//        newList.addAll(set);
//        System.out.println(newList);


//        List newList = new ArrayList(new HashSet(list));
//        System.out.println(newList);

        List<String> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);

    }
}
