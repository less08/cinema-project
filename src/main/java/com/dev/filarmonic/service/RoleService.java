package com.dev.filarmonic.service;

import com.dev.filarmonic.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
