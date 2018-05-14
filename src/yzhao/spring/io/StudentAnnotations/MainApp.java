package yzhao.spring.io.StudentAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beansstudent.xml");
//        Student student = (Student) context.getBean("student");
//
//        System.out.println("Age: " + student.getAge());
//        System.out.println("Name: " + student.getName());

        Profile profile = (Profile) context.getBean("profile");
        profile.print();
    }
}
