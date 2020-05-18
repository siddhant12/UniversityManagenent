package com.universitymanagement.service.impl;

import com.universitymanagement.entity.User;
import com.universitymanagement.repository.UserRepository;
import com.universitymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setConfirmPassword("");
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent())
            return user.get();
        else
            return null;
    }
}
