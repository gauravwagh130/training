package com.java.training;

public class FIEx {
  @FunctionalInterface
  public interface Sum {
    int sum(int a, int b);
  }

  public static void main(String[] args) {
    Sum sum = (a, b) -> a + b;
    System.out.println(sum.sum(10, 20));
  }
}

