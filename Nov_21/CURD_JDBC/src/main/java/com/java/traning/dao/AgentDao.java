package com.java.traning.dao;

import com.java.traning.model.Agent;

import java.sql.SQLException;
import java.util.List;

public interface AgentDao {
  List<Agent> showExamDao() throws SQLException, ClassNotFoundException;
  String addAgentDao(Agent agent) throws SQLException, ClassNotFoundException;
  Agent searchAgentDao(int agentId) throws SQLException, ClassNotFoundException;
  String updateAgentDao(Agent agent) throws SQLException, ClassNotFoundException;
  String deleteAgentDao(int agentId) throws SQLException, ClassNotFoundException;
}
