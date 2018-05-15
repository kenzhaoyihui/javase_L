package yzhao.spring.io.SpEL1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("EL.xml");
        Customer obj = (Customer) context.getBean("customer");

        System.out.println(obj.getItem().getName());
        System.out.println(obj.getItem().getQty());
        System.out.println(obj.getName());
    }
}
