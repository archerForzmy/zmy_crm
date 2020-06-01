package com.zzy.crm.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactVO {
    private Integer contactId;
    private Integer customerId;
    private String customerName;
    private String way;
    private String content;
    private String company;
}
