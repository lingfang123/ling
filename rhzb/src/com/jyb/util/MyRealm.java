package com.jyb.util;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.jyb.pojo.User;
import com.jyb.service.UserService;

public class MyRealm extends AuthorizingRealm{
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	//权限控制
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/*String principal = (String) getAvailablePrincipal(principals);
		System.out.println("当前用户为："+principal);
		 Set<String> roles = new HashSet<String>();
		 roles.add("user");
		 if("admin".equals(principal)) {
			 roles.add("admin");
			 roles.add("abc");
		 }
		
		 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		 info.setRoles(roles);
		
		return info;*/
		return null;
	}
	//登陆控制
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Object phone = token.getPrincipal();
		
		User user = userService.getByuserPhone(phone.toString());
		String password = user.getPassword();
		String userna = user.getUsername();
		Object users = userna;
		
		AuthenticationInfo info = new SimpleAuthenticationInfo(userna, password, ByteSource.Util.bytes(users), this.getName());
		
		return info;
	}
	
	public static void main(String[] args) {
		/*String username  = "admin";
		String password = "123456";
		Md5Hash md5Hash = new Md5Hash(username, password, 1);*/
	    //下面代码主要注册时候用的，存储在我们数据库的密码里面
		Object password = "123456";
		
		Object result = new SimpleHash("MD5", password, ByteSource.Util.bytes("yjm"), 10);
		
		System.out.println(result.toString());
	}
}
