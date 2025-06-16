package com.example.LibraryManagement.service.impl;

import com.example.LibraryManagement.dao.UserRepository;
import com.example.LibraryManagement.model.User;
import com.example.LibraryManagement.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found with id: "+id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found with id: "+id));
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
          userRepository.deleteById(id);
    }

}
