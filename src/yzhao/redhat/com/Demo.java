package yzhao.redhat.com;

public class Demo {
    public static void main(String[] args){
        Main.EnclosedClass.accessEnclosingClass();
        //Main.EnclosedClass.accessEnclosingClass2();
        Main.EnclosedClass ec = new Main.EnclosedClass();
        ec.accessEnclosingClass2();

        Main man = new Main();
        man.prints();
    }
}


class Main{
    private static int outerVariable;
    private int xx = 23;

    private static void privateStaticOuterMethod(){
        System.out.println(outerVariable);
        //System.out.println(xx);
    }

    protected void prints(){
        System.out.println(xx);
        System.out.println(outerVariable);
    }

    static void staticOuterMethod(){
        EnclosedClass.accessEnclosingClass();
    }

    static class EnclosedClass{
        static void accessEnclosingClass(){
            outerVariable = 1;
            privateStaticOuterMethod();
        }

        void accessEnclosingClass2(){
            staticOuterMethod();
            System.out.println(outerVariable);

        }
    }
}