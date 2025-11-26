package com.java.traning.dao;

import com.java.traning.Model.Loan;
import com.java.traning.exception.LibraryException;
import com.java.traning.util.ConnectionHelper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanDaoImpl implements LoanDao {

  @Override
  public Loan crateLoan(Loan loan) throws LibraryException {
    String sql = "INSERT INTO loans (member_id, isbn, issue_Date, due_date, return_Date) VALUES (?,?,?,?,?)";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, loan.getMemberId());
      ps.setString(2, loan.getIsbn());
      ps.setDate(3, Date.valueOf(loan.getIssueDate()));
      ps.setDate(4, Date.valueOf(loan.getDueDate()));
      if (loan.getReturnDate() != null) ps.setDate(5, Date.valueOf(loan.getReturnDate()));
      else ps.setNull(5, Types.DATE);
      ps.executeUpdate();
      try (ResultSet rs = ps.getGeneratedKeys()) {
        if(rs.next()){
          loan.setLoanId(rs.getInt(1));
        }
      }
    }catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error in creating loan",e);
    }
    return loan;
  }

  @Override
  public Loan findActiveLoanByMemberIdAndIsbn(int member_id, String isbn) throws LibraryException {
    String sql = "SELECT * FROM loans WHERE member_id =? AND isbn =? AND return_Date IS NULL";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, member_id);
      ps.setString(2, isbn);
      ResultSet rs = ps.executeQuery();
      if(rs.next()){
        return mapRow(rs);
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error",e);
    }
    return null;
  }

  @Override
  public List<Loan> findAllActiveLoan() throws LibraryException {
    List<Loan> list = new ArrayList<>();
    String sql = "SELECT * FROM loans";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()){
        list.add(mapRow(rs));
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error",e);
    }
    return list;
  }

  @Override
  public String updateReturnDate(int loanId, LocalDate returnDate) throws LibraryException {
    String sql = "UPDATE loans SET return_Date =?, WHERE loan_id=?";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setDate(1, Date.valueOf(returnDate));
      ps.setInt(2, loanId);
      ps.executeUpdate();
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error",e);
    }
    return "Return Date are Updated...";
  }
  private Loan mapRow (ResultSet rs) throws SQLException{
    Loan l = new Loan();
    l.setLoanId(rs.getInt("loan_id"));
    l.setMemberId(rs.getInt("member_id"));
    l.setIsbn(rs.getString("isbn"));
    l.setIssueDate(rs.getDate("issue_Date").toLocalDate());
    l.setDueDate(rs.getDate("due_Date").toLocalDate());
    Date rd = rs.getDate("return_Date");
    if (rd!=null){
      l.setReturnDate(rd.toLocalDate());
    }
    return l;
  }
}
