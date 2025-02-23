package com.example.SpringSecurityExample.service;

import com.example.SpringSecurityExample.model.User;
import com.example.SpringSecurityExample.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

  private final BCryptPasswordEncoder bCryptPasswordEncode = new BCryptPasswordEncoder();

  public User register(User user) {
    user.setPassword(bCryptPasswordEncode.encode(user.getPassword()));
    userRepo.save(user);
    return user;
  }


}
