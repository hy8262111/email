package com.longhu.service.impl;

import com.longhu.condition.UserCondition;
import com.longhu.dao.UserMapper;
import com.longhu.entity.User;
import com.longhu.exception.CustomerException;
import com.longhu.repository.UserRepository;
import com.longhu.response.CodeMsg;
import com.longhu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: houyong
 * @descririiption:
 * @create: 2019-03-12 18:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        user.setCreateBy("system");
        user.setCreateTime(new Date());
        user.setStatus(1);
        User returnUser = userRepository.save(user);
        if (Objects.isNull(returnUser)) {
            throw new CustomerException(CodeMsg.CREATE_FAILED);
        }
        return returnUser;
    }

    @Override
    public User updateUserById(Integer id) {
        User user = userRepository.getOne(id);
        if (Objects.isNull(user)) {
            throw new CustomerException(CodeMsg.NOT_FIND_DATA);
        }

        return null;
    }

    @Override
    public List<User> findUserByCondition(UserCondition userCondition) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        User user = userRepository.getOne(id);
        if (Objects.isNull(user)) {
            throw new CustomerException(CodeMsg.NOT_FIND_DATA);
        }
        return user;
    }
}
