package ru.otus.socialnetwork.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TokenService {

    private static final String PREFIX = "Bearer ";
    private static final String SECRET = "mySecretKey";

    public boolean isTokenPresent(String authenticationHeader) {
        if (authenticationHeader == null
                || !authenticationHeader.startsWith(PREFIX)
                || authenticationHeader.substring(PREFIX.length()).isBlank()) {
            return false;
        }
        return true;
    }

    public Claims parseToken(String authenticationHeader) {
        String jwtToken = authenticationHeader.replace(PREFIX, "");
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities) {
        String token = Jwts
                .builder()
                .setId(username)
                .setSubject(username)
                .claim("authorities",
                        authorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256,
                        SECRET.getBytes()).compact();

        return PREFIX + token;
    }

}
