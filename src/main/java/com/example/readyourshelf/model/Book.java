package com.example.readyourshelf.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book
{
    @Id
    private String isbn;
    private String title;
    private String author;
    private LocalDate releaseDate;
    private String genre;
    @Column(columnDefinition="TEXT")
    private String description;
    //private String image;
    private String status;
    private String owner;
    private String borrower;
    private String ownerEmail;

    public Book(String title, String author, String genre, String description, String isbn, String status, String owner, String borrower, String ownerEmail, LocalDate releaseDate)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.isbn = isbn;
        this.status = status;
        this.owner = owner;
        this.borrower = borrower;
        this.ownerEmail = ownerEmail;
        this.releaseDate = releaseDate;
    }

    public Book()
    {
        this.title = "";
        this.author = "";
        this.genre = "";
        this.description = "";
        this.isbn = "";
        this.status = "";
        this.owner = "";
        this.borrower = "";
        this.ownerEmail = "";
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getDescription()
    {
        return description;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getStatus()
    {
        return status;
    }

    public String getOwner()
    {
        return owner;
    }

    public String getBorrower()
    {
        return borrower;
    }

    public String getOwnerEmail()
    {
        return ownerEmail;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", owner='" + owner + '\'' +
                ", borrower='" + borrower + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }
}
