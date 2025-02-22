package com.example.SpringSecurityExample.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping
  public String greet(HttpServletRequest httpServletRequest) {
    return "Welcome!. " + httpServletRequest.getSession().getId();
  }

}
