package com.java.training.dec_23;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter number");
        String number=sc.nextLine();
        String parts [] = number.split("\\.");
        double decimal = 0;

        int power = 0;
        for (int i = parts[0].length()-1; i >=0 ; i--) {
            decimal += (parts[0].charAt(i)-'0')*Math.pow(2,power++);
        }

        if (parts.length == 2) {
            double frac = 0.5;
            for (char c : parts[1].toCharArray()) {
                decimal += (c-'0')*frac;
                frac/= 2;
            }

        }
        System.out.println(decimal);
    }
}
