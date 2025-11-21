package com.java.traning;

import java.sql.*;
import java.util.Scanner;

public class EmployInsert {
  public static void main(String[] args) {
    int empno;
    String name, gender, dept, desig;
    double basic;
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter employee no: ");
    empno = sc.nextInt();
    System.out.print("Enter employee name: ");
    name = sc.next();
    System.out.print("Enter employee Gender  : ");
    gender = sc.next();
    System.out.print("Enter employee department : ");
    dept = sc.next();
    System.out.print("Enter employee designation : ");
    desig = sc.next();
    System.out.print("Enter employee Basic : ");
    basic = sc.nextDouble();
    String cmd = "Insert into Employ(empno, name, gender, dept, desig, basic) VALUES (?,?,?,?,?,?)";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa3","root","Wagh@1234");
      PreparedStatement ps = conn.prepareStatement(cmd);
      ps.setInt(1, empno);
      ps.setString(2, name);
      ps.setString(3, gender);
      ps.setString(4, dept);
      ps.setString(5, desig);
      ps.setDouble(6, basic);
      ps.executeUpdate();
      System.out.println("****** Employ Record Inserted *****");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
