package com.zzy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
public class Role extends BaseEntity {



    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    //角色 -- 权限关系：多对多关系;
    @TableField(exist = false)
    private List<Permission> permissionList;

    //角色 -- 部门关系：多对多关系;
    @TableField(exist = false)
    private List<Department> departmentList;


}
