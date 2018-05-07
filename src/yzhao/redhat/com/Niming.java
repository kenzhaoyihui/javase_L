package yzhao.redhat.com;

abstract class People{
    abstract void speak();
}


public class Niming {
    public static void main(String[] args) {
        People person = new People() {
            String msg = "Hello";

            @Override
            public void speak(){
                System.out.println(msg);
            }
        };
        person.speak();
    }
}
