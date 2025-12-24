package com.java.training.dec_23;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String...");
        String str=sc.nextLine();
        String words [] =   str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i %2 != 0) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
            System.out.println(words[i]+ " ");
        }
    }
}
