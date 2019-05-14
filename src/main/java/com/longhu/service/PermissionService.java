package com.longhu.service;

import com.longhu.entity.Permission;


public interface PermissionService {
    Permission addPermission(Permission permission);

    Permission findById(Integer id);

}
