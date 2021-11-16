package com.tapu.interview.service;

import com.tapu.interview.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User userAdd(User user);
}
