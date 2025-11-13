package com.java.training.nov_13;

import java.util.Scanner;

public class Mult {
    public void multiplication(String number1, String number2){
//        String number1 = "134356787654322345678901234567654323456432124567812345987654323456709876543123456789876543234567833";
//        String number2 = "1234598765432345670987654312345678987654323456783312345987654323456709876543123456789876543234567833";
        int m = number1.length();
        int n = number2.length();
        int [] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int d1 = number1.charAt(i) - '0';
            for (int j = n-1; j>=0 ; j--){
                int d2 = number2.charAt(j) - '0';
                res[i + j + 1] += d1 * d2;
            }
        }

        for (int i = m + n - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        String finalResult = "";
        int start = 0;
        if (res[0] == 0) {
            start = 1;
        }
        for (int i = start; i < res.length; i++) {
            finalResult += res[i];
        }
        System.out.println(finalResult);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter then first number:");
        String number1 = sc.nextLine();
        System.out.println("Enter the Second number:");
        String number2 = sc.nextLine();
        Mult obj = new Mult();
        obj.multiplication( number1, number2);
    }
}
