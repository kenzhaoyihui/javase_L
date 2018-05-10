package thread.redhat.com;

import java.util.concurrent.Phaser;

public class Phaser2 {
    public static void main(String[] args){
        Phaser phaser = new Phaser(){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                //return super.onAdvance(phase, registeredParties);
                System.out.println("Inside onAdvance(): phaser = " + phase + ", Registered Parties = " + registeredParties);
                return false;
            }
        };


        phaser.register();
        //System.out.println("#1: isTerminated(): " + phaser.isTerminated());
        phaser.arriveAndDeregister();
        System.out.println("#1: isTerminated(): " + phaser.isTerminated());


        phaser.register();
        phaser.arriveAndDeregister();

        System.out.println("#2: isTerminated(): " + phaser.isTerminated());
        phaser.forceTermination();
        System.out.println("#3: isTerminated(): " + phaser.isTerminated());
    }
}
