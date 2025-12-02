package com.java.bank.dao;

import com.java.bank.model.Account;

import java.util.Map;

public class AccountDaoImpl implements AccountDao{
  @Override
  public String createAccount(Account account) {
    return "";
  }

  @Override
  public Account findByAccountNumber(String accNo) {
    return null;
  }

  @Override
  public boolean exists(String accNo) {
    return false;
  }

  @Override
  public Map<String, Account> findAll() {
    return Map.of();
  }
}
