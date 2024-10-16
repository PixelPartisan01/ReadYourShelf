package com.example.readyourshelf.repository;

import com.example.readyourshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository
        extends JpaRepository<Book, Long>
{
    @Query("SELECt b FROM Book b WHERE b.isbn = ?1")
    Optional<Book> findBookByIsbn(String isbn);
}
