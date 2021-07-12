package com.comit.bikerama.init;

import com.comit.bikerama.model.User;
import com.comit.bikerama.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //private final UserRepository userRepository;
    // tira un cable a la factory, encima del constructor lo que hace inyectar lo que encuentra en la factory adentro

    public void run(ApplicationArguments args){
        logger.debug("Construyendo un usuario");
        User use = new User();

    }
}