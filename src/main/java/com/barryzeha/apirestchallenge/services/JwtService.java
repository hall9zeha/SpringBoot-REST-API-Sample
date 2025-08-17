package com.barryzeha.apirestchallenge.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.security.Key;
import java.util.Date;

@Component
public class JwtService {
    private static final String SECRET_KEY = "ThisIsASuperSecretKeyForTestJWTServiceInSpringBootCanYouChangeForAnyMoreStrong";
    private static final long EXPIRATION_TIME = 3600000;

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(String userId, String username){
        return Jwts.builder()
                .setSubject(userId)
                .claim("username",username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    public Jws<Claims> validateToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
    public String getUsernameFromToken(String token){
        return validateToken(token).getBody().get("username", String.class);
    }
    public String getUserIdFromToken(String token){
        return validateToken(token).getBody().getSubject();
    }
}
