package com.comit.bikerama.services;

import java.util.List;
import java.util.Set;

import com.comit.bikerama.models.Role;
import com.comit.bikerama.models.User;

public interface IUserService {
    
    User findByUserName(String userName);
    User findByEmail(String email);
    User findById(Long id);
    User createUser(User user) throws Exception;
    
    List<User> getAll();
    User save(User user);
    User getById(Long id);
    void delete(long id);

}
