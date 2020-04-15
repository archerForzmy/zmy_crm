package com.zzy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.entity.Role;
import com.zzy.crm.service.RoleService;
import com.zzy.crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.AbstractWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/role")
    public List<Role> roles(){
        return roleService.list();
    }

    @GetMapping("/roles")
    public Map getList(Integer page,Integer limit ){
        Map<String,Object> map = new HashMap<String,Object> ();

        //设置mybatisPlus分页
        Page<Role> p = new Page<Role>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Role> iPage = roleService.selectList(p);

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @GetMapping("/recoverRole")
    public Map recoverRole(Integer page,Integer limit ){
        Map<String,Object> map = new HashMap<String,Object> ();

        //设置mybatisPlus分页
        Page<Role> p = new Page<Role>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Role> iPage = roleService.recoverRole(p);

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }


    @PostMapping("/role")
    public Map add(Role role,Integer deptId,Integer permId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.add(role,deptId,permId));
        return result;
    }

    @DeleteMapping("/recoverRole/del/{roleId}")
    public Map recoverRole(@PathVariable Integer roleId){
        Role role = new Role();
        role.setRoleId(roleId);
        role.setIsDel(0);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.updateById(role));
        return result;
    }
    @DeleteMapping("/role/del/{roleId}")
    public Map del(@PathVariable Integer roleId){
        Role role = new Role();
        role.setRoleId(roleId);
        role.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.updateById(role));
        return result;
    }

    @PutMapping("/role")
    public Map edit(Role role,Integer deptId,Integer permId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.update(role,deptId,permId));
        return result;
    }


}
