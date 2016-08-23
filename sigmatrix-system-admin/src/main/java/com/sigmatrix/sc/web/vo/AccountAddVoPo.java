package com.sigmatrix.sc.web.vo;

import scala.annotation.serializable;

/** 
 * @author  zln:
 * @date 创建时间：2016年7月25日 下午3:08:15 
 * @parameter   
 * @return 
 */
public class AccountAddVoPo extends serializable {
	
	public AccountAddVoPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountAddVoPo(String status, String email, String admin,
			String userName, String nickname, String password,
			String mobilePhoneNumber) {
		super();
		this.status = status;
		this.email = email;
		this.admin = admin;
		this.userName = userName;
		this.nickname = nickname;
		this.password = password;
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	private String status;
	private String email;
	private String admin;
	private String userName;
	private String nickname;
	private String password;
	private String mobilePhoneNumber;
}
