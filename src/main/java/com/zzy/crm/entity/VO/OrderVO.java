package com.zzy.crm.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVO {
    private Integer ordersId;
    private Integer businessId;
    private String busubessName;
    private Integer customerId;
    private String customerName;
    private BigDecimal totalPrice;
}
