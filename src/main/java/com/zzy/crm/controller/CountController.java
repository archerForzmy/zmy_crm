package com.zzy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 邹靓仔
 * @date 2020/4/4 -20:58 -zzy_crm
 **/
@RestController
public class CountController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private  ContactService contactService;

  /*  @GetMapping("/welcome")
    public String count(Model model){
        QueryWrapper queryWrapper= new QueryWrapper();
        queryWrapper.eq("is_del",0);
        model.addAttribute("employee",employeeService.count(queryWrapper));
        model.addAttribute("customer",customerService.count(queryWrapper));
        model.addAttribute("orders",ordersService.count(queryWrapper));
        model.addAttribute("department",departmentService.count(queryWrapper));
        model.addAttribute("business",businessService.count(queryWrapper));
        model.addAttribute("contact",contactService.count(queryWrapper));
        return "welcome";
    }
*/
}
