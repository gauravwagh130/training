package com.java.traning;

public class Family {
  private String city;
  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void showInfo(){
    System.out.println("City is "+city + "State is "+ state);
  }
}
