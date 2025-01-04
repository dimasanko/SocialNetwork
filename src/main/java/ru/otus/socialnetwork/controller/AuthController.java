package ru.otus.socialnetwork.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.socialnetwork.entity.auth.AuthRequest;
import ru.otus.socialnetwork.entity.auth.AuthResponse;
import ru.otus.socialnetwork.service.security.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public AuthResponse login(AuthRequest request) {
        return authService.login(request);
    }

}
