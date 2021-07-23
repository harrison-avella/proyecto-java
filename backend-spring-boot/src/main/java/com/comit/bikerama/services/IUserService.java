package com.comit.bikerama.services;

import java.util.List;

import com.comit.bikerama.models.User;

public interface IUserService {

    User findByUserName(String userName);

    User findByEmail(String email);

    User findById(Long id);

    User createUser(User user) throws Exception;

    List<User> findAll();

    User save(User user);

    void delete(long id);

}
