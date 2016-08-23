package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.BoxScanCount;
import com.sigmatrix.sc.entity.v1.BoxScanCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoxScanCountMapper {
    int countByExample(BoxScanCountExample example);

    int deleteByExample(BoxScanCountExample example);

    int deleteByPrimaryKey(@Param("encryptBarcodeBLevel") String encryptBarcodeBLevel, @Param("tablePrefix") String tablePrefix);

    int insert(BoxScanCount record);

    int insertSelective(BoxScanCount record);

    List<BoxScanCount> selectByExample(BoxScanCountExample example);

    BoxScanCount selectByPrimaryKey(@Param("encryptBarcodeBLevel") String encryptBarcodeBLevel, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") BoxScanCount record, @Param("example") BoxScanCountExample example);

    int updateByExample(@Param("record") BoxScanCount record, @Param("example") BoxScanCountExample example);

    int updateByPrimaryKeySelective(BoxScanCount record);

    int updateByPrimaryKey(BoxScanCount record);
}
