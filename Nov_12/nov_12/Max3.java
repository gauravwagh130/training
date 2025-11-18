package com.java.training.nov_12;

import java.util.Scanner;

public class Max3 {
    public void checkMaxNum(int a, int b, int c) {
        int m = a;

        if (m < b) {
            m = b;
        }
        if (m < c) {
            m = c;
        }

        System.out.println("Maximum number is " + m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the 3 numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        Max3 obj = new Max3();
        obj.checkMaxNum(a, b, c);
    }
}
