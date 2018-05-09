package Collections.reflect.yzhao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Test1{
    private final static int i;
    private String lj = "LJ";
    public int xx = 100;

    public String getLj() {
        return lj;
    }

    public void setLj(String lj) {
        this.lj = lj;
    }

    static{
        i = 2;
    }

    public Test1(){
        System.out.println("HAHA: " + i);
    }

    public Test1(Integer i, String name){
        System.out.println("Age: " + i + ", Name: " +name);
    }

    public Test1(Integer i, Integer j){
        System.out.println("i: " + i + ", j: " + j);
    }

    public void print(String name, Integer i){
        System.out.println("What is your name: " + name + ", Age: " + i);
    }

}

public class ReflectObjectCreate1 {
    public static void main(String[] args){
        Class<Test1> test1Class = Test1.class;
        try{

            Test1 pp = test1Class.newInstance();
            System.out.println(pp);
            Method method = test1Class.getMethod("print", String.class, Integer.class);
            method.invoke(pp, "LJ", 23);

            System.out.println("------------------------");

            Constructor<Test1> constructor = test1Class.getConstructor(Integer.class, Integer.class);
            Test1 p = constructor.newInstance(3, 4);
            System.out.println(p);
            System.out.println("==========================");



            Constructor<Test1> constructor1 = test1Class.getConstructor(Integer.class, String.class);
            Test1 p1 = constructor1.newInstance(23, "zyh");
            System.out.println(p1);


            System.out.println("----------------------------------------------------");

            Field field = test1Class.getField("xx");
            Integer str1 = (Integer) field.get(pp);

            System.out.println("Currect xx is:" + str1);

            field.set(pp, 200);

            str1 = (Integer) field.get(pp);
            System.out.println("Now the xx is: " + str1);

            Field field1 = test1Class.getDeclaredField("lj");
            field1.setAccessible(true);
            String str2 = (String) field1.get(pp);
            System.out.println("lj is: " + str2);

            field1.set(pp, "MyLovelj");
            str2 = (String) field1.get(pp);
            System.out.println("Now lj is : " + str2);



        }catch(IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException e){
            System.out.println(e.getMessage());
        }
    }
}
