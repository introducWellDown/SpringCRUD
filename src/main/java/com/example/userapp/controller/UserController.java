package com.example.userapp.controller;

import com.example.userapp.models.User;
import com.example.userapp.repository.UserRepository;
import com.example.userapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public  UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return  "users";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/del")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
