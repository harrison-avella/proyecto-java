package com.comit.bikerama.security.controller;


import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import com.comit.bikerama.dto.Message;
import com.comit.bikerama.security.dto.JwtDto;
import com.comit.bikerama.security.dto.LoginUser;
import com.comit.bikerama.security.dto.NewUser;
import com.comit.bikerama.security.entity.Role;
import com.comit.bikerama.security.entity.User;
import com.comit.bikerama.security.enums.RoleName;
import com.comit.bikerama.security.jwt.JwtProvider;
import com.comit.bikerama.security.service.RoleService;
import com.comit.bikerama.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;

    // request body espera un json
    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUser,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campós o email invalido"),
                    HttpStatus.BAD_REQUEST);
        if (userService.existsByUsername(newUser.getUsername()))
            return new ResponseEntity(
                    new Message("El nombre de usuario ya existe"),
                    HttpStatus.BAD_REQUEST);
        if (userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("El email ya existe"),
                    HttpStatus.BAD_REQUEST);
        User user = new User(newUser.getName(), newUser.getUsername(),
                newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(RoleName.ROLE_USER).get());
        if (newUser.getRoles().contains("admin"))
            roles.add(roleService.findByRoleName(RoleName.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("Usuario creado"),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos invalidos"),
                    HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(),
                        loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),
                userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}

