package com.java.training.springsecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(value = "/")
    public String home(HttpServletRequest request) {
        return "Welcome to Spring Security..." +  request.getSession().getId();
    }
}
