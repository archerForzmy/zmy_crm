package com.zzy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-29
 */
public interface OrdersService extends IService<Orders> {

    IPage<Orders> selectOrders(Page<Orders> page);
    IPage<Orders> recoverList(Page<Orders> page);

    Integer add(Orders orders);
}
