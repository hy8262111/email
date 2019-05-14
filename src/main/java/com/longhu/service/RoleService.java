package com.longhu.service;

import com.longhu.entity.Role;

public interface RoleService {
    Role findById(Integer id);

    Role addRole(Role role);
}
