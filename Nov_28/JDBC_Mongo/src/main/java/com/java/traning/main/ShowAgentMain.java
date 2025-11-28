package com.java.traning.main;

import com.java.traning.dao.AgentDao;
import com.java.traning.dao.AgentDaoImpl;
import com.java.traning.model.Agent;

import java.util.List;

public class ShowAgentMain {
  public static void main(String[] args) {
    AgentDao agentDao = new AgentDaoImpl();
    List<Agent> agentList = agentDao.showAllAgentDao();
    agentList.forEach(System.out::println);
//    agentDao.showAllAgent();
  }
}
