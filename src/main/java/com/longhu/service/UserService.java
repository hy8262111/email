package com.longhu.service;

import com.longhu.condition.UserCondition;
import com.longhu.entity.User;

import java.util.List;


public interface UserService {
    User addUser(User user);

    User findById(Integer id);

    User updateUserById(Integer id);

    List<User> findUserByCondition(UserCondition userCondition);
}
