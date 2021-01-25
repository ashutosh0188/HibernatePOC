package poc.orm.HibernatePOC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import poc.orm.HibernatePOC.entity.Book;
import poc.orm.HibernatePOC.response.BookResponse;

import java.util.Arrays;

@RestController
public class BookAPI {

    @GetMapping("/books")
    public ResponseEntity<BookResponse> getAllBook() {
        BookResponse bookResponse = new BookResponse();
        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookResponse> getBook(@PathVariable("bookId") Integer bookId) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setBooks(Arrays.asList(new Book()));
        return ResponseEntity.ok(bookResponse);
    }
}
