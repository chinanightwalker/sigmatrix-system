package com.sigmatrix.sc.service;

import com.sigmatrix.sc.entity.v1.ScanTimeOrder;
import com.sigmatrix.sc.entity.v1.ScanTimeOrderExample;
import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.page.PageBean;

public interface ScanTimeOrderService {

	public PageBean<ScanTimeOrder> getPageScanTimeOrderByExample (
			PageBean<ScanTimeOrder> page, ScanTimeOrder scanTimeOrder,
			String startDateStr,String endDateStr) throws Exception;
	public ScanTimeOrder getScanTimeOrderByKey(String scanCodeOrderId,String tablePrefix) throws Exception;
	
	//修改发货状态
	public void saveOrUpdateScanTimeOrder(ScanTimeOrder scanTimeOrder) throws Exception;
	
}