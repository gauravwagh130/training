package com.java.traning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("chatbot.xml");
    HelloWorld helloWorld = (HelloWorld) ctx.getBean("bean1");
    helloWorld.showInfo("Gaurav");
  }
}
