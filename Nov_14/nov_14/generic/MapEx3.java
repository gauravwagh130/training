package com.java.training.nov_14.generic;

import java.util.HashMap;
import java.util.Map;

public class MapEx3 {
    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Gaurav");
        names.put(2, "Nikhil");

        for(Map.Entry<Integer, String> entry:names.entrySet()){
            System.out.println(entry.getKey()+ " "+entry.getValue());
        }
    }
}
