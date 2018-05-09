package com.free.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.free.shiro.dao.RolePermissionMapper;
import com.free.shiro.dao.UserMapper;
import com.free.shiro.dao.UserRoleMapper;
import com.free.shiro.entity.DO.Permission;
import com.free.shiro.entity.DO.Role;
import com.free.shiro.entity.DO.RolePermission;
import com.free.shiro.entity.DO.User;
import com.free.shiro.entity.DO.UserRole;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	/**
	 * 授权
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
        List<UserRole> roles = userRoleMapper.selectByUserId(user.getId());
        if(roles.size()>0) {
            for(UserRole role : roles) {
                   List<RolePermission> permissions1 = rolePermissionMapper.selectByRoleId(role.getRoleId());
                if(permissions1.size()>0) {
                    for(RolePermission module : permissions1) {
                        permissions.add(module.getPermissionId());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
	}

	/**
	 * 认证
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken token1 = (UsernamePasswordToken) token;
		User user = userMapper.selectByPrimaryKey(token1.getUsername());
		return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
	}

}
