package com.java.traning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployDelete {
  public static void main(String[] args) {
    int empno;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter empno: ");
    empno = sc.nextInt();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa3", "root", "Wagh@1234");
      String cmd = "DELETE FROM EMPLOY WHERE empno = ?";
      PreparedStatement ps = conn.prepareStatement(cmd);
      ps.setInt(1, empno);
      ps.executeUpdate();
      System.out.println("Employ Record are Deleted");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
