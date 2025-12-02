package com.java.bank.dao;

import com.java.bank.model.Account;

import java.util.Map;

public interface AccountDao {
  String createAccount(Account account);
  Account findByAccountNumber(String accNo);
  boolean exists(String accNo);
  Map<String, Account> findAll();

}
