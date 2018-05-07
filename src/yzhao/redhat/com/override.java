package yzhao.redhat.com;

class Addr{
    public double add(int a, double b){
        return a+b;
    }

    public double add(double a, int b){
        return a+b;
    }
}

public class override {
    public static  void main(String[] args){
        Addr x= new Addr();
        double xx = x.add((double) 3, 2);
        double xxx = x.add(4, (double) 5);
        System.out.println(xx);
        System.out.println(xxx);
    }
}
