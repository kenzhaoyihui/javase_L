package yzhao.example.com;

class  MyClass1<T>{
    T ob;

    MyClass1(T o){
        ob = o;
    }

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

}


public class DoubleLike {
    public static void main(String... args){
        MyClass1 myClass1 = new MyClass1(new Double(13.14));
        double b = (Double) myClass1.getOb();
        System.out.println(b);
    }
}
