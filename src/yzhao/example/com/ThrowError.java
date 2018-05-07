package yzhao.example.com;

class MyException extends Exception{
    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
    }

    public MyException(String message, Throwable cause){
        super(message, cause);
    }

    public MyException(Throwable cause){
        super(cause);
    }
}

public class ThrowError {

    public static void m1() throws MyException{
        try{
            m2();
        }catch(MyException e){
            e.fillInStackTrace();
            throw e;
        }
    }

    public static void m2() throws MyException{
        throw new MyException("An error occured...");
    }

    public static void main(String[] args){
        try{
            m1();
        }catch (MyException e){
            e.printStackTrace();
        }
    }
}
