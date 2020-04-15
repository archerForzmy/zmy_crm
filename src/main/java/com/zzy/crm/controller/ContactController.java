package com.zzy.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Contact;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.service.ContactService;
import com.zzy.crm.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PIGS
 * @since 2020-03-29
 */
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Contact> page1 = new Page<>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Contact> iPage=contactService.listContactC(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @GetMapping("/recoverContact")
    public Map recoverContact(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Contact> page1 = new Page<>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Contact> iPage=contactService.recoverContactC(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @PostMapping("/contact")
    public Map add(Contact contact){
        Map<String,Object> map=new HashMap<>();
        contact.setUpdateTime(StringUtils.getNowTime());
        contact.setCreateTime(contact.getUpdateTime());
        contact.setIsDel(0);
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        contact.setEmpId(employee.getEmpId());
        if (contactService.save(contact)){
            map.put("state",1);
        }
        return  map;
    }

    @DeleteMapping("/contact/del/{contactId}")
    public Map del(@PathVariable Integer contactId){
        Map<String,Object> map=new HashMap<>();
        Contact contact=new Contact();
        contact.setIsDel(1);
        contact.setContactId(contactId);
        map.put("state",contactService.updateById(contact));
        return map;
    }
    @DeleteMapping("/recoverContact/del/{contactId}")
    public Map recoverContact(@PathVariable Integer contactId){
        Map<String,Object> map=new HashMap<>();
        Contact contact=new Contact();
        contact.setIsDel(0);
        contact.setContactId(contactId);
        map.put("state",contactService.updateById(contact));
        return map;
    }

}
