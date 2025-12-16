package com.java.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex2 {
  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1, "Gaurav", "Nagar", 8.12));
    studentList.add(new Student(2, "Mayur", "Mumbai", 7.44));
    studentList.add(new Student(3, "Nikhil", "Pune", 9.19));

    System.out.println("Sorted by Name:- ");
    Comparator<Student> compa = new NameComparator();
    Collections.sort(studentList, compa);
    studentList.forEach(System.out::println);

  }
}
