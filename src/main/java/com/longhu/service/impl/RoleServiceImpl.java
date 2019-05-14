package com.longhu.service.impl;

import com.longhu.entity.Role;
import com.longhu.exception.CustomerException;
import com.longhu.repository.RoleRepository;
import com.longhu.response.CodeMsg;
import com.longhu.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author: houyong
 * @descririiption:
 * @create: 2019-03-18 13:59
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleRepository roleRepository;

    @Override
    public Role findById(Integer id) {
        Role role = roleRepository.findById(id).get();
        if (Objects.isNull(role)) {
            throw new CustomerException(CodeMsg.NOT_FIND_DATA);
        }
        return role;
    }

    @Override
    public Role addRole(Role role) {
        Role retRole = roleRepository.save(role);
        if (Objects.isNull(retRole)) {
            throw new CustomerException(CodeMsg.CREATE_FAILED);
        }
        return retRole;
    }
}
