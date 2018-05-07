package yzhao.redhat.com;

public class Static {
    static int c = 5;
    static int d;

    static{
        System.out.println("Static blodk is here");
        d = c *2;
    }

    static void get(){
        System.out.println(d);
    }

    public static void main(String[] args){
        System.out.println(Static.c);
        System.out.println(Static.d);
        get();

    }
}
