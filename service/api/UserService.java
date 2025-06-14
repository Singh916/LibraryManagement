package com.example.LibraryManagement.service.api;


import com.example.LibraryManagement.model.User;
import java.util.List;


public interface UserService {

    User createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
    User updateUser(Long id,User user);
    void deleteUser(Long id);

}