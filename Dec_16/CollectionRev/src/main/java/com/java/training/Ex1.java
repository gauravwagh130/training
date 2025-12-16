package com.java.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex1 {
  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    Student s1 = new Student(1, "Gaurav", "Nagar", 8.12);
    Student s2 = new Student(2, "Nikhil", "Pune", 9.00);
    Student s3 = new Student(3, "Mayur", "Pune", 7.62);
    studentList.add(s1);
    studentList.add(s2);
    studentList.add(s3);
    studentList.forEach(System.out::println);
  }
}
