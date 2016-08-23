package com.sigmatrix.sc.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ScanTimeOrderMapper;
import com.sigmatrix.sc.entity.v1.ScanTimeOrder;
import com.sigmatrix.sc.entity.v1.ScanTimeOrderExample;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.ScanTimeOrderService;
import com.sigmatrix.sc.utils.DateUtil;
@Service
public class ScanTimeOrderServiceImpl implements ScanTimeOrderService {
	
	private static Logger logger1 = Logger.getLogger(ScanTimeOrderServiceImpl.class);
	@Autowired
	private ScanTimeOrderMapper scanTimeOrderMapper;
	@Override
	public PageBean<ScanTimeOrder> getPageScanTimeOrderByExample(
			PageBean<ScanTimeOrder> page, ScanTimeOrder scanTimeOrder,
			String startDateStr,String endDateStr) throws Exception {
		// TODO Auto-generated method stub
		ScanTimeOrderExample stoe = new ScanTimeOrderExample();
		stoe.setTablePrefix(scanTimeOrder.getTablePrefix());
		ScanTimeOrderExample.Criteria criteria = stoe.createCriteria();
		stoe.setOrderByClause("_create_time DESC");
		Date startDate = null;
		Date endDate = null;
		if(scanTimeOrder.getScanCodeOrderId()!=null && !scanTimeOrder.getScanCodeOrderId().equals("")){
			criteria.andScanCodeOrderIdEqualTo(scanTimeOrder.getScanCodeOrderId());
		}
		if(scanTimeOrder.getStatus()!=null){
			criteria.andStatusEqualTo(scanTimeOrder.getStatus());
		}
		if(scanTimeOrder.getTel()!=null && !scanTimeOrder.getTel().equals("")){
			criteria.andTelEqualTo(scanTimeOrder.getTel());
		}
		if(scanTimeOrder.getDuijiangStatus()!=null){
			criteria.andDuijiangStatusEqualTo(scanTimeOrder.getDuijiangStatus());
		}
		if(startDateStr!=null && !startDateStr.equals("")){
			startDate = DateUtil.getDate(startDateStr+" 00:00:00");	
		}
		if(endDateStr != null &&!endDateStr.equals("")){
			endDate = DateUtil.getDate(endDateStr+" 23:59:59");
		}
		if(startDate!=null && endDate!=null){
			criteria.andCreateTimeBetween(startDate, endDate);
		}else if(startDate!=null && endDate==null){
			endDate = new Date();
			criteria.andCreateTimeBetween(startDate, endDate);
		}else if(startDate==null && endDate!=null){
			criteria.andCreateTimeLessThan(endDate);
		}
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		return PageBeanUtil.toPagedResult(scanTimeOrderMapper
				.selectByExample(stoe));
	}
	@Override
	public ScanTimeOrder getScanTimeOrderByKey(String scanCodeOrderId,
			String tablePrefix) {
		// TODO Auto-generated method stub
		return scanTimeOrderMapper.selectByPrimaryKey(scanCodeOrderId, tablePrefix);		
	}
	@Override
	public void saveOrUpdateScanTimeOrder(ScanTimeOrder scanTimeOrder)
			throws Exception {
		// TODO Auto-generated method stub
		scanTimeOrderMapper.updateByPrimaryKeySelective(scanTimeOrder);		
	}

}
