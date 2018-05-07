package yzhao.example.com;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//import java.text.Annotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface A{
    String name() default "LJ";
    int age() default 100;
}

@Retention(RetentionPolicy.RUNTIME)
@interface B{
    String description();
}

@A()
@B(description = "Do you love me?")
public class Annotas {
    @A(name="method", age=34)
    @B(description = "test method")
    public static void myMeth() throws Exception{
        Annotas annotas = new Annotas();
        Class c = annotas.getClass();
        Annotation annos[] = c.getAnnotations();

        for(Annotation a: annos){
            System.out.println(a);
        }

        Method m = c.getMethod("myMeth");
        annos = m.getAnnotations();

        for (Annotation b: annos){
            System.out.println(b);
        }

    }

    public static void main(String[] args) throws Exception{
        myMeth();
    }

}
