package com.sigmatrix.sc.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.UnactivePrizeInfoMapper;
import com.sigmatrix.sc.entity.v1.UnactivePrizeInfo;
import com.sigmatrix.sc.entity.v1.UnactivePrizeInfoExample;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.UnactivePrizeInfoService;
import com.sigmatrix.sc.utils.DateUtil;
@Service
public class UnactivePrizeInfoServiceImpl implements UnactivePrizeInfoService {
	private static Logger logger1 = Logger.getLogger(UnactivePrizeInfoServiceImpl.class);
	@Autowired
	private UnactivePrizeInfoMapper unactivePrizeInfoMapper;
	@Override
	public PageBean<UnactivePrizeInfo> getPageUnactivePrizeInfoByExample(
			PageBean<UnactivePrizeInfo> page,
			UnactivePrizeInfo unactivePrizeInfo, String startDateStr,
			String endDateStr) throws Exception {
		UnactivePrizeInfoExample upie = new UnactivePrizeInfoExample();
		upie.setTablePrefix(unactivePrizeInfo.getTablePrefix());
		UnactivePrizeInfoExample.Criteria criteria = upie.createCriteria();
		upie.setOrderByClause("_create_time DESC");
		Date startDate = null;
		Date endDate = null;
		if(startDateStr!=null && !startDateStr.equals("") ){
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
		return PageBeanUtil.toPagedResult(unactivePrizeInfoMapper
				.selectByExample(upie));
		
	}

}
