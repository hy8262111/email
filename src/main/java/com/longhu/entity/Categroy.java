package com.longhu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Categroy implements Serializable {
    private Integer cateId;

    private String cateName;

    private Integer parentId;

    private static final long serialVersionUID = 1L;

}