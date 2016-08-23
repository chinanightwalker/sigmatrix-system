package com.sigmatrix.sc.service;


import java.util.List;
import java.util.Map;

import com.sigmatrix.sc.entity.v1.BarcodePrizeConsumer;
import com.sigmatrix.sc.entity.v1.CustomerInfo;
import com.sigmatrix.sc.page.PageBean;

//消费者兑换记录表
public interface BarcodePrizeConsumerService {
	
	//根据一级码查询消费者兑换记录表
    public BarcodePrizeConsumer getBPCByACode(String aCode,String tablePrefix) throws Exception;
	
    //插入消费者兑换表
    public void saveBPCInfo(BarcodePrizeConsumer bpc) throws Exception;
    
    /**
     * 根据订单号查询消费者兑换记录表
     * @param orderId
     * @return
     */
    public BarcodePrizeConsumer getBarcodePrizeConsumerById(String orderId,String tablePrefix);
    
    /**
     * 小于1元更新兑换记录
     * @param info, consumer
     */
    public boolean updateBarcodePrizeConsumerByLess1(CustomerInfo info, BarcodePrizeConsumer consumer);
    
	/**
	 * 支付红包支付成功更新兑换记录
	 * @param consumer
	 * @return
	 */
	public boolean repaybarcodesuccess(Integer userid,BarcodePrizeConsumer consumer,boolean repayFlag);
	
	/***
	 * 支付红包支付失败更新兑换记录
	 * @param consumer
	 * @return
	 */
	public boolean repaybarcodefalse(BarcodePrizeConsumer consumer,boolean repayFlag);
	
	/**
	 *  积分更新兑换记录
	 * @param consumer
	 * @param decrypt
	 * @return
	 */
	public int updatecheck(BarcodePrizeConsumer consumer, CustomerInfo info);
	/**、
	 * 讲兑换记录和用户绑定上
	 * @param consumer
	 * @param info
	 * @return
	 */
	public boolean UpdatebarcodePrizeConsumerDefault(BarcodePrizeConsumer consumer, CustomerInfo info);
	
	/*
	 * 分页查询中奖信息记录表
	 */
	public PageBean<BarcodePrizeConsumer> getPageBarcodePrizeConsumerByExample(PageBean<BarcodePrizeConsumer> page,BarcodePrizeConsumer example,Map<String, String[]> map) throws Exception;
	/*
	 * 查询全部中奖信息记录
	 */
	public PageBean<BarcodePrizeConsumer> getAllPageBarcodePrizeConsumerByExample(PageBean<BarcodePrizeConsumer> page,BarcodePrizeConsumer example,Map<String, String[]> map) throws Exception;

	public List<BarcodePrizeConsumer> getPageBarcodePrizeConsumerListByExample(
			BarcodePrizeConsumer barcodePrizeConsumer,
			Map<String, String[]> searchCondit) throws Exception;
}
