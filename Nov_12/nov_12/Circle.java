package com.java.training.nov_12;

import java.util.Scanner;

public class Circle {
    public void calculations(double r){
        double area = Math.PI * r * r;
        double circumference = 2 * Math.PI * r;
        System.out.println("Area of Circle is :" + area);
        System.out.println("Circumference of circle is: " + circumference);
    }
    public static void main(String[] args) {
        double r;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius :");
        r = sc.nextDouble();
        Circle obj = new Circle();
        obj.calculations(r);
    }
}
