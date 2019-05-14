package com.longhu.dao;

import com.longhu.entity.Categroy;
import com.longhu.entity.CategroyNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategroyMapper {
    int deleteByPrimaryKey(Integer cateId);

    int insert(Categroy record);

    int insertSelective(Categroy record);

    Categroy selectByPrimaryKey(Integer cateId);

    int updateByPrimaryKeySelective(Categroy record);

    int updateByPrimaryKey(Categroy record);

    CategroyNode findAll();
}