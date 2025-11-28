package com.java.traning.main;

import com.java.traning.dao.AgentDao;
import com.java.traning.dao.AgentDaoImpl;
import com.java.traning.model.Agent;
import com.java.traning.model.Gender;

import java.util.Scanner;

public class AddAgentMain {
  public static void main(String[] args) {
    Agent agent = new Agent();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter AgentId: ");
    agent.setAgentId(sc.nextInt());
    System.out.println("Enter Agent name: ");
    agent.setName(sc.next());
    System.out.println("Enter city: ");
    agent.setCity(sc.next());
    System.out.println("Gender: ");
    agent.setGender(Gender.valueOf(sc.next()));
    System.out.println("Premium: ");
    agent.setPremium(sc.nextDouble());
    AgentDao agentDao = new AgentDaoImpl();
    System.out.println(agentDao.addAgentDao(agent));
  }
}
