package com.sigmatrix.sc.web.vo;

import java.io.Serializable;

/** 
 * @author  
 * @date 创建时间：2016年7月15日 下午1:26:52 
 * @parameter 4.6查询用户接口  
 * @return 
 */
public class AccountSearch implements Serializable {
	private String id;
	public AccountSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountSearch(String id, String enterpriseId, String userName,
			String email, String mobilePhoneNumber, String password,
			String nickname, String salt, String admin, String status,
			String createTime, String createId, String updateTime,
			String updateId) {
		super();
		this.id = id;
		this.enterpriseId = enterpriseId;
		this.userName = userName;
		this.email = email;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.password = password;
		this.nickname = nickname;
		this.salt = salt;
		this.admin = admin;
		this.status = status;
		this.createTime = createTime;
		this.createId = createId;
		this.updateTime = updateTime;
		this.updateId = updateId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	private String enterpriseId;
	private String userName;
	private String email;
	private String mobilePhoneNumber;
	private String password;
	private String nickname;
	private String salt;
	private String admin;
	private String status;
	private String createTime;
	private String createId;
	private String updateTime;
	private String updateId;
	
}
