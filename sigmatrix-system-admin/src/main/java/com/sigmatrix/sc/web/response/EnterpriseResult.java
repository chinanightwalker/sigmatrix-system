package com.sigmatrix.sc.web.response;

import java.util.List;

import com.sigmatrix.sc.web.vo.Enterprise;

/** 
 * @author  zln:
 * @date 创建时间：2016年7月16日 下午2:24:23 
 * @parameter   
 * @return 
 */
public class EnterpriseResult extends CommonUserResponse{
	public EnterpriseResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnterpriseResult(String resultState, String resultMsg) {
		super(resultState, resultMsg);
		// TODO Auto-generated constructor stub
	}

	private List<Enterprise> resultList;

	public List<Enterprise> getResultList() {
		return resultList;
	}

	public void setResultList(List<Enterprise> resultList) {
		this.resultList = resultList;
	}
}
