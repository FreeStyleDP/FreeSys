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

import com.free.dao.RolePermissionMapper;
import com.free.dao.UserMapper;
import com.free.dao.UserRoleMapper;
import com.free.entity.DO.Permission;
import com.free.entity.DO.Role;
import com.free.entity.DO.User;
import com.free.entity.DO.UserRole;

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
        List<Role> roles = userRoleMapper.selectByUserId(user.getId());
        if(roles.size()>0) {
            for(Role role : roles) {
                   List<Permission> permissions1 = rolePermissionMapper.selectByRoleId(role.getId());
                if(permissions1.size()>0) {
                    for(Permission module : permissions1) {
                        permissions.add(module.getId());
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
