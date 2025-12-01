package com.java.traning.dao;

import com.java.traning.model.Employ;

import java.util.List;

public interface EmployDao {
  List<Employ> showEmployDao();
  Employ searchEmployDao(int empno);
  String addEMployDao(Employ employ);
  String updateEmployDao(Employ employ);
  String deleteEmployDao(int empno);
  int authenticate(String user, String pwd);
}
