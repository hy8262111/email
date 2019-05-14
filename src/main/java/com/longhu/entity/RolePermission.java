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
@Table(name = "afo_role_permission")
public class RolePermission implements Serializable {
    private static final long serialVersionUID = -7761316252114310545L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ruleId")
    private Integer ruleId;

    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "modify_time")
    private Date modifyTime;

    @Column(name = "modify_by")
    private String modifyBy;

}