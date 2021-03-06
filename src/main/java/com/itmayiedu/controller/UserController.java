package com.itmayiedu.controller;

import com.itmayiedu.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(String name, String pwd){
        return userService.register(name, pwd);
    }

    @RequestMapping("/get")
    public String get(Long userId){
        return userService.get(userId);
    }
}
