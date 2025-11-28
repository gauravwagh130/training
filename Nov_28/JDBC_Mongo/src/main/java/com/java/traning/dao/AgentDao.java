package com.java.traning.dao;

import com.java.traning.model.Agent;

import java.util.List;

public interface AgentDao {
  List<Agent> showAllAgentDao();
  String addAgentDao(Agent agent);
  Agent searchAgentDao(int agentId);
}
