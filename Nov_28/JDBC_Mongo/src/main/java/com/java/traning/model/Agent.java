package com.java.traning.model;

import java.math.BigDecimal;

public class Agent {
  private int agentId;
  private String name;
  private String city;
  private Gender gender;
  private double premium;

  public Agent() {
  };

  public Agent(int agentId, String name, String city, Gender gender, double premium) {
    this.agentId = agentId;
    this.name = name;
    this.city = city;
    this.gender = gender;
    this.premium = premium;
  }


  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAgentId() {
    return agentId;
  }

  public void setAgentId(int agentId) {
    this.agentId = agentId;
  }

  public double getPremium() {
    return premium;
  }

  public void setPremium(double premium) {
    this.premium = premium;
  }

  @Override
  public String toString() {
    return "Agent{" +
      "agentId=" + agentId +
      ", name='" + name + '\'' +
      ", city='" + city + '\'' +
      ", gender=" + gender +
      ", premium=" + premium +
      '}';
  }
}
