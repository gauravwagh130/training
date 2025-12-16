package com.java.training;

import java.util.function.Consumer;

public class ConsumerEx {
  public static void main(String[] args) {
    Consumer<String> printer = s -> System.out.println(s);
    printer.accept("Hello Java");
  }
}
