package yzhao.spring.io;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        hello hello1 = (hello) context.getBean("hello");

        hello1.getMessage();
        context.registerShutdownHook();
    }
}
