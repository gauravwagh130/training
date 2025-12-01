package com.java.traning.main;

import com.java.traning.App;
import com.java.traning.dao.EmployDao;
import com.java.traning.model.Employ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class EmploySearchMain {
  public static void main(String[] args) {
    int empno;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Employ Number   ");
    empno = sc.nextInt();
    ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc.xml");
    EmployDao employDao = (EmployDao) ctx.getBean("employDao");
    Employ employ = employDao.searchEmployDao(empno);
    if (employ != null) {
      System.out.println(employ);
    }else {
      System.out.println("Employ Not found...");
    }

  }
}
