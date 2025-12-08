package com.java.training.bankmongoproject.controller;

import com.java.training.bankmongoproject.exception.ResourceNotFoundException;
import com.java.training.bankmongoproject.model.Account;
import com.java.training.bankmongoproject.model.Trans;
import com.java.training.bankmongoproject.service.AccountService;
import com.java.training.bankmongoproject.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;
    private final TransService transService;

    public AccountController(AccountService accountService, TransService transService) {
        this.accountService = accountService;
        this.transService = transService;
    }
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "<html><body>"
                + "<a href='/oauth2/authorization/github'>Login with GitHub</a>"
                + "</body></html>";
    }
    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return "<html><body>"
                + "<h1>Login</h1>"
                + "<p><a href=\"/oauth2/authorization/google\">Login with Google</a></p>"
                + "<p><a href=\"/oauth2/authorization/github\">Login with GitHub</a></p>"
                + "</body></html>";
    }
    @GetMapping(value="/showAccount")
    public ResponseEntity<List<Account>> showAccount(){
        List<Account> accounts = accountService.findAll();
        return ResponseEntity.ok(accounts);

    }

    @GetMapping(value="/showTrans/{accountNo}")
    public ResponseEntity<List<Trans>> showTrans(@PathVariable int accountNo){
        List<Trans> trans = accountService.showAllTrans(accountNo);
        return ResponseEntity.ok(trans);
    }

    @PostMapping(value = "/deposit/{accountNo}/{depositAmount}")
    public ResponseEntity<String> deposit(@PathVariable int accountNo, @PathVariable double depositAmount) {
        String msg = accountService.depositAmount(accountNo, depositAmount);
        return ResponseEntity.ok(msg);
    }

    @PostMapping(value = "/withdraw/{accountNo}/{withdrawAmount}")
    public ResponseEntity<String> withdraw(@PathVariable int accountNo, @PathVariable double withdrawAmount) {
        String msg = accountService.withdrawAccount(accountNo, withdrawAmount);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping(value = "/deleteAccount/{accountNo}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accountNo) {
        accountService.deleteByAccountNo(accountNo); // throws ResourceNotFoundException if not found
        return ResponseEntity.ok("Account deleted successfully: " + accountNo);
    }

    @PostMapping(value = "/addAccount")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        String saved = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Account created successfully..." );
    }

    @GetMapping(value = "/search/{accno}")
    public ResponseEntity<Account> searchAccount(@PathVariable int accno) {
        Account accountFound = accountService.findByAccountNo(accno);
        if(accountFound==null){
            throw new ResourceNotFoundException("Account not found");
        }
        return ResponseEntity.ok(accountFound);
    }
}