package com.zzy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzy.crm.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.crm.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {



}
