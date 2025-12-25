package com.java.training.dec_24;

import com.java.training.nov_13.inheritance.Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransEx {
   public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, 100, "GROCERY"),
                new Transaction(3, 80, "GROCERY"),
                new Transaction(6, 120, "GROCERY"),
                new Transaction(7, 40, "ELECTRONICS"),
                new Transaction(10, 50, "GROCERY")
        );

        System.out.println("Filter Operation:-");
        transactions.stream().filter(x-> x.getValue()<100).forEach(System.out::println);
       System.out.println("Map Operation:-");
       transactions.stream().map(Transaction::getType).forEach(System.out::println);
       System.out.println("Sorted Operation:-");
       transactions.stream().sorted(Comparator.comparing(Transaction::getValue).reversed()).forEach(System.out::println);
       System.out.println("Distinct Operation:-");
       transactions.stream().map(Transaction::getType).distinct().forEach(System.out::println);

       Map<Integer, String> map = transactions.stream().collect(Collectors.toMap(Transaction::getId, Transaction::getType));
       map.entrySet().forEach(System.out::println);
       int total =
               transactions.stream()
                       .map(Transaction::getValue)
                       .reduce(0, Integer::sum);

       System.out.println("Total Value = " + total);


    }
}
