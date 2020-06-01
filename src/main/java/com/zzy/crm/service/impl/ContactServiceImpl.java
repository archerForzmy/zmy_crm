package com.zzy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Contact;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.mapper.ContactMapper;
import com.zzy.crm.service.ContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {

    @Autowired
    private ContactMapper contactMapper;


    @Override
    public IPage<Contact> listContactC(Page<Contact> page) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return contactMapper.listContactC(page,employee.getEmpId());
    }

    @Override
    public IPage<Contact> listContactC(Page<Contact> page, Date start, Date end, String customer_name) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return contactMapper.listContactCByCondition(page,employee.getEmpId(),start,end,customer_name);
    }

    @Override
    public IPage<Contact> recoverContactC(Page<Contact> page) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return contactMapper.recoverContactC(page,employee.getEmpId());
    }

    @Override
    public List<Map<String, Object>> selectContactCount() {
        return contactMapper.selectContactCount();
    }

    @Override
    public List<Map<String, Object>> selectContactCountByEmp() {
        return contactMapper.selectContactCountByEmp();
    }
}
