package com.java.traning.main;

import com.java.traning.dao.EmployDao;
import com.java.traning.dao.EmployDaoImp;
import com.java.traning.model.Employ;
import com.java.traning.model.Gender;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployAddMain {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Employ employ = new Employ();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Empno: ");
    employ.setEmpno(sc.nextInt());
    System.out.println("Enter Name: ");
    employ.setName(sc.next());
    System.out.println("Enter Gender: ");
    employ.setGender(Gender.valueOf(sc.next()));
    System.out.println("Enter Dept: ");
    employ.setDept(sc.next());
    System.out.println("Enter Desig");
    employ.setDesig(sc.next());
    System.out.println("Enter Basic");
    employ.setBasic(sc.nextDouble());
    EmployDao employDao = new EmployDaoImp();
    System.out.println(employDao.addEmployDao(employ));
  }
}
