package com.zzy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Contact;
import com.zzy.crm.entity.Customer;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.entity.VO.ContactVO;
import com.zzy.crm.service.ContactService;
import com.zzy.crm.utils.StringUtils;
import freemarker.template.utility.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        map.put("data",iPage.getRecords().stream().map((contact)->new ContactVO(contact.getContactId()
                ,contact.getCustomerId()
                ,contact.getCustomer().getCustomerName()
                ,contact.getWay()
                ,contact.getContent()
                ,contact.getCompany())).collect(Collectors.toList()));
        map.put("code",0);
        return map;
    }

    @GetMapping("/searchContact")
    public Map list(Integer page, Integer limit, String start, String  end, String empName) throws ParseException {
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Contact> page1 = new Page<>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Contact> iPage=null;
        if(com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(start)
                &&com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(end)
                &&com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(empName)){
            iPage=contactService.listContactC(page1);
        }else{
            iPage= contactService.listContactC(page1,StringUtils.converterStringToDate(start)
                    ,StringUtils.converterStringToDate(end)
                    ,empName);
        }
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords().stream().map((contact)->new ContactVO(contact.getContactId()
                ,contact.getCustomerId()
                ,contact.getCustomer().getCustomerName()
                ,contact.getWay()
                ,contact.getContent()
                ,contact.getCompany())).collect(Collectors.toList()));
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

    @PostMapping("/addContact")
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

    @PutMapping("/contact")
    public Map update(Contact contact){
        Map<String,Object> map=new HashMap<>();
        contact.setUpdateTime(StringUtils.getNowTime());
        map.put("state",contactService.updateById(contact));
        return map;
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
