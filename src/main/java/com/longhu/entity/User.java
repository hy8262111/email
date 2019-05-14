package com.longhu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name = "afo_user")
public class User extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 2005702328885994556L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotEmpty(groups = Update.class)
    private Integer id;

    //@NotBlank
    private String name;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private Date createTime;

    //@Min(18)
    private Integer age;

    //@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    //@NotBlank(message = "手机号码不能为空")
    private String phone;


    @Column(name = "modify_by")
    private String modifyBy;

    private Integer status;

    public interface Add {
    }

    public interface Update {
    }
}