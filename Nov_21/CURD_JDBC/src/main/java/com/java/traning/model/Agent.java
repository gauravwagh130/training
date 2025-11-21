package com.java.traning.model;

import java.math.BigDecimal;

public class Agent {
  private int agentId;
  private String name;
  private String city;
  private Gender gender;
  private int maritalStatus;
  private BigDecimal premium;



  public Agent(){};

  public Agent(int agentId, String name, String city, Gender gender, int maritalStatus, BigDecimal premium) {
    this.agentId = agentId;
    this.name = name;
    this.city = city;
    this.gender = gender;
    this.maritalStatus = maritalStatus;
    this.premium = premium;
  }

  public int getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(int maritalStatus) {
    this.maritalStatus = maritalStatus;
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

  public BigDecimal getPremium() {
    return premium;
  }

  public void setPremium(BigDecimal premium) {
    this.premium = premium;
  }

  @Override
  public String toString() {
    return "Agent{" +
      "agentId=" + agentId +
      ", name='" + name + '\'' +
      ", city='" + city + '\'' +
      ", gender=" + gender +
      ", maritalStatus=" + maritalStatus +
      ", premium=" + premium +
      '}';
  }
}
