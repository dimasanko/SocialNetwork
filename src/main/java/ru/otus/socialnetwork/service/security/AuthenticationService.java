package ru.otus.socialnetwork.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    public void authenticate() {
        System.out.println("Hello, world! from authenticate");
    }

    public void authorize() {
        System.out.println("Hello, world! from authorize");
    }

}
