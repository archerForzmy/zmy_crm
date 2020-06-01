package com.zzy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Business;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-29
 */
public interface BusinessService extends IService<Business> {

    IPage<Business> listContactC(Page<Business> page1, Date start, Date end, String busubess_name);
    List<Map<String,String>> businessAll();
}
