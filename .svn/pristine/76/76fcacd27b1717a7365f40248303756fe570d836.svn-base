package com.sigmatrix.sc.service;

import java.util.List;

import com.sigmatrix.sc.entity.v1.ActivityPrize;

public interface ActivityPrizeService {
	
	/**
	 * 根据条件获得所有奖项列表（不分页）
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public List<ActivityPrize> getPrizeListByExample(ActivityPrize example) throws Exception;
	//查询活动奖项设置表  一个活动对应多个奖项设置
    public List<ActivityPrize> getActivityPrizeList(Integer activityId);
    
    //更新活动奖项表 部分值
    public void updateByPrimaryKeySelective(ActivityPrize ap) throws Exception;
    
    /**
     * 根据奖项Id获取活动奖项信息
     * @param prizeId
     * @param tablePrefix
     * @return
     * @throws Exception
     */
    public ActivityPrize getActivityPrizeByPrizeId(Integer prizeId,String tablePrefix) throws Exception;

    /**
     * 添加或修改奖项
     * @param activityPrize
     * @return
     * @throws Exception
     */
    public int saveOrUpdate(ActivityPrize activityPrize) throws Exception;
    /**
     * 验证活动的中奖率是否超出100%,超出返回true,否则false
     * @param activityId 活动id 
     * @param prizeId 奖项id,若为空,请传null
     * @param currentPrizeRate 当前奖项中奖率(添加或修改奖项中奖率时传递,注意是float类型,1代表100%,0.83代表83%)
     * @param tablePrefix 表前缀
     * @return
     */
	public boolean validatePrizeRateIsFull(int parseInt, Integer prizeId, Float currentPrizeRate,String tablePrefix) throws Exception;
}