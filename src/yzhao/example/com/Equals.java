package yzhao.example.com;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;

class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }

        if(otherObject == null){
            return false;
        }

        if(this.getClass() != otherObject.getClass()){
            return false;
        }

        Point otherObject1 = (Point) otherObject;

        boolean isSamePoint = (this.x == otherObject1.x && this.y == otherObject1.y);
        return isSamePoint;
    }

    public int hashcode(){
        return (this.x + this.y);
    }
}
public class Equals {
    public static void main(String[] args) {
        Point pt1 = new Point(10, 10);
        Point pt2 = new Point(10, 10);
        Point pt3 = new Point(12, 19);
        Point pt4 = pt1;

        System.out.println("pt1 == pt1: " + (pt1 == pt1));
        System.out.println("pt1.equals(pt1): " + pt1.equals(pt1));

        System.out.println("pt1 == pt2: " + (pt1 == pt2));
        System.out.println("pt1.equals(pt2): " + pt1.equals(pt2));

        System.out.println("pt1 == pt3: " + (pt1 == pt3));
        System.out.println("pt1.equals(pt3): " + pt1.equals(pt3));

        System.out.println("pt1 == pt4: " + (pt1 == pt4));
        System.out.println("pt1.equals(pt4): " + pt1.equals(pt4));

        Point xx = new Point(2, 3);
        Object xxx = new Point(2,3);
        System.out.println(xx.equals(xxx));
        System.out.println(xx.getClass() + ", " + xxx.getClass());
        }

}
