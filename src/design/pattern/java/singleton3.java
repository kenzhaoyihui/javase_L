package design.pattern.java;

public class singleton3 {

    /*
    //first method: lazy men, not security

    private static singleton3 instance;

    private singleton3(){}
    public static singleton3 getInstance(){
        if(instance==null){
            instance = new singleton3();
        }

        return instance;
    }

    */

    //second method, lazy man, security
    /*
    private static singleton3 instance;

    private singleton3(){
    }

    public static synchronized singleton3 getInstance(){
        if(instance==null){
            instance = new singleton3();
        }

        return instance;
    }
    */

    //three method: hungry man
    /*
    private static singleton3 instance = new singleton3();
    private singleton3(){}

    public static singleton3 getInstance(){
        return instance;
    }
    */

    //four method: hungry man, two
    /*
    private static singleton3 instance = null;

    static {
        instance = new singleton3();
    }

    private singleton3(){}

    public static singleton3 getInstance(){
        return instance;
    }
    */


    //five method: static inner class
    /*
    private static class SingletonHolder{
        private static final singleton3 instance = new singleton3();
    }

    private singleton3(){}

    public static final singleton3 getInstance(){
        return SingletonHolder.instance;
    }
    */

    //six method: double check

    private volatile static singleton3 instance;
    private singleton3(){
    }

    public static singleton3 getInstance(){
        if(instance==null){
            synchronized (singleton3.class){
                if(instance==null){
                    instance = new singleton3();
                }
            }
        }
        return instance;
    }
}
