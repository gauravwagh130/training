package com.java.training.eurekainnerclientnew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/")
    public String home() {
        return "Home — <a href='/oauth2/authorization/github'>Login With GitHub</a>";
    }

    @GetMapping(value = "/showAgent")
    public Object showAgent(@AuthenticationPrincipal OAuth2User user) {
        return restTemplate.getForObject("http://AGENTCLIENT/showAllAgent", Object.class);
    }

    @GetMapping(value = "/complaint")
    public Object complaint() {
        return restTemplate.getForObject("http://REGISTERSERVICE/showAllComplaint", Object.class);
    }

}
