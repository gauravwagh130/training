package com.java.training.nov_14.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx {
    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Gaurav");
        names.put(2, "Nikhil");

        int key;
        String res;
        Scanner sc = new Scanner(System.in);
        key = sc.nextInt();
        res = names.getOrDefault(key, "Not Found");
        System.out.println(res);
    }
}
