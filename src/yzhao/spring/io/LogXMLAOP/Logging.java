package yzhao.spring.io.LogXMLAOP;

public class Logging {
    /**
     * This is the method which I would like to execute
     * before a selected method execution
     */
    public void beforeAdvice(){
        System.out.println("Before...");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution
     */
    public void afterAdvice(){
        System.out.println("After...");
    }

    /**
     * This is the method which I would like execute
     * when any method returns.
     *
     * @param retVal
     */
    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning: " + retVal.toString());
    }

    /**
     * This is the method which I would to execute
     * if there is an exception raised.
     *
     * @param e
     */
    public void AfterThrowingAdvice(IllegalArgumentException e){
        System.out.println("There has been an exception: " + e.toString());
    }
}
