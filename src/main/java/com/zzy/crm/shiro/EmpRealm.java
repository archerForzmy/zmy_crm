package com.zzy.crm.shiro;

import com.zzy.crm.entity.Employee;
import com.zzy.crm.entity.Permission;
import com.zzy.crm.entity.Role;
import com.zzy.crm.service.EmployeeService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 邹靓仔
 * @date 2020/3/25 -10:23 -zzy_crm
 **/
public class EmpRealm extends AuthorizingRealm {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入授权方法");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Employee emp = (Employee)principalCollection.getPrimaryPrincipal();

        for (Role role:emp.getRoleList()){
            info.addRole(role.getRoleName());
            for (Permission p : role.getPermissionList()){
                info.addStringPermission(p.getPermission());
            }
        }

        return info;
    }

    /**
     * 认证方法：判断前端传过来的用户名和数据库中的用户名是否一致，不一致就抛出异常；
     * 如果一致，就将信息打包交给安全管理器去判断其他的
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入Employee认证方法");

        //拿到前端传过来的用户名
        String empName = (String)authenticationToken.getPrincipal();

        //数据库获取用户名密码，用于判断用户信息
        Employee emp = employeeService.selectByName(empName);

        //判断用户是否存在，如果存在，通过，将密码判断交给安全管理器
        if (emp == null){
            throw new UnknownAccountException("用户不存在");
        }
        //将用户对象，密码，realm打包到SimpleAuthenticationInfo 对象中(授权方法还需要employee中的就是和权限)
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                emp,    //用户对象
                emp.getPwd(), //用户密码
                ByteSource.Util.bytes(emp.getCredentialsSalt()), //使用强化盐 = empName + salt
                getName());  //Realm的名称

        return info;
    }
}
