package yzhao.redhat.com;

class A {
}

class B {
}

class C extends A {
}

class D extends A {
}

public class Test2{
    public static void main(String args[]) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if (a instanceof A)
            System.out.println("a is instance of A");
        if (b instanceof B)
            System.out.println("b is instance of B");
        if (c instanceof C)
            System.out.println("c is instance of C");
        if (c instanceof A)
            System.out.println("c can be cast to A");

        if (a instanceof C)
            System.out.println("a can be cast to C");

        A ob;
        ob = d; // A reference to d
        System.out.println("ob now refers to d");
        if (ob instanceof D)
            System.out.println("ob is instance of D");

        ob = c; // A reference to c
        System.out.println("ob now refers to c");
        if (ob instanceof D)
            System.out.println("ob can be cast to D");
        else
            System.out.println("ob cannot be cast to D");

        if (ob instanceof A)
            System.out.println("ob can be cast to A");
        // all objects can be cast to Object
        if (a instanceof Object)
            System.out.println("a may be cast to Object");
        if (b instanceof Object)
            System.out.println("b may be cast to Object");
        if (c instanceof Object)
            System.out.println("c may be cast to Object");
        if (d instanceof Object)
            System.out.println("d may be cast to Object");
    }
}