package com.java.training.nov_12;

import java.util.Scanner;

public class ForLoop {
    public void checkPrimeOrNotPrime(int n) {
        boolean flag = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0){
                flag = false;
                break;
            }
        }
        if (flag == true){
            System.out.println(n + " is a Prime Number");
        }
        else {
            System.out.println("Not a Prime Number");
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Num :");
        n = sc.nextInt();
        ForLoop obj = new ForLoop();
        obj.checkPrimeOrNotPrime(n);
    }
}
