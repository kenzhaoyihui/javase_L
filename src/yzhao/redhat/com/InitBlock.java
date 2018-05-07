package yzhao.redhat.com;

class Block{
    private static int sum;

    public static int getSum() {
        return sum;
    }

    {
        System.out.println("Hello world");
    }

    static {
        sum = 10;
        System.out.println("Inside static initializer.");
    }

}
public class InitBlock {
    public static void main(String[] args){
        System.out.println("HAHA");
        System.out.println(Block.getSum());

        Block block = new Block();

    }
}
