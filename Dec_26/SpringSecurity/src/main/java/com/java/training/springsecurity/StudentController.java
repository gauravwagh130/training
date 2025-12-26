package com.java.training.springsecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student>studentList = new ArrayList<>(List.of(
            new Student(1, "Gaurav", 90),
            new Student(2, "Akay", 80 )
    ));
    @GetMapping(value = "/students")
    public List<Student> getStudentList() {
        return studentList;
    }
    @GetMapping(value = "/csrf")
    public CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping(value = "/students")
    public Student addStudent(@RequestBody Student student) {
        studentList.add(student);
        return student;
    }
}
