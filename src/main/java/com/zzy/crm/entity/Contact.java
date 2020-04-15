package com.zzy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-03-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("contact")
public class Contact extends BaseEntity {

    @TableId(value = "contact_id", type = IdType.AUTO)
    private Integer contactId;

    private String way;

    private String content;

    private Integer customerId;

    private String company;

    private Integer empId;

    @TableField(exist = false)
    private Customer customer;




}
