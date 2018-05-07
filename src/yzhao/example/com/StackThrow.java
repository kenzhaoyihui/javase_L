package yzhao.example.com;

/**
 * Java Stack Trace...
 * @author kenzhaoyihui
 * @version v1
 */

public class StackThrow {
    public static void printStackDetails(StackTraceElement[] frames){
        System.out.println("FRame count: " + frames.length);

        for(int i = 0; i<frames.length; i++){
            System.out.println("Frame index: " + i);
            System.out.println("File name: " + frames[i].getFileName());
            System.out.println("Class name: " + frames[i].getClassName());
            System.out.println("Method name: " + frames[i].getMethodName());
            System.out.println("Line name: " + frames[i].getLineNumber());
        }
    }

    public static void m4(){
        Throwable throwable = new Throwable();
        StackTraceElement[] frames = throwable.getStackTrace();
        printStackDetails(frames);
    }

    public static void m3(){
        m4();
    }

    public static void m2(){
        m3();
    }

    public static void m1(){
        m2();
    }

    public  static void main(String... args){
        m1();
    }
}
