package yzhao.example.com;

class MyClass2{
    private double value;

    <T extends Number>MyClass2 (T arg){
        value = arg.doubleValue();
    }


    void showval(){
        System.out.println("Value: " + value);
    }
}


public class ConstructorLike {
    public static void main(String... args){
        MyClass2 myClass2 = new MyClass2(22);
        //MyClass2 myClass21 = new MyClass2("ss");
        myClass2.showval();
        //myClass21.showval();
    }
}
