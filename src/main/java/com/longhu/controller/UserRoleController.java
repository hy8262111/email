package com.longhu.controller;

import com.longhu.entity.UserRole;
import com.longhu.response.Result;
import com.longhu.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-10 11:26
 */
@RestController
public class UserRoleController {
    public final String uroleUriPre = "/urole";

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(uroleUriPre + "/add")
    public Result<UserRole> addUserRole(Integer userId, Integer roleId) {
        UserRole addurole = userRoleService.addurole(userId, roleId);
        return Result.success(addurole);
    }
}
