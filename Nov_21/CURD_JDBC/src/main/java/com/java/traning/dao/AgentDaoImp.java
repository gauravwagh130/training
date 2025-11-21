package com.java.traning.dao;

import com.java.traning.model.Agent;
import com.java.traning.model.Gender;
import com.java.traning.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDaoImp implements AgentDao {
Connection conn = null;
PreparedStatement ps = null;
  @Override
  public List<Agent> showExamDao() throws SQLException, ClassNotFoundException {
    List<Agent> agentList = new ArrayList<>();
    conn = ConnectionHelper.getConnection();
    String cmd = "select * from Agent";
    ps = conn.prepareStatement(cmd);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      Agent agent = new Agent();
        agent.setAgentId(rs.getInt("agentId"));
        agent.setName(rs.getString("name"));
        agent.setCity(rs.getString("city"));
        agent.setGender(Gender.valueOf(rs.getString("gender")));
        agent.setMaritalStatus(rs.getInt("maritalStatus"));
        agent.setPremium(rs.getBigDecimal("premium"));
        agentList.add(agent);
      } return agentList;
  }

  @Override
  public String addAgentDao(Agent agent) throws SQLException, ClassNotFoundException {

    conn = ConnectionHelper.getConnection();
    String cmd = "insert into Agent (agentId, name, city, gender, maritalStatus, premium) values (?,?,?,?,?,?)";
    ps = conn.prepareStatement(cmd);
    ps.setInt(1, agent.getAgentId());
    ps.setString(2, agent.getName());
    ps.setString(3, agent.getCity());
    ps.setString(4, agent.getGender().toString());
    ps.setInt(5, agent.getMaritalStatus());
    ps.setBigDecimal(6, agent.getPremium());
    ps.executeUpdate();

    return "Agent are Added";
  }

  @Override
  public Agent searchAgentDao(int agentId) throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String cmd = "select * from Agent where agentId =?";
    ps = conn.prepareStatement(cmd);
    ps.setInt(1, agentId);
    ResultSet rs = ps.executeQuery();
    Agent agent = null;
    if (rs.next()){
      agent = new Agent();
      agent.setAgentId(rs.getInt("agentId"));
      agent.setName(rs.getString("name"));
      agent.setCity(rs.getString("city"));
      agent.setGender(Gender.valueOf(rs.getString("gender")));
      agent.setMaritalStatus(rs.getInt("maritalStatus"));
      agent.setPremium(rs.getBigDecimal("premium"));
    }
    return agent;
  }

  @Override
  public String updateAgentDao(Agent agent) throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String cmd = "update Agent set name =?, city =?, gender=?, maritalStatus=?, premium=? where agentId=?";
    ps = conn.prepareStatement(cmd);
    ps.setString(1, agent.getName());
    ps.setString(2, agent.getCity());
    ps.setString(3, agent.getGender().toString());
    ps.setInt(4, agent.getMaritalStatus());
    ps.setBigDecimal(5, agent.getPremium());
    ps.setInt(6, agent.getAgentId());
    ps.executeUpdate();
    return "Agent Record are Updated...";
  }

  @Override
  public String deleteAgentDao(int agentId) throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    Agent agentFound = searchAgentDao(agentId);
    if (agentFound != null) {
      String cmd = "delete from Agent where agentId =?";
      ps = conn.prepareStatement(cmd);
      ps.setInt(1, agentId);
      ps.executeUpdate();
      return "Agent are Deleted... ";
    } else {
        return "Agent record not found...";
    }

  }
}
