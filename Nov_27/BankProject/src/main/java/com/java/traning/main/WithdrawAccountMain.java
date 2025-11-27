package com.java.traning.main;

import com.java.traning.dao.BankDao;
import com.java.traning.dao.BankDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class WithdrawAccountMain {
  public static void main(String[] args) {
    double amount;
    int accountNo;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Account No:");
    accountNo = sc.nextInt();
    System.out.println("Enter Amount to Withdraw  :");
    amount = sc.nextDouble();
    BankDao bankDao = new BankDaoImpl();
    try {
      System.out.println(bankDao.withdrawAccount(accountNo, amount));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
