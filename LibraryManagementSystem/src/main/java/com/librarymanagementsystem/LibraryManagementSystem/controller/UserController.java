package com.librarymanagementsystem.LibraryManagementSystem.controller;

import com.librarymanagementsystem.LibraryManagementSystem.model.User;
import com.librarymanagementsystem.LibraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/updateUserById/{userId}")
    public User updateUserById(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/deleteUserById/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.delete(userId);
    }
}
