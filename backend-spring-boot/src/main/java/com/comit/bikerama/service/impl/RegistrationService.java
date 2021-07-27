package com.comit.bikerama.service.impl;

import com.comit.bikerama.utils.EmailValidator;
import com.comit.bikerama.utils.RegistrationRequest;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        Boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("El email no es valido");
        }

        return "Funciona";
    }

}
