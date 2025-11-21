package com.java.traning.main;

import com.java.traning.dao.EmployDao;
import com.java.traning.dao.EmployDaoImp;
import com.java.traning.model.Employ;
import com.java.traning.model.Gender;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployUpdateMain {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Employ employ = new Employ();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter employee no: ");
    employ.setEmpno(sc.nextInt());
    System.out.print("Enter employee name: ");
    employ.setName(sc.next());
    System.out.print("Enter employee Gender  : ");
    employ.setGender(Gender.valueOf(sc.next()));
    System.out.print("Enter employee department : ");
    employ.setDept(sc.next());
    System.out.print("Enter employee designation : ");
    employ.setDesig(sc.next());
    System.out.print("Enter employee Basic : ");
    employ.setBasic(sc.nextDouble());
    EmployDao employDao = new EmployDaoImp();
    System.out.println(employDao.updateEmployDao(employ));


  }
}
