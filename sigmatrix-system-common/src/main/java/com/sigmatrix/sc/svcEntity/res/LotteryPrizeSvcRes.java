package com.sigmatrix.sc.svcEntity.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sigmatrix.sc.global.StateInfoEnum;

/**
 * @Description: 扫码抽奖响应实体
 * @author zzw
 * @date 2016年3月9日 下午1:27:50
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class LotteryPrizeSvcRes {
	
	private String   retCode;                    //响应码
	private String   retInfo;                    //响应信息
	//二维码信息
	private String   aCode;                      //一级单品吗  
	private String   inputCode;					 //输入码 
	private String   outsideCode;				 //产品编码 外码内容 
	private Integer  productId;                  //产品ID
	private String   wechatAddr;				 //微信地址
	private String   openId;					 //用户openId
	private String   bpcOpenId;					 //消费者兑换记录表中的openId
	private Integer  dealerId;					 //经销商id
	//奖项信息
	private String   prizeOrderId;				 //奖品订单Id
	private Integer  isStatus;					 //状态  0 已抽奖， 1 已领奖 ， 2 已兑奖， 3 放弃领奖, 4 红包领取失败 5霸占红包分享中
	private Integer  isPrize;                    //中奖状态，0表示没奖，1表示中奖
	private Integer  prizeId;                    //中的奖项ID
	private Integer  prizeType;                  //奖项类型1再来一瓶，2红包,3邮寄奖品4、积分5、到店领取的奖品
	private Integer  redBagType;				 //红包类型 1 固定中奖金额  2 区间中奖金额 3 霸占型红包
	private String   prizeName;                  //中的奖项名称
	private Integer  prizeIntegration;			 //积分
	private Integer  prizeForciblyCount;		 //霸占红包的参与人数
	private String   prizeForciblyAmount;		 //霸占红包每人分到的钱数(大于等于1元，单位分)
	private String   prizeAmount;                //奖项金额，单位元，即微信红包的金额 真实的中奖金额
	private String   firstMinAmount;			 //首次中奖最小金额（单位分）
	
	private Integer  luckyCount;                 //中奖量
	private Integer  prizeCount;                 //投放量
	private Long  prizeLuckyAmount;           //中奖总金额 
	private Long  prizeTotalAmount;			 //投放总金额
	private Integer  shelfLife;					 //产品过期时间
	
	private String   redbagHint;				 //拆红包提示语
	private String   createTime;				 //抽奖时间
	private String	 acceptTime;				 //领奖时间
	private String	 getTime;					 //兑奖时间
	//活动模板
	private Integer  templateId;				 //模板
	private String   templatePath;				 //模板路径
	//过渡页
	private String 	 sCTpicUrl;					//过渡页url
	private String 	 sCTpicPath;				//过渡页物理路径
	
	//活动信息 活动结束 未开始返回
	private Integer  activityId;                 //活动Id
	private String   name;                       //活动名称
	private String   activityTitle;				 //活动标题
	private Integer  isForceCollect;             //是否强制关注，1强制关注，0非强制关注
	private String 	 startDate;					 //活动开始时间
	private String 	 endDate;					 //活动结束时间
	private String   comments;                   //活动描述
	private Integer  userDayMaxPrizeCount;		 //用户每天中奖限制
	
	private String   custFirstScan;              //用户首次扫码
	private String	 custFirstAct;				 //首次参加活动
	private String   firstLessYiYuan;			 //首次中小于一元
	private String   firstAward;                 //是否是首次抽奖0-非首次 1-首次
	private String   isCurrentOpenId;			 //当前用户的openId是否和消费者兑换记录表中的openId相同
	private String   custIsfollow;				 //用户是否关注0 未关注 1 关注
	
	private String   servicePhone;				//客服电话
	//记录日志使用
	private Integer codeStatus;			 		//码状态  0 无效  1 有效
	private Integer  isFirst;			 		//是否首次扫码  0 非首次 1 首次
	
	public LotteryPrizeSvcRes() {
	}

	public LotteryPrizeSvcRes(StateInfoEnum StateInfoEnum) {
		this.retCode = StateInfoEnum.getRetCode();
		this.retInfo = StateInfoEnum.getRetInfo();
	}
	
	public LotteryPrizeSvcRes(String retCode, String retInfo) {
		this.retCode = retCode;
		this.retInfo = retInfo;
	}
	
	public LotteryPrizeSvcRes(StateInfoEnum StateInfoEnum, String msg) {
		this.retCode = StateInfoEnum.getRetCode();
		this.retInfo = StateInfoEnum.getRetInfo() +"！"+ msg;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetInfo() {
		return retInfo;
	}

	public void setRetInfo(String retInfo) {
		this.retInfo = retInfo;
	}

	public String getaCode() {
		return aCode;
	}

	public void setaCode(String aCode) {
		this.aCode = aCode;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public String getOutsideCode() {
		return outsideCode;
	}

	public void setOutsideCode(String outsideCode) {
		this.outsideCode = outsideCode;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getWechatAddr() {
		return wechatAddr;
	}

	public void setWechatAddr(String wechatAddr) {
		this.wechatAddr = wechatAddr;
	}

	public String getBpcOpenId() {
		return bpcOpenId;
	}

	public void setBpcOpenId(String bpcOpenId) {
		this.bpcOpenId = bpcOpenId;
	}

	public String getPrizeOrderId() {
		return prizeOrderId;
	}

	public void setPrizeOrderId(String prizeOrderId) {
		this.prizeOrderId = prizeOrderId;
	}

	public Integer getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(Integer isStatus) {
		this.isStatus = isStatus;
	}

	public Integer getIsPrize() {
		return isPrize;
	}

	public void setIsPrize(Integer isPrize) {
		this.isPrize = isPrize;
	}


	public Integer getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	public Integer getPrizeType() {
		return prizeType;
	}

	public void setPrizeType(Integer prizeType) {
		this.prizeType = prizeType;
	}

	public Integer getRedBagType() {
		return redBagType;
	}

	public void setRedBagType(Integer redBagType) {
		this.redBagType = redBagType;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public Integer getPrizeIntegration() {
		return prizeIntegration;
	}

	public void setPrizeIntegration(Integer prizeIntegration) {
		this.prizeIntegration = prizeIntegration;
	}

	public Integer getPrizeForciblyCount() {
		return prizeForciblyCount;
	}

	public void setPrizeForciblyCount(Integer prizeForciblyCount) {
		this.prizeForciblyCount = prizeForciblyCount;
	}

	public String getPrizeForciblyAmount() {
		return prizeForciblyAmount;
	}

	public void setPrizeForciblyAmount(String prizeForciblyAmount) {
		this.prizeForciblyAmount = prizeForciblyAmount;
	}

	public String getPrizeAmount() {
		return prizeAmount;
	}

	public void setPrizeAmount(String prizeAmount) {
		this.prizeAmount = prizeAmount;
	}

	public String getFirstMinAmount() {
		return firstMinAmount;
	}

	public void setFirstMinAmount(String firstMinAmount) {
		this.firstMinAmount = firstMinAmount;
	}

	public String getRedbagHint() {
		return redbagHint;
	}

	public void setRedbagHint(String redbagHint) {
		this.redbagHint = redbagHint;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getGetTime() {
		return getTime;
	}

	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getsCTpicUrl() {
		return sCTpicUrl;
	}

	public void setsCTpicUrl(String sCTpicUrl) {
		this.sCTpicUrl = sCTpicUrl;
	}

	public String getsCTpicPath() {
		return sCTpicPath;
	}

	public void setsCTpicPath(String sCTpicPath) {
		this.sCTpicPath = sCTpicPath;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public Integer getIsForceCollect() {
		return isForceCollect;
	}

	public void setIsForceCollect(Integer isForceCollect) {
		this.isForceCollect = isForceCollect;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCustFirstScan() {
		return custFirstScan;
	}

	public void setCustFirstScan(String custFirstScan) {
		this.custFirstScan = custFirstScan;
	}

	public String getCustFirstAct() {
		return custFirstAct;
	}

	public void setCustFirstAct(String custFirstAct) {
		this.custFirstAct = custFirstAct;
	}

	public String getFirstLessYiYuan() {
		return firstLessYiYuan;
	}

	public void setFirstLessYiYuan(String firstLessYiYuan) {
		this.firstLessYiYuan = firstLessYiYuan;
	}

	public String getFirstAward() {
		return firstAward;
	}

	public void setFirstAward(String firstAward) {
		this.firstAward = firstAward;
	}

	public String getIsCurrentOpenId() {
		return isCurrentOpenId;
	}

	public void setIsCurrentOpenId(String isCurrentOpenId) {
		this.isCurrentOpenId = isCurrentOpenId;
	}

	public String getCustIsfollow() {
		return custIsfollow;
	}

	public void setCustIsfollow(String custIsfollow) {
		this.custIsfollow = custIsfollow;
	}

	public Integer getCodeStatus() {
		return codeStatus;
	}

	public void setCodeStatus(Integer codeStatus) {
		this.codeStatus = codeStatus;
	}

	public Integer getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}
	
	

	public String getServicePhone() {
		return servicePhone;
	}

	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}
	
	

	public Integer getLuckyCount() {
		return luckyCount;
	}

	public void setLuckyCount(Integer luckyCount) {
		this.luckyCount = luckyCount;
	}

	public Integer getPrizeCount() {
		return prizeCount;
	}

	public void setPrizeCount(Integer prizeCount) {
		this.prizeCount = prizeCount;
	}


	public Long getPrizeLuckyAmount() {
		return prizeLuckyAmount;
	}

	public void setPrizeLuckyAmount(Long prizeLuckyAmount) {
		this.prizeLuckyAmount = prizeLuckyAmount;
	}

	public Long getPrizeTotalAmount() {
		return prizeTotalAmount;
	}

	public void setPrizeTotalAmount(Long prizeTotalAmount) {
		this.prizeTotalAmount = prizeTotalAmount;
	}

	public Integer getUserDayMaxPrizeCount() {
		return userDayMaxPrizeCount;
	}

	public void setUserDayMaxPrizeCount(Integer userDayMaxPrizeCount) {
		this.userDayMaxPrizeCount = userDayMaxPrizeCount;
	}
	

	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}
	
	

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	@Override
	public String toString() {
		return "LotteryPrizeSvcRes [retCode=" + retCode + ", retInfo=" + retInfo + ", aCode=" + aCode + ", inputCode="
				+ inputCode + ", outsideCode=" + outsideCode + ", productId=" + productId + ", wechatAddr=" + wechatAddr
				+ ", openId=" + openId + ", bpcOpenId=" + bpcOpenId + ", dealerId=" + dealerId + ", prizeOrderId="
				+ prizeOrderId + ", isStatus=" + isStatus + ", isPrize=" + isPrize + ", prizeId=" + prizeId
				+ ", prizeType=" + prizeType + ", redBagType=" + redBagType + ", prizeName=" + prizeName
				+ ", prizeIntegration=" + prizeIntegration + ", prizeForciblyCount=" + prizeForciblyCount
				+ ", prizeForciblyAmount=" + prizeForciblyAmount + ", prizeAmount=" + prizeAmount + ", firstMinAmount="
				+ firstMinAmount + ", luckyCount=" + luckyCount + ", prizeCount=" + prizeCount + ", prizeLuckyAmount="
				+ prizeLuckyAmount + ", prizeTotalAmount=" + prizeTotalAmount + ", shelfLife=" + shelfLife
				+ ", redbagHint=" + redbagHint + ", createTime=" + createTime + ", acceptTime=" + acceptTime
				+ ", getTime=" + getTime + ", templateId=" + templateId + ", templatePath=" + templatePath
				+ ", sCTpicUrl=" + sCTpicUrl + ", sCTpicPath=" + sCTpicPath + ", activityId=" + activityId + ", name="
				+ name + ", activityTitle=" + activityTitle + ", isForceCollect=" + isForceCollect + ", startDate="
				+ startDate + ", endDate=" + endDate + ", comments=" + comments + ", userDayMaxPrizeCount="
				+ userDayMaxPrizeCount + ", custFirstScan=" + custFirstScan + ", custFirstAct=" + custFirstAct
				+ ", firstLessYiYuan=" + firstLessYiYuan + ", firstAward=" + firstAward + ", isCurrentOpenId="
				+ isCurrentOpenId + ", custIsfollow=" + custIsfollow + ", servicePhone=" + servicePhone
				+ ", codeStatus=" + codeStatus + ", isFirst=" + isFirst + "]";
	}


}
