package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {
    int countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(@Param("activityId") Integer activityId, @Param("tablePrefix") String tablePrefix);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(@Param("activityId") Integer activityId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
    /**
     * 更新活动的首次中奖奖项
     * @param activityId 活动id
     * @param firstPrizeId 首次中奖奖项id,可为null(即不设置)
     * @param tablePrefix 表前缀
     * @return
     */
    int updateActivityFirstPrizeId(@Param("activityId") Integer activityId,@Param("firstPrizeId") Integer firstPrizeId, @Param("tablePrefix") String tablePrefix);
}
