package yzhao.spring.io.LogXMLAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_student.xml");

        Student student = (Student) context.getBean("student");

        student.getAge();
        student.getName();
        student.printThrowException();
    }
}
