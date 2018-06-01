package redis;

import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.stream.Collectors;

public class testredislist {

    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("1234");

        System.out.println("Connection to server: " + jedis.ping());

        jedis.lpush("list1", "Redis");
        jedis.lpush("list1", "Mongodb");
        jedis.lpush("list1", "Mysql");
        jedis.lpush("list1", "Sqlite");

        List<String> list = jedis.lrange("list1", 0, 5);

        for(int i=0; i<list.size(); i++){
            System.out.println("Stored string in redis:: " + list.get(i));
        }

        Set<String> set1 = jedis.keys("*");

        List<String> list2 = new ArrayList<>();
        list2.addAll(set1);

        for(int i=0; i<list2.size(); i++){
            System.out.println("Set of stored keys:: " + list2.get(i));
        }


        List<String> ll = new ArrayList<>();
        ll.add("xx");
        ll.add("yy");
        ll.add("zz");
        ll.add("zz");

//        List<String> newList = new ArrayList<>();
//
//        Set<String> set = new HashSet<>();
//
//        for(String s: ll){
//            set.add(s);
//        }
//
//        newList.addAll(set);

        List<String> newList = ll.stream().distinct().collect(Collectors.toList());

        System.out.println("New List: " + newList);



    }
}
