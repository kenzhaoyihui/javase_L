package yzhao.example.com;

import java.util.ArrayList;
import java.util.List;

public class CopyList {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        ls.add("A");
        ls.add("B");
        ls.add("C");
        List<String> lsCopy = new ArrayList<String>();
        copyList(ls, lsCopy);

        for (String s: lsCopy){
            System.out.println(s);
        }

        List<Integer> lc = new ArrayList<Integer>();
        lc.add(0);
        lc.add(5);
        List<Integer> lcCopy = new ArrayList<Integer>();
        copyList(lc, lcCopy);

        for (int x: lcCopy){
            System.out.println(x);
        }
    }

    static <T> void copyList(List<T> src, List<T> dest) {
        for (int i = 0; i < src.size(); i++)
            dest.add(src.get(i));
    }
}