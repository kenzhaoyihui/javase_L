package yzhao.redhat.com;


interface Person {
    abstract void speak();
}


public class InterfaceNiMing {
    public static void main(String[] args){
        Person person = new Person() {
            String msg = (args.length == 1)? args[0]: "nothing to say";

            @Override
            public void  speak(){
                System.out.println(msg);
            }
        };
        person.speak();
    }
}
