package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.PrizePeriodTotal;
import com.sigmatrix.sc.entity.v1.PrizePeriodTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrizePeriodTotalMapper {
    int countByExample(PrizePeriodTotalExample example);

    int deleteByExample(PrizePeriodTotalExample example);

    int deleteByPrimaryKey(@Param("dateSlot") String dateSlot, @Param("tablePrefix") String tablePrefix);

    int insert(PrizePeriodTotal record);

    int insertSelective(PrizePeriodTotal record);

    List<PrizePeriodTotal> selectByExample(PrizePeriodTotalExample example);

    PrizePeriodTotal selectByPrimaryKey(@Param("dateSlot") String dateSlot, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") PrizePeriodTotal record, @Param("example") PrizePeriodTotalExample example);

    int updateByExample(@Param("record") PrizePeriodTotal record, @Param("example") PrizePeriodTotalExample example);

    int updateByPrimaryKeySelective(PrizePeriodTotal record);

    int updateByPrimaryKey(PrizePeriodTotal record);
}
