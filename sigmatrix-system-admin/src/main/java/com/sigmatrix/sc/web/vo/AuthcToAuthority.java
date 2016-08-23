package com.sigmatrix.sc.web.vo;

import java.io.Serializable;
import java.util.List;

/** 
 * @author  zln:
 * @date 创建时间：2016年7月15日 上午11:08:17 
 * @parameter  4.2用户登录接口 
 * @return 
 */
public class AuthcToAuthority implements Serializable{
	
	
	//token
	private String token;
	public AuthcToAuthority() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthcToAuthority(String token, String userId, String nickname,
			String tokenTimeout, String securityCode, String roleList,
			String authList, List<MenuAuth> menuList) {
		super();
		this.token = token;
		this.userId = userId;
		this.nickname = nickname;
		this.tokenTimeout = tokenTimeout;
		this.securityCode = securityCode;
		this.roleList = roleList;
		this.authList = authList;
		this.menuList = menuList;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTokenTimeout() {
		return tokenTimeout;
	}
	public void setTokenTimeout(String tokenTimeout) {
		this.tokenTimeout = tokenTimeout;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getRoleList() {
		return roleList;
	}
	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}
	public String getAuthList() {
		return authList;
	}
	public void setAuthList(String authList) {
		this.authList = authList;
	}
	public List<MenuAuth> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuAuth> menuList) {
		this.menuList = menuList;
	}
	//用户ID
	private String userId;
	//用户昵称
	private String nickname;
	//token过期时间，格式为时间毫秒数
	private String tokenTimeout;	
	//安全码
	private String securityCode;	
	//角色集合
	private String roleList;	
	//权限集合
	private String authList;	
	//菜单集合
	private List<MenuAuth> menuList;
	
	
	
	
	
}
