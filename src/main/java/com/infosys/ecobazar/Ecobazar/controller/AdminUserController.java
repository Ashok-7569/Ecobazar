package com.infosys.ecobazar.Ecobazar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infosys.ecobazar.Ecobazar.entity.User;
import com.infosys.ecobazar.Ecobazar.repository.UserRepository;

@RestController
@RequestMapping("/admin/users")   
public class AdminUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}