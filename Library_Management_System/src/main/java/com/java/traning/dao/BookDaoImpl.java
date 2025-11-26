package com.java.traning.dao;

import com.java.traning.Model.Book;
import com.java.traning.exception.LibraryException;
import com.java.traning.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
  @Override
  public List<Book> findAllBook()  throws LibraryException {
    List<Book> list = new ArrayList<>();
    String sql = "select * from books";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()){
        list.add(mapRowToBook(rs));
      }
    } catch (SQLException | ClassNotFoundException e ) {
      throw new LibraryException("Error fetching book", e);
    }
    return list;
  }

  @Override
  public Book findByisbn(String isbn) throws LibraryException {
    String sql = "select * from books where isbn = ?";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, isbn);
      ResultSet rs = ps.executeQuery();
      if (rs.next()){
        return mapRowToBook(rs);
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error fetching book by ISBN", e);
    }
    return null;
  }

  @Override
  public List<Book> searchByTitleOrAuthor(String term)  throws LibraryException {
    String sql = "select * from books where title LIKE ?  or author LIKE ?";
    List<Book> list = new ArrayList<>();
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      String like = " %" + term +"%";
      ps.setString(1, like);
      ps.setString(2, like);
      ResultSet rs = ps.executeQuery();
      while (rs.next()){
        list.add(mapRowToBook(rs));
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error",e);
    }

    return list;
  }

  @Override
  public String addBook(Book b) throws LibraryException {
    String sql = "INSERT INTO books(isbn, title, author, total_copies, available_copies) VALUES(?,?,?,?,?) ";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, b.getIsbn());
      ps.setString(2, b.getTitle());
      ps.setString(3, b.getAuthor());
      ps.setInt(4, b.getTotalCopies());
      ps.setInt(5, b.getAvailableCopies());
      ps.executeUpdate();
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error in adding book",e);
    }
    return "Books added successfully...";
  }

  @Override
  public String updateBook(Book b) throws LibraryException {
    String sql = "UPDATE books SET title = ?, author = ?, total_copies = ?, available_copies = ? WHERE isbn = ?";
    try (Connection conn = ConnectionHelper.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, b.getTitle());
      ps.setString(2, b.getAuthor());
      ps.setInt(3, b.getTotalCopies());
      ps.setInt(4, b.getAvailableCopies());
      ps.setString(5, b.getIsbn());
      int affected = ps.executeUpdate();
      if (affected == 0) {
        return "No book found to update.";
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error in updating book: " + e.getMessage(), e);
    }
    return "Book updated successfully.";
  }

  @Override
  public String deleteBook(String isbn) throws LibraryException {
    String sql = "DELETE FROM books WHERE isbn =?";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, isbn);
      ps.executeUpdate();
    }  catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error in deleting book",e);
    }
    return "Book are Deleted...";
  }
  private Book mapRowToBook(ResultSet rs) throws SQLException {
    Book b = new Book();
    b.setIsbn(rs.getString("isbn"));
    b.setTitle(rs.getString("title"));
    b.setAuthor(rs.getString("author"));
    b.setTotalCopies(rs.getInt("total_copies"));
    b.setAvailableCopies(rs.getInt("available_copies"));
    return b;
  }
}
