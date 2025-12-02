package com.java.training.sbemploycrud.controller;

import com.java.training.sbemploycrud.model.Employ;
import com.java.training.sbemploycrud.repository.EmployRepository;
import com.java.training.sbemploycrud.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployController {
    @Autowired
    private EmployService employService;

    @PostMapping(value = "/addEmploy")
    public Employ addEmploy(@RequestBody Employ employ) {
        return employService.save(employ);
    }
    @GetMapping(value="/searchEmploy/{id}")
    public Employ findByEmpno(@PathVariable int id){
        return employService.seach(id);
    }

    @GetMapping(value="/showEmploy")
    public List<Employ> showEmploy(){
        return employService.findAll();
    }
    @PutMapping(value = "/updateEmploy")
    public String updateEmploy(@RequestBody Employ employ){
        return employService.updateEmploy(employ);
    }
    @DeleteMapping(value = "/deleteEmploy/{empno}")
    public String deleteEmploy(@PathVariable int empno){
       return employService.deleteEmploy(empno);
    }
}
