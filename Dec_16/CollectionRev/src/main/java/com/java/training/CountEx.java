package com.java.training;

import java.util.Arrays;
import java.util.List;

public class CountEx {
  public static void main(String[] args) {
    List<Employ> employ = Arrays.asList(
      new Employ(1, "Akay", 20000),
      new Employ(2, "Gaurav", 30000),
      new Employ(3, "Shree", 25000)
    );

    int count = employ.stream()
      .map(e -> 1)
      .reduce(0, Integer::sum);

    System.out.println(count);
  }
  }

