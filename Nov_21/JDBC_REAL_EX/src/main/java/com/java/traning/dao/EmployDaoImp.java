package com.java.traning.dao;

import com.java.traning.model.Employ;
import com.java.traning.model.Gender;
import com.java.traning.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDaoImp implements EmployDao {
  Connection conn = null;
  PreparedStatement ps = null;

  @Override
  public List<Employ> showEmployDao() throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String cmd = "select * from Employ";
    ps = conn.prepareStatement(cmd);
    ResultSet rs = ps.executeQuery();
    List<Employ> employs = new ArrayList<>();
    while (rs.next()) {
      Employ employ = new Employ();
      employ.setEmpno(rs.getInt("empno"));
      employ.setName(rs.getString("name"));
      employ.setGender(Gender.valueOf(rs.getString("gender")));
      employ.setDept(rs.getString("dept"));
      employ.setDesig(rs.getString("desig"));
      employ.setBasic(rs.getDouble("basic"));
      employs.add(employ);
    }
    return employs;
  }

  @Override
  public String addEmployDao(Employ employ) {
    try {
      conn = ConnectionHelper.getConnection();
      String cmd = "Insert into employ (empno, name, gender, dept, desig, basic) values(?, ?,?,?,?,?)";
      ps = conn.prepareStatement(cmd);
      ps.setInt(1, employ.getEmpno());
      ps.setString(2, employ.getName());
      ps.setString(3, employ.getGender().toString());
      ps.setString(4, employ.getDept());
      ps.setString(5, employ.getDesig());
      ps.setDouble(6, employ.getBasic());
      ps.executeUpdate();

      return "Employ record are Inserted ...";
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public Employ searchEmployDao(int empno) throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String cmd = "select * from employ where empno = ?";
    ps = conn.prepareStatement(cmd);
    ps.setInt(1, empno);
    ResultSet rs = ps.executeQuery();
    Employ employ = null;
    if (rs.next()) {
      employ = new Employ();
      employ.setEmpno(rs.getInt("empno"));
      employ.setName(rs.getString("name"));
      employ.setGender(Gender.valueOf(rs.getString("gender")));
      employ.setDept(rs.getString("dept"));
      employ.setDesig(rs.getString("desig"));
      employ.setBasic(rs.getDouble("basic"));

    }
    return employ;
  }

  @Override
  public String updateEmployDao(Employ employ) throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String cmd = "update employ set name = ?, gender= ?, dept =?, desig =?, basic = ?  where empno=?";
    ps = conn.prepareStatement(cmd);
    ps.setString(1, employ.getName());
    ps.setString(2, employ.getGender().toString());
    ps.setString(3, employ.getDept());
    ps.setString(4, employ.getDesig());
    ps.setDouble(5, employ.getBasic());
    ps.setInt(6, employ.getEmpno());
    ps.executeUpdate();
    return "Employ record are Updated";
  }

  @Override
  public String deleteEmployDao(int empno) throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String cmd = "delete from employ where empno= ?";
    ps = conn.prepareStatement(cmd);

    ps.setInt(1, empno);
    ps.executeUpdate();
    return "Employ record deleted Successfully";
  }
}
