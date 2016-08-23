package com.sigmatrix.sc.dao.mapper.v1.manual;


import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.sigmatrix.sc.entity.v1.Activity;

public interface ActivityManualMapper {
	
	/**
	 * @Method: updateActivityScanCount1
	 * @Description: 根据活动id更新 扫码量 更新时间
	 * @param activity
	 * @return void
	 * @author zzw
	 * @date 2016年6月18日 下午1:06:13
	 */
	public void updateActivityScanCount1(Activity activity);
	
	/**
	 * @Method: updateActivityScanCount
	 * @Description: 根据活动id更新 扫码量 更新时间
	 * @param activityId
	 * @param scanCount
	 * @param updateTime
	 * @return void
	 * @author zzw
	 * @date 2016年6月18日 下午12:23:46
	 */
	public void updateActivityScanCount2(@Param("activityId") Integer activityId,
			@Param("scanCount") Integer scanCount,@Param("updateTime") Date updateTime);

}