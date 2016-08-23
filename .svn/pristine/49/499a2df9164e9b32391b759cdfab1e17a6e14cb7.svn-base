package com.sigmatrix.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.github.pagehelper.StringUtil;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityPrize;
import com.sigmatrix.sc.entity.v1.BarcodeALevel;
import com.sigmatrix.sc.entity.v1.BarcodeBLevel;
import com.sigmatrix.sc.entity.v1.BarcodeBLevelFl;
import com.sigmatrix.sc.entity.v1.ChangeOrder;
import com.sigmatrix.sc.entity.v1.CustomerInfo;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.service.ChangeOrderService;
import com.sigmatrix.sc.service.CustomerInfoService;
import com.sigmatrix.sc.service.LotteryPrizeCommonService;
import com.sigmatrix.sc.svcEntity.res.LotteryPrizeSvcRes;
import com.sigmatrix.sc.utils.DateUtil;
import com.sigmatrix.sc.utils.PrizeUtils;

//抽奖公共service
@Service
public class LotteryPrizeCommonServiceImpl implements LotteryPrizeCommonService {
	
	private static Logger logger1 = Logger.getLogger(LotteryPrizeCommonServiceImpl.class);
	private String tablePrefix;
    @Autowired
    private CustomerInfoService customerInfoService;
    @Autowired
    private ChangeOrderService changeOrderService;
    
    /**
     * @Method: isBCodeDateOut
     * @Description: 二级箱码是否过期判断
     * @param barcodeBLevel
     * @param shelfLife
     * @return Integer
     * @author zzw
     * @date 2016年6月28日 下午6:08:00
     */
    public Integer isBCodeDateOut(BarcodeBLevel barcodeBLevel,Integer shelfLife){
    	float dateOut = null != shelfLife?(float)shelfLife.intValue():(float)WebConstants.FL_TIME_OUT_DATE.intValue();
    	logger1.info("二级码是否过期 0过期 1没有过期   产品过期有效期="+dateOut);
    	logger1.info("过期：出库时间  + 产品过期有效期  < 当前时间 ");
		if(null != barcodeBLevel && null != barcodeBLevel.getOutTime()){
			Date outTime = barcodeBLevel.getOutTime();
			Date nowDate = new Date();
			logger1.info("出库时间="+DateUtil.formatDateToStr(outTime, DateUtil.YMDHMS)
			+" 当前时间="+DateUtil.formatDateToStr(nowDate, DateUtil.YMDHMS)
			+ " 过期时间="+DateUtil.formatDateToStr(DateUtil.addDate(outTime, shelfLife), DateUtil.YMDHMS));
			float numDate = DateUtil.getDayTimes2(outTime,nowDate);
			logger1.info("如果 numDate < dateOut 没有过期 当前时间-激活时间 numDate="+numDate);
			if(numDate < dateOut){//没有过期
				logger1.info("二级码没有过期直接返回");
				return WebConstants.B_CODE_DATE_OUT_NO;
			}else{
			}
		}else{
			logger1.info("二级箱码不存在 || 出库时间为空");
		}
		logger1.info("默认过期");
		return WebConstants.B_CODE_DATE_OUT_YES;
    }
    
    /**
     * @Method: isFLCodeDateOut
     * @Description: 辅料箱码是否过期
     * @param barcodeBlevelFl
     * @param shelfLife
     * @return Integer
     * @author zzw
     * @date 2016年6月28日 下午6:18:01
     */
    public Integer isFLCodeDateOut(BarcodeBLevelFl barcodeBlevelFl,Integer shelfLife) {
    	float dateOut = null != shelfLife?(float)shelfLife.intValue():(float)WebConstants.FL_TIME_OUT_DATE.intValue();
    	logger1.info("辅料箱码是否过期 0过期 1没有过期   产品过期有效期="+dateOut);
    	logger1.info("过期：激活时间  + 产品过期有效期  < 当前时间 ");
    	if(null != barcodeBlevelFl && null != barcodeBlevelFl.getActiviteTime()){
    		Date actTime = barcodeBlevelFl.getActiviteTime();//激活时间
			Date nowDate = new Date();
			logger1.info("激活时间="+DateUtil.formatDateToStr(actTime, DateUtil.YMDHMS)
			+" 当前时间="+DateUtil.formatDateToStr(nowDate, DateUtil.YMDHMS)
			+" 过期时间="+DateUtil.formatDateToStr(DateUtil.addDate(actTime, shelfLife), DateUtil.YMDHMS));
			float numDate = DateUtil.getDayTimes2(actTime,nowDate);
			logger1.info("如果 numDate < dateOut 没有过期 当前时间-激活时间 numDate="+numDate);
			if(numDate < dateOut){//没有过期
				logger1.info("辅料箱码没有过期直接返回");
				return WebConstants.FL_CODE_DATE_OUT_NO;
			}else{
			}
		}else{
			logger1.info("辅料箱码不存在 || 激活时间为空");
		}
    	logger1.info("默认过期");
		return WebConstants.FL_CODE_DATE_OUT_YES;
    }
    
   

    /**
     * @Method: getACodeAcvtivityStatus
     * @Description: 一级码是否激活判断
     * @param barcodeALevel 一级码
     * @param barcodeBLevel 二级码
     * @param barcodeBlevelFl 辅料码
     * @param lpRes 响应信息
     * @param projectFlag  项目标识
     * @return 一级码激活状态  1激活  2未激活
     * @throws Exception
     * @author zzw
     * @date 2016年6月28日 下午2:19:35
     */
    public Integer getACodeAcvtivityStatus(BarcodeALevel barcodeALevel,BarcodeBLevel barcodeBLevel,BarcodeBLevelFl barcodeBlevelFl,
    		LotteryPrizeSvcRes lpRes,String projectFlag) {
    	logger1.info("一级码状态判断 1已激活 2未激活 ");
    	//一级码处理
    	logger1.info("一级单品码是否激活判断="+barcodeALevel.getActivateStatus());
		if(WebConstants.A_CODE_ACTIVATE_YES.equals(barcodeALevel.getActivateStatus())){
			logger1.info("一级码激活 直接返回");
	    	return WebConstants.A_CODE_STATUS_ACT_YES;
		}else{
			logger1.info("一级码没有激活");
		}
		
		//箱码处理
		logger1.info("二级箱码是否激活判断");
		if(!WebConstants.PROJECT_FLAG_HNYJ.equals(projectFlag)){//河南燕京没有箱码激活判断 不走该流程
			if(null != barcodeBLevel){
				logger1.info("箱码激活状态 activateStatus="+barcodeBLevel.getActivateStatus());
				if(WebConstants.B_CODE_ACTIVATE_YES.equals(barcodeBLevel.getActivateStatus())){//激活
					logger1.info("箱码激活 直接返回");
			    	return WebConstants.A_CODE_STATUS_ACT_YES;
				}else{
					logger1.info("箱码没有激活");
				}
			}else{
				logger1.info("箱码信息不存在");
			}
		}else{
			logger1.info("河南燕京 没有二级箱码 不做二级箱码激活验证");
		}
		
		//辅料码处理
		logger1.info("辅料箱码是否激活判断");
		if(null == barcodeBlevelFl){
			logger1.info("辅料箱码信息不存在 一级码没有激活");
			lpRes.setCodeStatus(WebConstants.SCAN_LOG_AVTIVE_NO);//记录日志用
			lpRes.setRetCode(StateInfoEnum.FL_CODE_NOT_EXIST.getRetCode());
			lpRes.setRetInfo(StateInfoEnum.FL_CODE_NOT_EXIST.getRetInfo());
			return WebConstants.A_CODE_STATUS_ACT_NO;
		}
		logger1.info("辅料码激活状态 activateStatus="+barcodeBlevelFl.getActivateStatus());
		if(WebConstants.FL_CODE_ACTIVATE_YES.equals(barcodeBlevelFl.getActivateStatus())){//激活
			logger1.info("辅料箱码激活 激活直接返回");
			return WebConstants.A_CODE_STATUS_ACT_YES;
		}else{//未激活
			lpRes.setCodeStatus(WebConstants.SCAN_LOG_AVTIVE_NO);//记录日志用
			lpRes.setRetCode(StateInfoEnum.FL_CODE_NOT_ACTIVE.getRetCode());
			lpRes.setRetInfo(StateInfoEnum.FL_CODE_NOT_ACTIVE.getRetInfo());
			return WebConstants.A_CODE_STATUS_ACT_NO;
		}
    }

    //是否首次中小于一元红包
	public String isFirstWinLessYiYuan(Integer actId,String openId){
		logger1.info("判断是否是首次中 小于1元区间红包");
		if(StringUtil.isEmpty(openId)){
			logger1.info("openId为空首次抽奖");
			return WebConstants.FIRST_AWARD_YES;
		}
		//查询 消费者表
		CustomerInfo custInfo = customerInfoService.getCustomerInfoByOpenId(openId,tablePrefix);
		if (null == custInfo) {//没有用户信息
			logger1.info("客户信息不存在 首次抽奖");
			return WebConstants.FIRST_AWARD_YES;
		}
		//查询 零钱订单
		List<ChangeOrder> changeOrderLists = changeOrderService.getCustActChangeOrder(custInfo.getCustomerId(), actId);
		if (CollectionUtils.isEmpty(changeOrderLists) || null == changeOrderLists.get(0)) {//没有中零钱奖
			logger1.info("客户零钱订单表中无该活动记录 首次抽奖");
			return WebConstants.FIRST_AWARD_YES;
		}else{
			logger1.info("客户零钱订单表中有该活动记录 非首次抽奖");
		}
		return WebConstants.FIRST_AWARD_NO;//默认非首次
	}
	
	
	/**
	 * @Method: checkActivityStatus
	 * @Description: 活动是否存在  开启关闭校验  并设置响应信息
	 * @param lpRes
	 * @param activity
	 * @return 0 活动无效  1 活动有效
	 * @return String
	 * @author zzw
	 * @date 2016年6月28日 上午11:02:02
	 */
  	public String checkActivityStatus(LotteryPrizeSvcRes lpRes,Activity activity){
  		if(null == activity){
  			logger1.info("query _activity,activity not exist");
  			lpRes.setRetCode(StateInfoEnum.ACTIVITY_NOT_EXIST.getRetCode());
  			lpRes.setRetInfo(StateInfoEnum.ACTIVITY_NOT_EXIST.getRetInfo());
  			return WebConstants.ACT_VALID_ON;//活动无效
  		}
		//活动是否删除 关闭判断
		if(WebConstants.ACT_STATUS_DEL_YES.equals(activity.getStatus())){
			logger1.info("活动已经删除");
			lpRes.setRetCode(StateInfoEnum.ACTIVITY_IS_DELETED.getRetCode());
			lpRes.setRetInfo(StateInfoEnum.ACTIVITY_IS_DELETED.getRetInfo());
			return WebConstants.ACT_VALID_ON;//活动无效
		}
		if(WebConstants.ACT_ISOPEN_OFF.equals(activity.getIsOpen())){
			logger1.info("活动已经关闭");
			lpRes.setRetCode(StateInfoEnum.ACTIVITY_IS_CLOSED.getRetCode());
			lpRes.setRetInfo(StateInfoEnum.ACTIVITY_IS_CLOSED.getRetInfo());
			return WebConstants.ACT_VALID_ON;//活动无效
		}
		logger1.info("默认活动有效");
		return WebConstants.ACT_VALID_YES;//活动有效
  	}
	
	
	//活动是否有效校验 0无效 1有效  如果无效 设置活动信息
	public String checkActivityDate(LotteryPrizeSvcRes lpRes,Activity activity){
		//判断活动时间是否有效
		String nowDateStatus = DateUtil.nowDateStatus(activity.getStartDate(), activity.getEndDate());
		logger1.info("1-未开始 2-进行中  3-已经结束 nowDateStatus="+nowDateStatus);
		if(StringUtils.isEmpty(nowDateStatus)){//活动时间无效 活动不存在
			lpRes.setRetCode(StateInfoEnum.ACTIVITY_HAS_ENDED.getRetCode());
			lpRes.setRetInfo(StateInfoEnum.ACTIVITY_HAS_ENDED.getRetInfo());
			return WebConstants.ACT_VALID_ON;
		}else{
			if(WebConstants.ACT_NOT_BEG.equals(nowDateStatus)){//未开始
				lpRes.setRetCode(StateInfoEnum.ACTIVITY_NOT_START.getRetCode());
				lpRes.setRetInfo(StateInfoEnum.ACTIVITY_NOT_START.getRetInfo());
				return WebConstants.ACT_VALID_ON;
			}else if(WebConstants.ACT_HAS_END.equals(nowDateStatus)){//已经结束
				lpRes.setRetCode(StateInfoEnum.ACTIVITY_HAS_ENDED.getRetCode());
				lpRes.setRetInfo(StateInfoEnum.ACTIVITY_HAS_ENDED.getRetInfo());
				return WebConstants.ACT_VALID_ON;
			}else{
			}
		}
		return WebConstants.ACT_VALID_YES;
	}
	
	/**
	 * @Method: isActivityDateOut
	 * @Description: 判断活动是否过期
	 * @param lpRes
	 * @param act
	 * @param barcodeBLevel
	 * @param barcodeBlevelFl
	 * @param shelfLife
	 * @return Integer
	 * @author zzw
	 * @date 2016年6月28日 下午7:19:15
	 */
	public Integer isActivityDateOut(LotteryPrizeSvcRes lpRes,Activity act,
			BarcodeBLevel barcodeBLevel,BarcodeBLevelFl barcodeBlevelFl,Integer shelfLife){
		Integer validDateType = act.getValidDateType();
		logger1.info("活动有效期判断方式1:按辅料箱码激活时间+产品有效期判断 2 按按活动有效期抽奖 3按成品箱码激活时间+产品有效期判断="+validDateType);
		if(WebConstants.VALID_DATE_TYPE_ACT.equals(validDateType)){
			if(!WebConstants.ACT_VALID_YES.equals(this.checkActivityDate(lpRes, act))){
				return WebConstants.ACT_DATE_OUT_YES;
			}
		}else if(WebConstants.VALID_DATE_TYPE_B.equals(validDateType)){
			if(!WebConstants.B_CODE_DATE_OUT_NO.equals(this.isBCodeDateOut(barcodeBLevel, shelfLife))){
				lpRes.setCodeStatus(WebConstants.SCAN_LOG_INVALID);//记录日志用
				lpRes.setRetCode(StateInfoEnum.B_CODE_TIME_OUT.getRetCode());
				lpRes.setRetInfo(StateInfoEnum.B_CODE_TIME_OUT.getRetInfo());
				return WebConstants.ACT_DATE_OUT_YES;
			}
		}else{
			if(!WebConstants.FL_CODE_DATE_OUT_NO.equals(this.isFLCodeDateOut(barcodeBlevelFl, shelfLife))){
				lpRes.setCodeStatus(WebConstants.SCAN_LOG_INVALID);//记录日志用
				lpRes.setRetCode(StateInfoEnum.FL_CODE_TIME_OUT.getRetCode());
				lpRes.setRetInfo(StateInfoEnum.FL_CODE_TIME_OUT.getRetInfo());
				return WebConstants.ACT_DATE_OUT_YES;
			}
		}
		logger1.info("默认没有过期");
		return WebConstants.ACT_DATE_OUT_NO;
	}
	
	//获取真正的中奖金额
	public int getRealPrizeAmount(ActivityPrize ap,LotteryPrizeSvcRes response,Integer actId,String openId){
		logger1.info("获取真实中奖金额");
		int realPrizeAmount = 0;
		if(WebConstants.RED_TYPE_FIXED.equals(ap.getRedBagType())){//固定红包
			realPrizeAmount = ap.getPrizeAmount();
		}else if(WebConstants.RED_TYPE_BETWEEN.equals(ap.getRedBagType())){//中奖是区间红包
			logger1.info("中奖为区间红包 调用方法获取中奖金额");
			int minAmount = null != ap.getMinAmount()?ap.getMinAmount().intValue():0;
			int maxAmount = null != ap.getMaxAmount()?ap.getMaxAmount().intValue():0;
			logger1.info("minAmount="+minAmount+" maxAmount="+maxAmount);
			realPrizeAmount = PrizeUtils.getRandomBetween(minAmount,maxAmount);//调用后台获取区间红包金额
			logger1.info("中区间红包金额 realPrizeAmount="+realPrizeAmount);
			if(WebConstants.FIRST_LESS_YIYUAN_YES.equals(this.isFirstWinLessYiYuan(actId, openId))){//首次中小于一元
				response.setFirstAward(WebConstants.FIRST_AWARD_YES);
				logger1.info("首次中 小于1元区间红包 首次参与该活动 ");
				if(null != ap.getFirstMinAmount() && ap.getFirstMinAmount().intValue()>0){
					if(realPrizeAmount < ap.getFirstMinAmount().intValue()){//中奖金额  < 小于第一次中奖最小金额
						logger1.info("中奖金额  < 小于第一次中奖最小金额");
						realPrizeAmount = ap.getFirstMinAmount();//第一次中奖最小金额
						logger1.info("中区间红包金额变更为 realPrizeAmount="+realPrizeAmount);
					}
				}
			}else{
				logger1.info("非首次中 小于1元区间红包");
			}
		}else if(WebConstants.RED_TYPE_SHARE.equals(ap.getRedBagType())){//分享红包
			realPrizeAmount = ap.getPrizeForciblyCount()*ap.getPrizeForciblyAmount();//分享红包的总金额
		}else{
		}
		
		return realPrizeAmount;
	}
	
		
	//是否超过 投放量投放或者 投放金额 超过返回flase
	public boolean isGreaterTotalAmountAndPrizeCount(ActivityPrize ap,int realPrizeAmount){
		if(WebConstants.PRIZE_BY_PRO.equals(ap.getIsBoxPrize())// 1 按箱抽奖 2 按产品抽奖
				&& this.isLuckCountGreaterPrizeCount(ap)){//中奖数量 > 投放量 判断
			return true;
		}
		if(WebConstants.PRIZE_TYPE_RED.equals(ap.getPrizeType())){//中红包  积分不做这个判断
			if(this.isLuckyAmountGreaterTotalAmount(ap,realPrizeAmount)){//中奖金额  > 总金额 判断
				return true;
			}
		}
		return false;
	}


	//中奖金额+当前中奖金额 > 投放总金额 判断 大于返回true
	public boolean isLuckyAmountGreaterTotalAmount(ActivityPrize ap,int realPrizeAmount){
		logger1.info("中奖金额 > 投放金额 判断");
		if(null == ap){
			logger1.info("奖项为空 中奖金额 > 投放金额 ");
			return true;
		}
		int prizeLuckyAmount = null != ap.getPrizeLuckyAmount()?ap.getPrizeLuckyAmount().intValue()+realPrizeAmount:0;
		int prizeTotalAmount = null != ap.getPrizeTotalAmount()?ap.getPrizeTotalAmount().intValue():0;
		logger1.info("中奖金额 prizeLuckyAmount="+prizeLuckyAmount+"  投放金额 prizeTotalAmount="+prizeTotalAmount);
		if(prizeLuckyAmount>prizeTotalAmount){
			return true;
		}
		return false;
	}
	//中奖数量+当前中奖数量 (+1) > 投放量 判断   大于返回true
	public boolean isLuckCountGreaterPrizeCount(ActivityPrize ap){
		logger1.info("中奖量 > 投放量 判断");
		if(null == ap){
			logger1.info("奖项为空 中奖量 > 投放量");
			return true;
		}
		int luckCount = null != ap.getLuckyCount()?ap.getLuckyCount().intValue()+1:0;
		int prizeCount = null != ap.getPrizeCount()?ap.getPrizeCount().intValue():0;
		logger1.info("中奖量 luckCount="+luckCount+"  投放量 prizeCount="+prizeCount);
		if(luckCount > prizeCount){
			return true;
		}
		return false;
	}

}
