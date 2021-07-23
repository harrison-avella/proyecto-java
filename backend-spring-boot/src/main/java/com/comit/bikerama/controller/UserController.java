package com.comit.bikerama.controller;

import com.comit.bikerama.domain.User;
import com.comit.bikerama.service.impl.RoleService;
import com.comit.bikerama.service.impl.UserService;
import com.comit.bikerama.utils.StatusRole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/signUp"/* , produces = MediaType.APPLICATION_JSON_VALUE */)
    public ResponseEntity<?> signUp(@RequestBody User user) {
        try {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setRole(roleService.findByName(StatusRole.USER.toString()));
            User savedUser = userService.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            logger.error("Error al crear usuario", e);
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    

    /*
     * @Autowired public UserController(UserService userService){ this.userService =
     * userService; }
     */

    /*
     * @RequestMapping("/users") public String list(Model model){
     * model.addAttribute("persons", userService.findAll()); return "listado"; }
     */
}
