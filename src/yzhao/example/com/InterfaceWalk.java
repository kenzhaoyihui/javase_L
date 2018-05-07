package yzhao.example.com;

interface Walkable{
    void walk();
    public static void pp(){
        System.out.println("HELLO");
    };

    default void print(){
        System.out.println("HELLOWORLD");
    };

    class EmptyTask implements Walkable{
        private EmptyTask(){

        }
        public void runJob(){
            System.out.println("Run..");
        }

        public void walk(){
            System.out.println("Walking...");
        }
    }
    Walkable EMPTY_JOB = new EmptyTask();
    void runJob();
}

class Person implements Walkable{
    public void walk(){
        System.out.println("a person is walking");
    }

    public void runJob(){
        System.out.println("Runing Person...");
    }
}

class Dog implements Walkable{
    public void walk(){
        System.out.println("a dog is walking");
    }

    public void runJob(){
        System.out.println("Running Dog");
    }
}


class Walkables {
    public static void letThemWalk(Walkable[] list){
        for(Walkable w: list){
            w.walk();
        }
    }
}


public class InterfaceWalk {
    public static void main(String[] args){
        Walkable[] w = new Walkable[2];
        w[0] = new Person();
        w[1] = new Dog();


        Walkables.letThemWalk(w);

        w[0].print();
        Walkable.pp();

        Walkable.EMPTY_JOB.runJob();

    }
}
