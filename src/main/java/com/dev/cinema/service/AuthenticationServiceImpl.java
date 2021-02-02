package com.dev.cinema.service;

import com.dev.cinema.exception.AuthenticationException;
import com.dev.cinema.lib.Inject;
import com.dev.cinema.lib.Service;
import com.dev.cinema.model.User;
import com.dev.cinema.util.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent()) {
            String hashedPassword = HashUtil.hashPassword(password, user.get().getSalt());
            if (hashedPassword.equals(user.get().getPassword())) {
                return user.get();
            }
        }
        throw new AuthenticationException("Can't authenticate by email " + email
            + " and password " + password);
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userService.add(user);
    }
}
