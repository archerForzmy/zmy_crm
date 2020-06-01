package com.zzy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Contact;
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
public interface ContactMapper extends BaseMapper<Contact> {

    IPage<Contact> listContactC(Page<Contact> page, Integer empId);
    IPage<Contact> listContactCByCondition(Page<Contact> page, Integer empId, Date start,Date end,String customer_name);
    IPage<Contact> recoverContactC(Page<Contact> page, Integer empId);

    List<Map<String,Object>> selectContactCount();
    List<Map<String,Object>> selectContactCountByEmp();
}
