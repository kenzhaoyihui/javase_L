package yzhao.example.com;

class MySuper{
    public static void print(){
        System.out.println("Inside MySuper print()");
    }
}

class MySubClass extends MySuper{
    public static void print(){
        System.out.println("Inside MySubClass print()");
    }
}

public class Super {
    public static void main(String[] args){
        MySuper mySuper = new MySuper();
        MySubClass mySubClass = new MySubClass();

        MySuper my = new MySubClass();

//        MySuper.print();
//        MySubClass.print();
//
//        mySuper.print();
//        mySubClass.print();


        my.print();
        ((MySuper) mySubClass).print();

        //((MySubClass) mySuper).print();

        ((MySubClass) my).print();


    }
}
