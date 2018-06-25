package springboot_2_web.service;

import springboot_2_web.bean.Book;

import java.util.List;

public interface BookService {

    //Get all books
    List<Book> findAll();

    Book insertByBook(Book book);

    Book update(Book book);

    Book delete(Long id);

    Book findById(Long id);


}
