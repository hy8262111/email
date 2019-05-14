package com.longhu.service.impl;

import com.longhu.entity.Permission;
import com.longhu.exception.CustomerException;
import com.longhu.repository.PermissionRepository;
import com.longhu.response.CodeMsg;
import com.longhu.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author: houyong
 * @descririiption:
 * @create: 2019-03-12 18:11
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionRepository permissionRepository;

    @Override
    public Permission addPermission(Permission permission) {
        Permission returnPermission = permissionRepository.save(permission);
        if (Objects.isNull(returnPermission)) {
            throw new CustomerException(CodeMsg.CREATE_FAILED);
        }
        return returnPermission;
    }

    @Override
    public Permission findById(Integer id) {
        Permission permission = permissionRepository.getOne(id);
        if (Objects.isNull(permission)) {
            throw new CustomerException(CodeMsg.NOT_FIND_DATA);
        }
        return permission;
    }
}
