package com.zzy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Employee;
import com.zzy.crm.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
public interface RoleService extends IService<Role> {

    IPage<Role> selectList(Page<Role> page);

    IPage<Role> recoverRole(Page<Role> page);

    Integer add(Role role,Integer deptId,Integer permId);

    Integer update(Role role,Integer deptId,Integer permId);


}
