package yzhao.redhat.com;

//import java.lang.String;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstJava {
    public static void main(String[] args){
//        String str1 = "W3chelloyzhao.com.cn";
//
//        int len = str1.length();
//
//        for (int i=0; i<len; i++){
//            System.out.println(str1.charAt(i) + " has index" + i);
//        }
//
//        String str = String.join("--", "QQ", "2993614148", "33");
//        System.out.println(str);
//
//        String s4 = String.valueOf(23454);
//        System.out.println(s4);
        ArrayList<String> al = new ArrayList<>();
        al.add("1");
        al.add("2");
        al.add("3");

        String[] s1 = new String[al.size()];
        String[] s2 = al.toArray(s1);

        //System.out.println(s1==s2);
        //System.out.println(s1);
        //System.out.println(s2);

        System.out.println(Arrays.toString(s1));
        System.out.println((Arrays.toString(s2)));

        for (int i=0; i<s1.length; i++){
            System.out.println(s1[i]);
        }
    }
}
