package com.java.training.nov_18;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n%2 ==0;
        System.out.println(isEven.test(56));
        System.out.println(isEven.test(21));
        System.out.println("Predicate for String...");
        Predicate<String> isLong = s -> s.length()>5;
        System.out.println(isLong.test("Gaurav"));

    }
}
