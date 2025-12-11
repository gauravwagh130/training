package com.java.training;

import org.apache.log4j.Logger;

public class Hello {
  private static final Logger logger = Logger.getLogger(Hello.class);
  public static void main(String[] args) {
    logger.info("Info test");
    logger.error("Error test");
    System.out.println("Done");
  }

}
