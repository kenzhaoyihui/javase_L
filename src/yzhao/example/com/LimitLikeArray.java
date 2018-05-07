package yzhao.example.com;

class Gen1<T>{
    private T ob;

    Gen1(T o){
        ob = o;
    }

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}


class MyClass4<T extends Number>{
    T ob;
    T vals[];

    MyClass4(T o, T[] nums){
        ob = o;
        vals = nums;
    }

    public void setVals(T[] vals) {
        this.vals = vals;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }

    public T[] getVals() {
        return vals;
    }

    void print(){
        for(T a: vals){
            System.out.println(a);
        }
    }
}


public class LimitLikeArray {
    public static void main(String[] args){
        Integer n[] = {1,2,3,4,5};
        MyClass4<Integer> iob = new MyClass4<>(4, n);
        iob.print();

        Double x[] = {12.12, 34.34};

        MyClass4<?> iob2 = new MyClass4<Double>(12.12, x);
        iob2.print();

        MyClass4<?> gen[] = new MyClass4<?>[10];
        //MyClass4<Integer> gens[] = new MyClass4<Integer>[10];

        MyClass4<?> [] gen2 = new MyClass4<?>[5];
        //MyClass4<Integer>[] gen3 = new MyClass4<Integer>[6];

        Gen1<?> xx[] = new Gen1<?>[4];
        //Gen1<Integer> xxx[] = new Gen1<Integer>[8];

    }
}
