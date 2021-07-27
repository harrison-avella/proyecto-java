package com.comit.bikerama.service;

import java.util.List;
import java.util.Optional;

import com.comit.bikerama.domain.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    List<User> findAll();
    
    Optional<User> findById(Long id);
    
    User save(User user);
    
    User update(User user);
    
    String delete(Long id);
    
    //User findByUserName(String userName);

    //User findByEmail(String email);


}
