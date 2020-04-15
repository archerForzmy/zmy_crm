package com.zzy.crm.entity;

import java.math.BigDecimal;
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
 * @since 2020-03-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("orders")
public class Orders extends Business {

    @TableId(value = "orders_id", type = IdType.AUTO)
    private Integer ordersId;

    private Integer businessId;

    private BigDecimal totalPrice;

    private Integer customerId;


    @TableField(exist = false)
    private Business business;
    @TableField(exist = false)
    private Customer customer;

}
