package poc.orm.HibernatePOC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import poc.orm.HibernatePOC.entity.Book;
import poc.orm.HibernatePOC.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return new ArrayList<>(this.bookRepository.findAll());
    }

    public Book getBookById(Long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return this.bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return this.bookRepository
                .findById(book.getId())
                .map(v -> {
                    v.mergeBook(book);
                    return this.bookRepository.save(book);
                }).orElse(null);
    }

    public Book deleteBookById(Long bookId) {
        return this.bookRepository
                .findById(bookId)
                .map(bookFound -> {
                    this.bookRepository.deleteById(bookFound.getId()); return bookFound;
                })
                .orElse(null);
    }
}
