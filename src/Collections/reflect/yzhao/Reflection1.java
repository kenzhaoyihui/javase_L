package Collections.reflect.yzhao;

class Test{
    static{
        System.out.println("This is the static inititor....");
    }

    public void printDetail(){
        System.out.println("hah");
    }

}

public class Reflection1 {
    public static void main(String[] args){
        Test test = new Test();
        Class testclass = test.getClass();

        Class testclass2 = Test.class;

        System.out.println(testclass.getSimpleName());
        System.out.println(testclass2.getSimpleName() + ", " + testclass2);

        try{
            String className = "Collections.reflect.yzhao.Test";
            boolean initialize = false;

            ClassLoader classLoader = Reflection1.class.getClassLoader();

            Class c = Class.forName(className, initialize, classLoader);
            System.out.println("About a load...");
            System.out.println(c);

            Class c1 = Class.forName(className);
            System.out.println(c1);

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }


    }
}
