package ru.otus.socialnetwork.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtUtil {

    private static final String PREFIX = "Bearer ";
    private static final String SECRET = "mySecretKey";

    public static boolean isTokenPresent(String authenticationHeader) {
        if (authenticationHeader == null
                || !authenticationHeader.startsWith(PREFIX)
                || authenticationHeader.substring(PREFIX.length()).isBlank()) {
            return false;
        }
        return true;
    }

    public static Claims parseToken(String authenticationHeader) {
        String jwtToken = authenticationHeader.replace(PREFIX, "");
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    public static String generateToken(String username, Collection<? extends GrantedAuthority> authorities) {
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
