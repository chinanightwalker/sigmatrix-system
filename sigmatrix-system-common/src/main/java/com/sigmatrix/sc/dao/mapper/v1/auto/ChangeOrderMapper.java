package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ChangeOrder;
import com.sigmatrix.sc.entity.v1.ChangeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChangeOrderMapper {
    int countByExample(ChangeOrderExample example);

    int deleteByExample(ChangeOrderExample example);

    int deleteByPrimaryKey(@Param("changeOrderId") String changeOrderId, @Param("tablePrefix") String tablePrefix);

    int insert(ChangeOrder record);

    int insertSelective(ChangeOrder record);

    List<ChangeOrder> selectByExample(ChangeOrderExample example);

    ChangeOrder selectByPrimaryKey(@Param("changeOrderId") String changeOrderId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ChangeOrder record, @Param("example") ChangeOrderExample example);

    int updateByExample(@Param("record") ChangeOrder record, @Param("example") ChangeOrderExample example);

    int updateByPrimaryKeySelective(ChangeOrder record);

    int updateByPrimaryKey(ChangeOrder record);
}
