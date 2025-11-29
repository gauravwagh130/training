package com.java.traning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
    HelloImpl helloImpl = (HelloImpl) ctx.getBean("bean1");
    System.out.println(helloImpl.sayHello("Gaurav"));
  }
}
