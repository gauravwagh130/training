package com.java.training;


import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataTest {

  static Data data;
  @BeforeAll
  public static void setup() {
    data = new Data();
  }

  @BeforeEach
  public void beforeEach() {
    System.out.println("Test Case Started...");
  }

  @AfterEach
  public void afterEach() {
    System.out.println("Test Case Ended...");
  }

  @AfterAll
  static void cleanUp() {
    data = null;
    System.out.println("Program Ended...");
  }

  @Test
  public void testSayHello() {
    assertEquals("Hello World!", data.sayHello());
  }

  @Test
  public void testSum() {
    assertEquals(5, data.sum(2, 3));
  }

  @Test
  public void testNames() {
    List<String> names = data.names();
    assertAll(
      () -> assertEquals(3, names.size()),
      () -> assertTrue(names.contains("Gaurav")),
      () -> assertTrue(names.contains("b")),
      ()-> assertTrue(names.contains("c"))

    );
  }

  @Test
  public void testEvenOdd() {
    assertTrue(data.evenOdd(2));
    assertFalse(data.evenOdd(1));
  }
}
