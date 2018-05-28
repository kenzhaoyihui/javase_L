package Collections.reflect.yzhao;

public class test22 {
    int num;

    public test22(){}

    public test22(int num){
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args){
        test22 testa = new test22(1);
        test22 testb = new test22();
        testb = testa;
        testa.setNum(4);
        System.out.println("Ta: " + testa.getNum() + " , Tb: " + testb.getNum());

        int a = 3;
        int b = a;
        a = 7;
        System.out.println("a: " + a +" , b: " + b);
    }
}
