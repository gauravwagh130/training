package com.java.training.nov_17.jdk8_features;

import java.util.Arrays;
import java.util.List;

public class LambdaExpr3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,43, 13, 55);
        numbers.forEach(x -> System.out.println(x));
    }

}
