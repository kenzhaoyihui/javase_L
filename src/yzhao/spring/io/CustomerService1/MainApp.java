package yzhao.spring.io.CustomerService1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("CustomerServier.xml");

        //CustomerService customerService = (CustomerService) context.getBean("customerServiceProxy");
        CustomerService customerService = (CustomerService) context.getBean("customerService");

        System.out.println("*********************************");

        customerService.printName();
        System.out.println("*********************************");
        customerService.printUrl();
        System.out.println("*********************************");

        try{
            customerService.printThrowException();
        }catch (Exception e){
            e.printStackTrace();
            //System.out.println("Message: " + e.getMessage());
        }


    }
}
