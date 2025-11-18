package com.java.training.nov_14.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListExample2 {
    public static void main(String[] args) {
        List nums = new ArrayList();
        nums.add(42);
        nums.add(10);
        nums.add(520);
        nums.add(130);

        int sum = 0;
        for (Object ob : nums){
            sum += (Integer) ob;
        }
        System.out.println("Total Sum is :" + sum);
    }
}
