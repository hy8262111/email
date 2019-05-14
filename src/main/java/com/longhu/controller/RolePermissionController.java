package com.longhu.controller;

import com.longhu.entity.RolePermission;
import com.longhu.response.Result;
import com.longhu.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-10 11:42
 */

@RestController
public class RolePermissionController {
    public final String rpermUriPre = "/rperm";

    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping(rpermUriPre + "/add")
    public Result<RolePermission> addUserRole(Integer roleId, Integer permId) {
        RolePermission rolePermission = rolePermissionService.addurole(roleId, permId);
        return Result.success(rolePermission);
    }
}

