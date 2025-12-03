package com.java.training.sbsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContoller {
    @GetMapping("/home")
    public String home() {
        return "Welcome to the secured site!";
    }
}
