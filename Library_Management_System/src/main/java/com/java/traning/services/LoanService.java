package com.java.traning.services;

import com.java.traning.Model.Book;
import com.java.traning.Model.Loan;
import com.java.traning.Model.Member;
import com.java.traning.dao.BookDao;
import com.java.traning.dao.BookDaoImpl;
import com.java.traning.dao.LoanDao;
import com.java.traning.dao.LoanDaoImpl;
import com.java.traning.dao.MemberDao;
import com.java.traning.dao.MemberDaoImpl;
import com.java.traning.exception.LibraryException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class LoanService {

  private final LoanDao loanDao = new LoanDaoImpl();
  private final BookDao bookDao = new BookDaoImpl();
  private final MemberDao memberDao = new MemberDaoImpl();

  private static final int LOAN_PERIOD_DAYS = 14;

  public String issueBook(int memberId, String isbn) throws LibraryException {
    Member m = memberDao.findById(memberId);
    if (m == null) return "Member not found.";

    Book b = bookDao.findByisbn(isbn);
    if (b == null) return "Book not found.";
    if (b.getAvailableCopies() <= 0) return "No copies available.";

    // 1) decrement available in-memory
    b.setAvailableCopies(b.getAvailableCopies() - 1);

    // 2) try to persist the book update
    try {
      bookDao.updateBook(b);
    } catch (LibraryException e) {
      // update failed — return informative error
      return "Failed to update book availability: " + e.getMessage();
    }

    // 3) try to create loan; if it fails, revert the book update (compensating action)
    Loan loan = new Loan();
    loan.setMemberId(memberId);
    loan.setIsbn(isbn);
    loan.setIssueDate(LocalDate.now());
    loan.setDueDate(LocalDate.now().plusDays(LOAN_PERIOD_DAYS));
    loan.setReturnDate(null);

    try {
      loanDao.crateLoan(loan);
      return "Book issued successfully. Due date: " + loan.getDueDate();
    } catch (LibraryException e) {
      // Try to roll back the book availability change
      try {
        b.setAvailableCopies(b.getAvailableCopies() + 1);
        bookDao.updateBook(b); // attempt to restore
      } catch (LibraryException ex) {
        // If rollback also fails, include both messages for debugging
        return "Critical: loan creation failed (" + e.getMessage() +
          ") and rollback failed (" + ex.getMessage() + "). Check DB state.";
      }
      return "Loan creation failed: " + e.getMessage() + ". Book availability restored.";
    }
  }


  public String returnBook(int memberId, String isbn) throws LibraryException {
    Loan loan = loanDao.findActiveLoanByMemberIdAndIsbn(memberId, isbn);
    if (loan == null) return "No active loan found.";

    LocalDate today = LocalDate.now();
    loanDao.updateReturnDate(loan.getLoanId(), today);

    Book b = bookDao.findByisbn(isbn);
    b.setAvailableCopies(b.getAvailableCopies() + 1);
    bookDao.updateBook(b);

    if (today.isAfter(loan.getDueDate())) {
      long lateDays = ChronoUnit.DAYS.between(loan.getDueDate(), today);
      return "Returned late by " + lateDays + " days.";
    }
    return "Book returned successfully.";
  }

  public List<Loan> getActiveLoans() throws LibraryException {
    return loanDao.findAllActiveLoan();
  }
}
