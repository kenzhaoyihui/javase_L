package yzhao.example.com;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    String str();
    int val();
}


public class Annota {

    @MyAnno(str="LJ is my wife", val=23)
    public static void myMeth() {
        Annota annota = new Annota();
        try{
            Class c = annota.getClass();
            Method m = c.getMethod("myMeth");

            MyAnno anno = m.getAnnotation(MyAnno.class);

            System.out.println(anno.str() + "----" + anno.val());

        }catch (NoSuchMethodException e){
            e.printStackTrace();
            System.out.println("Method Not Found");
        }
    }

    public static void main(String[] args){
        myMeth();
    }
}
