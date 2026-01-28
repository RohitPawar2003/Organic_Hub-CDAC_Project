package com.cdac.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cdac.modelmvc.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY =
        "cdac-secret-key-should-be-at-least-32-characters-long";

    private static final long EXPIRATION = 86400000;

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(
                    Keys.hmacShaKeyFor(SECRET_KEY.getBytes()),
                    SignatureAlgorithm.HS256
                )
                .compact();
    }

    public String getEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
