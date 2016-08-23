package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.UserDayPrize;
import com.sigmatrix.sc.entity.v1.UserDayPrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDayPrizeMapper {
    int countByExample(UserDayPrizeExample example);

    int deleteByExample(UserDayPrizeExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int insert(UserDayPrize record);

    int insertSelective(UserDayPrize record);

    List<UserDayPrize> selectByExample(UserDayPrizeExample example);

    UserDayPrize selectByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") UserDayPrize record, @Param("example") UserDayPrizeExample example);

    int updateByExample(@Param("record") UserDayPrize record, @Param("example") UserDayPrizeExample example);

    int updateByPrimaryKeySelective(UserDayPrize record);

    int updateByPrimaryKey(UserDayPrize record);
}
