package yzhao.example.com;

interface InnerA{
    String s = "A";

    default void show(){
        System.out.println("ZYH");
    }

    static void pp(){
        System.out.println("Static");
    }
}

interface InnerB extends InnerA{
    String s = "B";

    default void show(){
        System.out.println("YHZ");
    }

    static void pp(){
        System.out.println("RE Static");
    }
}

class MyClass5 implements InnerB{

}


public class InterfaceIhn {
    public static void main(String[] args){
        MyClass5 myClass5 = new MyClass5();
        myClass5.show();
        //myClass5.pp();
    }
}

//
//interface AAA {
//    default String getValue(){
//        return "A";
//    }
//}
//interface BBB extends AAA {
//    default String getValue(){
//        return "B";
//    }
//}
//
//class MyClass5 implements BBB{
//
//}
//
//public class InterfaceIhn {
//    public static void main(String[] argv){
//        System.out.println(new MyClass5().getValue());
//    }
//}
