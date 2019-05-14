package com.longhu.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 */
@Data
@Entity
@Table(name = "afo_role")
public class Role extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 6437239092945524813L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String descri;


    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_by")
    private String modifyBy;

    private Integer status;

}