package yzhao.example.com;

class Book{
    private String title;
    private String author;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

public class Hashcode {
    public static void main(String[] args){
        Book book = new Book();
        book.setAuthor("yzhao");
        book.setTitle("yzhao");

        System.out.println(book.getAuthor().hashCode());
        System.out.println(book.getTitle().hashCode());

    }
}