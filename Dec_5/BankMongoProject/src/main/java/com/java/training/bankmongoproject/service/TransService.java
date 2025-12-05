package com.java.training.bankmongoproject.service;

import com.java.training.bankmongoproject.model.Trans;
import com.java.training.bankmongoproject.repository.TransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransService {

    @Autowired
    private TransRepository transRepository;

    public void addHistory(Trans trans){
        transRepository.save(trans);
    }
}