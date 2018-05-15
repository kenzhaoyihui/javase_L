package yzhao.spring.io.CustomerService1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.io.ObjectInputStream;
import java.util.Arrays;

public class AroundMethod implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable{
        //return null;

        System.out.println("Method name: " + invocation.getMethod().getName());

        System.out.println("Method arguments: " + Arrays.toString(invocation.getArguments()));

        System.out.println("Yihui: Around method execute...");

        try{

            // proceed to original method call
            Object result = invocation.proceed();

            // same with AfterReturningAdvice
            System.out.println("YIhui: Before affter hacked...");

            return result;

        }catch (IllegalArgumentException e){
            System.out.println("Yihui:  Throw exception hacked...");
            throw e;
        }


    }
}
