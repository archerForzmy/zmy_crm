package com.zzy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Business;
import com.zzy.crm.service.BusinessService;
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
 * @since 2020-03-29
 */
@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/listBusiness")
    public List<Business> permission(){
        QueryWrapper<Business> wrapper=new QueryWrapper<>();
        return businessService.list(wrapper.eq("is_del",0));
    }




    @GetMapping("/business")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Business> page1 = new Page<Business>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Business> wrapper=new QueryWrapper<>();
        IPage<Business> iPage=businessService.page(page1,wrapper.eq("is_del",0));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @GetMapping("/recoveryList")
    public Map recoveryList(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Business> page1 = new Page<Business>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Business> wrapper=new QueryWrapper<>();
        IPage<Business> iPage=businessService.page(page1,wrapper.eq("is_del",1));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @PostMapping("/business")
    public Map add(Business business){
        Map<String,Object> result = new HashMap<String,Object>();
        business.setCreateTime(StringUtils.getNowTime());
        business.setUpdateTime(business.getCreateTime());
        business.setIsDel(0);
        result.put("state",businessService.save(business));
        return result;
    }

    @DeleteMapping("/business/del/{businessId}")
    public Map del(@PathVariable Integer businessId){
        Business business = new Business();
        business.setBusinessId(businessId);
        business.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",businessService.updateById(business));
        return result;
    }
    @DeleteMapping("/recoveryDel/del/{businessId}")
    public Map recoveryDel(@PathVariable Integer businessId){
        Business business = new Business();
        business.setBusinessId(businessId);
        business.setIsDel(0);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",businessService.updateById(business));
        return result;
    }

    @PutMapping("/businessUpdate")
    public Map update(Business business){
        Map<String,Object> result = new HashMap<String,Object>();
        business.setCreateTime(StringUtils.getNowTime());//设置创建时间
        business.setUpdateTime(business.getCreateTime());
        business.setIsDel(0);
        result.put("state",businessService.updateById(business));
        return result;
    }

}
