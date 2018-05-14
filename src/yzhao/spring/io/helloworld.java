package yzhao.spring.io;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

class helloworld1{
    private int id;
    private String messages;
    private Greet greet;

    //why need a no args constructor , because the setter injection should find the no args constructor
    public helloworld1(){

    }

    public helloworld1(Greet greet){
        System.out.println("Inside helloworld1 constructor");
        this.greet = greet;
    }

    public helloworld1(Greet greet, String messages, int id){
        this.messages = messages;
        this.greet = greet;
        this.id = id;
    }


    public void setMessages(String messages){
        this.messages = messages;
    }

    public String getMessages() {
        System.out.println("Your message: " + this.messages);
        return messages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        System.out.println("Your id is: " + this.id);
        return id;
    }

    public void setGreet(Greet greet) {
        this.greet = greet;
    }

    public Greet getGreet() {
        return greet;
    }

    public void print(){
        System.out.println(this.messages);
    }

    public void init(){
        System.out.println("Init...");
    }

    public void destroy(){
        System.out.println("Destroyed...");
    }
}


public class helloworld {
    public static void main(String[] args){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //context.registerShutdownHook();
        //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //ApplicationContext context = new FileSystemXmlApplicationContext("//home/yzhao_sherry/IdeaProjects/javalearn/src/Beans.xml");
        helloworld1 obj = (helloworld1) context.getBean("helloworld");
        //obj.setMessage("hah");
        //obj.getMessages();
        obj.getId();


        //System.out.print("\n--------------------\n");
        //helloworld1 obj2 = (helloworld1) context.getBean("helloworld");
        //obj2.getMessage();


        //context.close();

//        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
//        helloworld1 obj = (helloworld1) factory.getBean("helloworld");
//        obj.getMessage();
    }
}
