package com.sigmatrix.sc.web.vo;
/** 
 * @author  zln:
 * @date 创建时间：2016年7月27日 上午10:38:08 
 * @parameter   
 * @return 
 */
public class AccountUpdateVo {
	
	public AccountUpdateVo(String roleIds, AccountUpdateVoPo account) {
		super();
		this.roleIds = roleIds;
		this.account = account;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public AccountUpdateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public AccountUpdateVoPo getAccount() {
		return account;
	}
	public void setAccount(AccountUpdateVoPo account) {
		this.account = account;
	}
	private String roleIds;
	private AccountUpdateVoPo account;
	
}
