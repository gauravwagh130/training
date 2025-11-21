package com.java.traning;

import java.sql.*;
import java.util.Scanner;

public class EmploySearch {
  public static void main(String[] args) {
    int empno;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter EmployNo:");
    empno = sc.nextInt();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa3", "root", "Wagh@1234");
      String cmd = "select * from Employ where empno = ?";
      PreparedStatement ps = conn.prepareStatement(cmd);
      ps.setInt(1, empno);
      ResultSet rs = ps.executeQuery();
      if (rs.next()){
        System.out.println("EmployNo: " + rs.getInt("empno"));
        System.out.println("Employ Name:  " +rs.getString("name"));
        System.out.println("Gender:  " +rs.getString("gender"));
        System.out.println("Department:  " +rs.getString("dept"));
        System.out.println("Designation:  " +rs.getString("desig"));
        System.out.println("Basic:  " +rs.getDouble("basic"));
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
