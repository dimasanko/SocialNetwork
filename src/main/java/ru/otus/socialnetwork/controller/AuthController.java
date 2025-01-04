package ru.otus.socialnetwork.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.socialnetwork.entity.UserAuth;
import ru.otus.socialnetwork.repository.UserRepository;
import ru.otus.socialnetwork.util.jwt.JwtUtil;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("login")
    public String login(UserAuth request) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = JwtUtil.generateToken(auth.getName(), auth.getAuthorities());
//        UserLogin userLogin = new UserLogin();
//        userLogin.setUsername(request.getUsername());
//        userLogin.setToken(token);
        return token;
    }

}
