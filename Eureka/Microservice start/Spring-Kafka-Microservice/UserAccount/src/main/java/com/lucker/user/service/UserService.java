package com.lucker.user.service;

import com.lucker.user.model.User;

public interface UserService {
    User registerUser(User input);
    Iterable<User> findAll();
}
