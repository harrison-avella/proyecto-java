package com.comit.bikerama.controller;

import com.comit.bikerama.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ShopController {
    
    @Autowired
    private IUserService userService;
    

}