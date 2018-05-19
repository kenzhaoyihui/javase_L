package springmybatis.order.pojo.designpattern;

class Mainwindow{
    private static Mainwindow instance = new Mainwindow();

    //private Mainwindow(){}

    public static Mainwindow getInstance() {
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello world!");
    }
}
public class singleton {
    public static void main(String[] args){
//        Mainwindow object = Mainwindow.getInstance();
//        object.showMessage();

        Mainwindow object = new Mainwindow();
        object.showMessage();
    }

}
