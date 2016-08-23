package com.sigmatrix.sc.web.response;

import java.util.List;

import com.sigmatrix.sc.web.vo.Role;

/** 
 * @author  zln:
 * @date 创建时间：2016年7月26日 下午6:30:53 
 * @parameter   
 * @return 
 */
public class AccountRoleResult extends CommonUserResponse {
	private List<Role> resultList;

	public List<Role> getResultList() {
		return resultList;
	}

	public void setResultList(List<Role> resultList) {
		this.resultList = resultList;
	}

	
}
