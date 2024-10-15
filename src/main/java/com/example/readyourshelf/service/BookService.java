package com.example.readyourshelf.service;

import com.example.readyourshelf.model.Book;
import com.example.readyourshelf.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    private boolean isISBNValid(String isbn)
    {
        if(isbn.length() != 13)
        {
            return false;
        }
        for(int i = 0; i < isbn.length(); i++)
        {
            if(!Character.isDigit(isbn.charAt(i)))
            {
                return false;
            }
        }
        return true;
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

        if(!isISBNValid(book.getIsbn()))
        {
            throw new IllegalStateException("Invalid ISBN");
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

    @Transactional
    public void updateBook(String isbn, String title, String author, LocalDate releaseDate, String genre,
                           String description, String status, String owner, String borrower, String ownerEmail)
    {
        Book book = bookRepository.findBookByIsbn(isbn).orElseThrow(() -> new IllegalStateException("Book with isbn " + isbn + " does not exist"));
        if (title != null && !title.isEmpty() && !title.equals(book.getTitle()))
        {
            book.setTitle(title);
        }
        if (author != null && !author.isEmpty() && !author.equals(book.getAuthor()))
        {
            book.setAuthor(author);
        }
        if (releaseDate != null && !releaseDate.equals(book.getReleaseDate()))
        {
            book.setReleaseDate(releaseDate);
        }
        if (genre != null && !genre.isEmpty() && !genre.equals(book.getGenre()))
        {
            book.setGenre(genre);
        }
        if (description != null && !description.isEmpty() && !description.equals(book.getDescription()))
        {
            book.setDescription(description);
        }
        if (status != null && !status.isEmpty() && !status.equals(book.getStatus()))
        {
            book.setStatus(status);
        }
        if (owner != null && !owner.isEmpty() && !owner.equals(book.getOwner()))
        {
            book.setOwner(owner);
        }
        if (borrower != null && !borrower.isEmpty() && !borrower.equals(book.getBorrower()))
        {
            book.setBorrower(borrower);
        }
        if (ownerEmail != null && !ownerEmail.isEmpty() && !ownerEmail.equals(book.getOwnerEmail()))
        {
            book.setOwnerEmail(ownerEmail);
        }
    }
}
