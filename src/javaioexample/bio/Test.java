package javaioexample.bio;

import java.io.IOException;
import java.util.Random;

public class Test {

    public static  void main(String[] args) throws InterruptedException{

        // run server
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    ServerBetter.start();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);


        //run client
        char operators[] = {'+', '-', '*', '/'};

        Random random = new Random(System.currentTimeMillis());

        new Thread(new Runnable() {
            @SuppressWarnings("static-access")
            @Override
            public void run() {
                while(true){

                    String expresion = random.nextInt(10) + "" + operators[random.nextInt(4)] + (random.nextInt(10) + 1);
                    Client.send(expresion);

                    try{
                        Thread.currentThread().sleep(random.nextInt(1000));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
