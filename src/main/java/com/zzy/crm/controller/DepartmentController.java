package com.zzy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Department;
import com.zzy.crm.entity.Permission;
import com.zzy.crm.service.DepartmentService;
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

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/department")
    public List<Department> selectRole(){
        return departmentService.list();
    }

    @GetMapping("/departments")
    public Map depList(Integer page, Integer limit){
        Map<String,Object> map=new HashMap<>();
        Page<Department> page1 = new Page<Department>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Department> queryWrapper=new QueryWrapper<>();
        IPage<Department> iPage=departmentService.page(page1,queryWrapper.eq("is_del",0));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @GetMapping("/recoverDepartment")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map=new HashMap<>();
        Page<Department> page1 = new Page<Department>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Department> queryWrapper=new QueryWrapper<>();
        IPage<Department> iPage=departmentService.page(page1,queryWrapper.eq("is_del",1));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @PostMapping("/department")
    public Map add(Department department){
        Map<String,Object> result = new HashMap<String,Object>();
        department.setCreateTime(StringUtils.getNowTime());//设置创建时间
        department.setUpdateTime(department.getCreateTime());
        department.setIsDel(0);
        result.put("state",departmentService.save(department));
        return result;
    }

    @DeleteMapping("/department/del/{deptId}")
    public Map del(@PathVariable Integer deptId){
        Department department = new Department();
        department.setDeptId(deptId);
        department.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",departmentService.updateById(department));
        return result;
    }
    @DeleteMapping("/recoverDepartment/del/{deptId}")
    public Map recoverDepartment(@PathVariable Integer deptId){
        Department department = new Department();
        department.setDeptId(deptId);
        department.setIsDel(0);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",departmentService.updateById(department));
        return result;
    }


}
