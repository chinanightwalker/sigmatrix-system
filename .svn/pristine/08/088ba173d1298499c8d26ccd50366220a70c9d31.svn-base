package com.sigmatrix.sc.service;

import com.sigmatrix.sc.entity.v1.CustomerInfo;

public interface CustomerInfoService {
	
	/**
	 * @Method: getCustomerInfoByOpenId
	 * @Description: 根据openID 获取客户信息
	 * @param openID
	 * @return CustomerInfo
	 * @author zzw
	 * @date 2016年7月14日 上午11:09:09
	 */
	public CustomerInfo getCustomerInfoByOpenId(String openID,String tablePrefix);
	/**
	 * @Method: getCustomerInfoByOpenId
	 * @Description: 根据客户id 获取客户信息
	 * @param openID
	 * @return CustomerInfo
	 * @author zzw
	 * @date 2016年7月14日 上午11:09:09
	 */
	public CustomerInfo getCustomerInfoById(Integer customerId,String tablePrefix)throws Exception;
	//查询保存客户信息 openId
	public void insertUser(String openId,String tablePrefix);
	//根据用户openId修改用户的支付openId
	public boolean updatePayopenId(String openId,String payOpenId,String tablePrefix);
	//更新用户激活状态
	public boolean updateStatus(String openId,int status,String tablePrefix);
	//直接保存客户信息openid 不查询 
	public void saveCustInfo(String openId,String tablePrefix);
	//根据openId更新消费者表活动Id
	public void updateActivityId(String openId,Integer actId,String tablePrefix);
	//直接保存客户信息openid 不查询 
	public void saveCustInfo(String openId,Integer custType,String tablePrefix);
	//查询并保存客户信息
	public void queryAndSaveCustInfo(String openId,Integer custType,String tablePrefix);
	//更新输入码输入错误次数和时间
	public void updateInputErrNumAdd(String openId,String tablePrefix);
	//更新输入码输入错误次数清零
	public void updateInputErrNumClear(String openId,String tablePrefix);
	//根据openId更新消费者表创建方式
	public void updateCustomerType(String openId,Integer type,String tablePrefix);
	
	
}