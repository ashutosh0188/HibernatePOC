package poc.orm.HibernatePOC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.orm.HibernatePOC.entity.Book;
import poc.orm.HibernatePOC.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.findAll());
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
