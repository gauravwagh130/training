package com.java.training.agentclient.repository;

import com.java.training.agentclient.model.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends MongoRepository<Agent, String> {
    Agent searchByAgentId( int agentId);
}
