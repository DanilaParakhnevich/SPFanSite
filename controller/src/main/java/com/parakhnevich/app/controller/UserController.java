package com.parakhnevich.app.controller;

import com.parakhnevich.app.dto.UserDto;
import com.parakhnevich.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/create")
    public UserDto createUser(@RequestBody UserDto user) {
        return userService.createUser(user);
    }
}
