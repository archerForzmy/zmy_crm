package com.zzy.crm.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Customer;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.entity.Permission;
import com.zzy.crm.service.CustomerService;
import com.zzy.crm.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> list(){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return customerService.list(queryWrapper.eq("emp_id",employee.getEmpId()).eq("is_del",0));
    }

    @GetMapping("/customer")
    public Map getList(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Customer> page1 = new Page<>();
        page1.setSize(limit);
        page1.setCurrent(page);
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        IPage<Customer> iPage=customerService.page(page1,queryWrapper.eq("is_del",0).eq("emp_id",employee.getEmpId()));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @GetMapping("/recoverCustomer")
    public Map recoverCustomer(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Customer> page1 = new Page<>();
        page1.setSize(limit);
        page1.setCurrent(page);
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        IPage<Customer> iPage=customerService.page(page1,queryWrapper.eq("is_del",1).eq("emp_id",employee.getEmpId()));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @PostMapping("/customer")
    public Map add(Customer customer){
        Map<String,Object> map=new HashMap<>();
        customer.setCreateTime(StringUtils.getNowTime());
        customer.setUpdateTime(customer.getCreateTime());
        customer.setIsDel(0);
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        customer.setEmpId(employee.getEmpId());
        if (customerService.save(customer)){
            map.put("state",1);
        }
        return  map;
    }

    @PutMapping("/customer")
    public Map update(Customer customer){
        Map<String,Object> map=new HashMap<>();
        customer.setUpdateTime(StringUtils.getNowTime());
        map.put("state",customerService.updateById(customer));
        return map;
    }

    @DeleteMapping("/recoverCustomer/del/{customerId}")
    public Map recoverCustomer(@PathVariable Integer customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setIsDel(0);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",customerService.updateById(customer));
        return result;
    }

    @DeleteMapping("/customer/del/{customerId}")
    public Map del(@PathVariable Integer customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",customerService.updateById(customer));
        return result;
    }


}
