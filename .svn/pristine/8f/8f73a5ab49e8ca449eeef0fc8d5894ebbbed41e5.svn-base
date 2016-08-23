package com.sigmatrix.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityConsumerMapper;
import com.sigmatrix.sc.entity.v1.ActivityConsumer;
import com.sigmatrix.sc.entity.v1.ActivityConsumerExample;
import com.sigmatrix.sc.entity.v1.CustomerInfo;
import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.service.ActivityConsumerService;
import com.sigmatrix.sc.service.CustomerInfoService;

@Service
public class ActivityConsumerServiceImpl implements ActivityConsumerService {
	private static Logger logger1 = Logger.getLogger(ActivityConsumerServiceImpl.class);
	
	@Autowired
	private CustomerInfoService customerInfoService;
	@Autowired
	private ActivityConsumerMapper activityConsumerMapper;
	
	//判断用户是否首次参加活动 如果是首次记录用户参与活动表  消费者表的活动Id为空 更新消费者表
	public String isCustActAttendedAndRecord (String openId,Integer actId,String tablePrefix){
		if(null == openId || null == actId){
			return WebConstants.CUST_FIRST_ACT_NO;//非首次
		}
		CustomerInfo custInfo = customerInfoService.getCustomerInfoByOpenId(openId,tablePrefix);
		if(null == custInfo || null == custInfo.getCustomerId()){
			logger1.info("没有用户信息 首次参与活动");
			return WebConstants.CUST_FIRST_ACT_YES;//首次
		}else{
			if(null == custInfo.getActivityId()){
				logger1.info("消费者表活动id为空 更新活动id");
				customerInfoService.updateActivityId(openId, actId,tablePrefix);
			}
			if(null == custInfo.getActivityId()){
				logger1.info("消费者表创建用户方式为空  更新创建用户方式 type");
				customerInfoService.updateCustomerType(openId, WebConstants.CUST_TYPE_SCAN,tablePrefix);
			}
		}
		String custId = custInfo.getCustomerId()+"";
		try {
			if (CollectionUtils.isEmpty(this.getActivityConsumer(custId, actId,tablePrefix))) {
				logger1.info("首次参与活动表中无记录 首次参与活动 并记录用户参与活动表");
				ActivityConsumer ac = new ActivityConsumer();
				ac.setActivityId(actId);
				ac.setUserId(custInfo.getCustomerId()+"");
				Date nowDate = new Date();
				ac.setCreateTime(nowDate);
				ac.setUpdateTime(nowDate);
				this.saveActivityConsumer(ac);
				return WebConstants.CUST_FIRST_ACT_YES;//首次
			}
		} catch (Exception e) {
			logger1.info("查询用户参与活动表异常 ActivityConsuer 用户非首次参与活动");
			return WebConstants.CUST_FIRST_ACT_NO;//非首次
		}
		return WebConstants.CUST_FIRST_ACT_NO;//非首次
	}
	
	//根据用户id 活动id查询用户参与活动信息
	public List<ActivityConsumer> getActivityConsumer(String custId,Integer actId,String tablePrefix) throws Exception{
		logger1.info("用户参与活动表  custId ="+custId+" actId ="+actId);
		List<ActivityConsumer> list = null;
		ActivityConsumerExample example = new ActivityConsumerExample();
		example.setTablePrefix(tablePrefix);
		com.sigmatrix.sc.entity.v1.ActivityConsumerExample.Criteria cia = example.createCriteria();
		cia.andActivityIdEqualTo(actId);//活动ID
		cia.andUserIdEqualTo(custId);//客户id
		list = activityConsumerMapper.selectByExample(example);
		return list;
	}
	
	//保存用户参与活动信息
	public void saveActivityConsumer(ActivityConsumer ac) throws Exception{
		logger1.info("保存用户参与活动信息");
		int flag = activityConsumerMapper.insert(ac);
		if(1 != flag){
			logger1.error("保存用户参与活动信息 失败 flag="+flag);
			throw new RuntimeException("save activityConsumer fail");
		}
	}
}