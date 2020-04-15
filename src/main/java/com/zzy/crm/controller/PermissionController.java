package com.zzy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.entity.Permission;
import com.zzy.crm.entity.Role;
import com.zzy.crm.entity.RolePermission;
import com.zzy.crm.service.PermissionService;
import com.zzy.crm.utils.StringUtils;
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
 * @since 2020-03-23
 */
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @GetMapping(value = "/permission")
    public List<Permission> permission(){
        return permissionService.list();
    }

    @GetMapping("/permissions")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map=new HashMap<>();
        Page<Permission> page1 = new Page<Permission>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
        IPage<Permission> iPage=permissionService.page(page1,queryWrapper.eq("is_del",0));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @GetMapping("/perm")
    public Map getList1(Integer page, Integer limit ){
        Map<String,Object> map=new HashMap<>();
        Page<Permission> page1 = new Page<Permission>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
        IPage<Permission> iPage=permissionService.page(page1,queryWrapper.eq("is_del",1));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @PostMapping("/per")
    public Map add(Permission permission){
        Map<String,Object> result = new HashMap<String,Object>();
        permission.setCreateTime(StringUtils.getNowTime());//设置创建时间
        permission.setUpdateTime(permission.getCreateTime());
        permission.setIsDel(0);
        result.put("state",permissionService.save(permission));
        return result;
    }

    @DeleteMapping("/permission/del/{permId}")
    public Map del(@PathVariable Integer permId){
        Permission permission = new Permission();
        permission.setPermId(permId);
        permission.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",permissionService.updateById(permission));
        return result;
    }

    @DeleteMapping("/perm/del/{permId}")
    public Map delete(@PathVariable Integer permId){
        Permission permission = new Permission();
        permission.setPermId(permId);
        permission.setIsDel(0);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",permissionService.updateById(permission));
        return result;
    }

    @PutMapping("/update")
    public Map update(Permission permission){
        Map<String,Object> result = new HashMap<String,Object>();
        permission.setCreateTime(StringUtils.getNowTime());//设置创建时间
        permission.setUpdateTime(permission.getCreateTime());
        permission.setIsDel(0);
        result.put("state",permissionService.updateById(permission));
        return result;
    }

}
