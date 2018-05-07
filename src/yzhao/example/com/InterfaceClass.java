package yzhao.example.com;


import java.io.IOException;

interface Shape{
    void show(int amount) throws IOException;
}

class Man implements Shape{

    @Override
    public void show(int amount){
        System.out.println("GUN..." + amount);
    }


    public void pirnt(){
        Shape s  = new Man();
        try {
            s.show(3);
        }catch (IOException e){
            e.printStackTrace();
        }
        show(4);
    }
}

abstract class Man1 implements Shape{

}
public class InterfaceClass  {
    public static void main(String[] args){
        Man m = new Man();

        m.pirnt();
    }
}
