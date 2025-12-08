package com.java.training.sboauth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "<a href='/oauth2/authorization/github'>Login with GitHub</a>";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User user) {
        return "Welcome " + user.getAttribute("login") +
                "<br>GitHub ID: " + user.getAttribute("id") +
                "<br><a href='/logout'>Logout</a>";
    }
}
