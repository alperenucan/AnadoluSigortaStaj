package com.example.internship.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        return List.of(new User(5L));
    }
}
