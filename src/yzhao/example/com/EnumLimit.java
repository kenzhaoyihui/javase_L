package yzhao.example.com;

import java.util.EnumSet;

enum Lev {
    LOW, MEDIUM, HIGH, URGENT;
}


public class EnumLimit {

    public static void print(EnumSet<Lev> levels){
        for(Lev d: levels){
            System.out.println(d + "--");
        }
    }

    public static void main(String[] args){
        EnumSet<Lev> allLevels = EnumSet.allOf(Lev.class);
        print(allLevels);

        System.out.println("---------------------------");

        EnumSet<Lev> ll = EnumSet.range(Lev.LOW, Lev.HIGH);
        print(ll);

    }
}
