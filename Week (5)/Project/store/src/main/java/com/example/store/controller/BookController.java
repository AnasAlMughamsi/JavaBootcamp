package com.example.store.controller;

import com.example.store.model.Book;
import com.example.store.service.BookService;
import com.example.store.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getBook() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.status(200).body(books);
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book books) {
        bookService.addBook(books);
        return ResponseEntity.status(200).body("Book added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book updateBook) {
        bookService.updateBook(id, updateBook);
        return ResponseEntity.status(200).body("Book updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBooks(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted!!");
    }


    @PostMapping("{book_id}/assign-store/{store_id}")
    public ResponseEntity assignCustomerToStore(@PathVariable Integer book_id,@PathVariable Integer store_id ) {
        bookService.assignBookToStore(store_id, book_id);
        return ResponseEntity.status(200).body("Assign book to store");
    }

    @GetMapping("/get-counts/{id}")
    public ResponseEntity bookCounts(@PathVariable Integer id) {
        int book_counts =  bookService.booksAvailability(id);
        return ResponseEntity.status(200).body(book_counts + " books available");
    }

    @GetMapping("/info/{id}")
    public ResponseEntity bookInfo(@PathVariable Integer id) {
        Book book = bookService.showBookDetails(id);
        return ResponseEntity.status(200).body(book);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity bookGenre(@PathVariable String genre) {
        List<Book> booksGenre = bookService.allBookGenre(genre);
        return ResponseEntity.status(200).body(booksGenre);
    }

}
