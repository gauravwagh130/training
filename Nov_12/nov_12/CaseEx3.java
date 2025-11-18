package com.java.training.nov_12;

import java.util.Scanner;

public class CaseEx3 {
    public int show(int year, int month) {
        int result = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                System.out.println("Month has 31 days");
                yield 31;
            }
            case 4, 6, 9, 11 -> {
                System.out.println("Month has 30 days");
                yield 30;
            }
            case 2 -> {
                if (year % 4 == 0) {
                    System.out.println("It's a Leap Year, you have 29 days...");
                    yield 29;
                } else {
                    System.out.println("It's not a Leap Year, it has 28 days only...");
                    yield 28;
                }
            }
            default -> {
                System.out.println("Invalid month number!");
                yield -1;
            }
        };
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year and month number: ");
        int year = sc.nextInt();
        int month = sc.nextInt();

        CaseEx3 obj = new CaseEx3();
        int days = obj.show(year, month);
        if (days != -1) {
            System.out.println("Total days: " + days);
        }
    }
}
