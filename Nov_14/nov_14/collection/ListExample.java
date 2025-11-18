package com.java.training.nov_14.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListExample {
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add("Gaurav");
        names.add("Nikhil");
        names.add("Mayur");
        names.add("Ram");

        System.out.println("Names are: ");
        for (Object obj : names){
            System.out.println(obj);
        }

        names.add(3, "Sham");
        System.out.println("Names after Insert: ");
        for (Object obj : names){
            System.out.println(obj);
        }

        names.set(3, "Krushna");
        System.out.println("Names after Updated: ");
        for (Object obj : names){
            System.out.println(obj);
        }

        names.remove(3);
        System.out.println("Names after deleted: ");
        for (Object obj : names){
            System.out.println(obj);
        }
    }
}
