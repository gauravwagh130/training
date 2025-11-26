package com.java.traning.main;

import com.java.traning.Model.Book;
import com.java.traning.Model.Member;
import com.java.traning.exception.LibraryException;
import com.java.traning.services.BookService;
import com.java.traning.services.MemberService;
import com.java.traning.services.LoanService;

import java.util.List;
import java.util.Scanner;

public class Main {

  private static final Scanner sc = new Scanner(System.in);

  private static final BookService bookService = new BookService();
  private static final MemberService memberService = new MemberService();
  private static final LoanService loanService = new LoanService();

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n===== Library Management =====");
      System.out.println("1. Book Management");
      System.out.println("2. Member Management");
      System.out.println("3. Issue Book");
      System.out.println("4. Return Book");
      System.out.println("5. Active Loans");
      System.out.println("6. Exit");
      System.out.print("Choose: ");

      switch (sc.nextLine()) {
        case "1" -> bookMenu();
        case "2" -> memberMenu();
        case "3" -> issueBook();
        case "4" -> returnBook();
        case "5" -> showActiveLoans();
        case "6" -> {
          System.out.println("Goodbye!");
          return;
        }
        default -> System.out.println("Invalid choice.");
      }
    }
  }

  // ---------------- BOOK MENU ----------------
  private static void bookMenu() {
    System.out.println("\n--- Book Menu ---");
    System.out.println("1. Add Book");
    System.out.println("2. Update Book");
    System.out.println("3. Delete Book");
    System.out.println("4. Search");
    System.out.println("5. List All");
    System.out.print("Choose: ");

    try {
      switch (sc.nextLine()) {
        case "1" -> addBook();
        case "2" -> updateBook();
        case "3" -> deleteBook();
        case "4" -> searchBook();
        case "5" -> listBooks();
        default -> System.out.println("Invalid.");
      }
    } catch (LibraryException e) {
      System.out.println("Operation failed: " + e.getMessage());
    }
  }

  private static void addBook() throws LibraryException {
    System.out.print("ISBN: "); String isbn = sc.nextLine();
    System.out.print("Title: "); String title = sc.nextLine();
    System.out.print("Author: "); String author = sc.nextLine();
    System.out.print("Total Copies: "); int total = Integer.parseInt(sc.nextLine());

    Book b = new Book(isbn, title, author, total, total);
    System.out.println(bookService.addBook(b));
  }

  private static void updateBook() throws LibraryException {
    System.out.print("ISBN to Update: ");
    String isbn = sc.nextLine();

    Book b = bookService.findByIsbn(isbn);
    if (b == null) {
      System.out.println("Book not found.");
      return;
    }

    System.out.print("New Title (leave blank): ");
    String t = sc.nextLine();
    if (!t.isBlank()) b.setTitle(t);

    System.out.print("New Author (leave blank): ");
    String a = sc.nextLine();
    if (!a.isBlank()) b.setAuthor(a);

    System.out.println(bookService.updateBook(b));
  }

  private static void deleteBook() throws LibraryException {
    System.out.print("ISBN: ");
    System.out.println(bookService.deleteBook(sc.nextLine()));
  }

  private static void searchBook() throws LibraryException {
    System.out.print("Search term: ");
    bookService.searchByTitleOrAuthor(sc.nextLine())
      .forEach(System.out::println);
  }

  private static void listBooks() throws LibraryException {
    bookService.findAllBook().forEach(System.out::println);
  }

  // ---------------- MEMBER MENU ----------------
  private static void memberMenu() {
    System.out.println("\n--- Member Menu ---");
    System.out.println("1. Add Member");
    System.out.println("2. List Members");
    System.out.print("Choose: ");

    try {
      switch (sc.nextLine()) {
        case "1" -> addMember();
        case "2" -> listMembers();
        default -> System.out.println("Invalid.");
      }
    } catch (LibraryException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void addMember() throws LibraryException {
    System.out.print("Name: "); String name = sc.nextLine();
    System.out.print("Email: "); String email = sc.nextLine();
    Member m = new Member(name, email);
    System.out.println(memberService.addMember(m));
  }

  private static void listMembers() throws LibraryException {
    memberService.findAllMember().forEach(System.out::println);
  }

  // ---------------- LOAN MENU ----------------
  private static void issueBook() {
    try {
      System.out.print("Member ID: ");
      int mid = Integer.parseInt(sc.nextLine());
      System.out.print("ISBN: ");
      String isbn = sc.nextLine();
      System.out.println(loanService.issueBook(mid, isbn));
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void returnBook() {
    try {
      System.out.print("Member ID: ");
      int mid = Integer.parseInt(sc.nextLine());
      System.out.print("ISBN: ");
      String isbn = sc.nextLine();
      System.out.println(loanService.returnBook(mid, isbn));
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static void showActiveLoans() {
    try {
      loanService.getActiveLoans().forEach(System.out::println);
    } catch (LibraryException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
