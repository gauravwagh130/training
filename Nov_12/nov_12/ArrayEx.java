package com.java.training.nov_12;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx {
    public void show(){
        int[] arr = new int[]{1,2};
        for(int num : arr){
            System.out.println(num);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayEx ob = new ArrayEx();
        ob.show();
//        System.out.println("Enter the size of array");
//        int size = sc.nextInt();
//        int[] arr = new int[size];
//        System.out.println("Enter the elements of array");
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }
//        for (int num : arr){
//            System.out.println(num);
//        }

    }
}
