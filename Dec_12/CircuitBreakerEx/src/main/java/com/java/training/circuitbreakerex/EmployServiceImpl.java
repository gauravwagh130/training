package com.java.training.circuitbreakerex;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployServiceImpl implements EmployService {

    @Autowired
    private EmployRepository employRepository;
    @Override
    @CircuitBreaker(name = "employCB", fallbackMethod = "fallbackShowEmploy")
    public List<Employ> showEmploy() {
        // FORCE FAILURE --> Ensures fallback gets triggered
        if (true) {
            throw new RuntimeException("DB Down!");
        }

        return employRepository.findAll();
    }

    @Override
    @CircuitBreaker(name = "employCB", fallbackMethod = "fallbackAddEmploy")
    public String addEmploy(Employ employ) {
        throw new RuntimeException("Insert Failure");
    }

    @Override
    @CircuitBreaker(name = "employDB", fallbackMethod = "fallbackSearchEmploy")
    public Employ searchEmploy(int empno) {
        throw new RuntimeException("Search Failed");
    }

    public List<Employ> fallbackShowEmploy(Throwable ex) {
        System.out.println("Fallback: showEmploy: " + ex.getMessage());
        return List.of();
    }

    public Employ fallbackSearchEmploy(int empno, Throwable ex) {
        System.out.println("Fallback: searchEmploy: " + ex.getMessage());
        return null;
    }
    public Employ fallbackAddEmploy(Employ employ,  Throwable ex) {
        System.out.println("Fallback: addEmploy: " + ex.getMessage());
        return null;
    }
}
