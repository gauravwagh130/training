package com.java.traning.main;

import com.java.traning.dao.EmployDao;
import com.java.traning.dao.EmployDaoImp;
import com.java.traning.model.Employ;

import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearchMain {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Scanner sc = new Scanner(System.in);
    int empno;
    System.out.println("Enter empno: ");
    empno = sc.nextInt();
    EmployDao employDao = new EmployDaoImp();
    Employ employ = employDao.searchEmployDao(empno);
    if (employ != null){
      System.out.println(employ);

    }else {
      System.out.println("Employ record not found");
    }
  }
}
