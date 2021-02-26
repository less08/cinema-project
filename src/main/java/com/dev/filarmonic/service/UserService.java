package com.dev.filarmonic.service;

import com.dev.filarmonic.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User getById(Long id);
}
