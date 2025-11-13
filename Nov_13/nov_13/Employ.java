package com.java.training.nov_13;

public class Employ {
    private int empno;
    private String name;
    private double salary;

    public Employ ( int empno, String name, double salary){
        this.empno = empno;
        this.name = name;
        this.salary = salary;
    }

    public Employ(){}
    @Override
    public String toString() {
        return "Employ{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", basic=" + salary +
                '}';
    }
}
