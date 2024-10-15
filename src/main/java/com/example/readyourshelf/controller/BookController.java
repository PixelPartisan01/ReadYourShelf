package com.example.readyourshelf.controller;

import com.example.readyourshelf.model.Book;
import com.example.readyourshelf.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public void deleteBook(@RequestParam(value = "isbn", required = true) String isbn)
    {
        bookService.deleteBook(isbn);
    }

    @PutMapping("/update_book/{isbn}")
    public void updateBook(@PathVariable(value = "isbn", required = true) String isbn,
                           @RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "author", required = false) String author,
                           @RequestParam(value = "releaseDate", required = false) LocalDate releaseDate,
                           @RequestParam(value = "genre", required = false) String genre,
                           @RequestParam(value = "description", required = false) String description,
                           @RequestParam(value = "status", required = false) String status,
                           @RequestParam(value = "owner", required = false) String owner,
                           @RequestParam(value = "borrower", required = false) String borrower,
                           @RequestParam(value = "ownerEmail", required = false) String ownerEmail)

    {
        bookService.updateBook(isbn, title, author, releaseDate, genre, description, status, owner, borrower, ownerEmail);
    }
}
