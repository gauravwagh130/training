package com.java.training.nov_12;

import java.util.Scanner;

public class CaseEx2 {
    public void show(int month){
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("Month has 31 days");
            case 4, 6, 9, 11 -> System.out.println("Month has 30 days");
            case 2 -> System.out.println("Month is either 29 or 28 days...");
            default -> System.out.println("Invalid Input");
        }
    }
    public static void main(String[] args) {
        int month;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Month Number");
        month = sc.nextInt();
        CaseEx2 obj = new CaseEx2();
        obj.show(month);
    }
}
