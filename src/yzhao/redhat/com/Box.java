package yzhao.redhat.com;

class BBox {
    int width;
    int height;
    int depth;
}

public class Box {
    public static void main(String args[]) {
        BBox myBox1 = new BBox();
        BBox myBox2 = myBox1;

        myBox1.width = 10;

        myBox2.width = 20;

        myBox1.width = 30;

        System.out.println("myBox1.width:" + myBox1.width);
        System.out.println("myBox2.width:" + myBox2.width);
    }
}