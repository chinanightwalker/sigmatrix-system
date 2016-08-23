package com.sigmatrix.sc.web.response;

import java.util.List;

import com.sigmatrix.sc.web.vo.MenuAuth;

/** 
 * @author  zln:
 * @date 创建时间：2016年7月16日 下午4:14:55 
 * @parameter   
 * @return 
 */
public class AuthcToAuthorityMiddle {
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	private String securityCode;
	private String token;
	private String roleList;
	private String authList;
	private List<MenuAuth> menuList;
	private String nickname;
	private String tokenTimeout;

	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getTokenTimeout() {
		return tokenTimeout;
	}
	public void setTokenTimeout(String tokenTimeout) {
		this.tokenTimeout = tokenTimeout;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
