package com.java.training.nov_13;

import java.util.Scanner;

public class NumToRoman {
    public void convertToRoman(int num) {
        int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40,  10, 9,  5, 4,  1};
        String[] roman = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        System.out.println(values.length);
        String result = "";
        for (int i = 0; i < values.length; i++) {
          while(num >= values[i]){
              result += roman[i];
              num -= values[i];
          }

        }
        System.out.println("Roman Number is :" + result);
    }

    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Num :");
        num = sc.nextInt();
        NumToRoman obj = new NumToRoman();
        obj.convertToRoman(num);

    }
}
