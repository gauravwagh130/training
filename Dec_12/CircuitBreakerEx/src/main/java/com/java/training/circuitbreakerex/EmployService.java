package com.java.training.circuitbreakerex;

import java.util.List;

public interface EmployService {
    List<Employ> showEmploy();
    String addEmploy(Employ employ);
    Employ searchEmploy(int empno);
}
