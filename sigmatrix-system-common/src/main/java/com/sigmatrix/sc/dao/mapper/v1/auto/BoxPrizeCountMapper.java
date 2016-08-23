package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.BoxPrizeCount;
import com.sigmatrix.sc.entity.v1.BoxPrizeCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoxPrizeCountMapper {
    int countByExample(BoxPrizeCountExample example);

    int deleteByExample(BoxPrizeCountExample example);

    int deleteByPrimaryKey(@Param("encryptBarcodeBLevel") String encryptBarcodeBLevel, @Param("tablePrefix") String tablePrefix);

    int insert(BoxPrizeCount record);

    int insertSelective(BoxPrizeCount record);

    List<BoxPrizeCount> selectByExample(BoxPrizeCountExample example);

    BoxPrizeCount selectByPrimaryKey(@Param("encryptBarcodeBLevel") String encryptBarcodeBLevel, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") BoxPrizeCount record, @Param("example") BoxPrizeCountExample example);

    int updateByExample(@Param("record") BoxPrizeCount record, @Param("example") BoxPrizeCountExample example);

    int updateByPrimaryKeySelective(BoxPrizeCount record);

    int updateByPrimaryKey(BoxPrizeCount record);
}
