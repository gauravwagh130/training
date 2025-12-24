package com.java.training.dec_23;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a sentence");
        String sent=sc.nextLine();
        String words [] = sent.split(" ");

        for(String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            if(word.equals(rev)) {
                System.out.println(word + " ");
            }
        }
    }
}
