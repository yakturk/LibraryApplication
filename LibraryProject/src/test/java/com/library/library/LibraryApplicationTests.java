package com.library.library;

import com.library.library.model.Book;
import com.library.library.repositories.BookRepository;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/*
tests crud operations by repository
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
public class LibraryApplicationTests {

    @Autowired
    private BookRepository bookRepository;

   @Test
    public void findByName()
    {
        Book book = new Book();
        book.setName("testBook1");
        book.setAuthorname("testBook1 Author");
        bookRepository.save(book);
        bookRepository.flush();
        Book foundedBook = bookRepository.findByName(book.getName());

        Assert.assertEquals(foundedBook.getName(),book.getName());
    }

    @Test
    public void deleteBook()
    {
        Book book = new Book();
        book.setName("testBook2");
        book.setAuthorname("testBook2 Author");
        bookRepository.save(book);
        bookRepository.flush();

        Book foundedBook = bookRepository.findByName(book.getName());
        if(foundedBook.getName().equals(book.getName()))
        {
            bookRepository.deleteById(book.getId());

            Book afterDeleted = bookRepository.findByName(book.getName());
            Assert.assertEquals(null, afterDeleted);
        }
        else
         Assert.fail();
    }

    @Test
    public void findAll()
    {
        Book book = new Book();
        book.setName("testBook3");
        book.setAuthorname("testBook3 Author");
        Book book2 = new Book();
        book2.setName("testBook4");
        book2.setAuthorname("testBook4 Author");
        bookRepository.save(book);
        bookRepository.save(book2);
        bookRepository.flush();

        List<Book> currentBooks = new ArrayList();
        currentBooks.add(book);
        currentBooks.add(book2);

        List<Book> foundedBooks = bookRepository.findAll();

        Assert.assertTrue(EqualsBuilder.reflectionEquals(foundedBooks,currentBooks));
    }

}

