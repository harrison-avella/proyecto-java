package com.comit.bikerama.service;

import com.comit.bikerama.model.User;
import com.comit.bikerama.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository iuserRepository;

    @Autowired
    public UserService(IUserRepository iuserRepository){
        this.iuserRepository = iuserRepository;
    }

    public List<User> usersList(){
        return iuserRepository.findAll();
    }
}
