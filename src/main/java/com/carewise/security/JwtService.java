package com.carewise.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "mySecretKeyForCareWiseApplicationJwtAuthentication123456";

    private Key getSignInKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }

    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60
                        )
                )
                .signWith(
                        getSignInKey(),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }
    
    public String extractUsername(String token) {

        return extractAllClaims(token)
                .getSubject();
    }
    
    private Claims extractAllClaims(String token) {

        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build();

        return parser.parseClaimsJws(token)
                .getBody();
    }
    
    private boolean isTokenExpired(String token) {

        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }
    
    public boolean isTokenValid(
            String token,
            String email) {

        String username =
                extractUsername(token);

        return username.equals(email)
                && !isTokenExpired(token);
    }
}