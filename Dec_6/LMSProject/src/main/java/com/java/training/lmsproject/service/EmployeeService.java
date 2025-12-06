package com.java.training.lmsproject.service;

import com.java.training.lmsproject.model.Employee;
import com.java.training.lmsproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> showEmployee() {
        return employeeRepository.findAll();
    }

    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee added successfully";
    }

    public Employee findByEmpNo(int EmpId) {
        return employeeRepository.findByEmpId(EmpId);
    }
}
