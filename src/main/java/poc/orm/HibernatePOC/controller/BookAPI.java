package poc.orm.HibernatePOC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import poc.orm.HibernatePOC.entity.Book;
import poc.orm.HibernatePOC.response.BookResponse;
import poc.orm.HibernatePOC.service.BookService;

import java.util.Arrays;

@RestController
public class BookAPI {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<BookResponse> getAllBook() {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setBooks(bookService.getAllBooks());
        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") Long bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }
}
