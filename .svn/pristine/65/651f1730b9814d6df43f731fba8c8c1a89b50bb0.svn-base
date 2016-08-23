package com.sigmatrix.sc.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ProductActivityMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ProductBaseMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ScancodeTransitionMapper;
import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductActivityExample;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ProductBaseExample;
import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.entity.v1.ScancodeTransitionExample;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.ProductBaseService;

@Service
public class ProductBaseServiceImpl implements ProductBaseService {

	private static Logger logger1 = Logger.getLogger(ProductBaseServiceImpl.class);

	@Autowired
	private ProductBaseMapper productBaseMapper;
	@Autowired
	private ScancodeTransitionMapper scancodeTransitionMapper;
	@Autowired
	private ProductActivityMapper productActivityMapper;

	/**
	 * 产品管理-查询
	 */
	@Override
	public PageBean<ProductBase> getProductBaseList(PageBean<ProductBase> page, ProductBase productbase) throws Exception {
		ProductBaseExample exa = new ProductBaseExample();
		exa.setTablePrefix(productbase.getTablePrefix());
		if (null != productbase) {
			if (StringUtils.isNotBlank(productbase.getProductName())) {
				exa.createCriteria().andProductNameLike("%" + productbase.getProductName() + "%");
			}
			if (StringUtils.isNotBlank(productbase.getProductCode())) {
				exa.createCriteria().andProductCodeEqualTo(productbase.getProductCode());
			}
			exa.createCriteria().andStatusEqualTo((productbase.getStatus()));
		}
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		return PageBeanUtil.toPagedResult(productBaseMapper.selectByExample(exa));
	}

	@Override
	public ProductBase getProductBaseById(ProductBase productbase) throws Exception {
		if (null != productbase) {
			productbase =productBaseMapper.selectByPrimaryKey(productbase.getProductId(), productbase.getTablePrefix());
		}		
		return productbase;
	}

	@Override
	public ProductBase getProductBaseById(Integer productId) throws Exception {
		return null;
	}

	@Override
	public int deleteProctBaseById(ProductBase productbase) {
		int s=0;
		if (null != productbase) {
			System.out.println("id"+productbase.getProductId());
			s=productBaseMapper.deleteByPrimaryKey(productbase.getProductId(),productbase.getTablePrefix());
		}
		return s;		
	}

	@Override
	public int updateAndsaveObject(ProductBase productbase) {
			return productBaseMapper.updateByPrimaryKeySelective(productbase);		
	}

	@Override
	public int insertAndsaveObject(ProductBase productBase) throws Exception {
		return productBaseMapper.insertSelective(productBase);		
	}

	@Override
	public ProductBase getProductBaseById(String productId, ProductBase productbase) throws Exception {
		return productBaseMapper.selectByPrimaryKey(productbase.getProductId(),productbase.getTablePrefix());
	}

	@Override
	public List<ScancodeTransition> selectScancodeTransitionbyId(ScancodeTransitionExample esc) throws Exception{
		return scancodeTransitionMapper.selectByExample(esc);
	}


	@Override
	public ProductBase getProductBaseByProductId(Integer productId,String tablePrefix)
			{
		// TODO Auto-generated method stub
		logger1.info("查询产品基础信息 _product_base  _product_id ="+productId);
		if(null == productId){
			return null;
		}
		ProductBase pb = productBaseMapper.selectByPrimaryKey(productId.toString(), tablePrefix);
		logger1.info("查询产品基础信息返回  "+JSONObject.toJSONString(pb));
		return pb;	
	}

	@Override
	public List<ProductActivity> selecProductActivitybyProductId(ProductActivityExample pro) throws Exception {
		// TODO Auto-generated method stub
		return productActivityMapper.selectByExample(pro);
	}
			
	

		
	

}