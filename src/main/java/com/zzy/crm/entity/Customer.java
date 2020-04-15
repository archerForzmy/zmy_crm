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
 * @since 2020-03-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("customer")
public class Customer extends BaseEntity {

    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    private String customerName;

    private String sex;

    private String telphone;

    private String company;

    private String address;

    private Integer empId;

    private Integer isOrders;

    @TableField(exist = false)
    private Employee employee;


}
