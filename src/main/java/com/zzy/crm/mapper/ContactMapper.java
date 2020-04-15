package com.zzy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Contact;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

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
    IPage<Contact> recoverContactC(Page<Contact> page, Integer empId);


}
