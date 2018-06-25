package springboot_2_web.service.Impl;

import org.springframework.stereotype.Service;
import springboot_2_web.bean.Book;
import springboot_2_web.service.BookService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{

    private static Map<Long, Book> BOOK_DB = new HashMap<>();

    @Override
    public Book findById(Long id) {
        //return null;
        return BOOK_DB.get(id);
    }

    @Override
    public List<Book> findAll() {
        //return null;
        return new ArrayList<>(BOOK_DB.values());
    }

    @Override
    public Book update(Book book) {
        //return null;
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        //return null;
        return BOOK_DB.remove(id);
    }

    @Override
    public Book insertByBook(Book book) {
        book.setId(BOOK_DB.size() + 1L);
        //return null;
        BOOK_DB.put(book.getId(), book);
        return book;
    }
}
