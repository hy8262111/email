package com.longhu.dao;

import com.longhu.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}