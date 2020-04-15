package com.zzy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 返回视图的控制器
 */
@Controller
public class PagesController {

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

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(Model model){

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

    @GetMapping("/403")
    public String un(){
        return "403";
    }
}
