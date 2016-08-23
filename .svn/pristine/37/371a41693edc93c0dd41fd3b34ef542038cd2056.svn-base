package com.sigmatrix.sc.service;
import java.util.List;

import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductActivityExample;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.entity.v1.ScancodeTransitionExample;
import com.sigmatrix.sc.page.PageBean;
public interface ProductBaseService {
	
	//查询产品基础信息 待用
    public ProductBase getProductBaseById(Integer productId) throws Exception;
    //产品管理-查询
	public PageBean<ProductBase> getProductBaseList(PageBean<ProductBase> page, ProductBase productbase)throws Exception;
	//产品管理-修改-根据productBaseid
	public ProductBase getProductBaseById(ProductBase productBase) throws Exception;
	//删除产品信息
	public int deleteProctBaseById(ProductBase productBase) throws Exception;
	//添加产品信息
	public int updateAndsaveObject(ProductBase productBase) throws Exception;
	//更新产品信息
	public int insertAndsaveObject(ProductBase productBase) throws Exception;
	//根据id 查询产品信息
	public ProductBase getProductBaseById(String productId, ProductBase productBase) throws Exception;
	//根据产皮id 查询过渡页是否使用
	public List<ScancodeTransition> selectScancodeTransitionbyId(ScancodeTransitionExample esc)throws Exception;

	//根据主键查询产品基础信息
    public ProductBase getProductBaseByProductId(Integer productId,String tablePrefix) throws Exception ;
    //跟均产品id 查询活动与产品 是否关联
    public List<ProductActivity> selecProductActivitybyProductId(ProductActivityExample pro) throws Exception;
}