package com.lucker.user.controller;


import com.lucker.user.model.User;

import com.lucker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/member")
    public ResponseEntity<Iterable<User>> getAll() {
        Iterable<User> all = userService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<User> register(@RequestBody User input) {
        User result = userService.registerUser(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
