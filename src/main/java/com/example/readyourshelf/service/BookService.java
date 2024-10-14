package com.example.readyourshelf.service;

import com.example.readyourshelf.model.Book;
import com.example.readyourshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks()
    {
        return bookRepository.findAll();
    }

    public void addBook(Book book)
    {
        Optional<Book> bookByIsbn
                = bookRepository.findBookByIsbn(book.getIsbn());

        if(bookByIsbn.isPresent())
        {
            throw new IllegalStateException("Book already exists");
        }

        bookRepository.save(book);
    }

    public void deleteBook(String isbn)
    {
        boolean exists = bookRepository.existsById(Long.parseLong(isbn));
        if(!exists)
        {
            throw new IllegalStateException("Book with isbn " + isbn + " does not exist");
        }
        else
        {
            bookRepository.deleteById(Long.parseLong(isbn));
        }
    }
}
