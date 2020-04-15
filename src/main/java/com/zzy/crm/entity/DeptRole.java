package com.zzy.crm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

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
@NoArgsConstructor
@AllArgsConstructor
public class DeptRole extends BaseEntity {



    private Integer deptId;

    private Integer roleId;




}
