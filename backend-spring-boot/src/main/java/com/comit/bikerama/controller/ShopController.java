package com.comit.bikerama.controller;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ShopController {
    
    @Autowired
    private IUserService userService;
    

}
