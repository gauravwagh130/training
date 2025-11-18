package com.java.training.nov_18;

public class Employ {
    private int empno;
    private String name;
    private double basic;

    public Employ(int empno, String name, double basic) {
        this.empno = empno;
        this.name = name;
        this.basic = basic;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", basic=" + basic +
                '}';
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasic() {
        return basic;
    }

    public Integer setBasic(double basic) {
        this.basic = basic;
        return null;
    }
}
