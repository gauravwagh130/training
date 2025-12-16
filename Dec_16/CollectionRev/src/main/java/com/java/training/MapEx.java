package com.java.training;

import java.util.Arrays;
import java.util.List;

public class MapEx {
  public static void main(String[] args) {
    List<Employ> employ = Arrays.asList(
      new Employ(1, "Akay", 20000),
      new Employ( 1,"Gaurav", 30000)
    );

    int total = employ.stream()
      .map(Employ::getSalary)
      .reduce(0, Integer::sum);

    System.out.println(total); // 50000
  }
}
