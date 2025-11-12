package com.java.training.nov_12;

import java.util.Scanner;

public class CaseEx {
    public void show(int choise){
        switch (choise){
            case 1:
                System.out.println("Gaurav");
                break;
            case 2:
                System.out.println("Nikhil");
                break;
            case 3:
                System.out.println("Ram");

        }


    }
    public static void main(String[] args) {
        int choise;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the choise");
        choise = sc.nextInt();
        CaseEx obj = new CaseEx();
        obj.show(choise);
    }
}
