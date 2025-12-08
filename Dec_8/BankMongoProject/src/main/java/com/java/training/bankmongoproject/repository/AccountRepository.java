package com.java.training.bankmongoproject.repository;

import com.java.training.bankmongoproject.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Integer> {
    Account findByAccountNo(int accountNo);
    Account findFirstByOrderByAccountNoDesc();
    void deleteByAccountNo(int accountNo);
}
