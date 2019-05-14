package com.longhu.service.impl;

import com.longhu.dao.CategroyMapper;
import com.longhu.entity.CategroyNode;
import com.longhu.service.CategroyService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-12 16:03
 */
@Service
public class CategroyServiceImpl implements CategroyService {
    @Resource
    private CategroyMapper categroyMapper;

    @Override
    public CategroyNode findAll() {
        return categroyMapper.findAll();
    }

    public static void main(String[] args) {
        String s = RandomStringUtils.randomNumeric(4);
        String s1 = RandomStringUtils.randomAlphanumeric(4);
        System.out.println(s);
        System.out.println(s1);
    }
}
