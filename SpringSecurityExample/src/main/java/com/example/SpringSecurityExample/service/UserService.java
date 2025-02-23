package com.example.SpringSecurityExample.service;

import com.example.SpringSecurityExample.model.User;
import com.example.SpringSecurityExample.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private JwtService jwtService;

  @Autowired
  private AuthenticationManager authenticationManager;

  private final BCryptPasswordEncoder bCryptPasswordEncode = new BCryptPasswordEncoder();

  public User register(User user) {
    user.setPassword(bCryptPasswordEncode.encode(user.getPassword()));
    userRepo.save(user);
    return user;
  }


  public String verify(User user) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

    return authentication.isAuthenticated() ? jwtService.generateToken(user.getUsername()) : "Failure";
  }
}
