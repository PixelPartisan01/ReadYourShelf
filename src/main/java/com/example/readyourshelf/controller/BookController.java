package com.example.readyourshelf.controller;

import com.example.readyourshelf.model.Book;
import com.example.readyourshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController
{
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("get_books")
    public List<Book> getBooks()
    {
        return bookService.getBooks();
    }

    @PostMapping("/add_book")
    public void addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
    }

    @DeleteMapping("/delete_book")
    public void deleteBook(@RequestParam("isbn") String isbn)
    {
        bookService.deleteBook(isbn);
    }
}
