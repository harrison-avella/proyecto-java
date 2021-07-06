package com.comit.bikerama.service;

import com.comit.bikerama.model.User;
import com.comit.bikerama.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> usersList(){
        return userRepository.findAll();
    }
}
