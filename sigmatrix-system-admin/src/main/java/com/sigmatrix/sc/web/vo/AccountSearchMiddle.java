package com.sigmatrix.sc.web.vo;

import java.util.List;

/** 
 * @author  zln:
 * @date 创建时间：2016年7月23日 下午5:17:11 
 * @parameter   
 * @return 
 */
public class AccountSearchMiddle {
	private String totalCount;
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public List<AccountSearch> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<AccountSearch> accountList) {
		this.accountList = accountList;
	}
	private List<AccountSearch> accountList;
}
