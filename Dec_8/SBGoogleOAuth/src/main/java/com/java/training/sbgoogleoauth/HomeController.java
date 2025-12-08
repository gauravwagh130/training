package com.java.training.sbgoogleoauth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "<a href='/oauth2/authorization/google'>Login with Google</a>";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User user) {

        return "Welcome " + user.getAttribute("name")
                + "<br>Email: " + user.getAttribute("email")
                + "<br>Picture: <img src='" + user.getAttribute("picture") + "' width='100'/>"
                + "<br><a href='/logout'>Logout</a>";
    }
}
