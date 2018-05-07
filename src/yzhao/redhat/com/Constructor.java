package yzhao.redhat.com;

class Test{
//    Test(){
//        this("hello");
//    }

    Test(String s){
        System.out.println("The String is : " + s);
    }

    Test(int x){
        if (x<0){
            return;
        }else{
            System.out.println(x);
        }
    }

    Test(){
        TestConstructor testConstructor = new TestConstructor();
    }
}

class TestX extends TestConstructor{
    TestX(char a){
        TestConstructor testConstructor = new TestConstructor(a);
    }
}

class TestY extends Test{
    TestY(){
        super();
    }
}

public class Constructor {
    public static void main(String[] args){
        //Test test = new Test();
        Test test1 = new Test("yzhao");
        Test test2 = new Test(-1);
        Test test3 = new Test(3);

        Test test4 = new Test();

        TestX testX = new TestX('C');
        TestY testY = new TestY();
    }
}
