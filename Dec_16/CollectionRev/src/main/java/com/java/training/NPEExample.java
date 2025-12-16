package com.java.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NPEExample {
  public static void main(String[] args) {

    String name = null;

    Optional<String> optName = Optional.ofNullable(name);

    String result = optName.orElse("Guest");

    System.out.println(result);
  }
}
