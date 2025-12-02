package com.java.training.springbootmongodb.services;

import com.java.training.springbootmongodb.model.User;
import com.java.training.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User u) {
        return repo.save(u);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
    public User getUserById(String id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    public User updateUser(String id, User updatedUser) {
        User existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(updatedUser.getName());
        existing.setCity(updatedUser.getCity());

        return repo.save(existing);
    }

    // DELETE
    public String deleteUser(String id) {
        repo.deleteById(id);
        return "User deleted with id: " + id;
    }
}

