package com.java.traning.Model;

import java.util.Objects;

public class Book {
  private String isbn;
  private String title;
  private String author;
  private int totalCopies;
  private int availableCopies;

  public Book(){};

  public Book(String isbn, String title, String author, int totalCopies, int availableCopies) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.totalCopies = totalCopies;
    this.availableCopies = availableCopies;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getTotalCopies() {
    return totalCopies;
  }

  public void setTotalCopies(int total_copies) {
    this.totalCopies = total_copies;
  }

  public int getAvailableCopies() {
    return availableCopies;
  }

  public void setAvailableCopies(int available_copies) {
    this.availableCopies = available_copies;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return totalCopies == book.totalCopies && availableCopies == book.availableCopies && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn, title, author, totalCopies, availableCopies);
  }

  @Override
  public String toString() {
    return "Book{" +
      "isbn='" + isbn + '\'' +
      ", title='" + title + '\'' +
      ", author='" + author + '\'' +
      ", total_copies=" + totalCopies +
      ", available_copies=" + availableCopies +
      '}';
  }
}
