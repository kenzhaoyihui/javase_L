package yzhao.spring.io.CustomerService1;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterReturningMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) {
        System.out.println("Yihui: After method executing.");
    }
}
