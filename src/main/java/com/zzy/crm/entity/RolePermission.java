package com.zzy.crm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

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
 * @since 2020-03-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role_permission")
public class RolePermission extends BaseEntity{



    private Integer roleId;

    private Integer permId;




}
