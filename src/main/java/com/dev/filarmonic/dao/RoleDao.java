package com.dev.filarmonic.dao;

import com.dev.filarmonic.model.Role;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(String roleName);
}
