package yzhao.example.com;


//class Final{
//    private int x;
//
//    public Final(int x){
//        this.x = x;
//    }
//
//    public void finalize(){
//        System.out.println("Finaling: " + this.x);
//    }
//}
//
//public class Finalize {
//    public static void main(String[] args){
//        for(int i=0; i<5; i++){
//            new Final(i);
//            System.out.println(i);
//        }
//    }
//}


class Final {
    private int x;

    public Final(int x) {
        this.x = x;
    }

    @Override
    public void finalize() {
        System.out.println("Finalizing " + this.x);

    }
}

public class Finalize {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Final x = new Final(i);
            x.finalize();
        }
    }
}