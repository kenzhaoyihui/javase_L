package yzhao.example.com;

class Wrong<T>{

    private T ob;

    Wrong(T o){
        ob = o;
    }

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    static<V> void print(V y){
        System.out.println(y);
    }
}

public class TestStaticLike {
    public static void  main(String [] args){
        Wrong<Integer> wrong = new Wrong<>(5);
        wrong.setOb(6);
        System.out.println(wrong.getOb());
        Wrong.print(44);
        Wrong.print("er");
        Wrong.print('A');
    }
}
