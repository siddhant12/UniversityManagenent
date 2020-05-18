package com.universitymanagement.service;

import com.universitymanagement.entity.User;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
}
