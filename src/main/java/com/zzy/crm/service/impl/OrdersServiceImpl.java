package com.zzy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Customer;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.entity.Orders;
import com.zzy.crm.mapper.CustomerMapper;
import com.zzy.crm.mapper.OrdersMapper;
import com.zzy.crm.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.crm.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-29
 */
@Service
@Transactional
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public IPage<Orders> selectOrders(Page<Orders> page) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return ordersMapper.selectOrders(page,employee.getEmpId());
    }

    @Override
    public IPage<Orders> recoverList(Page<Orders> page) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return ordersMapper.recoverList(page,employee.getEmpId());
    }

    @Override
    public Integer add(Orders orders) {
        orders.setCreateTime(StringUtils.getNowTime());
        orders.setUpdateTime(orders.getCreateTime());
        orders.setIsDel(0);
        Integer a=ordersMapper.insert(orders);
        QueryWrapper<Customer> wrapper=new QueryWrapper<>();
        if (customerMapper.selectOne(wrapper.eq("customer_id",orders.getCustomerId()).eq("is_orders",1))==null){
            Customer custome=new Customer();
            custome.setCustomerId(orders.getCustomerId());
            custome.setIsOrders(1);
            customerMapper.updateById(custome);
        }
        return a;
    }

    @Override
    public IPage<Orders> selectOrders(Page<Orders> page, Date start, Date end, String busubess_name) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return ordersMapper.selectOrdersBySearch(page,employee.getEmpId(),start,end,busubess_name);
    }

    @Override
    public List<Map<String, Object>> selectOrderCount() {
        return ordersMapper.selectOrderCount();
    }

    @Override
    public List<Map<String, Object>> selectOrderSum() {
        return ordersMapper.selectOrderSum();
    }

    @Override
    public List<Map<String, Object>> selectOrderSumByEmp() {
        return ordersMapper.selectOrderSumByEmp();
    }
}
