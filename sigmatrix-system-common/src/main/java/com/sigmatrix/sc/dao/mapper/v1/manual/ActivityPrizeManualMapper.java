package com.sigmatrix.sc.dao.mapper.v1.manual;


import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.sigmatrix.sc.entity.v1.ActivityPrize;

public interface ActivityPrizeManualMapper {
	
	/**
	 * @Method: updateActivityPrize1
	 * @Description: 根据id更新奖项表的中奖数量  中奖金额  更新时间
	 * @param activityPrize
	 * @return void
	 * @author zzw
	 * @date 2016年6月14日 下午3:18:18
	 */
	public void updateActivityPrize1(ActivityPrize activityPrize);
	
	/**
	 * @Method: updateActivityPrize2
	 * @Description: 根据id更新奖项表的中奖数量  中奖金额  更新时间
	 * @param prizeId
	 * @param luckyCount
	 * @param prizeLuckyAmount
	 * @param updateTime
	 * @return void
	 * @author zzw
	 * @date 2016年6月18日 下午1:05:45
	 */
	public void updateActivityPrize2(@Param("prizeId") Integer prizeId,@Param("luckyCount") Integer luckyCount,
			@Param("prizeLuckyAmount") Integer prizeLuckyAmount,@Param("updateTime") Date updateTime);

}