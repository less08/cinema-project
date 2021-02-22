package com.dev.cinema.util;

import com.dev.cinema.model.Role;
import com.dev.cinema.model.RoleType;
import com.dev.cinema.model.User;
import com.dev.cinema.service.RoleService;
import com.dev.cinema.service.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private UserService userService;
    private RoleService roleService;

    public DataInitializer(UserService userService,
                           RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void initData() {
        Role adminRole = new Role();
        adminRole.setRoleType(RoleType.ADMIN);
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setRoleType(RoleType.USER);
        roleService.add(userRole);

        User admin = new User();
        admin.setEmail("admin");
        admin.setRoles(List.of(adminRole, userRole));
        admin.setPassword("admin");
        userService.add(admin);
    }
}
