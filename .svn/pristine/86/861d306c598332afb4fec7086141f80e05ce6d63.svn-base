package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.CashCouponRecord;
import com.sigmatrix.sc.entity.v1.CashCouponRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashCouponRecordMapper {
    int countByExample(CashCouponRecordExample example);

    int deleteByExample(CashCouponRecordExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int insert(CashCouponRecord record);

    int insertSelective(CashCouponRecord record);

    List<CashCouponRecord> selectByExample(CashCouponRecordExample example);

    CashCouponRecord selectByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") CashCouponRecord record, @Param("example") CashCouponRecordExample example);

    int updateByExample(@Param("record") CashCouponRecord record, @Param("example") CashCouponRecordExample example);

    int updateByPrimaryKeySelective(CashCouponRecord record);

    int updateByPrimaryKey(CashCouponRecord record);
}
