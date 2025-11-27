package com.java.traning.main;

import com.java.traning.dao.BankDao;
import com.java.traning.dao.BankDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class CloseAccountMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int accountNo;
    System.out.println("Enter Account No:-");
    accountNo = sc.nextInt();
    BankDao bankDao = new BankDaoImpl();
    try {
      System.out.println(bankDao.closeAccount(accountNo));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
