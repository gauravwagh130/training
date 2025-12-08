package com.java.training.bankmongoproject.service;

import com.java.training.bankmongoproject.model.Trans;
import com.java.training.bankmongoproject.repository.TransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransService {

    private final TransRepository transRepository;

    public TransService(TransRepository transRepository) {
        this.transRepository = transRepository;
    }


    public Trans addHistory(Trans trans){
        return transRepository.save(trans);
    }

    public List<Trans> findByAccountNo(int accountNo) {
        return transRepository.findByAccountNo(accountNo);
    }
}