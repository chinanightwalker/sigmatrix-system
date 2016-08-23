package com.sigmatrix.sc.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.BarcodeBLevelMapper;
import com.sigmatrix.sc.entity.v1.BarcodeBLevel;
import com.sigmatrix.sc.entity.v1.BarcodeBLevelExample;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.BarcodeBLevelService;
import com.sigmatrix.sc.utils.DateUtil;


@Service
public class BarcodeBLevelServiceImpl implements BarcodeBLevelService {
	
	private static Logger logger1 = Logger.getLogger(BarcodeBLevelServiceImpl.class);
	
	@Autowired
	private BarcodeBLevelMapper barcodeBLevelMapper;

	@Override
	public BarcodeBLevel getBarcodeBLevelByBCode(String bCode,String tablePrefix) throws Exception {
		logger1.info("查询箱码表 bCode="+bCode);
		if(StringUtils.isEmpty(bCode)){
			return null;
		}
		BarcodeBLevel barcodeBLevel = barcodeBLevelMapper.selectByPrimaryKey(bCode,tablePrefix);
		logger1.info("查询箱码表  "+JSONObject.toJSONString(barcodeBLevel));
		return barcodeBLevel;
	}

	@Override
	public PageBean<BarcodeBLevel> getBarcodeBLeveLList(PageBean<BarcodeBLevel> page, BarcodeBLevel barcodeBLevel,
			String startDateStr, String endDateStr) throws Exception {
		Date startDate = null;
		Date endDate = null;
		if (startDateStr != null && !startDateStr.equals("")) {
			startDate = DateUtil.getDate(startDateStr + " 00:00:00");
		}
		if (endDateStr != null && !endDateStr.equals("")) {
			endDate = DateUtil.getDate(endDateStr + " 23:59:59");
		}
		BarcodeBLevelExample barcodeBLevelExample=new BarcodeBLevelExample();
		barcodeBLevelExample.setTablePrefix(barcodeBLevel.getTablePrefix());
		//根据时间查询
		if(startDate != null&& endDate != null){
			barcodeBLevelExample.createCriteria().andUpdateTimeBetween(startDate, endDate);
		}else if(startDate == null && endDate != null){
			startDate = DateUtil.getDate("1970-01-01 00:00:00");
			barcodeBLevelExample.createCriteria().andUpdateTimeBetween(startDate,endDate);
		}else if(startDate != null&& endDate == null){
			endDate=new Date();
			barcodeBLevelExample.createCriteria().andUpdateTimeBetween(startDate,endDate);
		}
		
		
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		barcodeBLevelExample.setOrderByClause("_update_time DESC");//根据时间倒叙
		return PageBeanUtil.toPagedResult(barcodeBLevelMapper.selectByExample(barcodeBLevelExample));
	}
}
