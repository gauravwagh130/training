package com.java.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda1 {
  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1, "Gaurav", "Nagar", 8.12));
    studentList.add(new Student(2, "Mayur", "Mumbai", 7.44));
    studentList.add(new Student(3, "Nikhil", "Pune", 9.19));

    Collections.sort(studentList, (Student s1, Student s2) -> s1.getCity().compareTo(s2.getCity()));
    studentList.forEach(System.out::println);
  }
}
