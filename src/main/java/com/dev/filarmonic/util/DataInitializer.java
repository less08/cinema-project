package com.dev.filarmonic.util;

import com.dev.filarmonic.model.Role;
import com.dev.filarmonic.model.RoleType;
import com.dev.filarmonic.model.User;
import com.dev.filarmonic.service.RoleService;
import com.dev.filarmonic.service.UserService;
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
