package com.longhu.dao;

import com.longhu.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RulePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}