package yzhao.spring.io.daospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("DAO.xml");

        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

        System.out.println("------Records Creation------");

        studentJDBCTemplate.create("Zyh", 22);
        studentJDBCTemplate.create("lj", 18);
        studentJDBCTemplate.create("haha", 20);
        studentJDBCTemplate.create("hehe", 3);

        System.out.println("------List Multiple Records------");
        List<Student> students = studentJDBCTemplate.listStudents();
        for(Student s: students){
            System.out.println("ID: " + s.getId() + " , Name: " + s.getName() + " , Age: " + s.getAge());
        }

        System.out.println("------Updating Record with ID=2------");
        studentJDBCTemplate.update(2, 100);
        System.out.println("------ List Record ID=2------");
        Student s2 = studentJDBCTemplate.getStudent(2);
        System.out.println("ID: " + s2.getId() + " , Name: " + s2.getName() + " , Age: " + s2.getAge());

        System.out.println("------Delete ID=3");
        studentJDBCTemplate.delete(3);

        for(Student s: studentJDBCTemplate.listStudents()){
            System.out.println("ID: " + s.getId() + " , Name: " + s.getName() + " , Age: " + s.getAge());
        }
    }
}
