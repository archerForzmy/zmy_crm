package com.zzy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    IPage<Employee> selectList(Page<Employee> page);

    IPage<Employee> recoverEmp(Page<Employee> page);

    Employee selectByName(String empName);

    List<Map<String,Object>> selectAll();

}
