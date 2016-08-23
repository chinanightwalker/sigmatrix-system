package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ChangeOrderRecord;
import com.sigmatrix.sc.entity.v1.ChangeOrderRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChangeOrderRecordMapper {
    int countByExample(ChangeOrderRecordExample example);

    int deleteByExample(ChangeOrderRecordExample example);

    int deleteByPrimaryKey(@Param("payId") String payId, @Param("tablePrefix") String tablePrefix);

    int insert(ChangeOrderRecord record);

    int insertSelective(ChangeOrderRecord record);

    List<ChangeOrderRecord> selectByExample(ChangeOrderRecordExample example);

    ChangeOrderRecord selectByPrimaryKey(@Param("payId") String payId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ChangeOrderRecord record, @Param("example") ChangeOrderRecordExample example);

    int updateByExample(@Param("record") ChangeOrderRecord record, @Param("example") ChangeOrderRecordExample example);

    int updateByPrimaryKeySelective(ChangeOrderRecord record);

    int updateByPrimaryKey(ChangeOrderRecord record);
}
