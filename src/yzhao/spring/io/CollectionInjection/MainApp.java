package yzhao.spring.io.CollectionInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context =  new ClassPathXmlApplicationContext("Beans2.xml");

        JavaCollection javaCollection = (JavaCollection) context.getBean("java");

        javaCollection.getAddressList();
        javaCollection.getAddressSet();
        javaCollection.getAddressMap();
        javaCollection.getAddressProp();
    }
}
