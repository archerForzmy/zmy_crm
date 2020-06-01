package com.zzy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Contact;
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
public interface ContactService extends IService<Contact> {

    IPage<Contact> listContactC(Page<Contact> page);
    IPage<Contact> listContactC(Page<Contact> page, Date start, Date end, String customer_name);
    IPage<Contact> recoverContactC(Page<Contact> page);

    List<Map<String,Object>> selectContactCount();
    List<Map<String,Object>> selectContactCountByEmp();
}
