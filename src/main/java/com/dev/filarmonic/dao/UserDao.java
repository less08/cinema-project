package com.dev.filarmonic.dao;

import com.dev.filarmonic.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> getById(Long id);
}
