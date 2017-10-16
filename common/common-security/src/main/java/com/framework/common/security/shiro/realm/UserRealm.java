package com.framework.common.security.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.CollectionUtils;

import com.framework.common.security.model.SecurityRole;
import com.framework.common.security.model.SecurityUser;
import com.framework.common.security.service.UserService;

public class UserRealm extends AuthorizingRealm {

	private UserService userService;
	
	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String)getAvailablePrincipal(principals);
		SecurityUser user = userService.getUserByName(username);
		if( null != user ) {
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			authorizationInfo.setRoles(user.getRoleCodes());
			if( !CollectionUtils.isEmpty(user.getRoles()) ) {
				for (SecurityRole role : user.getRoles()) {
					authorizationInfo.addStringPermissions(role.getPermissions());
				}
			}
			return authorizationInfo;
		}
		
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
		
		// 判断用户是否存在
		SecurityUser user = userService.getUserByName(usernamePasswordToken.getUsername());
		if( null != user ) {
			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		}
		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
