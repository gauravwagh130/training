package com.java.traning.main;

import com.java.traning.dao.AgentDao;
import com.java.traning.dao.AgentDaoImp;
import com.java.traning.model.Agent;

import java.sql.SQLException;
import java.util.List;

public class AgentShowMain {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    AgentDao agentDao = new AgentDaoImp();
    List<Agent>agentList = agentDao.showExamDao();
    agentList.forEach(System.out::println);
  }
}
