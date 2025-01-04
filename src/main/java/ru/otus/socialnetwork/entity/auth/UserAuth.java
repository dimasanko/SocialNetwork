package ru.otus.socialnetwork.entity.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
public class UserAuth implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String token;
    private Set<GrantedAuthority> authorities;

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

}
