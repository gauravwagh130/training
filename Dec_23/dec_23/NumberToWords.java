package com.java.training.dec_23;

import java.util.Scanner;

public class NumberToWords {
    static String[] ones = {
            "", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    static String[] tens = {
        "", "", "twenty", "thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    public static String numberToWords(int num) {
        StringBuilder words = new StringBuilder();

        if(num >1000){
            words.append(ones[num/1000]).append(" thousand ");
            num = num%1000;
        }
        if(num>100){
            words.append(ones[num/100]).append(" hundred ");
            num = num%100;
        }
        if(num>20){
            words.append(ones[num/10]).append(" ");
            num = num%10;
        }
        return words.toString();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scan.nextInt();
        if(num ==0){
            System.out.println("Zero");
            return;
        }
        if(num>9999 || num<0){
            System.out.println("only numbers up to 4 digits are allowed");
            return;
        }
        System.out.println(numberToWords(num));
    }
}
