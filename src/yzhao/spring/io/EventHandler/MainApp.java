package yzhao.spring.io.EventHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("javabeans.xml");

        context.start();

        Helloworld obj = (Helloworld) context.getBean("helloworld");
        obj.getMessage();

        context.stop();

    }
}
