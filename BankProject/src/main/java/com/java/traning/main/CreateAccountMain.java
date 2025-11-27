package com.java.traning.main;

import com.java.traning.dao.BankDao;
import com.java.traning.dao.BankDaoImpl;
import com.java.traning.model.Accounts;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountMain {
  public static void main(String[] args) {
    BankDao bankDao = new BankDaoImpl();
    Accounts account = new Accounts();

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter First Name  ");
    account.setFirstName(sc.nextLine());
    System.out.println("Enter Last Name");
    account.setLastName(sc.next());
    System.out.println("Enter City");
    account.setCity(sc.next());
    System.out.println("Enter State");
    account.setState(sc.next());
    System.out.println("Enter Amount");
    account.setAmount(sc.nextDouble());
    System.out.println("Enter Cheque Facil (YES/NO)  ");
    account.setCheqFacil(sc.next());
    System.out.println("Enter Account Type (SAVINGS/CURRENT) ");
    account.setAccountType(sc.next());
    try {
      System.out.println(bankDao.createAccount(account));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
