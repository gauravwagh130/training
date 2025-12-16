package com.java.training;

import java.util.Arrays;
import java.util.List;

public class DistinctEx {
  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(10, 20, 10, 34, 20 , 11, 10, 34);
    nums.stream().distinct().forEach(System.out::println);
  }
}
