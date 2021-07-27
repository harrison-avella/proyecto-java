package com.comit.bikerama.utils;

import java.util.function.Predicate;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
public class EmailValidator implements Predicate<String> {
    
    @Override
    public boolean test (String email) {
        return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }
/*
    public Boolean isValid(String email) {
        return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }
    
    */
}
