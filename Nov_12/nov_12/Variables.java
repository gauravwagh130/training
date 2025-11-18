package com.java.training.nov_12;

class Variable {

    // Instance variables
    int id = 101;
    String name = "Gaurav";

    // Static variable
    static String college = "SGOI COEM College";
    void showDetails() {

        // Local variable
        int marks = 85;

        System.out.println("Local Variable (marks): " + marks);
        System.out.println("Instance Variable (id): " + id);
        System.out.println("Instance Variable (name): " + name);
        System.out.println("Static Variable (college): " + college);
    }

    public static void main(String[] args) {
        Variable obj = new Variable();
        obj.showDetails();
    }
}
