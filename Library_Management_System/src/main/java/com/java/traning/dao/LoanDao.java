package com.java.traning.dao;

import com.java.traning.Model.Loan;
import com.java.traning.exception.LibraryException;

import java.time.LocalDate;
import java.util.List;

public interface LoanDao {
  Loan crateLoan(Loan loan) throws LibraryException;
  Loan findActiveLoanByMemberIdAndIsbn(int member_id, String isbn) throws LibraryException;
  List<Loan> findAllActiveLoan() throws LibraryException;
  String updateReturnDate(int loanId, LocalDate returnDate) throws LibraryException;
}
