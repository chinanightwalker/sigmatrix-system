package com.sigmatrix.sc.web.response;

import com.sigmatrix.sc.web.vo.Enterprise;

/** 
 * @author  zln:
 * @date 创建时间：2016年7月21日 下午3:40:06 
 * @parameter   
 * @return 
 */
public class EnterpriseSearch extends CommonUserResponse {
	public EnterpriseSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Enterprise resultList;

	public Enterprise getResultList() {
		return resultList;
	}

	public void setResultList(Enterprise resultList) {
		this.resultList = resultList;
	}

	
}
