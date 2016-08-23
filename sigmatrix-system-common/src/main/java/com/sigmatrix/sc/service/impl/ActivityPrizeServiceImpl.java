package com.sigmatrix.sc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityPrizeMapper;
import com.sigmatrix.sc.entity.v1.ActivityPrize;
import com.sigmatrix.sc.entity.v1.ActivityPrizeExample;
import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.service.ActivityPrizeService;
@Service
public class ActivityPrizeServiceImpl implements ActivityPrizeService {
	
	private static Logger logger1 = Logger.getLogger(ActivityPrizeServiceImpl.class);
	
	@Autowired
	private ActivityPrizeMapper activityPrizeMapper;
	
	public List<ActivityPrize> getPrizeListByExample(ActivityPrize example) throws Exception{
		ActivityPrizeExample exa = new ActivityPrizeExample();
		exa.setTablePrefix(example.getTablePrefix());
		ActivityPrizeExample.Criteria cia = exa.createCriteria();
		if(example.getActivityId()!=null){
			cia.andActivityIdEqualTo(example.getActivityId());
		}
		// 带上状态条件
		if(example.getStatus()!=null){
			cia.andStatusEqualTo(example.getStatus());
		}
		return activityPrizeMapper.selectByExample(exa);
	}
	
	
	
    //查询活动奖项设置表  一个活动对应多个奖项设置
    public List<ActivityPrize> getActivityPrizeList(Integer activityId){
    	logger1.info("查询活动奖项表 _activity_prize _activity_id ="+activityId);
		if(null == activityId){
			return null;
		}
		ActivityPrizeExample activityPrizeExample = new ActivityPrizeExample();
		com.sigmatrix.sc.entity.v1.ActivityPrizeExample.Criteria activityPrizeExampleCia = activityPrizeExample.createCriteria();
		activityPrizeExampleCia.andActivityIdEqualTo(activityId);
		activityPrizeExampleCia.andStatusEqualTo(1);//奖项数据状态正常  0删除1正常
		List<ActivityPrize> activityPrizeLists = activityPrizeMapper.selectByExample(activityPrizeExample);
		logger1.info("查询活动奖项表返回  _activity_prize "+JSONObject.toJSONString(activityPrizeLists));
		return activityPrizeLists;
    }
    
    //更新活动奖项表 部分值
    public void updateByPrimaryKeySelective(ActivityPrize ap) throws Exception{
		logger1.info("更新活动奖项表"+JSONObject.toJSONString(ap));
		int updateActivityPrize = activityPrizeMapper.updateByPrimaryKeySelective(ap);
		logger1.info("更新活动奖项表 成功失败标识 updateActivityPrize="+updateActivityPrize);
		if(1 != updateActivityPrize){
			logger1.error("update _activity_prize fail");
			throw new RuntimeException("update _activity_prize fail");
		}
    }
    
    //根据奖项获取活动奖项信息
    public ActivityPrize getActivityPrizeByPrizeId(Integer prizeId,String tablePrefix) throws Exception{
    	logger1.info("查询奖项信息 prizeId="+prizeId);
    	ActivityPrize ap = activityPrizeMapper.selectByPrimaryKey(prizeId,tablePrefix);
    	logger1.info("查询奖项信息返回 "+JSONObject.toJSONString(ap));
    	return ap;
    }
    
    public int saveOrUpdate(ActivityPrize activityPrize) throws Exception{
    	if(activityPrize.getPrizeId()==null){
    		// 插入时肯定是插入正常状态的
    		activityPrize.setStatus(WebConstants.PRIZE_COMMON_STATUS);
    		return activityPrizeMapper.insert(activityPrize);
    	}else{
    		return activityPrizeMapper.updateByPrimaryKeySelective(activityPrize);
    	}
    }



	@Override
	public boolean validatePrizeRateIsFull(int activityId, Integer prizeId, Float currentPrizeRate, String tablePrefix)
			throws Exception {

		// 根据奖项id查询所有活动所有正常状态的奖项
		ActivityPrize activityPrizeExample = new ActivityPrize();
		// 只需填充表前缀、活动id、奖项状态
		activityPrizeExample.setTablePrefix(tablePrefix); // 表前缀
		activityPrizeExample.setActivityId(activityId); // 活动id
		activityPrizeExample.setStatus(WebConstants.PRIZE_COMMON_STATUS); // 查正常状态
		List<ActivityPrize> prizeList = getPrizeListByExample(activityPrizeExample);
		if(prizeList==null || prizeList.isEmpty()){
			return false; // 未超出
		}
		Float totalPrizeRate = 0f; // 当前奖项总中奖率（修改时等于除修改奖项外的总中奖率）
		if(prizeId==null){ // 添加新的奖项
			for(ActivityPrize prize:prizeList){
				totalPrizeRate += prize.getPrizeRate();
			}
		}else{ // 修改原奖项的中奖率
			for(ActivityPrize prize:prizeList){
				if(prize.getPrizeId().intValue()!=prizeId){
					totalPrizeRate += prize.getPrizeRate()==null?0.0f:prize.getPrizeRate(); // 除当前奖项外的总中奖率
				}
			}
		}
		if(totalPrizeRate + currentPrizeRate>1.0f){
			return true; // 超出100%
		}
		return false;
	}

    
}
