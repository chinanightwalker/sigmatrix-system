package com.sigmatrix.sc.web.vo;

import java.io.Serializable;

/** 
 * @author  
 * @date 创建时间：2016年7月15日 上午11:19:47 
 * @parameter   查询我的信息接口
 * @return 
 */
public class AccountProfile implements Serializable {
	//用户id
	private String id;
	public AccountProfile(String id, String createTime, String status,
			String updateTime, String email, String admin, String updateId,
			String userName, String password, String mobilePhoneNumber,
			String createId, String enterpriseId) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.status = status;
		this.updateTime = updateTime;
		this.email = email;
		this.admin = admin;
		this.updateId = updateId;
		this.userName = userName;
		this.password = password;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.createId = createId;
		this.enterpriseId = enterpriseId;
	}
	public AccountProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	//用户创建时间
	private String createTime;
	//用户状态(-1:已删除，0：未激活，1：正常)
	private String status;
	//用户信息更新时间
	private String updateTime;
	//email
	private String email;
	//是否是管理员 Boolean
	private String admin;
	//更新用户信息的人员
	private String updateId;
	//用户名
	private String userName;
	//密码
	private String password;
	//电话号码
	private String mobilePhoneNumber;
	//创建用户信息的人员
	private String createId;
	//企业ID
	private String enterpriseId;
	
	
	
}
