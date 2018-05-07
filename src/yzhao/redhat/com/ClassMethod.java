package yzhao.redhat.com;


class TestMethod{
    static int m = 10;
    int n = 20;

    static void printM(){
        System.out.println("m=" + m);
    }

    void printMN(){
        System.out.println("m==" + m);
        System.out.println("n==" + n);
    }

}
public class ClassMethod {
    public static void main(String[] args){
        TestMethod testMethod = new TestMethod();
        testMethod.printMN();
        testMethod.printM();
        TestMethod.printM();
    }
}
