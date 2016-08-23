package com.sigmatrix.sc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.dao.mapper.v1.auto.ProductActivityMapper;
import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductActivityExample;
import com.sigmatrix.sc.service.ProductActivityService;

@Service
public class ProductActivityServiceImpl implements ProductActivityService {
	private static Logger logger1 = Logger.getLogger(ProductActivityServiceImpl.class);
	
	@Autowired
	public ProductActivityMapper productActivityMapper;
	
    //根据产品查询产品活动配置信息
    public ProductActivity getProductActivity(Integer productId){
    	logger1.info("查询产品活动表 _product_activity _product_id ="+productId);
		if(null == productId){
			return null;
		}
		ProductActivityExample pae = new ProductActivityExample();
		com.sigmatrix.sc.entity.v1.ProductActivityExample.Criteria pceCia = pae.createCriteria();
		pceCia.andProductIdEqualTo(productId);
		List<ProductActivity> paLists = null;
		paLists = productActivityMapper.selectByExample(pae);
		logger1.info("查询产品活动表返回 _product_activity "+JSONObject.toJSONString(paLists));
		if (!CollectionUtils.isEmpty(paLists) && null != paLists.get(0)){
			return paLists.get(0);
		}
		return null;
    }

}
