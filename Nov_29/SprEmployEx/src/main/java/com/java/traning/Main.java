package com.java.traning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
    Person person1 = (Person) ctx.getBean("person1");
    Person person2 = (Person) ctx.getBean("person2");
    Person person3 = (Person) ctx.getBean("person3");
    person1.showAll();
    System.out.println("------------------------------------");
    person2.showAll();
    System.out.println("------------------------------------");
    person3.showAll();
  }
}
