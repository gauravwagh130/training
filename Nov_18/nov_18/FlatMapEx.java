package com.java.training.nov_18;

import java.util.Arrays;
import java.util.List;

public class FlatMapEx {
    public static void main(String[] args) {
        List<String > list1 = Arrays.asList("Gaurav", "Sai", "Lokesh");
        List<String > list2 = Arrays.asList("Akshitha", "Junaid", "Priya");
        List<String> list3 = Arrays.asList("Shaili", "Vivek", "Indu");

        List<List<String>> all = Arrays.asList(list1, list2, list3);
        all.forEach(System.out::println);

        System.out.println("Print elements using flatMap");
        all.stream().flatMap(e->e.stream()).forEach(System.out::println);
    }
}
