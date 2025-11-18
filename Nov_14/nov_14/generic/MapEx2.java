package com.java.training.nov_14.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> userData = new HashMap<>();
        userData.put("Gaurav", "Wagh");
        userData.put("Priya","Darshini");
        userData.put("Harsh", "Naidu");

        String user, pwd, res;
        System.out.println("Enter userName and passWord");
        user= sc.nextLine();
        pwd = sc.nextLine();
        res = userData.getOrDefault(user, "Invalid Password");
        if(res.equals(pwd)){
            System.out.println("Correct credentials");
        }
        else {
            System.out.println("Incorrect Credentials");
        }
    }
}
