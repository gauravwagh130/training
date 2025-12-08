package com.java.training.agentclient.controller;

import com.java.training.agentclient.model.Agent;
import com.java.training.agentclient.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {
    @Autowired
    private AgentService agentService;
    @GetMapping(value = "/showAllAgent")
    public ResponseEntity<List<Agent>> findAllAgent() {
        return ResponseEntity.ok(agentService.findAllAgent());
    }
    @GetMapping(value = "/searchAgent/{agentId}")
    public ResponseEntity<Agent> findByAgentId(@PathVariable int agentId) {
        Agent agent = agentService.searchAgent(agentId);
        return ResponseEntity.ok(agent);
    }

    @PostMapping(value = "/addAgent")
    public ResponseEntity<String> addAgent(@RequestBody Agent agent) {
        agentService.addAgent(agent);
        return ResponseEntity.ok("Agent added successfully");

    }

    @PutMapping(value = "/updateAgent/{agentId}")
    public ResponseEntity<String> update(@PathVariable int agentId, @RequestBody Agent agent) {
        agentService.updateAgent(agentId, agent);
        return ResponseEntity.ok("Agent updated successfully");
    }

    @DeleteMapping(value = "/delete/{agentId}")
    public ResponseEntity<String> deleteAgent(@PathVariable int agentId) {
        agentService.deleteAgent(agentId);
        return ResponseEntity.ok("Agent deleted successfully");
    }
}
