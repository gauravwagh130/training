package com.java.training;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Division {
  private static Logger logger = Logger.getLogger(Division.class);

  public static void main(String[] args) {
    int a, b, c;
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter 2 numbers   : ");
    logger.info("Performing Division of 2 Numbers Program...");
    try {
      a = sc.nextInt();
      b = sc.nextInt();
      c = a / b;
      System.out.println("Division " +c);
      logger.info("Program Executed with No Errors...");
    } catch(ArithmeticException e) {
      System.err.println("Division by zero Impossible...");
      logger.error("Division by zero Impossible...Error Occurred");
    } catch (InputMismatchException e) {
      System.err.println("Please enter a valid integer...");
      logger.error("Please enter a valid integer...Error Occurred...");
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
