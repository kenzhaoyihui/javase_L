package yzhao.example.com;

class Gen<T>{
    T ob;

    Gen(T ob){
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    void showType() {
        System.out.println("Type of T is: " + ob.getClass().getName());
    }
}


public class LikeClass {
    public static void main(String [] args){
        Gen<Integer> iob = new Gen<Integer>(88);
        iob.showType();

        int v = iob.getOb();
        System.out.println("value: " + v);

        Gen<String> strOb = new Gen<String>("Generics Test");
        strOb.showType();

        String str = strOb.getOb();
        System.out.println("value: " + str);
    }
}
