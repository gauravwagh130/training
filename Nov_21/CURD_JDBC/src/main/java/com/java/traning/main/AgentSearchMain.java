package com.java.traning.main;

import com.java.traning.dao.AgentDao;
import com.java.traning.dao.AgentDaoImp;
import com.java.traning.model.Agent;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearchMain {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    int agentId;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter AgentId: ");
    agentId = sc.nextInt();
    AgentDao agentDao = new AgentDaoImp();
    Agent agent = agentDao.searchAgentDao(agentId);
    if (agent != null){
      System.out.println(agent);
    } else {
      System.out.println("Agent record not found...");
    }

  }
}
