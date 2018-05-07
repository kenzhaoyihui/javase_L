package yzhao.example.com;


interface MinMax<T extends Comparable<T>>{
    T max();
}

class MyClass3<T extends Comparable<T>> implements MinMax<T>{

    T[] vals;

    MyClass3(T[] o){
        vals = o;
    }

    public T max(){
        T max = vals[0];

        for (int i=1; i<vals.length; i++){
            if (vals[i].compareTo(max) > 0){
                max = vals[i];
            }
        }
        return max;
    }
}


public class InterfaceLike {

    public static void main(String ... args){
        Integer inums[] = {1,2,3,4,5,65};
        Character chars[] = {'A', 'C', 'D'};

        MyClass3<Integer> myClass3 = new MyClass3<>(inums);
        MyClass3<Character> myClass31 = new MyClass3<>(chars);

        System.out.println(myClass3.max());
        System.out.println(myClass31.max());
    }
}
