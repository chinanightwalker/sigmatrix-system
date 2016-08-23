package com.sigmatrix.sc.service;

import com.sigmatrix.sc.entity.v1.UserDayPrize;

//用户每天中奖表
public interface UserDayPrizeService {
	
	/**
	 * @Method: getUserDayPrizeCount
	 * @Description: 查询用户活动当天的中奖信息 如果不是当天 同步到当天
	 * @param userId
	 * @param actId
	 * @param date
	 * @return UserDayPrize
	 * @author zzw
	 * @date 2016年5月31日 下午2:28:30
	 */
	public int getUserDayPrizeAndSyn (Integer userId ,Integer actId);
	
	/**
	 * @Method: saveUserDayPrize
	 * @Description: 保存用户中奖信息
	 * @param userId
	 * @param actId
	 * @param date
	 * @param prizeCount
	 * @return void
	 * @author zzw
	 * @date 2016年5月31日 下午2:33:40
	 */
	public void saveUserDayPrize(Integer userId ,Integer actId,Integer prizeCount);
	

	/**
	 * @Method: queryAndUpdateUserDayPrize
	 * @Description: 查询更新或者保存
	 * @param userId
	 * @param actId
	 * @param date
	 * @return void
	 * @author zzw
	 * @date 2016年5月31日 下午2:39:07
	 */
	public void queryUpdateSaveUserDayPrize(Integer userId, Integer actId);
	
	/**
	 * @Method: updateByPrimaryKeySelective
	 * @Description: 更新实体中有值的字段
	 * @param udp
	 * @return void
	 * @author zzw
	 * @date 2016年5月31日 下午3:38:53
	 */
	public void updateByPrimaryKeySelective(UserDayPrize udp);
	
	
	
}
