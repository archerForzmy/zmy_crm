package com.zzy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
public interface EmployeeService extends IService<Employee> {

    IPage<Employee> selectList(Page<Employee> page);

    IPage<Employee> recoverEmp(Page<Employee> page);

    Employee selectByName(String empName);

    Integer add(Employee employee,Integer roleId);

    Integer update(Employee employee,Integer roleId);
}
