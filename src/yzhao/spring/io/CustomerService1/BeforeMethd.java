package yzhao.spring.io.CustomerService1;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeMethd implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println("Yihui: Before method execute");
    }
}
