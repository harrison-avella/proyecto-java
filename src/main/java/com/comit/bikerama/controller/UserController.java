package com.comit.bikerama.controller;


import com.comit.bikerama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Users")
public class UserController{
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("persons", userService.usersList());
        return "listado";
    }
}
