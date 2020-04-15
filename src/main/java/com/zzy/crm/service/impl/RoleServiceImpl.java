package com.zzy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.DeptRole;

import com.zzy.crm.entity.Role;
import com.zzy.crm.entity.RolePermission;
import com.zzy.crm.mapper.DeptRoleMapper;
import com.zzy.crm.mapper.RoleMapper;
import com.zzy.crm.mapper.RolePermissionMapper;
import com.zzy.crm.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private DeptRoleMapper deptRoleMapper ;

    @Autowired
    private RolePermissionMapper rolePermissionMapper ;


    @Override
    public IPage<Role> selectList(Page<Role> page) {
        return roleMapper.selectList(page);
    }

    @Override
    public IPage<Role> recoverRole(Page<Role> page) {

        return roleMapper.recoverRole(page);
    }

    @Override
    public Integer add(Role role, Integer deptId, Integer permId) {
        role.setCreateTime(StringUtils.getNowTime());
        role.setUpdateTime(role.getCreateTime());
        role.setIsDel(0);
        int result = roleMapper.insert(role);

        DeptRole deptRole = new DeptRole(deptId,role.getRoleId());
        deptRole.setCreateTime(StringUtils.getNowTime());
        deptRole.setUpdateTime(deptRole.getCreateTime());
        deptRole.setIsDel(0);
        deptRoleMapper.insert(deptRole);

        RolePermission permission = new RolePermission(role.getRoleId(),permId);
        permission.setCreateTime(StringUtils.getNowTime());
        permission.setUpdateTime(deptRole.getCreateTime());
        permission.setIsDel(0);
        rolePermissionMapper.insert(permission);

        return result;
    }
    @Override
    public Integer update(Role role, Integer deptId, Integer permId) {
        role.setUpdateTime(StringUtils.getNowTime());
        int result =  roleMapper.updateById(role);

        DeptRole deptRole = new DeptRole(deptId,role.getRoleId());
        deptRole.setUpdateTime(role.getUpdateTime());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("dept_id",deptId);
        Integer update = deptRoleMapper.update(deptRole,queryWrapper);
        if(update!=1){
            deptRole.setCreateTime(StringUtils.getNowTime());
            deptRole.setUpdateTime(deptRole.getCreateTime());
            deptRole.setIsDel(0);
            deptRoleMapper.insert(deptRole);
        }

        RolePermission permission = new RolePermission(role.getRoleId(),permId);
        permission.setUpdateTime(StringUtils.getNowTime());
        QueryWrapper queryWrapper2 = new QueryWrapper();
        queryWrapper.eq("perm_id",permId);
        Integer update2 = rolePermissionMapper.update(permission,queryWrapper);
        if(update2!=1){
            permission.setCreateTime(StringUtils.getNowTime());
            permission.setUpdateTime(deptRole.getCreateTime());
            permission.setIsDel(0);
            rolePermissionMapper.insert(permission);
        }
        return result;
    }



}
