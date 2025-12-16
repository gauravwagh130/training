package com.java.training;

import java.util.function.Function;

public class FunctionEx {
  public static void main(String[] args) {
    Function<Integer, Integer> square = x -> x * x;
    System.out.println(square.apply(10));
  }
}
