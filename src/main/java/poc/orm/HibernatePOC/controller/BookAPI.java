package poc.orm.HibernatePOC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.orm.HibernatePOC.entity.Book;
import poc.orm.HibernatePOC.response.BookResponse;

@RestController
public class BookAPI {

    @GetMapping("/books/all")
    public ResponseEntity<BookResponse> getAllBook() {
        BookResponse bookResponse = new BookResponse();
        return ResponseEntity.ok(bookResponse);
    }
}
