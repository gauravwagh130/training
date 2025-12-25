package com.java.training.beanvalidation.service;

import com.java.training.beanvalidation.model.User;
import com.java.training.beanvalidation.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
