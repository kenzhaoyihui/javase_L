package yzhao.spring.io.StudentAnnotations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

public class Profile {
    @Autowired
    private Student student;

    public Profile(){
        System.out.println("Inside Profile constructor");
    }

    public void print(){
        System.out.println("Name: " + student.getName() + " , Age: " + student.getAge());
    }
}
