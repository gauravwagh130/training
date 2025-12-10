package com.java.training;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmployTest {
  @Test
  public void testConstructor() {
    Employ employ1 = new Employ();
    assertNotNull(employ1);
    Employ employ2 = new Employ(13, "Gaurav", Gender.MALE, "Java", "Programmer",99233);
    assertEquals(13, employ2.getEmpno());
    assertEquals("Gaurav", employ2.getName());
    assertEquals(Gender.MALE, employ2.getGender());
    assertEquals("Java", employ2.getDept());
    assertEquals("Programmer", employ2.getDesig());
    assertEquals(99233, employ2.getBasic(),0);
  }

  @Test
  public void testGettersSetters() {
    Employ employ1 = new Employ();
    employ1.setEmpno(13);
    employ1.setName("Gaurav");
    employ1.setGender(Gender.MALE);
    employ1.setDept("Java");
    employ1.setDesig("Programmer");
    employ1.setBasic(99233);
    assertEquals(13, employ1.getEmpno());
    assertEquals("Gaurav", employ1.getName());
    assertEquals(Gender.MALE, employ1.getGender());
    assertEquals("Java", employ1.getDept());
    assertEquals("Programmer", employ1.getDesig());
    assertEquals(99233, employ1.getBasic(),0);
  }

  @Test
  public void testToString() {
    Employ employ1 = new Employ(13, "Gaurav", Gender.MALE, "Java", "Programmer", 99233);
    String result = "Employ{empno=13, name='Gaurav', gender=MALE, dept='Java', desig='Programmer', basic=99233.0}";
    assertEquals(result, employ1.toString());
  }
}
