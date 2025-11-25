package com.java.traning.dao;

import com.java.traning.Model.Book;
import com.java.traning.exception.LibraryException;

import java.util.List;

public interface BookDao {
  List<Book> findAllBook()  throws LibraryException;
  Book findByisbn(String isbn)  throws LibraryException;
  List<Book> searchByTitleOrAuthor(String term)  throws LibraryException;
  String addBook(Book b)  throws LibraryException;
  String updateBook(Book b)  throws LibraryException;
  String deleteBook(String isbn)  throws LibraryException;
}
