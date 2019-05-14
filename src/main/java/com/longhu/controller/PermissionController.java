package com.longhu.controller;

import com.longhu.entity.Permission;
import com.longhu.response.Result;
import com.longhu.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: houyong
 * @descririiption: 权限管理
 * @create: 2019-03-18 13:48
 */
@RestController
public class PermissionController {
    public final String permisUriPre = "/permission";

    @Autowired
    private PermissionService permissionService;

    @PostMapping(permisUriPre + "/add")
    public Result<Permission> addPermission(@RequestBody Permission permission) {
        Permission retPermission = permissionService.addPermission(permission);
        Result<Permission> success = Result.success(retPermission);
        return success;
    }

    @GetMapping(permisUriPre + "/get{id}")
    public Result<Permission> findPermissionById(@PathVariable("id") Integer id) {
        Permission permission = permissionService.findById(id);
        return Result.success(permission);
    }
}
