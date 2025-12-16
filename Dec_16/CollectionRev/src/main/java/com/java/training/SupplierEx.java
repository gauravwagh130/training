package com.java.training;

import java.util.function.Supplier;

public class SupplierEx {
  public static void main(String[] args) {
    Supplier<String> supplier = () -> "Hello Java";
    System.out.println(supplier.get());
  }
}
