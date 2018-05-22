package com.iatlyakov.ema.controller;

import com.iatlyakov.ema.entity.User;
import com.iatlyakov.ema.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/")
    public void saveUser(@Valid @RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

}
