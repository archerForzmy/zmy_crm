package com.zzy.crm.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author 邹靓仔
 * @date 2020/3/23 -16:56 -zzy_crm
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

   /* @Test
    public void selectList(){
        System.out.println(employeeMapper.selectList());
    }*/
    @Test
    public void selectByName(){
        System.out.println(employeeMapper.selectByName("admin"));
    }



}