package com.java.training.nov_12;

import java.util.Scanner;

public class CurrentBill {
    public double calculateBill(int units){
        int [] unitSlabs = {90, 150, 200, 240};
        double[] rateSlabs = {1, 1.5, 2, 2.5, 3};

        double bill = 0;
        int previousUnits=0;
        for (int i = 0; i < unitSlabs.length; i++) {
            if (units > unitSlabs[i]){
                bill += (unitSlabs[i]- previousUnits) * rateSlabs[i];
                previousUnits = unitSlabs[i];
            }
            else{
                bill += (units - previousUnits) * rateSlabs[i];
                return bill;
            }
        }
        bill += (units - previousUnits)* rateSlabs[rateSlabs.length -1 ];
        return bill;
    }
    public static void main(String[] args) {
        int units;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total units :");
        units = sc.nextInt();
        CurrentBill obj = new CurrentBill();

        double total = obj.calculateBill(units);
        System.out.println("Total Bill is :" + total);
    }
}
