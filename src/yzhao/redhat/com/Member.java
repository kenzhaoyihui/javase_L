package yzhao.redhat.com;

class EnclosingClass {
    private int outerVariable = 1;

    private void privateOuterMethod(){
        System.out.println(outerVariable);
    }

    class EnclosedClass{
        void accessEnclosingClass(){
            outerVariable = 2;
            privateOuterMethod();
        }
    }
}


public class Member {
    public static void main(String[] args){
        EnclosingClass es = new EnclosingClass();
        es.new EnclosedClass().accessEnclosingClass();
    }
}
