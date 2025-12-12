package com.java.training.circuitbreakerex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployController {
    @Autowired
    private EmployService employService;

    @GetMapping(value = "/showEmploy")
    public List<Employ> showEmploy() {
        return employService.showEmploy();
    }

    @GetMapping(value = "/searchEmploy/{empno}")
    public Employ searchEmploy(@PathVariable int empno) {
        return employService.searchEmploy(empno);
    }

    @PostMapping(value = "/addEmploy")
    public String addEmploy(@RequestBody Employ employ) {
        employService.addEmploy(employ);
        return "Employ added successfully";
    }
}
