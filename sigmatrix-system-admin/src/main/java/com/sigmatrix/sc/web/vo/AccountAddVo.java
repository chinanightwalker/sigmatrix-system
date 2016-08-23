package com.sigmatrix.sc.web.vo;
/** 
 * @author  zln:
 * @date 创建时间：2016年7月25日 下午2:19:25 
 * @parameter   
 * @return 
 */
public class AccountAddVo {
	private String roleIds;
	public AccountAddVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	
	private AccountAddVoPo account;
	public AccountAddVoPo getAccount() {
		return account;
	}
	public void setAccount(AccountAddVoPo account) {
		this.account = account;
	}
	
}
