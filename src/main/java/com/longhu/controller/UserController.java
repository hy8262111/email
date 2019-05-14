package com.longhu.controller;

import com.longhu.annotation.PermConst;
import com.longhu.annotation.RequirePermission;
import com.longhu.dao.CategroyMapper;
import com.longhu.entity.User;
import com.longhu.response.Result;
import com.longhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author: houyong
 * @descririiption: 用户接口
 * @create: 2019-03-13 11:02
 */
@RestController
public class UserController {
    public final String userUriPre = "/user";

    @Autowired
    private UserService userService;

    @Autowired
    private CategroyMapper categroyMapper;


    @RequirePermission(PermConst.ADDUSER)
    @PostMapping(userUriPre + "/add")
    public Result<User> addUser(@RequestBody @Validated User user) {
        User returnUser = userService.addUser(user);
        Result<User> success = Result.success(returnUser);
        return Result.success(returnUser);
    }


    @GetMapping(userUriPre + "/get/{id}")
    public Result<User> findUserById(@PathVariable("id") @Validated({User.Update.class}) Integer id) {
        User user = userService.findById(id);
        return Result.success(user);
    }
}
