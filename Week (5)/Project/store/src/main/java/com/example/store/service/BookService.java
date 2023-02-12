package com.example.store.service;


import com.example.store.api.ApiException;
import com.example.store.model.Book;
import com.example.store.model.Store;
import com.example.store.repository.BookRepository;
import com.example.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final StoreRepository storeRepository;
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Integer id, Book updateBook) {
        Book book = bookRepository.findBookById(id);
        if(book == null) {
            throw new ApiException("Book not found");
        }
        updateBook.setId(id);
        bookRepository.save(updateBook);
    }


    public void deleteBook(Integer id) {
        Book book = bookRepository.findBookById(id);
        if(book == null) {
            throw new ApiException("Book not found");
        }
        bookRepository.delete(book);
    }



    public void assignBookToStore(Integer store_id, Integer book_id) {
        Store store = storeRepository.findStoreById(store_id);
        Book book = bookRepository.findBookById(book_id);
        if(store == null || book == null) {
            throw new ApiException("Can't find book or store");
        }
        store.getBooks().add(book);
        storeRepository.save(store);

    }

    public int booksAvailability(Integer id) {
        Book book = bookRepository.findBookById(id);
        if(book == null) {
            throw new ApiException("Can't find book");
        }
        return book.getBookCount();
    }

    public Book showBookDetails(Integer id) {
        Book book = bookRepository.findBookById(id);
        if(book == null) {
            throw new ApiException("Can't find book");
        }
//        ArrayList bookInfo = new ArrayList<>();
//        bookInfo.add(book.getId());
//        bookInfo.add(book.getBookCount());
//        bookInfo.add(book.getGenre());
//        bookInfo.add(book.getStore());
//        String info = "book id: " + book.getId() + "\n book counts:";
        return book;
    }

    public List<Book> allBookGenre(String genre) {
        List<Book> genre1 = bookRepository.findBooksByGenre(genre);
        if(genre1 == null) {
            throw new ApiException("Can't find book with this genre, try again");
        }

        return genre1;
    }
}
