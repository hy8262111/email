package com.longhu.entity;

import lombok.Data;

import java.util.List;

/**
 * @author: houyong
 * @descririiption:
 * @create: 2019-04-09 17:28
 */
@Data
public class CategroyNode extends Categroy {
    private List<Categroy> categroys;
}
