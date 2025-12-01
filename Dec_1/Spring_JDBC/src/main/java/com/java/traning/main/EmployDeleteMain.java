package com.java.traning.main;

import com.java.traning.dao.EmployDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class EmployDeleteMain {
  public static void main(String[] args) {
    int empno;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter EmployNo:- ");
    empno= sc.nextInt();
    ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc.xml");
    EmployDao employDao = (EmployDao) ctx.getBean("employDao");
    System.out.println(employDao.deleteEmployDao(empno));
  }
}
