package com.dev.filarmonic.service;

import com.dev.filarmonic.model.User;

public interface AuthenticationService {

    User register(String email, String password);
}
