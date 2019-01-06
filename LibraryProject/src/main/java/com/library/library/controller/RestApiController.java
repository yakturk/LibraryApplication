package com.library.library.controller;

import com.library.library.model.Book;
import com.library.library.service.BookService;
import com.library.library.util.LibraryErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/*
it handles restApi calls which comes from frontend
 */
@RestController
@RequestMapping("/api")
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book/", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBooks() {
        List<Book> books = bookService.findAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBook(@PathVariable("id") long id) {
        logger.info("Searching Book with id {}", id);
        Book book = bookService.findById(id);
        if (book == null) {
            logger.error("Book is not found.", id);
            return new ResponseEntity(new LibraryErrorType("Book id: " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Book : {}", book);

        if (bookService.isBookExists(book)) {
            logger.error("Could not create book.It is already already exist", book.getName());
            return new ResponseEntity(new LibraryErrorType("Could not create " +
                    book.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        bookService.saveBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/book/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        logger.info("Updating Book: ", id);

        Book currentBook = bookService.findById(id);

        if (currentBook == null) {
            logger.error("Book could not be found with the id: ", id);
            return new ResponseEntity(new LibraryErrorType("Could not update book: " + id + " is not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentBook.setName(book.getName());
        currentBook.setAuthorname(book.getAuthorname());

        bookService.updateBook(currentBook);
        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable("id") long id) {
        logger.info("Deleting Book: ", id);

        Book book = bookService.findById(id);
        if (book == null) {
            logger.error("Could not delete book: ", id);
            return new ResponseEntity(new LibraryErrorType("Could not delete book. " + id + " is not found."),
                    HttpStatus.NOT_FOUND);
        }
        bookService.deleteBookById(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/book/", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteAllUsers() {
        logger.info("Deleting All Books");

        bookService.deleteAllBooks();
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
}
