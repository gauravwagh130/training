package com.java.traning.dao;

import com.java.traning.model.Agent;
import com.java.traning.model.Gender;
import com.java.traning.util.ConnectionHelper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AgentDaoImpl implements AgentDao {
  MongoDatabase db;
  @Override
  public List<Agent> showAllAgentDao() {
    db = ConnectionHelper.getConnection();
    MongoCollection<Document> col = db.getCollection("agent");
    List<Agent> agentList = new ArrayList<>();
    FindIterable<Document> list = col.find();
    for (Document d : list){
      Agent agent = new Agent();
      agent.setAgentId(d.getInteger("agentId"));
      agent.setName(d.getString("name"));
      agent.setGender(Gender.valueOf(d.getString("gender")));
      agent.setCity(d.getString("city"));
      agent.setPremium(d.getDouble("premium"));
      agentList.add(agent);
    }
    return agentList;
  }

  @Override
  public String addAgentDao(Agent agent) {
    db = ConnectionHelper.getConnection();
    MongoCollection<Document> col = db.getCollection("agent");
    Document doc = new Document();
    doc.put("agentId", agent.getAgentId());
    doc.put("name", agent.getName());
    doc.put("gender", agent.getGender().toString());
    doc.put("city", agent.getCity());
    doc.put("premium", agent.getPremium());

    col.insertOne(doc);
    return "Agent are added successfully...";
  }

  @Override
  public Agent searchAgentDao(int agentId) {
    db = ConnectionHelper.getConnection();
    MongoCollection<Document> col = db.getCollection("agent");
    Document query = col.find(new Document("agentId", agentId)).first();
    if (query == null) {
      return null;
    }
    Agent agent = new Agent();
    agent.setAgentId(agentId);
    agent.setName(query.getString("name"));
    agent.setGender(Gender.valueOf(query.getString("gender")));
    agent.setCity(query.getString("city"));
    agent.setPremium(query.getDouble("premium"));

    return agent;
  }
}
