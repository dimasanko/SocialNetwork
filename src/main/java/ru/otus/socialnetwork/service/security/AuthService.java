package ru.otus.socialnetwork.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.otus.socialnetwork.entity.auth.AuthRequest;
import ru.otus.socialnetwork.entity.auth.AuthResponse;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(AuthRequest request) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = tokenService.generateToken(auth.getName(), auth.getAuthorities());

        return new AuthResponse()
                .setToken(token);
    }

}
