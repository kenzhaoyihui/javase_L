package yzhao.redhat.com;

abstract class Shape {
    double height;
    double width;

    Shape(double a, double b) {
        height = a;
        width = b;
    }
    abstract double area();
}

class Rectangle extends Shape{
    Rectangle(double a, double b) {
        super(a, b);
    }
    double area() {
        System.out.println("Inside Area for Rectangle.");
        return height * width;
    }
}
class Triangle extends Shape{
    Triangle(double a, double b) {
        super(a, b);
    }
    double area() {
        System.out.println("Inside Area for Triangle.");
        return height * width / 2;

    }
}

public class abstract1 {
    public static void main(String args[]) {
        Rectangle r = new Rectangle(10, 5);
        Triangle t = new Triangle(10, 8);

        //Shape figref;

        //figref = r;
        System.out.println("Area is " + r.area());

        //figref = t;
        System.out.println("Area is " + t.area());
    }
}