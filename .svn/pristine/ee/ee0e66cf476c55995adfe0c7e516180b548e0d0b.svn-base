package com.sigmatrix.sc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmatrix.sc.dao.mapper.v1.auto.ChangeOrderMapper;
import com.sigmatrix.sc.entity.v1.ChangeOrder;
import com.sigmatrix.sc.entity.v1.ChangeOrderExample;
import com.sigmatrix.sc.service.ChangeOrderService;

@Service
public class ChangeOrderServiceImpl implements ChangeOrderService {

	private static Logger logger1 = Logger.getLogger(ChangeOrderServiceImpl.class);
	@Autowired
	private ChangeOrderMapper mapper;

	/**
	 * @Method: getCustActChangeOrder
	 * @Description: 根据客户id活动id查询 零钱订单 获取客户活动零钱订单
	 * @param custId
	 * @param activityId
	 * @return
	 * @return List<ChangeOrder>
	 * @author zzw
	 * @date 2016年7月14日 上午11:15:01
	 */
	public List<ChangeOrder> getCustActChangeOrder(Integer custId,Integer activityId){
		logger1.info("查询零钱订单表 _change_order,custId="+custId+" activityId="+activityId);
		ChangeOrderExample changeOrderExample = new ChangeOrderExample();
		com.sigmatrix.sc.entity.v1.ChangeOrderExample.Criteria 
		changeOrderExampleCia = changeOrderExample.createCriteria();
		changeOrderExampleCia.andUserIdEqualTo(custId);//客户ID
		changeOrderExampleCia.andActivityIdEqualTo(activityId);//活动Id
		return mapper.selectByExample(changeOrderExample);
	}
}
