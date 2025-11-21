package com.java.traning.dao;

import com.java.traning.model.Employ;

import java.sql.SQLException;
import java.util.List;

public interface EmployDao {
  List<Employ> showEmployDao() throws SQLException, ClassNotFoundException;
  String addEmployDao(Employ employ)throws SQLException, ClassNotFoundException;
  Employ searchEmployDao(int empno)throws SQLException, ClassNotFoundException;
  String updateEmployDao(Employ employ)throws SQLException, ClassNotFoundException;
  String deleteEmployDao(int empno)throws SQLException, ClassNotFoundException;

}
