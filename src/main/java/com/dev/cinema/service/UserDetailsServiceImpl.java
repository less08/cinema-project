package com.dev.cinema.service;

import static org.springframework.security.core.userdetails.User.withUsername;

import com.dev.cinema.model.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(email);
        User user = userOptional.orElseThrow(() ->
                new UsernameNotFoundException("User with email " + email + "was not found"));
        UserBuilder builder = withUsername(user.getEmail());
        builder.password(user.getPassword());
        builder.roles(user.getRoles()
                .stream()
                .map(r -> r.getRoleType().toString())
                .toArray(String[]::new));
        return builder.build();
    }
}
