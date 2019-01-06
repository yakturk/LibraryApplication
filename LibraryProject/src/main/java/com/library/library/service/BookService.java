package com.library.library.service;

import com.library.library.model.Book;

import java.util.List;

/*
services is used by controller to operate book related operations
so service provided operations
 */
public interface BookService {

    Book findById(Long id);
    Book findByName(String name);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBookById(Long id);
    void deleteAllBooks();
    List<Book> findAllBooks();
    boolean isBookExists(Book book);
}
