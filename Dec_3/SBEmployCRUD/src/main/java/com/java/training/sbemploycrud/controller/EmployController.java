package com.java.training.sbemploycrud.controller;

import com.java.training.sbemploycrud.model.Employ;
import com.java.training.sbemploycrud.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployController {

    @Autowired
    private EmployService employService;

    @PostMapping("/addEmploy")
    public ResponseEntity<Employ> addEmploy(@RequestBody Employ employ) {
        Employ saved = employService.save(employ);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/searchEmploy/{id}")
    public ResponseEntity<Employ> findByEmpno(@PathVariable int id) {
        Employ employ = employService.seach(id);

        if (employ == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(employ);
    }

    @GetMapping("/showEmploy")
    public ResponseEntity<List<Employ>> showEmploy() {
        List<Employ> list = employService.findAll();
        return ResponseEntity.ok(list);
    }


    @PutMapping("/updateEmploy")
    public ResponseEntity<String> updateEmploy(@RequestBody Employ employ) {
        String result = employService.updateEmploy(employ);

        if (result.equalsIgnoreCase("Employ Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteEmploy/{empno}")
    public ResponseEntity<String> deleteEmploy(@PathVariable int empno) {
        String result = employService.deleteEmploy(empno);

        if (result.equalsIgnoreCase("Employ Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }

        return ResponseEntity.ok(result);
    }
}
