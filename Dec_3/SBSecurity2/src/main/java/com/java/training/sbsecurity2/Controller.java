package com.java.training.sbsecurity2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value="/home")
    public String home() {
        return "This is Unsecure Content...";
    }
    @GetMapping("/delete")
    public String delete()
    {
        return "This is the delete request";
    }


}