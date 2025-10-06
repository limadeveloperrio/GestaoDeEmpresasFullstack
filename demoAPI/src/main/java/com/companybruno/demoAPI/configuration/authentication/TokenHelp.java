package com.companybruno.demoAPI.configuration.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class TokenHelp {

    private static Key secretKey = null;
    private final long expirationMillis;

    public TokenHelp(JwtProperties jwtProperties) {
        this.secretKey = Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
        this.expirationMillis = jwtProperties.getExpiration();
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMillis);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

    // 🔹 Lê o email (ou username) salvo no token
    public static String getEmailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // 🔹 Método genérico para buscar qualquer claim
    private static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)     // valida usando a mesma chave secreta
                .build()
                .parseClaimsJws(token)        // faz o parse do token
                .getBody();

        return claimsResolver.apply(claims);
    }

    // 🔹 Verifica se o token ainda é válido
    public boolean isTokenValid(String token, String username) {
        String extractedUsername = getEmailFromToken(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = getClaimFromToken(token, Claims::getExpiration);
        return expiration.before(new Date());
    }
}