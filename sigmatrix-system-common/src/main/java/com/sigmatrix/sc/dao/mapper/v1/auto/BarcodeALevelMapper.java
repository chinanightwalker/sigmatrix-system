package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.BarcodeALevel;
import com.sigmatrix.sc.entity.v1.BarcodeALevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BarcodeALevelMapper {
    int countByExample(BarcodeALevelExample example);

    int deleteByExample(BarcodeALevelExample example);

    int deleteByPrimaryKey(@Param("encryptBarcodeALevel") String encryptBarcodeALevel, @Param("tablePrefix") String tablePrefix);

    int insert(BarcodeALevel record);

    int insertSelective(BarcodeALevel record);

    List<BarcodeALevel> selectByExample(BarcodeALevelExample example);

    BarcodeALevel selectByPrimaryKey(@Param("encryptBarcodeALevel") String encryptBarcodeALevel, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") BarcodeALevel record, @Param("example") BarcodeALevelExample example);

    int updateByExample(@Param("record") BarcodeALevel record, @Param("example") BarcodeALevelExample example);

    int updateByPrimaryKeySelective(BarcodeALevel record);

    int updateByPrimaryKey(BarcodeALevel record);
}
