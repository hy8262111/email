package com.longhu;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.longhu.dao.CategroyMapper;
import com.longhu.dao.UserMapper;
import com.longhu.entity.CategroyNode;
import com.longhu.entity.User;
import com.longhu.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailApplicationTests {
    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CategroyMapper categroyMapper;

    @Test
    public void test() {
        List<User> all =
                userRepository.findAll();
        System.out.println(all);
    }


    @Test
    public void save() {
        User user = new User();
        user.setAge(1);
        user.setCreateBy("houyong");
        user.setCreateTime(new Date());
        user.setName("helloworld");
        userMapper.insertSelective(user);
    }

    @Test
    public void test2() {
        PageHelper.startPage(0, 2);
        Page<User> users =
                userMapper.fidnUserByCondition(null);
        List<User> result = users.getResult();
        long total = users.getTotal();
        System.out.println(total);
        System.out.println(result);
    }

    @Test
    public void categoryAll() {
        CategroyNode all =
                categroyMapper.findAll();
        String s = JSON.toJSONString(all);
        System.out.println(s);
    }


}
