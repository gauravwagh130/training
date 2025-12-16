package com.java.training;

import java.util.Optional;

public class NPEEx2 {
  public static void main(String[] args) {
    Student student = null; // could be null from DB or API

    String studentName = Optional.ofNullable(student)
      .map(Student::getName)
      .orElse("Unknown Student");

    System.out.println(studentName);

  }
}
