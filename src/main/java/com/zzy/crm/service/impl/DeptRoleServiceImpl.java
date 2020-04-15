package com.zzy.crm.service.impl;

import com.zzy.crm.entity.DeptRole;
import com.zzy.crm.mapper.DeptRoleMapper;
import com.zzy.crm.service.DeptRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-27
 */
@Service
@Transactional
public class DeptRoleServiceImpl extends ServiceImpl<DeptRoleMapper, DeptRole> implements DeptRoleService {

}
