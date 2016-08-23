package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.UserScanCodeTimePrize;
import com.sigmatrix.sc.entity.v1.UserScanCodeTimePrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserScanCodeTimePrizeMapper {
    int countByExample(UserScanCodeTimePrizeExample example);

    int deleteByExample(UserScanCodeTimePrizeExample example);

    int deleteByPrimaryKey(@Param("scanTimePrizeId") Integer scanTimePrizeId, @Param("tablePrefix") String tablePrefix);

    int insert(UserScanCodeTimePrize record);

    int insertSelective(UserScanCodeTimePrize record);

    List<UserScanCodeTimePrize> selectByExample(UserScanCodeTimePrizeExample example);

    UserScanCodeTimePrize selectByPrimaryKey(@Param("scanTimePrizeId") Integer scanTimePrizeId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") UserScanCodeTimePrize record, @Param("example") UserScanCodeTimePrizeExample example);

    int updateByExample(@Param("record") UserScanCodeTimePrize record, @Param("example") UserScanCodeTimePrizeExample example);

    int updateByPrimaryKeySelective(UserScanCodeTimePrize record);

    int updateByPrimaryKey(UserScanCodeTimePrize record);
}
