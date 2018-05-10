package thread.redhat.com;

public class ThreadJoin {
    public static void main(String[] args){
//        Thread t = new Thread(() -> {
//            print();
//        });

        Thread t = new Thread(ThreadJoin::print);
        t.start();
        try{
            t.join(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public static void print(){
        for(int i=0; i<5;i++){
            try{
                System.out.println("Current: " + i);
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
