package com.java.training.nov_14.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set names = new HashSet();
        names.add("Gaurav");
        names.add("Saurav");
        names.add("Gauri");
        names.add("Ashtha");
        names.add("Gaurav");
        names.add("sham");

        System.out.println("Names are");
        for (Object ob : names){
            System.out.println(ob);
        }
    }

}
