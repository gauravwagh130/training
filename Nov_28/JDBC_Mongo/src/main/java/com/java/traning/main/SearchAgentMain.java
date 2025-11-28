package com.java.traning.main;

import com.java.traning.dao.AgentDao;
import com.java.traning.dao.AgentDaoImpl;
import com.java.traning.model.Agent;

import java.util.Scanner;

public class SearchAgentMain {
  public static void main(String[] args) {
    int agentId;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter AgentId:- ");
    agentId = sc.nextInt();

    AgentDao agentDao = new AgentDaoImpl();
    Agent agent = agentDao.searchAgentDao(agentId);
    if (agent != null) {
      System.out.println(agent);
    }
    else {
      System.out.println("Agent not found...");
    }
  }
}
