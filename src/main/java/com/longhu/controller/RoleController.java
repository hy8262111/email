package com.longhu.controller;

import com.longhu.entity.Role;
import com.longhu.response.Result;
import com.longhu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: houyong
 * @descririiption: 角色管理
 * @create: 2019-03-18 13:48
 */
@RestController
public class RoleController {
    public final String roleUriPre = "/role";

    @Autowired
    private RoleService roleService;

    @PostMapping(roleUriPre + "/add")
    public Result<Role> addRole(@RequestBody Role role) {
        Role returnRole = roleService.addRole(role);
        Result<Role> success = Result.success(returnRole);
        return success;
    }

    @GetMapping(roleUriPre + "/get{id}")
    public Result<Role> findRoleById(@PathVariable("id") Integer id) {
        Role role = roleService.findById(id);
        return Result.success(role);
    }
}
