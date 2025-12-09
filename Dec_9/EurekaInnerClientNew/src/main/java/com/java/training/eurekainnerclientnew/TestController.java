package com.java.training.eurekainnerclientnew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/showAgent")
    public Object showEmploy() {
        return restTemplate.getForObject("http://AGENTCLIENT/showAllAgent", Object.class);
    }

    @GetMapping(value = "/complaint")
    public Object complaint() {
        return restTemplate.getForObject("http://REGISTERSERVICE/showAllComplaint", Object.class);
    }

}
