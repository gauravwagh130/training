package com.java.training.nov_18;

import java.util.Arrays;
import java.util.List;

public class FlatMapEx2 {
    public static void main(String[] args) {
        List<List<Integer>> list = List.of(List.of(12,32,23), List.of(43, 21), List.of(33, 12, 55));

        list.stream().flatMap(integers -> integers.stream()).forEach(System.out::println);


        List<String> names = List.of("Gaurav", "Ram");
        System.out.println("Split names into characters");
        names.stream()
                .flatMap(name -> Arrays.stream(name.split("")))
                .forEach(System.out::println);
    }
}
