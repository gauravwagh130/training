package com.java.training.nov_18;

import java.security.PublicKey;

public class MethodRefEx2 {
    public static String convertSubString(String s){
        return s.substring(0, 5);
    }

    public static void main(String[] args) {
        StringProcessor proc = MethodRefEx2::convertSubString;
        System.out.println(proc.process("Gaurav Wagh"));
    }
}
