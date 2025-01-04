package ru.otus.socialnetwork.entity.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AuthResponse {

    String token;

}
