package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ScanTimeOrder;
import com.sigmatrix.sc.entity.v1.ScanTimeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScanTimeOrderMapper {
    int countByExample(ScanTimeOrderExample example);

    int deleteByExample(ScanTimeOrderExample example);

    int deleteByPrimaryKey(@Param("scanCodeOrderId") String scanCodeOrderId, @Param("tablePrefix") String tablePrefix);

    int insert(ScanTimeOrder record);

    int insertSelective(ScanTimeOrder record);

    List<ScanTimeOrder> selectByExample(ScanTimeOrderExample example);

    ScanTimeOrder selectByPrimaryKey(@Param("scanCodeOrderId") String scanCodeOrderId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ScanTimeOrder record, @Param("example") ScanTimeOrderExample example);

    int updateByExample(@Param("record") ScanTimeOrder record, @Param("example") ScanTimeOrderExample example);

    int updateByPrimaryKeySelective(ScanTimeOrder record);

    int updateByPrimaryKey(ScanTimeOrder record);
}
