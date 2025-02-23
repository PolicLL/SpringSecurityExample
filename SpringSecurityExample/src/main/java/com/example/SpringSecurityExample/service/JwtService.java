package com.example.SpringSecurityExample.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  public String generateToken(String username) {
    Map<String, Object> claims = new HashMap<>();

    return Jwts.builder()
        .claims()
        .add(claims)
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() * 60 * 60 * 30))
        .and()
        .signWith(getKey())
        .compact();
  }

  private Key getKey() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode("5hfesf"));
  }
}
