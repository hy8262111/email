package com.longhu.condition;

import lombok.Data;

import java.util.Date;

/**
 * @author: houyong
 * @descririiption:
 * @create: 2019-03-18 11:07
 */
@Data
public class UserCondition {
    private Integer id;
    private String name;
    private String createBy;
    private Date createTime;
    private Integer age;
    private Integer phone;
    private Date modifyTime;
    private String modifyBy;
    private Integer status;
}
