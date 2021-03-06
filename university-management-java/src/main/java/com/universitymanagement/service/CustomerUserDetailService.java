package com.universitymanagement.service;

import com.universitymanagement.entity.User;
import com.universitymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent())
            return user.get();
        else
            throw new UsernameNotFoundException("User not found");
    }
    @Transactional
    public User loadUserById(Long id){
        User user = userRepository.getById(id);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return user;
    }
}
