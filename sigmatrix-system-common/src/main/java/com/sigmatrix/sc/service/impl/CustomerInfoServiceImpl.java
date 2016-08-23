package com.sigmatrix.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.dao.mapper.v1.auto.CustomerInfoMapper;
import com.sigmatrix.sc.entity.v1.CustomerInfo;
import com.sigmatrix.sc.entity.v1.CustomerInfoExample;
import com.sigmatrix.sc.entity.v1.CustomerInfoExample.Criteria;
import com.sigmatrix.sc.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
	
	private static Logger logger1 = Logger.getLogger(CustomerInfoServiceImpl.class);
	@Autowired
	private CustomerInfoMapper customerInfoMapper;
	
	/**
	 * @Method: getCustomerInfoByOpenId
	 * @Description: 根据openID 获取客户信息
	 * @param openID
	 * @return CustomerInfo
	 * @author zzw
	 * @date 2016年7月14日 上午11:09:09
	 */
	public CustomerInfo getCustomerInfoByOpenId(String openID,String tablePrefix) {
		CustomerInfoExample example = new CustomerInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openID);
		logger1.info("查询消费者表 _customer_info,openId="+openID);
		List<CustomerInfo>	list = customerInfoMapper.selectByExample(example);
		logger1.info("查询消费者表返回 _customer_info ,cutInfoLists="+JSONObject.toJSONString(list));
		if(list != null && list.size()>0){
			return list.get(0);
		}
		logger1.info("客户信息不存在");
		return null;
	}
	

	public CustomerInfo getCustomerInfoById(Integer customerId,String tablePrefix) throws Exception {
		return customerInfoMapper.selectByPrimaryKey(customerId,tablePrefix);
	}

	public void insertUser(String openId,String tablePrefix) {
		logger1.info("插入消费者表");
		CustomerInfoExample example = new CustomerInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		logger1.info("查询消费者表 _customer_info,openId="+openId);
		List<CustomerInfo> list = customerInfoMapper.selectByExample(example);
		logger1.info("查询消费者表返回 _customer_info ,cutInfoLists="+JSONObject.toJSONString(list));
		if (list == null || list.size() == 0) { // 消费者不存在插入数据
			this.saveCustInfo(openId,tablePrefix);
		}
	}
	
	public void saveCustInfo(String openId,String tablePrefix){
		CustomerInfo c = new CustomerInfo();
		c.setOpenId(openId);
		c.setCreateTime(new Date());
		c.setUpdateTime(new Date());
		c.setStatus(0);
		c.setCurrents(0);
		logger1.info("保存消费者信息 "+JSONObject.toJSONString(c));
		int flag = customerInfoMapper.insertSelective(c);
		logger1.info("保存消费者信息 成功失败标识 flag="+flag);
	}




	@Override
	public boolean updatePayopenId(String openId, String payOpenId,String tablePrefix) {
		CustomerInfoExample example = new CustomerInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		CustomerInfo c = new CustomerInfo();
		c.setPayOpenId(payOpenId);
		return customerInfoMapper.updateByExampleSelective(c, example)>0;
	}


	@Override
	public boolean updateStatus(String openId, int status,String tablePrefix) {
		CustomerInfoExample example = new CustomerInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		CustomerInfo c = new CustomerInfo();
		c.setStatus(status);
		return customerInfoMapper.updateByExampleSelective(c, example)>0;
	}
	

	
	public void updateActivityId(String openId,Integer actId,String tablePrefix){
		logger1.info("更新消费者表 创建用户时参与活动  openId="+openId +" actId="+actId);
		CustomerInfoExample example = new CustomerInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		CustomerInfo c = new CustomerInfo();
		c.setActivityId(actId);
		int b = customerInfoMapper.updateByExampleSelective(c, example);
		logger1.info("更新消费者 创建用户时参与活动 表成功失败标识 b="+b);
	}
	
	public void updateCustomerType(String openId,Integer type,String tablePrefix){
		logger1.info("更新消费者表 创建用户方式 openId="+openId +" type="+type);
		CustomerInfoExample example = new CustomerInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		CustomerInfo c = new CustomerInfo();
		c.setType(type);
		int b = customerInfoMapper.updateByExampleSelective(c, example);
		logger1.info("更新消费者表 创建用户方式 成功失败标识 b="+b);
	}
	
	//查询并保存客户信息
	public void queryAndSaveCustInfo(String openId,Integer custType,String tablePrefix){
		//查询客户信息
		CustomerInfo custInfo = this.getCustomerInfoByOpenId(openId,tablePrefix);
		if(null == custInfo){
			this.saveCustInfo(openId, custType,tablePrefix);//保存客户信息
		}
	}
		
	//创建用户
	public void saveCustInfo(String openId,Integer custType,String tablePrefix){
		CustomerInfo c = new CustomerInfo();
		c.setOpenId(openId);
		c.setType(custType);//客户类型 1 扫码用户 2 一元换购用户
		c.setStatus(0);//0是未注册，1 已注册
		c.setCurrents(0);//当前用户积分
		c.setInputErrNum(0);
		Date date = new Date();
		c.setCreateTime(date);
		c.setUpdateTime(date);
		logger1.info("保存消费者信息 "+JSONObject.toJSONString(c));
		int flag = customerInfoMapper.insertSelective(c);
		logger1.info("保存消费者信息 成功失败标识 flag="+flag);
	}
	
	//更新输入码输入错误次数和时间
	public void updateInputErrNumAdd(String openId,String tablePrefix){
		logger1.info("更新消费者表 输入码输入错误次数和时间  openId="+openId);
		CustomerInfo c = this.getCustomerInfoByOpenId(openId,tablePrefix);
		CustomerInfo custInfo = new CustomerInfo();
		custInfo.setCustomerId(c.getCustomerId());
		custInfo.setInputErrNum(null != c.getInputErrNum()?c.getInputErrNum().intValue()+1:1);
		int b = customerInfoMapper.updateByPrimaryKeySelective(custInfo);
		logger1.info("更新消费者表 输入码输入错误次数和时间 成功失败标识 b="+b);
	}
	
	//更新输入码输入错误次数清零
	public void updateInputErrNumClear(String openId,String tablePrefix){
		logger1.info("更新输入码输入错误次数清零  openId="+openId);
		CustomerInfo c = this.getCustomerInfoByOpenId(openId,tablePrefix);
		if(null != c.getInputErrNum() && c.getInputErrNum()>0){
			CustomerInfo custInfo = new CustomerInfo();
			custInfo.setCustomerId(c.getCustomerId());
			custInfo.setInputErrNum(0);
			int b = customerInfoMapper.updateByPrimaryKeySelective(custInfo);
			logger1.info("更新输入码输入错误次数清零 b="+b);
		}else{
			logger1.info("用户输入错误次数为0");
		}
		
	}
	
	
	

}
