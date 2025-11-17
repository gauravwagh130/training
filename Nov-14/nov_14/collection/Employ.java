package com.java.training.nov_14.collection;

import java.util.Objects;

public class Employ {
    int empno;
    String name;
    double salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return empno == employ.empno && Double.compare(salary, employ.salary) == 0 && Objects.equals(name, employ.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, name, salary);
    }

    public Employ(int empno, String name, double salary) {
        this.empno = empno;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
