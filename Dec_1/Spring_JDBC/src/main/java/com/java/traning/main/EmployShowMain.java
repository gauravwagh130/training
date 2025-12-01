package com.java.traning.main;

import com.java.traning.App;
import com.java.traning.dao.EmployDao;
import com.java.traning.dao.EmployDaoImpl;
import com.java.traning.model.Employ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployShowMain {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc.xml");
    EmployDaoImpl impl = (EmployDaoImpl) ctx.getBean("employDao");
    List<Employ> employList = impl.showEmployDao();
    employList.stream().forEach(System.out::println);
  }
}
