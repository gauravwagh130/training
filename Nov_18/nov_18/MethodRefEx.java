package com.java.training.nov_18;


public class MethodRefEx {
    public static String toUpper(String s){
        return s.toUpperCase();
    }

    public static String toLower(String s){
        return s.toLowerCase();
    }

    public static void main(String[] args) {
        StringProcessor processor = MethodRefEx::toUpper;
        System.out.println(processor.process("Gaurav"));

        processor = MethodRefEx::toLower;
        System.out.println(processor.process("Gaurav"));
    }
}
