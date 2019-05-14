package com.longhu.service.impl;

import com.longhu.entity.UserRole;
import com.longhu.exception.CustomerException;
import com.longhu.repository.UserRoleRepository;
import com.longhu.response.CodeMsg;
import com.longhu.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-10 11:28
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;


    @Override
    public UserRole addurole(Integer userId, Integer roleId) {
        UserRole userRole = new UserRole();
        userRole.setCreateTime(new Date());
        userRole.setRuleId(roleId);
        userRole.setUserId(userId);
        UserRole urole = userRoleRepository.save(userRole);
        if (Objects.isNull(urole)) {
            throw new CustomerException(CodeMsg.NOT_FIND_DATA);
        }
        return urole;
    }


}
