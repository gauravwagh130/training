package com.java.training.lmsproject.controller;

import com.java.training.lmsproject.exception.ResourceNotFoundException;
import com.java.training.lmsproject.model.Employee;
import com.java.training.lmsproject.repository.EmployeeRepository;
import com.java.training.lmsproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/showEmployee")
    public ResponseEntity<List<Employee>> showEmployee(){
        List<Employee> employees = employeeService.showEmployee();
        return ResponseEntity.ok(employees);
    }

    @GetMapping(value = "/searchEmployee/{empId}")
    public ResponseEntity<Employee> searchEmployee(@PathVariable int empId) {
        Employee employeeFound = employeeService.findByEmpNo(empId);
        if(employeeFound == null){
            throw new ResourceNotFoundException("Employee not found: " + empId);
        }
        return ResponseEntity.ok(employeeFound);
    }
    @PostMapping(value = "/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
       String result = employeeService.addEmployee(employee);
       return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
