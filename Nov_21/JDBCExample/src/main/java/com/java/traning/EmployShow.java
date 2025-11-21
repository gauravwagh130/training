package com.java.traning;

import java.sql.*;

public class EmployShow {
  public static void main(String[] args) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa3","root","Wagh@1234");
      String cmd = "SELECT * FROM EMPLOY";
      PreparedStatement ps = conn.prepareStatement(cmd);
      ResultSet rs = ps.executeQuery();

      while (rs.next()){
        System.out.println("EmployNo: " + rs.getInt("empno"));
        System.out.println("EmployName: " + rs.getString("name"));
        System.out.println("Gender: " + rs.getString("gender"));
        System.out.println("Department: " + rs.getString("dept"));
        System.out.println("Designation: " + rs.getString("desig"));
        System.out.println("Baisc: "+ rs.getDouble("basic"));
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
