package yzhao.redhat.com;

import com.sun.org.apache.xml.internal.serialize.TextSerializer;

class TestConstructor{
    TestConstructor(){
        System.out.println("Default");
    }

    public TestConstructor(int x){
        System.out.println("public:" + x);
    }

    private TestConstructor(String s){
        System.out.println("Private: " + s);
    }

    protected TestConstructor(char a){
        System.out.println("Protected: " + a);
    }
}

class AAA extends TestConstructor{
    AAA(int s){
        super(s);
    }
}

public class Constructor1 {
    public static void main(String[] args){
        AAA aaa = new AAA(3);
    }
}
