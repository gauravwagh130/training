package com.java.training;

import org.apache.log4j.Logger;

public class Test {
  private static final Logger logger = Logger.getLogger(Test.class);
  private static final Logger alertLogger = Logger.getLogger("com.example.alerts");

  public static void main(String[] args) throws InterruptedException {
    logger.trace("Trace message (very fine)");
    logger.debug("Debug message");
    logger.info("Info message - application started");
    logger.warn("Warning message - something odd");
    logger.error("Error message - something failed");
    logger.fatal("Fatal message - critical failure");

    // Trigger alert logger (ERROR) which is attached to SMTP appender
    alertLogger.error("Critical error for team: immediate attention required!");

    // Log to a different package-level logger (shows additivity and package config)
    Logger pkgLogger = Logger.getLogger("com.example.sub.Feature");
    pkgLogger.debug("Debug from sub-feature");

    // Demonstrate many logs quickly (rollover or async behavior)
    for (int i = 0; i < 5; i++) {
      logger.info("High-volume log entry #" + i);
    }

    System.out.println("Logging demo complete.");
  }
}
