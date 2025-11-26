package com.java.traning.services;

import com.java.traning.Model.Book;
import com.java.traning.dao.BookDao;
import com.java.traning.dao.BookDaoImpl;
import com.java.traning.dao.MemberDao;
import com.java.traning.dao.MemberDaoImpl;
import com.java.traning.exception.LibraryException;

import java.util.List;

public class BookService {
  private final BookDao bookDao = new BookDaoImpl();
  private final MemberDao memberDao = new MemberDaoImpl();

  public String addBook(Book b) throws LibraryException {
    return bookDao.addBook(b);
  }

  public String updateBook(Book b) throws LibraryException {
    return bookDao.updateBook(b);
  }
  public String deleteBook(String isbn) throws LibraryException{
    return bookDao.deleteBook(isbn);
  }

  public Book findByIsbn(String isbn) throws LibraryException {
    return bookDao.findByisbn(isbn);
  }
  public List<Book> searchByTitleOrAuthor(String term)  throws LibraryException{
    return bookDao.searchByTitleOrAuthor(term);
  }
  public List<Book> findAllBook() throws LibraryException {
    return bookDao.findAllBook();
  }
}
