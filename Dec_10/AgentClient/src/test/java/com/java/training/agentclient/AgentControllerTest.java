package com.java.training.agentclient;

import com.java.training.agentclient.controller.AgentController;
import com.java.training.agentclient.model.Agent;
import com.java.training.agentclient.service.AgentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AgentControllerTest {
    @InjectMocks
    private AgentController agentController;
    @Mock
    private AgentService agentService;

    private MockMvc  mockMvc;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(agentController).build();
    }

    @Test
    public void testShowAgent() throws Exception {
        Agent a1 = new Agent(1, "Gaurav", "Wagh", "Nagar", "MH", 98222);
        Agent a2 = new Agent(2, "Ram", "M", "Pune", "MH", 87678);
        List<Agent> agentList = Arrays.asList(a1, a2);
        when(agentService.findAllAgent()).thenReturn(agentList);

        mockMvc.perform(get("/showAllAgent"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].agentId").value(1))
                .andExpect(jsonPath("$[0].firstName").value("Gaurav"))
                .andExpect(jsonPath("$[0].lastName").value("Wagh"))
                .andExpect(jsonPath("$[0].city").value("Nagar"))
                .andExpect(jsonPath("$[0].state").value("MH"))
                .andExpect(jsonPath("$[0].premiumPaid").value(98222));
    }

    @Test
    public void searchAgent() throws Exception {
        Agent a1 = new Agent(1, "Gaurav", "Wagh", "Nagar", "MH", 98222);

        when(agentService.searchAgent(1)).thenReturn(a1);
        mockMvc.perform(get("/searchAgent/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Gaurav"));

        ;
    }

    @Test
    public void testAddAgent() throws Exception {
        when(agentService.addAgent(Mockito.any(Agent.class)))
                .thenReturn("Agent added successfully");

        String jsonBody = """
                {
                  "agentId": 100,
                  "firstName": "Gaurav",
                  "lastName": "Wagh",
                  "city": "Nagar",
                  "state":"MH",
                  "premiumPaid": 98222
                }
                """;

        mockMvc.perform(post("/addAgent")                                            // leading slash required
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string("Agent added successfully"));              // matches the mocked return
    }
}