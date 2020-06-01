package com.zzy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.crm.entity.Customer;
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
public interface BusinessMapper extends BaseMapper<Business> {
    IPage<Business> businessList(Page<Business> page, Date start, Date end, String busubess_name);
    List<Map<String,String>> businessAll();
}
