package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.RedbagForciblyOrder;
import com.sigmatrix.sc.entity.v1.RedbagForciblyOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedbagForciblyOrderMapper {
    int countByExample(RedbagForciblyOrderExample example);

    int deleteByExample(RedbagForciblyOrderExample example);

    int deleteByPrimaryKey(@Param("forciblyOrderId") String forciblyOrderId, @Param("tablePrefix") String tablePrefix);

    int insert(RedbagForciblyOrder record);

    int insertSelective(RedbagForciblyOrder record);

    List<RedbagForciblyOrder> selectByExample(RedbagForciblyOrderExample example);

    RedbagForciblyOrder selectByPrimaryKey(@Param("forciblyOrderId") String forciblyOrderId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") RedbagForciblyOrder record, @Param("example") RedbagForciblyOrderExample example);

    int updateByExample(@Param("record") RedbagForciblyOrder record, @Param("example") RedbagForciblyOrderExample example);

    int updateByPrimaryKeySelective(RedbagForciblyOrder record);

    int updateByPrimaryKey(RedbagForciblyOrder record);
}
