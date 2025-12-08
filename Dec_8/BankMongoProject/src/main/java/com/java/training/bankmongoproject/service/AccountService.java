package com.java.training.bankmongoproject.service;

import com.java.training.bankmongoproject.exception.AlreadyExistsException;
import com.java.training.bankmongoproject.exception.ResourceNotFoundException;
import com.java.training.bankmongoproject.model.Account;
import com.java.training.bankmongoproject.model.Trans;
import com.java.training.bankmongoproject.repository.AccountRepository;
import com.java.training.bankmongoproject.repository.TransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransRepository transRepository;

    public AccountService(AccountRepository accountRepository, TransRepository transRepository) {
        this.accountRepository = accountRepository;
        this.transRepository = transRepository;
    }

    public List<Account> findAll(){
        return  accountRepository.findAll();
    }
    public Account getMaxAccountNo() {
        return accountRepository.findFirstByOrderByAccountNoDesc();
    }

    public Account findByAccountNo(int accountNo){
        Account account = accountRepository.findByAccountNo(accountNo);
        if(account==null){
            throw new ResourceNotFoundException("Account not found");
        }
        return account;
    }

    public String deleteByAccountNo(int accountNo) {
        Account acc = accountRepository.findByAccountNo(accountNo);
        if (acc == null) {
            throw new ResourceNotFoundException("Account not found: " + accountNo);
        }
        accountRepository.deleteByAccountNo(accountNo);
        return "Account Deleted...";
    }
    public String createAccount(Account account){
        if (account.getAccountNo() != 0) {
            Account exists = accountRepository.findByAccountNo(account.getAccountNo());
            if (exists != null) {
                throw new AlreadyExistsException("Account already exists with accountNo: " + account.getAccountNo());
            }
        }

        account.setStatus("ACTIVE");
        account.setDateOfOpen(new Date());
        account.setAmount(account.getAmount()); // initial balance

        // Auto-generate new account number
        Account maxAccount = getMaxAccountNo();
        int newAccNo = (maxAccount == null) ? 1 : maxAccount.getAccountNo() + 1;
        account.setAccountNo(newAccNo);
        accountRepository.save(account);
        return "Account Created Successfully...";
    }

    public List<Trans> showAllTrans(int accountNo) {
        Account acc = accountRepository.findByAccountNo(accountNo);
        if (acc == null) {
            throw new ResourceNotFoundException("Account not found with AccountNo: " + accountNo);
        }
        return transRepository.findByAccountNo(accountNo);
    }

    public String withdrawAccount(int accountNo, double withDrawAmount) {
        Account account = findByAccountNo(accountNo);
        double amount = account.getAmount();
        if (withDrawAmount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }

        if (account.getAmount() < withDrawAmount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.setAmount(amount - withDrawAmount);
        accountRepository.save(account);
        Trans trans = new Trans();
        trans.setAccountNo(account.getAccountNo());
        trans.setTranAmount(withDrawAmount);
        trans.setTranType("WITHDRAW");
        transRepository.save(trans);
        return "Account Withdrawn Successfully...";
    }

    public String depositAmount(int accountNo, double depositAmount) {
        Account account = findByAccountNo(accountNo);
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        account.setAmount(account.getAmount()+depositAmount);
        accountRepository.save(account);
        Trans trans = new Trans();
        trans.setAccountNo(account.getAccountNo());
        trans.setTranAmount(depositAmount);
        trans.setTranType("DEPOSIT");
        transRepository.save(trans);
        return "Account Deposited Successfully...";
    }
}