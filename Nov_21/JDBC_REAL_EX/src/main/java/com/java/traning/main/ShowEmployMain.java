package com.java.traning.main;

import com.java.traning.dao.EmployDao;
import com.java.traning.dao.EmployDaoImp;
import com.java.traning.model.Employ;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowEmployMain {
  public static void main(String[] args) {
    EmployDao dao = new EmployDaoImp();
    try {
      List<Employ> employList = dao.showEmployDao();
      employList.forEach(System.out::println);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
