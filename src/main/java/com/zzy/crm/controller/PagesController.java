package com.zzy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/statistics")
    @ResponseBody
    public Object  statistics(){
        List<Map<String,Object>> contacts = contactService.selectContactCount();
        List<Map<String,Object>> orders = ordersService.selectOrderCount();

        List<List<Object>> data = new ArrayList<List<Object>>(3);
        data.add(new ArrayList<Object>());
        data.add(new ArrayList<Object>());
        data.add(new ArrayList<Object>());

        Set<String> datetime = new HashSet();
        Set<String> contactSet = new HashSet();
        Set<String> orderSet = new HashSet();
        for(Map contact:contacts){
            datetime.add(contact.get("days").toString());
            contactSet.add(contact.get("days").toString());
        }
        for(Map order:orders){
            datetime.add(order.get("days").toString());
            orderSet.add(order.get("days").toString());
        }
        data.get(0).addAll(datetime);
        Collections.sort(data.get(0),(Object date1,Object date2)->{
            return date1.toString().compareTo(date2.toString());
        });

        for(Object date:data.get(0)){
            if(contactSet.contains(date)){
                for(Map contact:contacts){
                    if(contact.get("days").equals(date)){
                        data.get(1).add(contact.get("count"));
                    }
                }
            }else{
                data.get(1).add("0");
            }
            if(orderSet.contains(date)){
                for(Map order:orders){
                    if(order.get("days").equals(date)){
                        data.get(2).add(order.get("count"));
                    }
                }
            }else{
                data.get(2).add("0");
            }
        }

        for(int i=0;i<data.get(2).size();i++){
            data.get(2).set(i,new BigDecimal(data.get(2).get(i).toString()).divide(new BigDecimal(data.get(1).get(i).toString()),2,BigDecimal.ROUND_HALF_UP));
        }

        return data;
    }

    @GetMapping("/statistics1")
    @ResponseBody
    public Object statistics1(){
        List<Map<String,String>> buss = businessService.businessAll();
        List<Map<String,Object>> orders = ordersService.selectOrderSum();
        Set<String> dates = new HashSet<String>();
        Set<String> bussineses = new HashSet<String>();
        Set<String> bussId = new HashSet<String>();
        for(Map order:orders){
           dates.add(order.get("days").toString());
           for(Map bus:buss){
               System.out.println(order.get("business_id").toString() +": "+bus.get("business_id").toString());
               if(order.get("business_id").toString().equals(bus.get("business_id").toString())){
                   bussineses.add(bus.get("busubess_name").toString());
               }
           }
           bussId.add(order.get("business_id").toString());
        }

        List<List<Object>> data = new ArrayList<List<Object>>();
        for(int i=0;i<bussineses.size()+1;i++){
            data.add(new ArrayList<Object>());
            if(i==0){
                data.get(i).add("date");
            }else {
                data.get(i).add(buss.get(i - 1).get("business_id"));
            }
        }

        //日期排序
        List<String> datelist = new ArrayList<String>();
        datelist.addAll(dates);
        Collections.sort(datelist,(Object date1,Object date2)->{
            return date1.toString().compareTo(date2.toString());
        });
        data.get(0).addAll(datelist);

        for(int i=1;i<data.size();i++){
            for(int j=1;j<data.get(0).size();j++) {
                data.get(i).add(0);
                for (Map order : orders) {
                    if(order.get("days").toString().equals(data.get(0).get(j).toString())&&order.get("business_id").toString().equals(data.get(i).get(0).toString())){
                        data.get(i).set(j,order.get("sum").toString());
                    }
                }
            }
        }

        for(int i=1;i<data.size();i++){
            for(Map bus:buss){
                if(data.get(i).get(0).toString().equals(bus.get("business_id").toString())){
                    data.get(i).set(0,bus.get("busubess_name").toString());
                }
            }
        }

        return data;
    }

    @GetMapping("/statistics2")
    @ResponseBody
    public Object statistics2(){
        List<Map<String,Object>> contactByemp = contactService.selectContactCountByEmp();
        List<Map<String,Object>> orderByemp = ordersService.selectOrderSumByEmp();
        List<Map<String,Object>> emps = employeeService.selectAll();

        Set<String> dates = contactByemp.stream().map(map->map.get("days").toString()).collect(Collectors.toSet());
        dates.addAll(orderByemp.stream().map(map->map.get("days").toString()).collect(Collectors.toSet()));
        List<String> datelist = new ArrayList<String>();
        datelist.addAll(dates);
        Collections.sort(datelist,(Object date1,Object date2)->{
            return date1.toString().compareTo(date2.toString());
        });

        Map<String,List> item = new HashMap<String,List>();
        item.put("timeline",datelist);
        item.put("emps",emps.stream().map(emp->emp.get("emp_name")).collect(Collectors.toList()));


        List<List> dataSet = new ArrayList<List>();
        for(int i=0;i<datelist.size();i++){
            List<List> dataItem = new ArrayList<List>();
            for(int j=0;j<emps.size();j++){
                String date  = datelist.get(i);
                String emp_name =  emps.get(j).get("emp_name").toString();
                List subItem  = new ArrayList();
                subItem.add(isExistNameAndDate(contactByemp,emp_name,date));
                subItem.add(isExistNameAndDate(orderByemp,emp_name,date));
                subItem.add(emp_name);
                dataItem.add(subItem);
            }
            dataSet.add(dataItem);
        }

        item.put("series",dataSet);
        return item;
    }

    private String isExistNameAndDate(List<Map<String,Object>> items,String name,String date){
        for(Map item:items){
            if(date.equals(item.get("days").toString())&& name.equals(item.get("emp_name").toString())){
                if(item.containsKey("count")){
                    return item.get("count").toString();
                }else{
                    return item.get("sum").toString();
                }
            }
        }
        return "0";
    }

    @GetMapping("/403")
    public String un(){
        return "403";
    }
}
