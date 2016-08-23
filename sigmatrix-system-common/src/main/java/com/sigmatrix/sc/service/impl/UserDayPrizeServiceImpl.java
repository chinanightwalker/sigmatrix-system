package com.sigmatrix.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.dao.mapper.v1.auto.UserDayPrizeMapper;
import com.sigmatrix.sc.entity.v1.UserDayPrize;
import com.sigmatrix.sc.entity.v1.UserDayPrizeExample;
import com.sigmatrix.sc.service.UserDayPrizeService;
import com.sigmatrix.sc.utils.DateUtil;

//用户每天中奖表
@Service
public class UserDayPrizeServiceImpl implements UserDayPrizeService {
	
	private static Logger logger1 = Logger.getLogger(UserDayPrizeServiceImpl.class);
	
	@Autowired
	private UserDayPrizeMapper userDayPrizeMapper;
	
	public UserDayPrize getUserDayPrize(Integer userId, Integer actId) {
		logger1.info("查询用户每天中奖表   userId="+userId+" actId="+actId);
		if(null == userId || null == actId){
			return null;
		}
		UserDayPrizeExample example = new UserDayPrizeExample();
		com.sigmatrix.sc.entity.v1.UserDayPrizeExample.Criteria cia= example.createCriteria();
		cia.andUserIdEqualTo(userId);
		cia.andActivityIdEqualTo(actId);
		List<UserDayPrize> list= userDayPrizeMapper.selectByExample(example);
		logger1.info("查询用户每天中奖表返回   "+JSONObject.toJSONString(list));
		if(null != list && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public int getUserDayPrizeAndSyn(Integer userId, Integer actId) {
		UserDayPrize udp = this.getUserDayPrize(userId, actId);
		if(null != udp){
			if(!DateUtil.isSameDate(udp.getUpdateTime(),new Date())){
				//判断创建时间是否和 当前时间是否为同一天 如果不同更新到当天 中奖记录清零
				Date date = new Date();
				udp.setUpdateTime(date);
				udp.setLastPrizeTime(date);
				udp.setPrizeCount(new Integer(0));
				this.updateByPrimaryKeySelective(udp);
				return 0;
			}else{
				return null != udp.getPrizeCount()?udp.getPrizeCount().intValue():0;
			}
		}else{
			this.saveUserDayPrize(userId, actId,0);
			return 0;
		}
	}


	@Override
	public void saveUserDayPrize(Integer userId, Integer actId,Integer prizeCount) {
		logger1.info("保存 userDayPrize   userId="+userId+" actId="+actId+" prizeCount="+prizeCount);
		UserDayPrize udp =  new UserDayPrize();
		udp.setUserId(userId);
		udp.setActivityId(actId);
		udp.setPrizeCount(prizeCount);
		Date date = new Date();
		udp.setCreateTime(date);
		udp.setUpdateTime(date);
		udp.setLastPrizeTime(date);
		int flag = userDayPrizeMapper.insert(udp);
		logger1.info("保存 userDayPrize 成功失败标识 flag="+flag);
	}


	@Override
	public void queryUpdateSaveUserDayPrize(Integer userId, Integer actId) {
		UserDayPrize udp = this.getUserDayPrize(userId, actId);
		if(null != udp){//更新
			Date date = new Date();
			udp.setPrizeCount(null != udp.getPrizeCount()?udp.getPrizeCount().intValue()+1:1);
			udp.setUpdateTime(date);
			udp.setLastPrizeTime(date);
			this.updateByPrimaryKeySelective(udp);
		}else{//保存
			this.saveUserDayPrize(userId, actId,1);
		}
		
	}
	
	public void updateByPrimaryKeySelective(UserDayPrize udp){
		logger1.info("更新 userDayPrize "+ JSONObject.toJSONString(udp));
		int flag = userDayPrizeMapper.updateByPrimaryKeySelective(udp);
		logger1.info("跟新  userDayPrize成功失败标识 flag="+flag);
		
	}

	
}
