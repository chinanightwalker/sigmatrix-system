package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductActivityMapper {
    int countByExample(ProductActivityExample example);

    int deleteByExample(ProductActivityExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int insert(ProductActivity record);

    int insertSelective(ProductActivity record);

    List<ProductActivity> selectByExample(ProductActivityExample example);

    ProductActivity selectByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ProductActivity record, @Param("example") ProductActivityExample example);

    int updateByExample(@Param("record") ProductActivity record, @Param("example") ProductActivityExample example);

    int updateByPrimaryKeySelective(ProductActivity record);

    int updateByPrimaryKey(ProductActivity record);
}
