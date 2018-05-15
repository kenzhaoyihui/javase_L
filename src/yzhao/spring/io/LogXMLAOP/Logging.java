package yzhao.spring.io.LogXMLAOP;

import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {

    @Pointcut("execution(* yzhao.spring.io.LogXMLAOP.*.*(..))")
    public void selectAll(){

    }
    /**
     * This is the method which I would like to execute
     * before a selected method execution
     */
    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("Before...");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution
     */
    @After("selectAll()")
    public void afterAdvice(){
        System.out.println("After...");
    }

    /**
     * This is the method which I would like execute
     * when any method returns.
     *
     * @param retVal
     */
    @AfterReturning(pointcut = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning: " + retVal.toString());
    }

    /**
     * This is the method which I would to execute
     * if there is an exception raised.
     *
     * @param e
     */

    @AfterThrowing(pointcut = "selectAll()", throwing = "e")
    public void AfterThrowingAdvice(IllegalArgumentException e){
        System.out.println("There has been an exception: " + e.toString());
    }
}
