package com.java.training;

import java.util.Arrays;
import java.util.List;

public class Data {
  public String sayHello() {
    return "Hello World!";
  }
  public int sum(int a, int b) {
    return a + b;
  }

  public List<String> names() {
    List<String> names = Arrays.asList(new String[]{"Gaurav", "b", "c"});
    return names;
  }

  public boolean evenOdd(int n) {
    if (n%2==0) {
      return true;
    }
    return false;
  }
}
