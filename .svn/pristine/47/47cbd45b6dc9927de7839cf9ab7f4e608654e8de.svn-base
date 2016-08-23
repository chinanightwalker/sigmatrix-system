package com.sigmatrix.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.BarcodePrizeConsumerMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.CustomerCurrentsLogMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.CustomerInfoMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.UnactivePrizeInfoMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.UserPrizeTotalMapper;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.BarcodePrizeConsumer;
import com.sigmatrix.sc.entity.v1.BarcodePrizeConsumerExample;
import com.sigmatrix.sc.entity.v1.CustomerCurrentsLog;
import com.sigmatrix.sc.entity.v1.CustomerInfo;
import com.sigmatrix.sc.entity.v1.UnactivePrizeInfo;
import com.sigmatrix.sc.entity.v1.UserPrizeTotal;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.BarcodePrizeConsumerService;
import com.sigmatrix.sc.utils.DateUtil;

//消费者兑换记录表
@Service
public class BarcodePrizeConsumerServiceImpl implements BarcodePrizeConsumerService {
	
	private static Logger logger1 = Logger.getLogger(BarcodePrizeConsumerServiceImpl.class);
	
	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private BarcodePrizeConsumerMapper barcodePrizeConsumerMapper;
	@Autowired
	private UnactivePrizeInfoMapper unactivePrizeInfoMapper;
	@Autowired
	private CustomerInfoMapper customerInfoMapper;
	@Autowired
	private CustomerCurrentsLogMapper customerCurrentsLogMapper;
	@Autowired
	private UserPrizeTotalMapper userPrizeTotalMapper;
	@Autowired
	private UnactivePrizeInfoMapper activeMapper;
    //根据一级码查询消费者兑换记录表
    public BarcodePrizeConsumer getBPCByACode(String aCode,String tablePrefix) throws Exception{
    	logger1.info("查询消费者兑换记录表  aCode ="+aCode);
    	if(null == aCode){
    		return null;
    	}
    	List<BarcodePrizeConsumer> list =  null;
    	BarcodePrizeConsumerExample example = new BarcodePrizeConsumerExample();
    	example.setTablePrefix(tablePrefix);
		com.sigmatrix.sc.entity.v1.BarcodePrizeConsumerExample.Criteria cia = example.createCriteria();
		cia.andBarcodeEqualTo(aCode);//一级码表
		list = barcodePrizeConsumerMapper.selectByExample(example);
		logger1.info("查询消费者兑换记录表返回 "+JSONObject.toJSONString(list)+aCode);
		if (!CollectionUtils.isEmpty(list) && null != list.get(0)) {//已经抽过将
			return list.get(0);
		}
		return null;
    }
	
    //插入消费者兑换表
    public void saveBPCInfo(BarcodePrizeConsumer bpc) throws Exception{
		logger1.info("插入消费者兑换记录表 BarcodePrizeConsumer："+JSONObject.toJSONString(bpc));
		int flag = barcodePrizeConsumerMapper.insert(bpc);
		if(1 != flag){
			logger1.error("插入消费者兑换记录表失败 flag="+flag);
			throw new RuntimeException("save _barcode_prize_consumer fail");
		}
    }

    /**
     * 根据订单号查询消费者兑换记录表
     */
	public BarcodePrizeConsumer getBarcodePrizeConsumerById(String orderId,String tablePrefix) {
		BarcodePrizeConsumer c = null;
		try {
			c = barcodePrizeConsumerMapper.selectByPrimaryKey(orderId,tablePrefix);
			logger1.info("查到兑换记录:"+JSONObject.toJSONString(c));
			return c;
		} catch (Exception e) {
			logger1.error("查询兑换记录"+e.getMessage());
			return null;
		}
	}

	 /**
     * 小于1元更新兑换记录
     * @param info, consumer
     */
	public boolean updateBarcodePrizeConsumerByLess1(CustomerInfo info, BarcodePrizeConsumer consumer) {

		logger1.info("getIsActive====="+consumer.getIsActive());
		if(consumer.getIsActive() == null || consumer.getIsActive()==0){
			UnactivePrizeInfo activeInfo = new UnactivePrizeInfo();
			activeInfo.setBarcode(consumer.getBarcode());
			activeInfo.setUserId(String.valueOf(info.getCustomerId()));
			activeInfo.setOpenId(info.getOpenId());
			activeInfo.setPrizeId(consumer.getPrizeId());
			activeInfo.setPrizeName(consumer.getPrizeName());
			activeInfo.setActivityId(consumer.getActivityId());
			activeInfo.setPrizeAmount(consumer.getPrizeAmount());
			activeInfo.setCreateTime(new Date());
			logger1.info(unactivePrizeInfoMapper.insertSelective(activeInfo)>0?"插入未激活产品中奖表成功":"插入未激活产品中奖表失败");;
		}
					logger1.info("客户总账");
					logger1.info("info.getCustomerId()"+info.getCustomerId());
					UserPrizeTotal upt= userPrizeTotalMapper.selectByPrimaryKey(info.getCustomerId(),info.getTablePrefix());
					if(upt==null){
						logger1.error("客户总账为空");
						return false;
					}
					logger1.info("fs"+upt);
					upt.setChangeCount(upt.getChangeCount()+1);
					upt.setChangeAmount(upt.getChangeAmount()+consumer.getPrizeAmount());
					upt.setUpdateTime(new Date());
					
					//更新兑换记录
					consumer.setOpenId(info.getOpenId());
					consumer.setUserId(String.valueOf(info.getCustomerId()));
					consumer.setIsStatus(1);
					consumer.setAcceptTime(new Date());
					consumer.setUpdateTime(new Date());
					int flag;
					int f;
					logger1.info("总账S");
					try {
						f = userPrizeTotalMapper.updateByPrimaryKeySelective(upt);
						flag = barcodePrizeConsumerMapper.updateByPrimaryKeySelective(consumer);
						logger1.info("13123123123123flag=/...."+flag+"f=13213"+f);
					} catch (Exception e) {
						e.printStackTrace();
						logger1.error("小于1元绑定用户更新兑换记录表"+e.getMessage());
						return false;
					}
					logger1.info("flag=/...."+flag+"f=13213"+f);
					if (1 == flag&&f==1) {
						return true;
					} else {
						return false;
					}
				
		
	
	}

	/**
	 * 再次支付红包支付成功更新兑换记录
	 * @param consumer
	 * @return
	 */
	public boolean repaybarcodesuccess(Integer userid ,BarcodePrizeConsumer consumer ,boolean repayFlag) {
		//兑换记录
		consumer.setIsStatus(2);
		consumer.setGetTime(new Date());
		consumer.setUpdateTime(new Date());
		int flag;
		int f;
		try {
			flag = barcodePrizeConsumerMapper.updateByPrimaryKeySelective(consumer);
			//客户总账表
			UserPrizeTotal upt= userPrizeTotalMapper.selectByPrimaryKey(userid,consumer.getTablePrefix());
			if(upt==null){
				logger1.error("客户总账为空");
				return false;
			}
			if(!repayFlag){
				upt.setRedbagCount(upt.getRedbagCount()+1);
				upt.setRedbagAmount(upt.getRedbagAmount()+consumer.getPrizeAmount());
			}
			upt.setRedbagSuccessCount(upt.getRedbagSuccessCount()+1);
			upt.setRedbagSuccessAmount(upt.getRedbagSuccessAmount()+consumer.getPrizeAmount());
			upt.setUpdateTime(new Date());
			f=userPrizeTotalMapper.updateByPrimaryKeySelective(upt);
		} catch (Exception e) {
			e.printStackTrace();
			logger1.error("再次支付成功之后更新兑换记录表"+e.getMessage());
			return false;
		}
		if (1 == flag&&f==1) {
			return true;
		}
		return false;
	}
	/***
	 * 再次支付红包支付失败更新兑换记录
	 * @param consumer
	 * @return
	 */
	public boolean repaybarcodefalse(BarcodePrizeConsumer consumer,boolean repayFlag) {
		
		consumer.setIsStatus(4);
		consumer.setGetTime(new Date());
		consumer.setUpdateTime(new Date());
		int flag;
		try {
			flag = barcodePrizeConsumerMapper.updateByPrimaryKeySelective(consumer);
			if(!repayFlag){
				UserPrizeTotal upt= userPrizeTotalMapper.selectByPrimaryKey(Integer.parseInt(consumer.getUserId()),consumer.getTablePrefix());
				upt.setRedbagCount(upt.getRedbagCount()+1);
				upt.setRedbagAmount(upt.getRedbagAmount()+consumer.getPrizeAmount());
				upt.setUpdateTime(new Date());
				userPrizeTotalMapper.updateByPrimaryKeySelective(upt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger1.error("再次支付失败之后更新兑换记录表"+e.getMessage());
			return false;
		}
		if (1 == flag) {
			return true;
		}
		return false;
	}

	/**
	 *  积分更新兑换记录
	 * @param consumer
	 * @param decrypt
	 * @return
	 */
	public int updatecheck(BarcodePrizeConsumer consumer, CustomerInfo info) {
		
		Integer prizeType;// 4 积分
		if (consumer == null) {
			logger1.error("查不到兑换记录");
			return 0;
		}
		prizeType = consumer.getPrizeType();
		Activity activity = activityMapper.selectByPrimaryKey(consumer.getActivityId(),consumer.getTablePrefix());
		if (activity == null) {
			logger1.error("查不到活动");
			return 0;
		}
		logger1.info("prizeType:"+prizeType);
		if (prizeType == 4) {
			if(consumer.getIsActive() == null || consumer.getIsActive()==0){
				UnactivePrizeInfo activeInfo = new UnactivePrizeInfo();
				activeInfo.setBarcode(consumer.getBarcode());
				activeInfo.setUserId(consumer.getUserId());
				activeInfo.setOpenId(consumer.getOpenId());
				activeInfo.setPrizeId(consumer.getPrizeId());
				activeInfo.setPrizeName(consumer.getPrizeName());
				activeInfo.setActivityId(consumer.getActivityId());
				activeInfo.setPrizeAmount(consumer.getPrizeAmount());
				activeInfo.setCreateTime(new Date());
				logger1.info(activeMapper.insertSelective(activeInfo)>0?"插入未激活产品中奖表成功":"插入未激活产品中奖表失败");
			}
				int flag;
				try {
					consumer.setUserPhone(info.getPhone());
					consumer.setOpenId(info.getOpenId());
					consumer.setUserId(String.valueOf(info.getCustomerId()));
					consumer.setIsStatus(2);
					consumer.setAcceptTime(new Date());
					consumer.setUpdateTime(new Date());
					flag = barcodePrizeConsumerMapper.updateByPrimaryKeySelective(consumer);
				} catch (Exception e) {
					e.printStackTrace();
					logger1.error("兑换记录表："+e.getMessage());
					return 0;
				}
				int f1;
				try {
					CustomerCurrentsLog log = new CustomerCurrentsLog();
					log.setCustomerId(String.valueOf(info.getCustomerId()));
					log.setCreateTime(new Date());
					log.setCurrentnum(consumer.getPrizeIntegration());
					log.setIntegralType(3);
					 f1= customerCurrentsLogMapper.insert(log);
				} catch (Exception e) {
					e.printStackTrace();
					logger1.error("积分日志表："+e.getMessage());
					return 0;
				}
				
				if (1 == flag&&1 == f1) {
					UserPrizeTotal upt= userPrizeTotalMapper.selectByPrimaryKey(info.getCustomerId(),info.getTablePrefix());
					if(upt==null){
						logger1.error("客户总账为空");
						return 0;
					}
					upt.setIntegralCount(upt.getIntegralCount()+1);
					upt.setIntegralAmount(upt.getIntegralAmount()+consumer.getPrizeIntegration());
					upt.setUpdateTime(new Date());
					logger1.info("普通红包统计金额"+consumer.getPrizeAmount()+"barcode="+consumer.getBarcode()+"+++orderid="+consumer.getPrizeOrderId());

					info.setCurrents(info.getCurrents()+consumer.getPrizeIntegration());
					int a = customerInfoMapper.updateByPrimaryKeySelective(info);
					int f = userPrizeTotalMapper.updateByPrimaryKeySelective(upt);
					logger1.info("用户增加积分成功或失败      1  成功   0 失败::::"+a);
					if(a==1&&f==1){
						return 4;
					}else{
						return 0;
					}
					
				}
				return 0;
			}
		logger1.error("奖项不是积分");
		return 0;
	}

	@Override
	public boolean UpdatebarcodePrizeConsumerDefault(BarcodePrizeConsumer bpc, CustomerInfo info) {
	logger1.info("--------更新消费者兑换记录表-----------");
		bpc.setUserPhone(info.getPhone());
		bpc.setUserId(String.valueOf(info.getCustomerId()));
		bpc.setOpenId(info.getOpenId());
		bpc.setIsStatus(1);
		bpc.setAcceptTime(new Date());
		bpc.setGetTime(new Date());
		int	flag = barcodePrizeConsumerMapper.updateByPrimaryKeySelective(bpc);
		logger1.info("更新数据返回结果："+flag);
		if(1 == flag){
			return true;
		}
		return false;
	}

	@Override
	public PageBean<BarcodePrizeConsumer> getPageBarcodePrizeConsumerByExample(
			PageBean<BarcodePrizeConsumer> page, BarcodePrizeConsumer example,Map<String, String[]> map) throws Exception{
		List<BarcodePrizeConsumer> barcodePrizeConsumerList = new ArrayList<BarcodePrizeConsumer>();
		BarcodePrizeConsumerExample bpce = new BarcodePrizeConsumerExample();
		bpce.setTablePrefix(example.getTablePrefix());
		BarcodePrizeConsumerExample.Criteria criteria = bpce.createCriteria();
		bpce.setOrderByClause("_create_time DESC");
		if(example.getActivityId()!=null){
			criteria.andActivityIdEqualTo(example.getActivityId());
		}
		if(org.apache.commons.lang.StringUtils.isNotBlank(example.getUserId())){
			criteria.andUserIdEqualTo(example.getUserId());
		}
		if(example.getPrizeType()!=null){
			criteria.andPrizeTypeEqualTo(example.getPrizeType());
		}
		if(example.getIsType()!=null){
			criteria.andIsTypeEqualTo(example.getIsType());
		}
		if(example.getIsStatus()!=null){
			criteria.andIsStatusEqualTo(example.getIsStatus());
		}		
		Date startDate = null;
		Date endDate = null;
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key == "startDate" || key.equals("startDate")) {
				if (!map.get("startDate")[0].equals("")
						&& map.get("startDate")[0] != null) {
//					System.out.println("startDate=="+map.get(key)[0]);
					startDate = DateUtil.getDate(map.get(key)[0]+" 00:00:00");
					
				}
			}
			if(key == "endDate" || key.equals("endDate")){
				if(!map.get("endDate")[0].equals("") && map.get("endDate")[0] !=null){
//					System.out.println("endDate=="+map.get(key)[0]);
					endDate = DateUtil.getDate(map.get(key)[0]+" 23:59:59");
				}				
			}			
		}
		if(startDate!=null && endDate!=null){
			criteria.andUpdateTimeBetween(startDate, endDate);
		}else if(startDate!=null && endDate==null){
			endDate = new Date();
			criteria.andUpdateTimeBetween(startDate, endDate);
		}else if(startDate==null && endDate!=null){
			criteria.andUpdateTimeLessThan(endDate);
		}
		try {
			PageHelper.startPage(page.getPageNo(), page.getPageSize());
			return PageBeanUtil.toPagedResult(barcodePrizeConsumerMapper
					.selectByExample(bpce));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<BarcodePrizeConsumer> getAllPageBarcodePrizeConsumerByExample(
			PageBean<BarcodePrizeConsumer> page, BarcodePrizeConsumer example,
			Map<String, String[]> map) throws Exception {
		List<BarcodePrizeConsumer> barcodePrizeConsumerList = new ArrayList<BarcodePrizeConsumer>();
		BarcodePrizeConsumerExample bpce = new BarcodePrizeConsumerExample();
		bpce.setTablePrefix(example.getTablePrefix());
		BarcodePrizeConsumerExample.Criteria criteria = bpce.createCriteria();
		if(example.getActivityId()!=null){
			criteria.andActivityIdEqualTo(example.getActivityId());
		}
		if(org.apache.commons.lang.StringUtils.isNotBlank(example.getUserId())){
			criteria.andUserIdEqualTo(example.getUserId());
		}
		if(example.getPrizeType()!=null){
			criteria.andPrizeTypeEqualTo(example.getPrizeType());
		}
		if(example.getIsType()!=null){
			criteria.andIsTypeEqualTo(example.getIsType());
		}
		if(example.getIsStatus()!=null){
			criteria.andIsStatusEqualTo(example.getIsStatus());
		}
		Date startDate = null;
		Date endDate = null;
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key == "startDate" || key.equals("startDate")) {
				if (!map.get("startDate")[0].equals("")
						&& map.get("startDate")[0] != null) {
//					System.out.println("startDate=="+map.get(key)[0]);
					startDate = DateUtil.getDate(map.get(key)[0]+" 00:00:00");
					
				}
			}
			if(key == "endDate" || key.equals("endDate")){
				if(!map.get("endDate")[0].equals("") && map.get("endDate")[0] !=null){
//					System.out.println("endDate=="+map.get(key)[0]);
					endDate = DateUtil.getDate(map.get(key)[0]+" 23:59:59");
				}				
			}			
		}
		if(startDate!=null && endDate!=null){
			criteria.andUpdateTimeBetween(startDate, endDate);
		}
		try {
			//PageHelper.startPage(page.getPageNo(), page.getPageSize());
			return PageBeanUtil.toPagedResult(barcodePrizeConsumerMapper
					.selectByExample(bpce));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BarcodePrizeConsumer> getPageBarcodePrizeConsumerListByExample(
			BarcodePrizeConsumer barcodePrizeConsumer,
			Map<String, String[]> map) throws Exception {
		// TODO Auto-generated method stub
		List<BarcodePrizeConsumer> barcodePrizeConsumerList = new ArrayList<BarcodePrizeConsumer>();
		BarcodePrizeConsumerExample bpce = new BarcodePrizeConsumerExample();
		bpce.setTablePrefix(barcodePrizeConsumer.getTablePrefix());
		BarcodePrizeConsumerExample.Criteria criteria = bpce.createCriteria();
		bpce.setOrderByClause("_create_time DESC");
		if(barcodePrizeConsumer.getActivityId()!=null){
			criteria.andActivityIdEqualTo(barcodePrizeConsumer.getActivityId());
		}
		if(org.apache.commons.lang.StringUtils.isNotBlank(barcodePrizeConsumer.getUserId())){
			criteria.andUserIdEqualTo(barcodePrizeConsumer.getUserId());
		}
		if(barcodePrizeConsumer.getPrizeType()!=null){
			criteria.andPrizeTypeEqualTo(barcodePrizeConsumer.getPrizeType());
		}
		if(barcodePrizeConsumer.getIsType()!=null){
			criteria.andIsTypeEqualTo(barcodePrizeConsumer.getIsType());
		}
		if(barcodePrizeConsumer.getIsStatus()!=null){
			criteria.andIsStatusEqualTo(barcodePrizeConsumer.getIsStatus());
		}		
		Date startDate = null;
		Date endDate = null;
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key == "startDate" || key.equals("startDate")) {
				if (!map.get("startDate")[0].equals("")
						&& map.get("startDate")[0] != null) {
//					System.out.println("startDate=="+map.get(key)[0]);
					startDate = DateUtil.getDate(map.get(key)[0]+" 00:00:00");
					
				}
			}
			if(key == "endDate" || key.equals("endDate")){
				if(!map.get("endDate")[0].equals("") && map.get("endDate")[0] !=null){
//					System.out.println("endDate=="+map.get(key)[0]);
					endDate = DateUtil.getDate(map.get(key)[0]+" 23:59:59");
				}				
			}			
		}
		if(startDate!=null && endDate!=null){
			criteria.andUpdateTimeBetween(startDate, endDate);
		}else if(startDate!=null && endDate==null){
			endDate = new Date();
			criteria.andUpdateTimeBetween(startDate, endDate);
		}else if(startDate==null && endDate!=null){
			criteria.andUpdateTimeLessThan(endDate);
		}
		try {
			
			return barcodePrizeConsumerMapper.selectByExample(bpce);
		} catch (Exception e) {
			// TODO: handle exception
			logger1.error("导出excel查询",e);
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}
