package transient1.designpattern;

interface Printer1{
    void print();
}

class ConsolePrinter implements Printer1{
    private String filename;

    public ConsolePrinter(String filename){
        this.filename = filename;
    }

    public void print() {
        System.out.println("Displaying: " + filename);
    }
}

class ProxyPrinter implements Printer1{
    private String filename;
    private ConsolePrinter consolePrinter;

    public ProxyPrinter(String filename){
        this.filename = filename;
    }

    public void print() {
        if (consolePrinter == null){
            consolePrinter = new ConsolePrinter(filename);
        }

        consolePrinter.print();
    }
}


public class proxy {

    public static void main(String[] args){
        Printer1 image = new ProxyPrinter("test");
        image.print();
    }
}
