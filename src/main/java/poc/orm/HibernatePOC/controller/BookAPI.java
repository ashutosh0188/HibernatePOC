package poc.orm.HibernatePOC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity getBook(@PathVariable("bookId") Long bookId) {
        Book book = bookService.getBookById(bookId);
        ResponseEntity res = book!=null ? ResponseEntity.accepted().body(book) : ResponseEntity.notFound().build();
        return ResponseEntity.ok(res);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(this.bookService.updateBook(book));
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity deleteBook(@PathVariable("bookId") Long bookId) {
        ResponseEntity res = this.bookService.deleteBookById(bookId)!=null ? ResponseEntity.accepted().build() : ResponseEntity.notFound().build();
        return ResponseEntity.ok(res);
    }
}
