package com.java.traning.Model;

import java.util.Objects;

public class Member {
  private int memberId;
  private String name;
  private String email;

  public Member(){};

  public Member(int memberId, String name, String email) {
    this.memberId = memberId;
    this.name = name;
    this.email = email;
  }

  public Member(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public int getMemberId() {
    return memberId;
  }

  public void setMemberId(int memberId) {
    this.memberId = memberId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Member member = (Member) o;
    return memberId == member.memberId && Objects.equals(name, member.name) && Objects.equals(email, member.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberId, name, email);
  }

  @Override
  public String toString() {
    return "Member{" +
      "memberId=" + memberId +
      ", name='" + name + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
