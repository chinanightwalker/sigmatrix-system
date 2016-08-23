package com.sigmatrix.sc.service;

import java.util.List;

import com.sigmatrix.sc.entity.v1.ActivityConsumer;

public interface ActivityConsumerService {
	//判断用户是否首次参加活动 如果是首次记录用户参与活动表
	public String isCustActAttendedAndRecord (String openId,Integer actId,String tablePrefix);
	
	//根据用户id 活动id查询用户参与活动信息
	public List<ActivityConsumer> getActivityConsumer(String custId,Integer actId,String tablePrefix) throws Exception;
	
	//保存用户参与活动信息"
	public void saveActivityConsumer(ActivityConsumer ac) throws Exception;
	
}