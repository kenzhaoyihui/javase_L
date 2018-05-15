package yzhao.spring.io.CustomerService1;

public class CustomerService {
    private String name;
    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void printName(){
        System.out.println("Customer name: " + name);
    }

    public void printUrl(){
        System.out.println("customer url: " + url);
    }

    public void printThrowException(){
        throw new IllegalArgumentException();
    }
}
