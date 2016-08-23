package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.CustomerCurrentsLog;
import com.sigmatrix.sc.entity.v1.CustomerCurrentsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerCurrentsLogMapper {
    int countByExample(CustomerCurrentsLogExample example);

    int deleteByExample(CustomerCurrentsLogExample example);

    int deleteByPrimaryKey(@Param("id") String id, @Param("tablePrefix") String tablePrefix);

    int insert(CustomerCurrentsLog record);

    int insertSelective(CustomerCurrentsLog record);

    List<CustomerCurrentsLog> selectByExample(CustomerCurrentsLogExample example);

    CustomerCurrentsLog selectByPrimaryKey(@Param("id") String id, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") CustomerCurrentsLog record, @Param("example") CustomerCurrentsLogExample example);

    int updateByExample(@Param("record") CustomerCurrentsLog record, @Param("example") CustomerCurrentsLogExample example);

    int updateByPrimaryKeySelective(CustomerCurrentsLog record);

    int updateByPrimaryKey(CustomerCurrentsLog record);
}
