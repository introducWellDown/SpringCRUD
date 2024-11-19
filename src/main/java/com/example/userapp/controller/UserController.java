package com.example.userapp.controller;

import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users",userRepository.findAll());
        return  "users";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name, @RequestParam int age){
        User user = new User(name,age);
        userRepository.save(user);
        return "redirect:/users";
    }

}
