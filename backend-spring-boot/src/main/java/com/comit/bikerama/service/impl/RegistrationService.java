package com.comit.bikerama.service.impl;

import com.comit.bikerama.domain.User;
import com.comit.bikerama.security.EmailValidator;
import com.comit.bikerama.security.RegistrationRequest;
import com.comit.bikerama.service.UserService;
import com.comit.bikerama.utils.StatusRole;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        Boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("El email no es valido");
        }
        return userService.signUpUser(new User(request.getName(), request.getEmail(),
                request.getPassword(), StatusRole.USER));
    }
    /*
     * public String singUp(User user) { return "Funciona"; }
     */
}
