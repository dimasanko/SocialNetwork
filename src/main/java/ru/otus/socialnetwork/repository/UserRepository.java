package ru.otus.socialnetwork.repository;

import org.springframework.stereotype.Repository;
import ru.otus.socialnetwork.entity.User;

import java.util.Optional;

@Repository
public class UserRepository {

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(new User()
                .setId(1L)
                .setUsername("user_1")
                .setPassword("password_1"));
    };

}
