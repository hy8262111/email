package com.longhu.entity;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-12 17:14
 */
@Data
public class BaseDomain {
    @Column(name = "modify_time")
    private Date modifyTime;
}
