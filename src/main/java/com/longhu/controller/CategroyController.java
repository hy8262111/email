package com.longhu.controller;

import com.longhu.entity.CategroyNode;
import com.longhu.response.Result;
import com.longhu.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-12 16:01
 */
@RestController
public class CategroyController {
    public final String cateUriPre = "/cate";

    @Autowired
    private CategroyService categroyService;

    @GetMapping(cateUriPre + "/findAll")
    public Result<CategroyNode> getCateAll() {
        CategroyNode categroyNode = categroyService.findAll();
        return Result.success(categroyNode);
    }
}
