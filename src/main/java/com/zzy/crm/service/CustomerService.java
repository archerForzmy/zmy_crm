package com.zzy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
public interface CustomerService extends IService<Customer> {

   IPage<Customer> listContactC(Page<Customer> page, Date start,Date end,String empName);

}
