package com.comit.bikerama.service.impl;

import java.util.List;

import com.comit.bikerama.domain.Cart;
import com.comit.bikerama.domain.User;
import com.comit.bikerama.repository.IRoleRepository;
import com.comit.bikerama.repository.IUserRepository;
import com.comit.bikerama.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private static final Logger logger = LoggerFactory.getLogger(UserService.class); 

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRoleRepository iRoleRepository;

    /*@Autowired
    public UserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }
    */

    //For test purposes
    @Override
    public List<User> findAll(){
        return iUserRepository.findAll();
    }

    @Override
    public User findById(Long id){
        return iUserRepository.findById(id).get();
    }

    @Override
    public User save(User user){
        return iUserRepository.save(user);
    }
    
    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User findByUserName(String userName) {
        return iUserRepository.findByUserName(userName);
    }

    @Override
    public User findByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        User localUser = this.findByUserName(user.getUserName());
        if (localUser == null) {
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);

            localUser = this.save(user);
            
        }else{
            logger.info("El usuario {}, existe, no es posible el registro", user.getUserName());
        }
        return localUser;
    }



}
