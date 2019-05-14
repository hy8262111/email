package com.longhu.dao;

import com.longhu.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}