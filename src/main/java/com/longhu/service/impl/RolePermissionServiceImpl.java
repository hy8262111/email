package com.longhu.service.impl;

import com.longhu.entity.RolePermission;
import com.longhu.exception.CustomerException;
import com.longhu.repository.RolePermRepository;
import com.longhu.response.CodeMsg;
import com.longhu.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-10 11:45
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermRepository rolePermRepository;

    @Override
    public RolePermission addurole(Integer roleId, Integer permId) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setCreateTime(new Date());
        rolePermission.setRuleId(roleId);
        rolePermission.setPermissionId(permId);
        RolePermission _rolePermission = rolePermRepository.save(rolePermission);
        if (Objects.isNull(_rolePermission)) {
            throw new CustomerException(CodeMsg.NOT_FIND_DATA);
        }
        return _rolePermission;
    }
}
