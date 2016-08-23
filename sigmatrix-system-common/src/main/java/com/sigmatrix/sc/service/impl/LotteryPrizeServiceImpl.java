package com.sigmatrix.sc.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.sigmatrix.sc.dao.mapper.v1.manual.ActivityManualMapper;
import com.sigmatrix.sc.dao.mapper.v1.manual.ActivityPrizeManualMapper;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityPrize;
import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.entity.v1.BarcodeALevel;
import com.sigmatrix.sc.entity.v1.BarcodeBLevel;
import com.sigmatrix.sc.entity.v1.BarcodeBLevelFl;
import com.sigmatrix.sc.entity.v1.BarcodePrizeConsumer;
import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.service.ActivityConsumerService;
import com.sigmatrix.sc.service.ActivityPrizeService;
import com.sigmatrix.sc.service.ActivityService;
import com.sigmatrix.sc.service.ActivityTemplateService;
import com.sigmatrix.sc.service.BarcodeALevelService;
import com.sigmatrix.sc.service.BarcodeBLevelFlService;
import com.sigmatrix.sc.service.BarcodeBLevelService;
import com.sigmatrix.sc.service.BarcodePrizeConsumerService;
import com.sigmatrix.sc.service.LotteryPrizeCommonService;
import com.sigmatrix.sc.service.LotteryPrizeService;
import com.sigmatrix.sc.service.ProductActivityService;
import com.sigmatrix.sc.service.ProductBaseService;
import com.sigmatrix.sc.service.ScancodeTransitionService;
import com.sigmatrix.sc.service.UserDayPrizeService;
import com.sigmatrix.sc.svcEntity.req.LotteryPrizeSvcReq;
import com.sigmatrix.sc.svcEntity.res.LotteryPrizeSvcRes;
import com.sigmatrix.sc.utils.CommonUtils;
import com.sigmatrix.sc.utils.DateUtil;
import com.sigmatrix.sc.utils.PrizeConfig;
import com.sigmatrix.sc.utils.PrizeUtils;

@Service
public class LotteryPrizeServiceImpl implements LotteryPrizeService {
	
	private static Logger logger1 = Logger.getLogger(LotteryPrizeServiceImpl.class);
	
	private String tablePrefix;
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserDayPrizeService userDayPrizeService;
	@Autowired
	private BarcodeALevelService barcodeALevelService;
	@Autowired
	private ProductBaseService productBaseService;
	@Autowired
	private ProductActivityService productActivityService;
	@Autowired
	private ActivityPrizeService activityPrizeService;
	@Autowired
	private ActivityManualMapper activityManualMapper;
	@Autowired
	private ActivityConsumerService activityConsumerService;
	@Autowired
	private ActivityTemplateService activityTemplateService;
	@Autowired
	private LotteryPrizeCommonService lotteryPrizeCommonService;
	@Autowired
	private BarcodePrizeConsumerService barcodePrizeConsumerService;
	@Autowired
	private ScancodeTransitionService scanCodeTransitionService;
	@Autowired
	private ActivityPrizeManualMapper activityPrizeManualMapper;
	@Autowired
	private BarcodeBLevelService barcodeBLevelService;
	@Autowired
	private BarcodeBLevelFlService barcodeBlevelFlService;

	//抽奖流程
	public LotteryPrizeSvcRes updateLotteryPrize(LotteryPrizeSvcReq lpReq,LotteryPrizeSvcRes lpRes) throws Exception{
		//获取请求参数
		String aCode = lpReq.getaCode();//一级单品吗
		String inputCode = lpReq.getInputCode();//输入码
		String openId = lpReq.getOpenId();//当前用户openId
//		String custFirstScan = lpReq.getCustFirstScan();//首次扫码
		Integer userId = lpReq.getUserId();//用户Id
		String projectFlag = lpReq.getProjectFlag();//项目标识
		
		//定义公共变量
		Integer activityId = null;//活动ID
		Integer productId = null;//产品ID
//		Integer aCodeActive = null;//一级码激活状态
		String hasAward = WebConstants.HAS_AWARD_NO;//是否已经抽奖 0 没有抽奖 1已经抽奖
		Integer isActive = WebConstants.BPC_IS_ACTIVE_YES;//码激活状态 默认激活 消费者表
		String lotteryWay =  WebConstants.LOTTERY_NORMAL;//
		Integer shelfLife = WebConstants.PRODUCT_TIME_OUT_DATE;//产品有效期 辅料箱码过期时间判断使用
		String custFirstAct = WebConstants.CUST_FIRST_ACT_NO;//是否首次参与活动 默认非首次
		//设置响应信息默认值
//		LotteryPrizeSvcRes lpRes = new LotteryPrizeSvcRes();
		lpRes.setRetCode(StateInfoEnum.SUCCESS.getRetCode());
		lpRes.setRetInfo(StateInfoEnum.SUCCESS.getRetInfo());
		lpRes.setOpenId(openId);
		lpRes.setCustFirstAct(custFirstAct);
		lpRes.setFirstAward(WebConstants.FIRST_AWARD_NO);//是否是首次抽奖 非首次 0 首次 1
		lpRes.setIsForceCollect(WebConstants.FORCE_COLLECT_NO);//是否强制关注 0 否  1 是
		lpRes.setIsFirst(WebConstants.CODE_FIRST_SCAN_YES);//是否首次扫码  记录日志使用
		lpRes.setCodeStatus(WebConstants.SCAN_LOG_VALID);//码状态  记录日志使用
		lpRes.setShelfLife(shelfLife);

		//查询一级单品码 
		BarcodeALevel barcodeALevel = barcodeALevelService.getBarcodeALevel(aCode, inputCode,tablePrefix);
		if(null == barcodeALevel){
			lpRes.setCodeStatus(WebConstants.SCAN_LOG_ACODE_NOT_EXIST);//码无效 日志使用
			if(!StringUtils.isEmpty(aCode)){
				lpRes.setaCode(lpReq.getUserACode());//一级码 请求码
				lpRes.setRetCode(StateInfoEnum.A_CODE_INVALID.getRetCode());
				lpRes.setRetInfo(StateInfoEnum.A_CODE_INVALID.getRetInfo());
			}else{
				lpRes.setInputCode(lpReq.getUserInputCode());//输入码 请求码
				lpRes.setRetCode(StateInfoEnum.INPUT_CODE_INVALID.getRetCode());
				lpRes.setRetInfo(StateInfoEnum.INPUT_CODE_INVALID.getRetInfo());
			}
			return lpRes;
		}else{
			if(null == barcodeALevel.getProductId()){//一级码没有和产品码关联
				lpRes.setRetCode(StateInfoEnum.A_CODE_NO_RELATED_PRO.getRetCode());
				lpRes.setRetInfo(StateInfoEnum.A_CODE_NO_RELATED_PRO.getRetInfo());
				return lpRes;
			}
			productId = barcodeALevel.getProductId();//产品ID
			aCode = barcodeALevel.getEncryptBarcodeALevel();//一级单品码  插入消费者兑换记录表会用
			//设置部分响应信息
			lpRes.setaCode(aCode);//一级码
			lpRes.setInputCode(barcodeALevel.getInputCode());//输入码
			lpRes.setOutsideCode(barcodeALevel.getOutsideCode());//产品编码 外码
			lpRes.setProductId(productId);//产品
			logger1.info("产品ID ="+barcodeALevel.getProductId()+" 一级码激活状态 ="+barcodeALevel.getActivateStatus());
			logger1.info("箱码 ="+barcodeALevel.getEncryptBarcodeBLevel()+" 辅料码="+barcodeALevel.getEncryptBarcodeBLevelFl());
		}
		
		//查询产品基础信息表  产品是否有效 获取产品有效期
		ProductBase productBase = productBaseService.getProductBaseById(productId);
		if (null == productBase){
			logger1.info("productBase info not exist");
			lpRes.setRetCode(StateInfoEnum.PRO_INFO_NOT_EXIST.getRetCode());
			lpRes.setRetInfo(StateInfoEnum.PRO_INFO_NOT_EXIST.getRetInfo());
			return lpRes;
		}else{
			this.getScanCodeTransAndSetRes(productId, lpRes);//设置过渡页信息
			logger1.info("产品有效期 = "+productBase.getShelfLife());
			if(null != productBase.getShelfLife()){
				shelfLife = productBase.getShelfLife();//产品有效期 判断辅料码是否过期使用
				lpRes.setShelfLife(shelfLife);
			}
		}
		
		//判断是否抽过奖 
		hasAward = this.isHasAwardAndSetRes(lpRes, barcodeALevel,projectFlag,shelfLife);
		if(WebConstants.HAS_AWARD_YES.equals(hasAward)){//已经抽奖 直接返回
			return lpRes;
		}
		//没有参与抽奖 走下面流程
		//产品活动设置表
		ProductActivity productActivity = productActivityService.getProductActivity(productId);
		if (null == productActivity || StringUtils.isEmpty(productActivity.getActivityId())){//产品活动信息不存在
			logger1.info("productActivity info not exist");
			lpRes.setRetCode(StateInfoEnum.PRO_ACT_NOT_EXIST.getRetCode());
			lpRes.setRetInfo(StateInfoEnum.PRO_ACT_NOT_EXIST.getRetInfo());
			return lpRes;
		}
		activityId = productActivity.getActivityId();//活动ID
		lpRes.setActivityId(activityId);
		//查询活动信息 活动表_activity 获取未激活抽奖流程
		Activity act = activityService.getActivityById(activityId,tablePrefix);
		this.setActivityInfoRs(lpRes, act);//设置活动响应信息
		if(!WebConstants.ACT_VALID_YES.equals(lotteryPrizeCommonService.checkActivityStatus(lpRes, act))){
			logger1.info("活动无效 直接返回");
			return lpRes;
		}
//		BarcodeBLevel barcodeBLevel = new BarcodeBLevel();//二级箱码
//		BarcodeBlevelFl barcodeBlevelFl = new BarcodeBlevelFl(); //辅料箱码
		
		BarcodeBLevel barcodeBLevel = null;//二级箱码
		BarcodeBLevelFl barcodeBlevelFl = null; //辅料箱码
		//查询二级箱码和辅料箱码信息
    	if(!WebConstants.PROJECT_FLAG_HNYJ.equals(projectFlag)){//河南燕京 不查询箱码表
			if(!StringUtil.isEmpty(barcodeALevel.getEncryptBarcodeBLevel())){//查询箱码
				barcodeBLevel = barcodeBLevelService.getBarcodeBLevelByBCode(barcodeALevel.getEncryptBarcodeBLevel(),tablePrefix);
			}else{
				logger1.info("一级码表中没有 箱码");
			}
		}else{
			logger1.info("河南燕京没有箱码 不查询");
		}
    	
    	if(!StringUtil.isEmpty(barcodeALevel.getEncryptBarcodeBLevelFl())){//查询辅料箱码
			barcodeBlevelFl = barcodeBlevelFlService.getBarcodeBlevelFl(barcodeALevel.getEncryptBarcodeBLevelFl(),tablePrefix);
		}else{
			logger1.info("一级码表中没有  辅料箱码");
		}
		if(null != barcodeBLevel){
			lpRes.setDealerId(barcodeBLevel.getCustomerId());//经销商id
		}
		//一级码状态判断
		Integer aCodeStuts = lotteryPrizeCommonService.getACodeAcvtivityStatus(barcodeALevel, barcodeBLevel, barcodeBlevelFl, lpRes, projectFlag);
		if(!WebConstants.A_CODE_STATUS_ACT_YES.equals(aCodeStuts)){//没激活
			lotteryWay = lpReq.getLotteryWayNoAct();//未激活 抽奖方式 
			isActive = WebConstants.BPC_IS_ACTIVE_NO;//消费者兑换记录表记录
			//未激活处理方式  活动表中配置
			logger1.info("一级码 没有激活处理方式 0显示一个页面 1取最小奖 ="+act.getUnactiviteProcessType());
			if(!WebConstants.UNACTIVITE_MINPRIZE.equals(act.getUnactiviteProcessType())){
				logger1.info("一级码没有激活  直接返回");
				return lpRes;
			}
		}else{
			logger1.info("一级码激活  走下面的流程");
		}
		//活动是否过期
		Integer isDateOut = lotteryPrizeCommonService.isActivityDateOut(lpRes, act, barcodeBLevel, barcodeBlevelFl, shelfLife);
		if(!WebConstants.ACT_DATE_OUT_NO.equals(isDateOut)){//过期
			logger1.info("活动过期直接返回");
			return lpRes;
		}else{
			logger1.info("活动没有过期  走下面的流程");
		}
		
		//判断用户中奖数量是否达到上限
		Integer userMaxPrizeLimit = WebConstants.USER_MAX_PRIZE_LIMIT_NO;//没有达到上限
		Integer userMaxPrizeWay = WebConstants.USER_MAX_PRIZE_WAY_BCYCJ;//用户达到中奖数量上限处理方式 
		//用户每天最大中奖数量
		Integer userDayMaxCont1 = act.getUserDayMaxPrizeCount();
		int userDayMaxCont = null!=userDayMaxCont1?userDayMaxCont1.intValue():0;
		lpRes.setUserDayMaxPrizeCount(new Integer(userDayMaxCont));//设置响应
		int userPrizeCount = userDayPrizeService.getUserDayPrizeAndSyn(userId, activityId);//用户每天已中奖数量
		logger1.info("用户已中奖数量="+userPrizeCount+" 活动中奖数量限制="+userDayMaxCont);
		if(userPrizeCount>=userDayMaxCont){//达到上限
			userMaxPrizeWay = act.getUserMaxPrizeProcessType();
			userMaxPrizeLimit = WebConstants.USER_MAX_PRIZE_LIMIT_YES;
			if(!WebConstants.USER_MAX_PRIZE_WAY_CJBZJ.equals(userMaxPrizeWay)){//达到上限 不参与抽奖直接返回  参与抽奖往下走
				logger1.info("达到上限不参与抽奖 返回达到每日抽奖次数限制页面");
				lpRes.setRetCode(StateInfoEnum.USER_MAX_PRIZE_LIMIT.getRetCode());
				lpRes.setRetInfo(StateInfoEnum.USER_MAX_PRIZE_LIMIT.getRetInfo());
				return lpRes;
			}
		}
		//判断用户是否首次参加活动 如果是首次记录用户参与活动表 消费者表的活动Id为空 更新消费者表
		custFirstAct = activityConsumerService.isCustActAttendedAndRecord(openId, activityId,tablePrefix);
		logger1.info("判断用户是否首次参加活动 返回 custFirstAct="+custFirstAct);
		lpRes.setCustFirstAct(custFirstAct);
		
		logger1.info("用户首次参与活动0非首次 1首次 custFirstAct="+custFirstAct +" 正常抽奖取最小奖标识 lotteryWay="+lotteryWay);
		
		//查询活动奖项设置表  一个活动对应多个奖项设置
		List<ActivityPrize> apLists = activityPrizeService.getActivityPrizeList(activityId);
		if (CollectionUtils.isEmpty(apLists)){
			logger1.info("ActivityPrize info not exist");//活动奖项不存在
			lpRes.setRetCode(StateInfoEnum.PRIZE_NOT_EXIST.getRetCode());
			lpRes.setRetInfo(StateInfoEnum.PRIZE_NOT_EXIST.getRetInfo());
			return lpRes;
		}
		logger1.info("抽奖前数据校验完成 准备抽奖......");
		ActivityPrize apTemp = null;//临时 奖项信息实体
		Boolean flagLotterPrize = false;//默认没有中奖
		Integer prizeId = null;//奖项ID
		int realAmount = 0;//真正的中奖金额
		if(WebConstants.USER_MAX_PRIZE_LIMIT_YES.equals(userMaxPrizeLimit)){//用户达到中奖数量上限处理方式 
			logger1.info("用户每日中奖数量已经达到上限  抽奖但是不中奖处理");
			flagLotterPrize = false;
		}else{
			Integer firstPrizeId = act.getFirstPrizeId();
			logger1.info("首次抽奖奖项Id 获取活动表中配置的奖项 firstPrizeId="+firstPrizeId);
			if(WebConstants.CUST_FIRST_ACT_YES.equals(custFirstAct) && null != firstPrizeId){//首次抽奖 奖项id不为空
				logger1.info("首次参与活动 首次抽奖");
				lpRes.setFirstAward(WebConstants.FIRST_AWARD_YES);
				apTemp = activityPrizeService.getActivityPrizeByPrizeId(firstPrizeId,tablePrefix);
				if(null == apTemp){//奖项不存在
					lpRes.setRetCode(StateInfoEnum.PRIZE_NOT_EXIST.getRetCode());
					lpRes.setRetInfo(StateInfoEnum.PRIZE_NOT_EXIST.getRetInfo());
					return lpRes;
				}else{
					if(WebConstants.PRIZE_TYPE_RED.equals(apTemp.getPrizeType())){
						realAmount = lotteryPrizeCommonService.getRealPrizeAmount(apTemp, lpRes, activityId, openId);//获取真正的中奖金额
					}
					if(!lotteryPrizeCommonService.isGreaterTotalAmountAndPrizeCount(apTemp, realAmount)){//中奖 && (没有超过投放量 || 投放金额)
						flagLotterPrize = true;
					}
				}
			}else{//正常抽奖
				if(WebConstants.LOTTERY_NORMAL.equals(lotteryWay)){//正常抽奖
					logger1.info("正常抽奖流程 调用抽奖方法");
					prizeId = this.lotterPrizeByScan(act, apLists,barcodeALevel);
					logger1.info("调用抽奖方法返回  奖项id="+prizeId);
					if(null != prizeId && -1 != prizeId.intValue()){//中奖 
						logger1.info("中奖 从奖项列表中获取 奖项实体");
						apTemp = this.getActivityPrizeByPrizeId(apLists, prizeId);
						if(null != apTemp){
							if(WebConstants.PRIZE_TYPE_RED.equals(apTemp.getPrizeType())){
								realAmount = lotteryPrizeCommonService.getRealPrizeAmount(apTemp, lpRes, activityId, openId);//获取真正的中奖金额
							}
							if(!lotteryPrizeCommonService.isGreaterTotalAmountAndPrizeCount(apTemp, realAmount)){//中奖 && (没有超过投放量 || 投放金额)
								flagLotterPrize = true;
							}
						}
					}
				}else{//一级码没有激活抽奖方式
					logger1.info("一级码没有激活抽奖流程------");
					lotteryWay = lpReq.getLotteryWayNoAct();//未激活抽奖
					apTemp = this.lotteryPrizeNoWinAct(apLists,lotteryWay);
					if(null != apTemp){
						realAmount = apTemp.getPrizeAmount();
						flagLotterPrize = true;
					}
				}
			}
			//未中奖 && 需要处理 
			if(!flagLotterPrize && WebConstants.NOT_WIN_WAY_YES.equals(lpReq.getNotWinWay())){
				logger1.info("未中奖 && 需要处理抽奖流程-------");
				lotteryWay = lpReq.getLotteryWayNoWin();
				apTemp = this.lotteryPrizeNoWinAct(apLists,lotteryWay);
				if(null != apTemp){
					realAmount = apTemp.getPrizeAmount();
					flagLotterPrize = true;
				}
			}
		}
		
		logger1.info("奖项实体**** "+JSONObject.toJSONString(apTemp));
		logger1.info("是否中奖 flagLotterPrize="+flagLotterPrize);
		//抽完奖  写库实体设置
		ActivityPrize ap = new ActivityPrize();//奖项信息实体
		Integer isPrize = WebConstants.ISPRIZE_NO;//是否中奖 0 未中奖 1 中奖 临时
		BarcodePrizeConsumer bpcEnd = new BarcodePrizeConsumer();// 抽奖后实体
		if(flagLotterPrize){//中奖
			ap = apTemp;
			apTemp = null;
			isPrize = WebConstants.ISPRIZE_YES;
			lpRes.setLuckyCount(ap.getLuckyCount());
			lpRes.setPrizeCount(ap.getPrizeCount());
			lpRes.setPrizeLuckyAmount(ap.getPrizeLuckyAmount());
			lpRes.setPrizeTotalAmount(ap.getPrizeTotalAmount());
		}else{
			ap.setPrizeId(-1);
			//未中奖绑定用户信息
			bpcEnd.setOpenId(openId);
			bpcEnd.setUserId(userId+"");
		}
		//抽完奖  写库实体设置 消费者兑换表  _barcode_prize_consumer
		bpcEnd.setIsPrize(isPrize);//是否中奖 0 未中奖 1 中奖
		bpcEnd.setIsActive(isActive);//是否激活
		bpcEnd.setPrizeAmount(realAmount);//中红包实际金额 如果为霸占红包 为霸占红包的总量
		bpcEnd.setProductId(productId);//产品ID
		bpcEnd.setActivityId(act.getActivityId());//活动ID
		bpcEnd.setBarcode(aCode);//单品码内容
		bpcEnd.setDealerId(lpRes.getDealerId());//经销商Id
		if(WebConstants.CUST_FIRST_ACT_YES.equals(custFirstAct)){
			bpcEnd.setIsFirstGet(new Integer(1));//是否首次获得 0 非首次 1 首次
		}else{
			bpcEnd.setIsFirstGet(new Integer(0));
		}
		bpcEnd = this.getBarcodePrizeConsumer(ap,bpcEnd);//设置剩下的值
		
		//抽奖完成写库 
		logger1.info("抽奖后跟新数据库......");
		this.updateDBLotterPrizeEnd(bpcEnd,ap, act, barcodeALevel,flagLotterPrize,realAmount,userId);
		
		//返回抽奖结果信息
		logger1.info("组装返回抽奖结果信息......");
		lpRes = this.getLotteryPrizeSvcResponse(bpcEnd,lpRes,StateInfoEnum.SUCCESS);
		return lpRes;
	}
	
	//未中奖 未激活抽奖方式  返回奖项实体
	private ActivityPrize lotteryPrizeNoWinAct(List<ActivityPrize> apLists,String lotteryWay){
//		logger1.info("未中奖 || 未激活 抽奖流程-------");
		ActivityPrize ap = null;
		if(WebConstants.LOTTERY_MIN_PRIZE.equals(lotteryWay)){//取区间红包的最小奖
			logger1.info("取区间红包的最小值");
			ap = this.getActivityPrizeBetweenRed(apLists);
			if(null != ap){
				ap.setPrizeAmount(ap.getMinAmount());//真正的中奖金额
			}
		}else if(WebConstants.LOTTERY_INTEGRAL.equals(lotteryWay)){//取积分
			logger1.info("取积分");
			ap = this.getActivityPrizeIntegral(apLists);
			if(null != ap){
				ap.setPrizeAmount(0);//真正的中奖金额
			}
		}else if(WebConstants.LOTTERY_MIN_FIXED_RED.equals(lotteryWay)){
			logger1.info("取定额红包的最小值");
			ap = this.getActivityFixedRed(apLists);
			if(null != ap){
				ap.setPrizeAmount(ap.getPrizeAmount());//真正的中奖金额
			}
		}else{
			logger1.info("默认值 奖项实体为空 没有中奖");
		}
		return ap;
	}
	
	//返回是否参与抽奖 并设置响应信息
	private String isHasAwardAndSetRes(LotteryPrizeSvcRes lpRes,BarcodeALevel barcodeALevel,String projectFlag,Integer shelfLife) throws Exception  {
		//判断是否抽过奖 查询消费者兑换表
		BarcodePrizeConsumer bpcHasPrize = barcodePrizeConsumerService.getBPCByACode(barcodeALevel.getEncryptBarcodeALevel(),tablePrefix);
		if(null == bpcHasPrize){
			return WebConstants.HAS_AWARD_NO;
		}
		//设置部分响应信息 如果已抽奖 以已抽奖信息为准
		lpRes.setRetCode(StateInfoEnum.QRCODE_HAS_PRIZE.getRetCode());
		lpRes.setRetInfo(StateInfoEnum.QRCODE_HAS_PRIZE.getRetInfo());
		lpRes.setaCode(bpcHasPrize.getBarcode());//一级码
		lpRes.setProductId(bpcHasPrize.getProductId());//产品
		lpRes.setActivityId(bpcHasPrize.getActivityId());//活动Id
		lpRes.setBpcOpenId(bpcHasPrize.getOpenId());//用户openId
		lpRes.setIsFirst(WebConstants.CODE_FIRST_SCAN_NO);//非首次扫码 记录日志使用
		if(WebConstants.BPC_IS_ACTIVE_YES.equals(bpcHasPrize.getIsActive())){//激活
			lpRes.setCodeStatus(WebConstants.SCAN_LOG_VALID);//码有效 记录日志
		}else{//未激活
			lpRes.setCodeStatus(WebConstants.SCAN_LOG_AVTIVE_NO);//码未激活 记录日志
		}
		//中奖 没有和openId绑定 可以再次领奖  做活动验证
		if(WebConstants.ISPRIZE_YES.equals(bpcHasPrize.getIsPrize()) && StringUtils.isEmpty(bpcHasPrize.getOpenId())){
			logger1.info("已抽奖 中奖 没有和openId绑定 可以再次领奖  做活动验证");
			Activity act = activityService.getActivityById(bpcHasPrize.getActivityId(),tablePrefix);//查询活动信息
			this.setActivityInfoRs(lpRes, act);//设置活动响应信息
			if(!WebConstants.ACT_VALID_YES.equals(lotteryPrizeCommonService.checkActivityStatus(lpRes, act))){
				logger1.info("活动无效 直接返回");
				return WebConstants.HAS_AWARD_YES;//已抽奖标识
			}
			
			BarcodeBLevel barcodeBLevel = new BarcodeBLevel();//二级箱码
			BarcodeBLevelFl barcodeBlevelFl = new BarcodeBLevelFl(); //辅料箱码
			//查询二级箱码和辅料箱码信息
	    	if(!WebConstants.PROJECT_FLAG_HNYJ.equals(projectFlag)){//河南燕京 不查询箱码表
				if(!StringUtil.isEmpty(barcodeALevel.getEncryptBarcodeBLevel())){//查询箱码
					barcodeBLevel = barcodeBLevelService.getBarcodeBLevelByBCode(barcodeALevel.getEncryptBarcodeBLevel(),tablePrefix);
				}else{
					logger1.info("一级码表中没有 箱码");
				}
			}else{
				logger1.info("河南燕京没有箱码 不查询");
			}
	    	
	    	if(!StringUtil.isEmpty(barcodeALevel.getEncryptBarcodeBLevelFl())){//查询辅料箱码
				barcodeBlevelFl = barcodeBlevelFlService.getBarcodeBlevelFl(barcodeALevel.getEncryptBarcodeBLevelFl(),tablePrefix);
			}else{
				logger1.info("一级码表中没有  辅料箱码");
			}
			Integer isActDateOut = lotteryPrizeCommonService.isActivityDateOut(lpRes, act, barcodeBLevel, barcodeBlevelFl, shelfLife);
			if(!WebConstants.ACT_DATE_OUT_NO.equals(isActDateOut)){
				logger1.info("活动过期 直接返回");
				return WebConstants.HAS_AWARD_YES;//已抽奖标识
			}
		}else{
			//查询活动模板信息
			ActivityTemplate at = activityTemplateService.getActTemByActId(bpcHasPrize.getActivityId(),tablePrefix);
			if(null != at){//设置响应信息
				lpRes.setTemplateId(at.getTemplateId());
				lpRes.setTemplatePath(at.getTemplatePath());
			}
		}
		this.getLotteryPrizeSvcResponse(bpcHasPrize,lpRes,StateInfoEnum.QRCODE_HAS_PRIZE); //设置响应信息
		return WebConstants.HAS_AWARD_YES;//已抽奖标识
	}
	
	/**
	 * @Method: updateDBLotterPrizeEnd
	 * @Description: 抽奖后更新数据库 
	 * @param bpc
	 * @param activityPrize
	 * @param activity
	 * @param barcodeALevel
	 * @param flagLotterPrize 是否中奖标识
	 * @param realPrizeAmount 真正中奖金额
	 * @return void
	 * @author zzw
	 * @date 2016年5月25日 上午9:11:05
	 */
	public void updateDBLotterPrizeEnd(BarcodePrizeConsumer bpc, ActivityPrize activityPrize,
			Activity activity,BarcodeALevel barcodeALevel,boolean flagLotterPrize,int realPrizeAmount,Integer userId) throws Exception {
		//更新抽奖活动表 扫码量
		logger1.info("更新活动表的扫码量 activityId = "+activity.getActivityId());
		Activity act0 = activityService.getActivityById(activity.getActivityId(),tablePrefix);
		if(null != act0){
			Activity act1 = new Activity();
			act1.setUpdateTime(new Date());//更新时间
			act1.setActivityId(act0.getActivityId());
			act1.setScanCount(new Integer(1));//扫码量+1
//			act1.setScanCount(null != activity.getScanCount()?activity.getScanCount().intValue()+1:1);
			if(null == act0.getScanCount()){//扫码数量为空
				activityService.updateByPrimaryKeySelective(act1);
			}else{
				activityManualMapper.updateActivityScanCount1(act1);
			}
		}
		
		//中奖更新
		if(flagLotterPrize){
			ActivityPrize ap0 = activityPrizeService.getActivityPrizeByPrizeId(activityPrize.getPrizeId(),tablePrefix);
			if(null != ap0){
				//更新 活动奖项设置表 中奖数量 和  中奖金额
				ActivityPrize ap1 = new ActivityPrize();
				ap1.setPrizeId(ap0.getPrizeId());
				ap1.setUpdateTime(new Date());//更新时间
				ap1.setLuckyCount(1);//中奖数量
				if(WebConstants.PRIZE_TYPE_RED.equals(ap0.getPrizeType())){//中红包将 更新中奖金额
					ap1.setPrizeLuckyAmount(new Long(realPrizeAmount));
				}else{
					ap1.setPrizeLuckyAmount(new Long(0));
				}
				
				if(null == ap0.getPrizeLuckyAmount() || null == ap0.getLuckyCount()){
					activityPrizeService.updateByPrimaryKeySelective(ap1);
				}else{
					activityPrizeManualMapper.updateActivityPrize1(ap1);//更新奖项表
				}
			}
			//用户每天中奖量
			userDayPrizeService.queryUpdateSaveUserDayPrize(userId,activity.getActivityId());
		}
//		int i= 2/0;
		//判断是否抽过奖 查询消费者兑换表
		BarcodePrizeConsumer bpcHasPrize = barcodePrizeConsumerService.getBPCByACode(bpc.getBarcode(),tablePrefix);
		if(null == bpcHasPrize){
			//插入消费者兑换表
			barcodePrizeConsumerService.saveBPCInfo(bpc);
		}else{
			throw new RuntimeException("该码已经在消费者兑换记录表存在  手动抛出异常");
//			int i=1/0;
		}
		
	}
	
	/**
	 * @Method: lotterPrizeByScan
	 * @Description: 抽奖 非首次
	 * @throws Exception 
	 * @date 2016年3月1日 上午9:33:22
	 */
	private Integer lotterPrizeByScan(Activity activity,List<ActivityPrize> apLists, 
			BarcodeALevel barcodeALevel) throws Exception {
		//组装调用抽奖接口数据
		int totalCount = 0;//预估参与人数
		int boxTotalCount = 0;//一箱的总数量，如果没有按箱抽奖，此项填0
		List<PrizeConfig> boxList = null;//根据箱抽奖集合
		List<PrizeConfig> productList = new ArrayList<PrizeConfig>();//根据产品抽奖集合
		//预估参与人数  活动表中参与人数
		totalCount = null != activity.getEstimateNum() ? activity.getEstimateNum().intValue():0;
		for (ActivityPrize ap:apLists){
			PrizeConfig prizeConfig = new PrizeConfig();
			//_is_box_prize 1 按箱抽奖 2 按产品抽奖
			if(WebConstants.PRIZE_BY_PRO.equals(ap.getIsBoxPrize())){
				prizeConfig.setPrizeId(ap.getPrizeId());//奖项ID
//				prizeConfig.setHasLotteryCount(activity.getScanCount());//已经抽过奖的数量 扫码量 
//				prizeConfig.setHasPrizeCount(ap.getLuckyCount());//每个奖项的中奖量
				prizeConfig.setPrizeRate(null != ap.getPrizeRate()?ap.getPrizeRate().floatValue():0);//中奖率
				prizeConfig.setPrizeCount(null != ap.getPrizeCount()?ap.getPrizeCount().intValue():0);//投放量
				productList.add(prizeConfig);
			}
		}
		//调用抽奖算法  中奖的奖项ID
		logger1.info("正常抽奖 参数组装完成 列表如下****** ");
		logger1.info("按照产品抽奖List="+JSONObject.toJSONString(productList));
		logger1.info("按照箱子抽奖List="+JSONObject.toJSONString(boxList));
		logger1.info("预估参与人数 totalCount="+totalCount);
		logger1.info("一箱的总数量  boxTotalCount="+boxTotalCount);
		logger1.info("调用抽奖算法开始");
		Integer prizeId = PrizeUtils.lotterPrizeByScan(productList, boxList, totalCount,boxTotalCount);
		logger1.info("调用抽奖算法返回 prizeId="+prizeId);
		return prizeId;
	}
	
	/**
	 * @Method: getMinActivityPrize
	 * @Description: 从活动奖项列表中获取区间红包的最小值不再查询数据库
	 * @date 2016年3月4日 上午11:11:32
	 */
	private ActivityPrize getActivityPrizeBetweenRed(List<ActivityPrize> lists){
		if (CollectionUtils.isEmpty(lists)) {
			return null;
		}
		logger1.info("获取区间红包奖项集合");
		List<ActivityPrize> list = new ArrayList<ActivityPrize>();
		for(ActivityPrize ap:lists){
			if(WebConstants.PRIZE_TYPE_RED.equals(ap.getPrizeType())//红包
					&& WebConstants.RED_TYPE_BETWEEN.equals(ap.getRedBagType())){//区间
				list.add(ap);
			}
		}
		//区间金额排序
		Collections.sort(list, new Comparator<ActivityPrize>() {
			public int compare(ActivityPrize o1, ActivityPrize o2) {
				//按照区间最小值升序排列  从小到大
				if (o1.getMinAmount() > o2.getMinAmount()){
					return 1;
				}
				if (o1.getMinAmount() == o2.getMinAmount()){
					return 0;
				}
				return -1;
			}
		});
		logger1.info("排序后的区间红包奖项列表 = "+JSONObject.toJSONString(list));
		for(ActivityPrize ap:list){
			if(lotteryPrizeCommonService.isGreaterTotalAmountAndPrizeCount(ap,ap.getMinAmount())){//中奖量  > 投放量  || 中奖金额 > 投放金额
				continue;
			}
			return ap;
		}
		return null;
	}
	
	/**
	 * @Method: getActivityFixedRed
	 * @Description: 从活动奖项列表中获取最小的定额红包
	 * @date 2016年3月4日 上午11:11:32
	 */
	private ActivityPrize getActivityFixedRed(List<ActivityPrize> lists){
		if (CollectionUtils.isEmpty(lists)) {
			return null;
		}
		logger1.info("获取定额红包奖项集合");
		List<ActivityPrize> list = new ArrayList<ActivityPrize>();
		for(ActivityPrize ap:lists){
			if(WebConstants.PRIZE_TYPE_RED.equals(ap.getPrizeType())//红包
					&& WebConstants.RED_TYPE_FIXED.equals(ap.getRedBagType())){//定额
				list.add(ap);
			}
		}
		//固定金额排序
		Collections.sort(list, new Comparator<ActivityPrize>() {
			public int compare(ActivityPrize o1, ActivityPrize o2) {
				//按照金额进行升序排列  从小到大
				if (o1.getPrizeAmount() > o2.getPrizeAmount()){
					return 1;
				}
				if (o1.getPrizeAmount() == o2.getPrizeAmount()){
					return 0;
				}
				return -1;
			}
		});
		
		logger1.info("排序后的定额奖项列表 = "+JSONObject.toJSONString(list));
		for(ActivityPrize ap:list){
			if(lotteryPrizeCommonService.isGreaterTotalAmountAndPrizeCount(ap,ap.getPrizeAmount())){//中奖量  > 投放量 中奖金额 > 投放金额
				continue;
			}
			return ap;
		}
		return null;
	}
	
	/**
	 * @Method: getActivityPrizeIntegral
	 * @Description: 从活动奖项列表中获取积分
	 * @date 2016年3月4日 上午11:11:32
	 */
	private ActivityPrize getActivityPrizeIntegral(List<ActivityPrize> lists){
		if (CollectionUtils.isEmpty(lists)) {
			return null;
		}
		logger1.info("获取积分奖项集合");
		List<ActivityPrize> list = new ArrayList<ActivityPrize>();
		for(ActivityPrize ap:lists){
			if(WebConstants.PRIZE_TYPE_POINT.equals(ap.getPrizeType())){//积分
				list.add(ap);
			}
		}
		//积分排序
		Collections.sort(list, new Comparator<ActivityPrize>() {
			public int compare(ActivityPrize o1, ActivityPrize o2) {
				//按照积分进行升序排列  从小到大
				if (o1.getIntegration() > o2.getIntegration()){
					return 1;
				}
				if (o1.getIntegration() == o2.getIntegration()){
					return 0;
				}
				return -1;
			}
		});
		
		logger1.info("排序后的积分奖项列表 = "+JSONObject.toJSONString(list));//积分
		for(ActivityPrize ap:list){
			if(lotteryPrizeCommonService.isLuckCountGreaterPrizeCount(ap)){//中奖量  > 投放量
				continue;
			}
			return ap;
		}
		return null;
	}
	
	/**
	 * @Method: getActivityPrize
	 * @Description: 从活动列表中取出中奖的实体 不再查询数据库
	 * @date 2016年3月4日 上午11:11:32
	 */
	private ActivityPrize getActivityPrizeByPrizeId(List<ActivityPrize> lists,Integer prizeId){
		if (CollectionUtils.isEmpty(lists) || null == prizeId) {
			return null;
		}
		for(ActivityPrize ap:lists){
			if(null !=ap.getPrizeId() && ap.getPrizeId().equals(prizeId)){
				return ap;
			}
		}
		return null;
	}
	
	/**
	 * @Method: getScanCodeTransAndSetRes
	 * @Description: 查询过渡页并设置响应信息
	 * @param productId
	 * @param lpRes
	 * @return void
	 * @author zzw
	 * @throws Exception 
	 * @date 2016年5月25日 下午1:15:44
	 */
	private void getScanCodeTransAndSetRes(Integer productId,LotteryPrizeSvcRes lpRes) throws Exception{
		ScancodeTransition sct = scanCodeTransitionService.queryScanCodeTransition(productId);
		if(null != sct){//设置过渡页信息
			lpRes.setsCTpicUrl(sct.getPicUrl());
			lpRes.setsCTpicPath(sct.getPicPath());
		}
	}
	

	/**
	 * @Method: getBarcodePrizeConsumer
	 * @Description: 抽奖完成写库实体
	 * @date 2016年3月17日 上午11:13:02
	 */
    private BarcodePrizeConsumer getBarcodePrizeConsumer(ActivityPrize ap,BarcodePrizeConsumer bpcEnd){
		//抽完奖  写库实体设置 消费者兑换表  _barcode_prize_consumer
		String prizeOrderId = CommonUtils.getBusinessOrderID(WebConstants.BUSINESS_CODE_SMCJ);//奖品订单ID
		logger1.info("奖品订单 prizeOrderId="+prizeOrderId);
		bpcEnd.setPrizeOrderId(prizeOrderId);//奖品订单ID
		bpcEnd.setIsStatus(WebConstants.BPC_STATUS_ALREADY);
		bpcEnd.setIsType(WebConstants.LOTTERY_WAY_SCAN);//抽奖方式'1 扫码抽奖 2 积分抽奖'
		bpcEnd.setPrizeId(ap.getPrizeId());//中奖的奖项ID
		bpcEnd.setPrizeName(ap.getPrizeName());//奖项名称
		bpcEnd.setPrizeType(ap.getPrizeType());//奖项类型  1 再来一瓶， 2红包, 3 邮寄奖品4、积分  5、到店领取的奖品
		bpcEnd.setRedBagType(ap.getRedBagType());//红包类型  1 固定中奖金额  2 区间中奖金额 3 霸占型红包
//		bpcEnd.setPrizeLuckyAmount(new Integer(ap.getPrizeLuckyAmount().intValue()));//已中此奖项的总金额(单位分)
//		bpcEnd.setPrizeTotalAmount(new Integer(ap.getPrizeTotalAmount().intValue()));//奖项的总金额(单位分)
		bpcEnd.setMinAmount(ap.getMinAmount());//最小红包金额
		bpcEnd.setMaxAmount(ap.getMaxAmount());//最大红包金额
		bpcEnd.setFirstMinAmount(ap.getFirstMinAmount());//首次中奖最小金额（单位分）
		bpcEnd.setPrizeForciblyCount(ap.getPrizeForciblyCount());//霸占红包的参与人数
		bpcEnd.setPrizeForciblyAmount(ap.getPrizeForciblyAmount());//霸占红包每人分到的钱数(大于等于1元， 单位分)
		bpcEnd.setPrizeForciblyLuckyCount(0);//霸占红包已经参与的人数
		bpcEnd.setPrizeIntegration(ap.getIntegration());//积分
		Date nowDate = new Date();
		bpcEnd.setCreateTime(nowDate);//抽奖时间
		bpcEnd.setUpdateTime(nowDate);//更新时间
		bpcEnd.setAcceptTime(nowDate);//领奖时间
		bpcEnd.setGetTime(nowDate);//兑奖时间
    	return bpcEnd;
    }

	/**
	 * @Method: getLotteryPrizeSvcResponse
	 * @Description: 抽奖完成返回实体
	 * @date 2016年3月17日 上午11:13:02
	 */
	private LotteryPrizeSvcRes getLotteryPrizeSvcResponse(BarcodePrizeConsumer bpc,LotteryPrizeSvcRes lpRes,StateInfoEnum tateInfoEnum) {
		// 设置响应值 根据响应码和中奖信息判断
		if(null != tateInfoEnum){
			lpRes.setRetCode(tateInfoEnum.getRetCode());
			lpRes.setRetInfo(tateInfoEnum.getRetInfo());
		}
		if(null != bpc){//消费者兑换记录
			lpRes.setPrizeOrderId(bpc.getPrizeOrderId());//奖项订单ID
			lpRes.setaCode(bpc.getBarcode());//一级单品码
			lpRes.setProductId(bpc.getProductId());//产品ID
			lpRes.setActivityId(bpc.getActivityId());//活动ID
			lpRes.setPrizeId(bpc.getPrizeId());//中的奖项ID
			lpRes.setIsPrize(bpc.getIsPrize());//中奖状态，0 表示没奖，1表示中奖
			lpRes.setIsStatus(bpc.getIsStatus());//抽奖状态
			lpRes.setPrizeType(bpc.getPrizeType());//奖项类型  1 再来一瓶， 2红包, 3 邮寄奖品4、积分  5、到店领取的奖品
			lpRes.setRedBagType(bpc.getRedBagType());//红包类型
			lpRes.setPrizeName(bpc.getPrizeName());//中的奖项名称
			lpRes.setCreateTime(DateUtil.formatDateToStr(bpc.getCreateTime(), DateUtil.YMDHMS));//抽奖时间
			lpRes.setAcceptTime(DateUtil.formatDateToStr(bpc.getAcceptTime(), DateUtil.YMDHMS));//领奖时间
			lpRes.setGetTime(DateUtil.formatDateToStr(bpc.getGetTime(), DateUtil.YMDHMS));//兑奖时间
			lpRes.setPrizeForciblyCount(null!=bpc.getPrizeForciblyCount()?bpc.getPrizeForciblyCount():0);//霸占红包的参与人数
			lpRes.setPrizeIntegration(null != bpc.getPrizeIntegration()?bpc.getPrizeIntegration():0);//积分
			//金额处理
			lpRes.setPrizeAmount(formatAmount(bpc.getPrizeAmount()));///中红包实际金额 如果为霸占红包 为霸占红包的总量
			lpRes.setFirstMinAmount(formatAmount(bpc.getFirstMinAmount()));//首次中奖最小金额（单位分）
			lpRes.setPrizeForciblyAmount(formatAmount(bpc.getPrizeForciblyAmount()));//霸占红包每人分到的钱数(大于等于1元，单位分)
		}
		return lpRes;
	}
	
	//设置活动未开始 和已经结束的响应信息
	private void setActivityInfoRs(LotteryPrizeSvcRes lpRes,Activity activity){
		if(null != activity){
			lpRes.setActivityId(activity.getActivityId());//活动Id
			lpRes.setActivityTitle(null != activity.getActivityTitle()?activity.getActivityTitle():"");//活动标题
			lpRes.setName(null!=activity.getName()?activity.getName():"");//活动名称
//				lpRes.setComments(null!=activity.getComments()?activity.getComments():"");//活动描述
			lpRes.setStartDate(DateUtil.formatDateToStr(activity.getStartDate(), DateUtil.YMDHMS));
			lpRes.setEndDate(DateUtil.formatDateToStr(activity.getEndDate(), DateUtil.YMDHMS));
			lpRes.setIsForceCollect(activity.getIsForceCollect());//是否强制关注标识
			
			if(null != activity.getTemplateId()){
				//查询活动模板信息
				ActivityTemplate at = activityTemplateService.getActTemById(activity.getTemplateId(),tablePrefix);
				if(null != at){//设置响应信息
					lpRes.setTemplateId(at.getTemplateId());
					lpRes.setTemplatePath(at.getTemplatePath());
				}
			}
		}
	}
	
	//金额格式化
	private static String formatAmount(Integer amount){
//		System.out.println((float)(Math.round(amount))/100+"");
//		System.out.println(String.format("%.2f", ((double) amount) / 100));
//		System.out.println(new DecimalFormat("0.00").format((double)amount.intValue()/100));
		return null!=amount && !amount.equals(0)?(new DecimalFormat("#0.00").format((double)amount.intValue()/100)+""):"0.00";
	}

	public static void main(String[] args) {
		System.out.println(formatAmount(42563));
	}

}
