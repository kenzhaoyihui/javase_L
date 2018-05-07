package yzhao.redhat.com;

class AA{
    final static int a;
    static int b;

    static{
        a = 1;
        b = 2;
    }

    AA(){ }

    final static int sum(int a, int b){
        return a+b;
    }

    final void print(){
        System.out.println(a);
    }

}

//class BB extends AA{
//
//    @Override
//    int sum(int a, int b){
//        return a-b;
//    }
//}

public class Final {
    public static void main(String[] args){
        AA aa = new AA();
        aa.print();
        System.out.println(aa.sum(20, 30));

        System.out.println(AA.sum(22, 33));

    }
}
