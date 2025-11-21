package com.java.traning.main;

import com.java.traning.dao.AgentDao;
import com.java.traning.dao.AgentDaoImp;
import com.java.traning.model.Agent;
import com.java.traning.model.Gender;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentUpdateMain {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Agent agent = new Agent();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter AgentId: ");
    agent.setAgentId(sc.nextInt());
    System.out.println("Enter Name: ");
    agent.setName(sc.next());
    System.out.println("Enter city: ");
    agent.setCity(sc.next());
    System.out.println("Gender: ");
    agent.setGender(Gender.valueOf(sc.next()));
    System.out.println("MaritalStatus: ");
    agent.setMaritalStatus(sc.nextInt());
    System.out.println("Premium: ");
    agent.setPremium(sc.nextBigDecimal());
    AgentDao agentDao = new AgentDaoImp();
    System.out.println(agentDao.updateAgentDao(agent));
  }
}
