package com.java.training.nov_12;

import java.util.Scanner;

public class PosNeg {
    public void check(int n){
        if (n>=0){
            System.out.println("Its positive num");
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        PosNeg posNeg = new PosNeg();
        posNeg.check(n);
    }
}
