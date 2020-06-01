package com.zzy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

   IPage<Customer> customerList(Page<Customer> page,Integer empId, Date start, Date end, String empName);

}
