package com.java.training.sbemploycrud.service;

import com.java.training.sbemploycrud.model.Employ;
import com.java.training.sbemploycrud.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService {
    @Autowired
    private EmployRepository employRepository;
    public List<Employ> findAll() {
        return employRepository.findAll();
    }

    public Employ seach(int empno) {
        return employRepository.findByEmpno(empno);
    }
    public Employ save(Employ employ) {
        return employRepository.save(employ);
    }

    public String updateEmploy(Employ employ) {
        employRepository.save(employ);
        return "Employ updated";
    }
    public String deleteEmploy(int empno) {
        Employ employFound = employRepository.findByEmpno(empno);
        employRepository.delete(employFound);
        return "employ has been deleted";
    }
}
