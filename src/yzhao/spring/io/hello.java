package yzhao.spring.io;

public class hello {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        //return message;
        System.out.println("Your message is : " + message);
    }

    public void init(){
        System.out.println("Bean is going through init...");
    }

    public void destroy(){
        System.out.println("Bean will destroy now...");
    }
}
