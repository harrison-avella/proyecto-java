package com.comit.bikerama.controller.rest;

import com.comit.bikerama.model.User;
import com.comit.bikerama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> usersList(){
        return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
    }
}
