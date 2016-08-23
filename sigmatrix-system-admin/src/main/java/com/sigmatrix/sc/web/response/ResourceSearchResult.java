package com.sigmatrix.sc.web.response;
import java.util.List;

import com.sigmatrix.sc.web.vo.SysResource;
/** 
 * @author  zln:
 * @date 创建时间：2016年7月26日 上午10:36:31 
 * @parameter   
 * @return 
 */
public class ResourceSearchResult extends CommonUserResponse {
	private List<SysResource> resultList;

	public List<SysResource> getResultList() {
		return resultList;
	}

	public void setResultList(List<SysResource> resultList) {
		this.resultList = resultList;
	}
}
