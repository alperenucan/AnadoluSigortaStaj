package com.example.internship.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public void addNewStudent(User user) {
        Optional<User> userById = userRepository.findUserById(user.getId());
        if(userById.isPresent()){
            throw new IllegalStateException("id is taken");
        }
        userRepository.save(user);
        System.out.println(user);
    }
}
