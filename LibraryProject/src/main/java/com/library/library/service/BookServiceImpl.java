package com.library.library.service;

import com.library.library.model.Book;
import com.library.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findById(Long id) {
        return  bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        saveBook(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean isBookExists(Book book) {
        return findByName(book.getName()) != null;
    }
}
