package com.zzy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.EmpRole;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.mapper.EmpRoleMapper;
import com.zzy.crm.mapper.EmployeeMapper;
import com.zzy.crm.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.crm.utils.ShiroUtils;
import com.zzy.crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
@Service
@Transactional
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Override
    public IPage<Employee> selectList(Page<Employee> page) {
        return employeeMapper.selectList(page);
    }

    @Override
    public IPage<Employee> recoverEmp(Page<Employee> page) {
        return employeeMapper.recoverEmp(page);
    }

    @Override
    public Employee selectByName(String empName) {
        return employeeMapper.selectByName(empName);
    }

    @Override
    public Integer add(Employee employee, Integer roleId) {
        //从ShiroUtils类中随机生成盐
        employee.setSalt(ShiroUtils.randomSalt());
        //将密码设置为 加密后的密码
        employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));

        employee.setCreateTime(StringUtils.getNowTime());//设置创建时间
        employee.setUpdateTime(employee.getCreateTime());
        employee.setIsDel(0);
        int result = employeeMapper.insert(employee);

        //获取插入自增ID
        int empId = employee.getEmpId();
        EmpRole empRole = new EmpRole(empId,roleId);
        empRole.setCreateTime(StringUtils.getNowTime());
        empRole.setUpdateTime(empRole.getCreateTime());
        empRole.setIsDel(0);
        empRoleMapper.insert(empRole);


        return result;
    }

    @Override
    public Integer update(Employee employee,Integer roleId) {
        //System.out.println("修改的员工信息："+employee);
        //判断用户是否输入密码，如果没有，获取的就是空字符串 ("")  就不修改密码
        if (!"".equals(employee.getPwd()) ){
            //从ShiroUtils类中随机生成盐
            employee.setSalt(ShiroUtils.randomSalt());
            //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
            employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));
        }else {
            employee.setPwd(null);
        }
        //设置时间
        employee.setUpdateTime(StringUtils.getNowTime());
        //将信息更新到数据库中（空的属性不修改）
        int result =  employeeMapper.updateById(employee);


        EmpRole empRole = new EmpRole(employee.getEmpId(),roleId);
        empRole.setUpdateTime(StringUtils.getNowTime());
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("emp_id",employee.getEmpId());
        empRoleMapper.update(empRole,wrapper);

        return result;
    }
}
