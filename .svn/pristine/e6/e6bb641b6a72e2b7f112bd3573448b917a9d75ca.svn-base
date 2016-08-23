package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ProductBaseExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductBaseMapper {
    int countByExample(ProductBaseExample example);

    int deleteByExample(ProductBaseExample example);

    int deleteByPrimaryKey(@Param("productId") String productId, @Param("tablePrefix") String tablePrefix);

    int insert(ProductBase record);

    int insertSelective(ProductBase record);

    List<ProductBase> selectByExample(ProductBaseExample example);

    ProductBase selectByPrimaryKey(@Param("productId") String productId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ProductBase record, @Param("example") ProductBaseExample example);

    int updateByExample(@Param("record") ProductBase record, @Param("example") ProductBaseExample example);

    int updateByPrimaryKeySelective(ProductBase record);

    int updateByPrimaryKey(ProductBase record);

	
}
