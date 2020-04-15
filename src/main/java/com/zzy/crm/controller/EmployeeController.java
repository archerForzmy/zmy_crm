package com.zzy.crm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 邹靓仔
 * @date 2020/3/25 -10:02 -zzy_crm
 **/
@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    /**
     *  查询一页员工信息
     * @param page 当前页码
     * @param limit 每页记录数
     * @return
     */
    @GetMapping("/emp")
    public Map getList(Integer page,Integer limit ){
        Map<String,Object> map = new HashMap<String,Object> ();

        //设置mybatisPlus分页
        Page<Employee> p = new Page<Employee>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Employee> iPage = employeeService.selectList(p);

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @GetMapping("/recoverEmp")
    public Map recoverEpm(Integer page,Integer limit ){
        Map<String,Object> map = new HashMap<String,Object> ();

        //设置mybatisPlus分页
        Page<Employee> p = new Page<Employee>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Employee> iPage = employeeService.recoverEmp(p);

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    /**
     *  新增用户
     */
    @PostMapping("/emp")
    public Map add(Employee employee,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.add(employee,roleId));
        return result;
    }

    /**
     *  删除用户
     */
    @DeleteMapping("/emp/del/{empId}")
    public Map del(@PathVariable Integer empId){
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.updateById(employee));
        return result;
    }

    @DeleteMapping("/recoverEmp/del/{empId}")
    public Map recoverEmp(@PathVariable Integer empId){
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setIsDel(0);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.updateById(employee));
        return result;
    }

    /**
     *  修改
     */
    @PutMapping("/emp")
    public Map edit(Employee employee,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.update(employee,roleId));
        return result;
    }
}

