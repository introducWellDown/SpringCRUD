package com.example.userapp.services;

import com.example.userapp.models.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUserById(Long id);
}
