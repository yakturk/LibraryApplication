package com.library.library.repositories;

import com.library.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
It is a repository which is used for crud operations so extends jpaRepository
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);
}
