package com.java.traning.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {
  private int loanId;
  private int memberId;
  private String isbn;
  private LocalDate issueDate;
  private LocalDate dueDate;
  private LocalDate returnDate;

  public Loan(){};

  public Loan(int loanId, int memberId, String isbn, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
    this.loanId = loanId;
    this.memberId = memberId;
    this.isbn = isbn;
    this.issueDate = issueDate;
    this.dueDate = dueDate;
    this.returnDate = returnDate;
  }

  public int getLoanId() {
    return loanId;
  }

  public void setLoanId(int loanId) {
    this.loanId = loanId;
  }

  public int getMemberId() {
    return memberId;
  }

  public void setMemberId(int memberId) {
    this.memberId = memberId;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Loan loan = (Loan) o;
    return loanId == loan.loanId && memberId == loan.memberId && Objects.equals(isbn, loan.isbn) && Objects.equals(issueDate, loan.issueDate) && Objects.equals(dueDate, loan.dueDate) && Objects.equals(returnDate, loan.returnDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loanId, memberId, isbn, issueDate, dueDate, returnDate);
  }

  @Override
  public String toString() {
    return "Loan{" +
      "loanId=" + loanId +
      ", memberId=" + memberId +
      ", isbn='" + isbn + '\'' +
      ", issueDate=" + issueDate +
      ", dueDate=" + dueDate +
      ", returnDate=" + returnDate +
      '}';
  }
}
