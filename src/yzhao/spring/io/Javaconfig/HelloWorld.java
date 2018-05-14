package yzhao.spring.io.Javaconfig;

public class HelloWorld {
    private String message;

    public String getMessage() {
        System.out.println("Your message: " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void print(){
        System.out.println("It is a print function...");
    }
}
