package com.example.LibraryManagement.service.impl;

import com.example.LibraryManagement.model.User;
import com.example.LibraryManagement.service.api.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Long,User> userStorage = new HashMap<>();
    private Long userIdSeq=1L;

    @Override
    public User createUser(User user) {
        user.setUserId(userIdSeq++);
        userStorage.put(user.getUserId(),user);
        return user;
    }

    @Override
    public User getUser(Long id) {
        User user=userStorage.get(id);
        if (user == null) {
            throw new RuntimeException("User not found with Id: "+id);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userStorage.values());
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        User existingUser = userStorage.get(id);
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        return existingUser;
    }

    @Override
    public void deleteUser(Long id) {
         if(userStorage.remove(id)==null) {
             throw new RuntimeException("User not found with id: "+id);
         }
    }

}
