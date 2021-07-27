package com.comit.bikerama.controller;

import com.comit.bikerama.service.impl.RegistrationService;
import com.comit.bikerama.utils.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1")
@AllArgsConstructor
public class RegistrationController {

  private RegistrationService registrationService;

  @PostMapping(path="/registration")
  public String register(@RequestBody RegistrationRequest request) {
    return registrationService.register(request);
  }
}
