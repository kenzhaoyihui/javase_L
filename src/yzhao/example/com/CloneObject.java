package yzhao.example.com;

class MyClass implements Cloneable{
    private double value;

    public MyClass(double value){
        this.value = value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }


    public Object clone(){
        MyClass copy = null;

        try{
            copy = (MyClass) super.clone();
            //System.out.println(copy.getClass());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        return copy;
    }
}


class ShowCopy implements Cloneable{
    private MyClass holder = new MyClass(10.00);

    public ShowCopy(double value){
        this.holder.setValue(value);
    }

    public void setHolder(double value) {
        this.holder.setValue(value);
    }

    public double getHolder() {
        return this.holder.getValue();
    }

    public Object clone(){
        ShowCopy copy = null;
        try{
            copy = (ShowCopy) super.clone();
            copy.holder = (MyClass) this.holder.clone();  //Deepcopy 30, 40
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        return copy;
    }
}


public class CloneObject {

    public static void main(String[] args){
        MyClass myClass = new MyClass(100.00);

        MyClass myClass1clone =  (MyClass) myClass.clone();

        System.out.println(myClass.getValue());

        System.out.println(myClass1clone.getValue());

        System.out.println("----------");
        //myClass.setValue(200.00);
        myClass1clone.setValue(400.00);

        System.out.println(myClass.getValue());
        System.out.println(myClass1clone.getValue());


        System.out.println("--------------------------------------------");

        ShowCopy sc = new ShowCopy(20.00);
        ShowCopy scclone = (ShowCopy) sc.clone();  // 20, 20

        sc.setHolder(30.00);  // 30, 30
        scclone.setHolder(40.00); // 40, 40


        System.out.println(sc.getHolder());
        System.out.println(scclone.getHolder());


    }
}
