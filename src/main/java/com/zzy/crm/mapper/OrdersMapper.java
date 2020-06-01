package com.zzy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author PIGS
 * @since 2020-03-29
 */
@Repository
public interface OrdersMapper extends BaseMapper<Orders> {

    IPage<Orders> selectOrders(Page<Orders> page , Integer empId);
    IPage<Orders> selectOrdersBySearch(Page<Orders> page , Integer empId, Date start, Date end, String busubess_name);
    IPage<Orders> recoverList(Page<Orders> page , Integer empId);

    List<Map<String,Object>> selectOrderCount();
    List<Map<String,Object>> selectOrderSum();
    List<Map<String,Object>> selectOrderSumByEmp();
}
