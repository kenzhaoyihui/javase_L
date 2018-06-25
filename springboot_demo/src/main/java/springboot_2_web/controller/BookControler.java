package springboot_2_web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot_2_web.bean.Book;
import springboot_2_web.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookControler {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBookList() {
        return bookService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Book postBook(@RequestBody Book book) {
        return bookService.insertByBook(book);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Book putBook(@RequestBody Book book) {
        return bookService.update(book);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Book deleteBook(@PathVariable Long id) {
        return bookService.delete(id);
    }
}
