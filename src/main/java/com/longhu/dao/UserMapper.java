package com.longhu.dao;

import com.github.pagehelper.Page;
import com.longhu.condition.UserCondition;
import com.longhu.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Page<User> fidnUserByCondition(UserCondition userCondition);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}