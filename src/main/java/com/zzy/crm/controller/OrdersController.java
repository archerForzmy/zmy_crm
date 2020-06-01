package com.zzy.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Orders;
import com.zzy.crm.entity.Permission;
import com.zzy.crm.entity.VO.OrderVO;
import com.zzy.crm.service.OrdersService;
import com.zzy.crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PIGS
 * @since 2020-03-29
 */
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Orders> page1 = new Page<Orders>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Orders> iPage=ordersService.selectOrders(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords().stream().map((order)->new OrderVO(order.getOrdersId()
                ,order.getBusinessId()
                ,order.getBusiness().getBusubessName()
                ,order.getCustomerId()
                ,order.getCustomer().getCustomerName()
                ,order.getTotalPrice())).collect(Collectors.toList()));
        map.put("code",0);
        return map;
    }

    @GetMapping("/searchOrder")
    public Map list(Integer page, Integer limit,String start,String end,String busubess_name) throws ParseException {
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Orders> page1 = new Page<Orders>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Orders> iPage = null;
        if(com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(start)
                &&com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(end)
                &&com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(busubess_name)){
            iPage =ordersService.selectOrders(page1);
        }else{
            iPage= ordersService.selectOrders(page1,StringUtils.converterStringToDate(start)
                    ,StringUtils.converterStringToDate(end)
                    ,busubess_name);
        }

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords().stream().map((order)->new OrderVO(order.getOrdersId()
                ,order.getBusinessId()
                ,order.getBusiness().getBusubessName()
                ,order.getCustomerId()
                ,order.getCustomer().getCustomerName()
                ,order.getTotalPrice())).collect(Collectors.toList()));
        map.put("code",0);
        return map;
    }

    @GetMapping("/recoverOrders")
    public Map recoverList(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Orders> page1 = new Page<Orders>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Orders> iPage=ordersService.recoverList(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @PostMapping("/orders")
    public Map add(Orders orders){
        Map<String,Object> map=new HashMap<>();
        map.put("state",ordersService.add(orders));
        return map;
    }

    @PutMapping("/ordersUpdate")
    public Map update(Orders orders){
        Map<String,Object> result = new HashMap<String,Object>();
       //修改时间
        orders.setUpdateTime(orders.getCreateTime());
        orders.setIsDel(0);
        result.put("state",ordersService.updateById(orders));
        return result;
    }

    @DeleteMapping("/ordersUpdate/del/{ordersId}")
    public Map del(@PathVariable Integer ordersId){
        Orders orders = new Orders();
        orders.setOrdersId(ordersId);
        orders.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",ordersService.updateById(orders));
        return result;
    }
    @DeleteMapping("/recoverOrders/del/{ordersId}")
    public Map recoverOrders(@PathVariable Integer ordersId){
        Orders orders = new Orders();
        orders.setOrdersId(ordersId);
        orders.setIsDel(0);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",ordersService.updateById(orders));
        return result;
    }

}
