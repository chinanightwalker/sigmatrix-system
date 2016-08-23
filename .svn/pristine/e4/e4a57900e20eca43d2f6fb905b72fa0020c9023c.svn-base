package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ActivityPrize;
import com.sigmatrix.sc.entity.v1.ActivityPrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityPrizeMapper {
    int countByExample(ActivityPrizeExample example);

    int deleteByExample(ActivityPrizeExample example);

    int deleteByPrimaryKey(@Param("prizeId") Integer prizeId, @Param("tablePrefix") String tablePrefix);

    int insert(ActivityPrize record);

    int insertSelective(ActivityPrize record);

    List<ActivityPrize> selectByExample(ActivityPrizeExample example);

    ActivityPrize selectByPrimaryKey(@Param("prizeId") Integer prizeId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ActivityPrize record, @Param("example") ActivityPrizeExample example);

    int updateByExample(@Param("record") ActivityPrize record, @Param("example") ActivityPrizeExample example);

    int updateByPrimaryKeySelective(ActivityPrize record);

    int updateByPrimaryKey(ActivityPrize record);
}
