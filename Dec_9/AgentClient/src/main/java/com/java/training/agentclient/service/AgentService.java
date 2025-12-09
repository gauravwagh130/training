package com.java.training.agentclient.service;

import com.java.training.agentclient.exception.ResourceNotFoundException;
import com.java.training.agentclient.model.Agent;
import com.java.training.agentclient.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;
    public List<Agent> findAllAgent() {
        return agentRepository.findAll();
    }
    public String addAgent(Agent agent) {
        agentRepository.save(agent);
        return "Added Agent Successfully";
    }

    public Agent searchAgent(int agentId) {
        Agent agent = agentRepository.searchByAgentId(agentId);
        if (agent == null) {
            throw new ResourceNotFoundException("Agent Not Found");
        }
        return agent;
    }

    public String updateAgent(int agentId, Agent updatedAgent) {
        Agent existing = agentRepository.searchByAgentId(agentId);
        existing.setFirstName(updatedAgent.getFirstName());
        existing.setLastName(updatedAgent.getLastName());
        existing.setCity(updatedAgent.getCity());
        existing.setState(updatedAgent.getState());
        existing.setPremiumPaid(updatedAgent.getPremiumPaid());
        agentRepository.save(existing);
        return "Updated Agent Successfully";
    }

    public String deleteAgent(int agentId) {
        Agent agent = agentRepository.searchByAgentId(agentId);
        if (agent == null) {
            throw new ResourceNotFoundException("Agent Not Found");
        }

        agentRepository.delete(agent);
        return "Deleted Agent Successfully";
    }

}
