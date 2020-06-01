package com.zzy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Business;
import com.zzy.crm.mapper.BusinessMapper;
import com.zzy.crm.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Autowired
    BusinessMapper businessMapper;

    @Override
    public IPage<Business> listContactC(Page<Business> page, Date start, Date end, String busubess_name) {
        return businessMapper.businessList(page,start,end,busubess_name);
    }

    @Override
    public List<Map<String, String>> businessAll() {
        return businessMapper.businessAll();
    }
}
