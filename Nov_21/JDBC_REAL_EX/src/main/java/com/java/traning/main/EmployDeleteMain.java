package com.java.traning.main;

import com.java.traning.dao.EmployDao;
import com.java.traning.dao.EmployDaoImp;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployDeleteMain {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    int empno;
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter Employ No: ");
    empno = sc.nextInt();
    EmployDao employDao = new EmployDaoImp();
    System.out.println(employDao.deleteEmployDao(empno));
  }
}
