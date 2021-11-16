package com.tapu.interview.service.impl;

import com.tapu.interview.model.User;
import com.tapu.interview.repositoy.UserRepository;
import com.tapu.interview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User userAdd(User user) {
        this.userRepository.save(user);
        return user;
    }
}
