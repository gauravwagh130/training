package com.java.traning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployUpdate {
  public static void main(String[] args) {
    int empno;
    String name,dept,desig,gender;
    double basic;
    Scanner sc = new Scanner(System.in);
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

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa3", "root", "Wagh@1234");
      String cmd = "update employ set Name = ?, Gender = ?, Dept = ?, Desig =?, Basic = ? where empno =?";
      PreparedStatement ps = conn.prepareStatement(cmd);
      ps.setString(1, name);
      ps.setString(2, gender);
      ps.setString(3, dept);
      ps.setString(4, desig);
      ps.setDouble(5, basic);
      ps.setInt(6, empno);
      ps.executeUpdate();
      System.out.println("Record are Successfully Updated");

    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
