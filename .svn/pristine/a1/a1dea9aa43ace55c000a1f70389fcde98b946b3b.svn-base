package com.sigmatrix.sc.web.vo;


import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
  * @author zyc 作者 E-mail: 
  * @date 创建时间：2016年7月25日 上午9:47:28
  * @version 1.0
  * @parameter
  * @since
  * @return
  */
public class ActivityAddVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "找不到此活动信息，请重试！")
	private Integer activityId;
	@NotBlank(message = "活动名称不能为空")
	@Length(max=40,message = "活动名称过长，请小于40个字节")
    private String name;
	@NotBlank(message = "活动标题不能为空")
	@Length(max=40, message="活动标题过长，请小于40个字节")
	private String activityTitle;
	@NotBlank(message="活动开始时间不能为空")
	private String startDate;
	@NotBlank(message="活动结束时间不能为空")
	private String endDate;
	@NotNull(message="请选择活动有效期判断方式")
	private Integer validDateType;
	@NotNull(message="活动角色不能为空")
	private Integer activityRole;
	@NotNull(message="请设置是否强制关注")
	private Integer isForceCollect;
	@NotNull(message="请选择是否开启活动区域设置")
	private Integer isArea;
	@NotBlank(message="活动兑奖结束时间不能为空")
	private String awardEndDate;
	@NotNull(message="活动模板不能为空")
	private Integer templateId;
    
	
	



	
	private Integer type;
	
	private Integer isIntegral;
	
	
	private Integer isOpen;
	
	private String activityImgUrl;

    private Integer useIntegral;

    private String createTime;

    private String updateTime;

    private Integer unprizeIntegration;

    private Integer scanCount;

    private Integer status;

 

    private String comments;


    private String picUrl;

    private String picPath;

    private Integer userDayMaxPrizeCount;

    private Integer userMaxPrizeProcessType;

    private Integer unactiviteProcessType;

    private Integer firstPrizeId;

    private Integer accountId;

    private Integer estimateNum;

    private Integer step;

    private Integer bindStatus;

    
    
	public ActivityAddVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ActivityAddVo(Integer activityId, String name, String activityTitle, String startDate, String endDate,
			Integer validDateType, Integer activityRole, Integer isForceCollect, Integer isArea, String awardEndDate,
			Integer templateId, Integer type, Integer isIntegral, Integer isOpen, String activityImgUrl,
			Integer useIntegral, String createTime, String updateTime, Integer unprizeIntegration, Integer scanCount,
			Integer status, String comments, String picUrl, String picPath, Integer userDayMaxPrizeCount,
			Integer userMaxPrizeProcessType, Integer unactiviteProcessType, Integer firstPrizeId, Integer accountId,
			Integer estimateNum, Integer step, Integer bindStatus) {
		super();
		this.activityId = activityId;
		this.name = name;
		this.activityTitle = activityTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.validDateType = validDateType;
		this.activityRole = activityRole;
		this.isForceCollect = isForceCollect;
		this.isArea = isArea;
		this.awardEndDate = awardEndDate;
		this.templateId = templateId;
		this.type = type;
		this.isIntegral = isIntegral;
		this.isOpen = isOpen;
		this.activityImgUrl = activityImgUrl;
		this.useIntegral = useIntegral;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.unprizeIntegration = unprizeIntegration;
		this.scanCount = scanCount;
		this.status = status;
		this.comments = comments;
		this.picUrl = picUrl;
		this.picPath = picPath;
		this.userDayMaxPrizeCount = userDayMaxPrizeCount;
		this.userMaxPrizeProcessType = userMaxPrizeProcessType;
		this.unactiviteProcessType = unactiviteProcessType;
		this.firstPrizeId = firstPrizeId;
		this.accountId = accountId;
		this.estimateNum = estimateNum;
		this.step = step;
		this.bindStatus = bindStatus;
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

	public Integer getValidDateType() {
		return validDateType;
	}

	public void setValidDateType(Integer validDateType) {
		this.validDateType = validDateType;
	}

	public Integer getActivityRole() {
		return activityRole;
	}

	public void setActivityRole(Integer activityRole) {
		this.activityRole = activityRole;
	}

	public Integer getIsForceCollect() {
		return isForceCollect;
	}

	public void setIsForceCollect(Integer isForceCollect) {
		this.isForceCollect = isForceCollect;
	}

	public Integer getIsArea() {
		return isArea;
	}

	public void setIsArea(Integer isArea) {
		this.isArea = isArea;
	}

	public String getAwardEndDate() {
		return awardEndDate;
	}

	public void setAwardEndDate(String awardEndDate) {
		this.awardEndDate = awardEndDate;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsIntegral() {
		return isIntegral;
	}

	public void setIsIntegral(Integer isIntegral) {
		this.isIntegral = isIntegral;
	}

	public Integer getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public String getActivityImgUrl() {
		return activityImgUrl;
	}

	public void setActivityImgUrl(String activityImgUrl) {
		this.activityImgUrl = activityImgUrl;
	}

	public Integer getUseIntegral() {
		return useIntegral;
	}

	public void setUseIntegral(Integer useIntegral) {
		this.useIntegral = useIntegral;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUnprizeIntegration() {
		return unprizeIntegration;
	}

	public void setUnprizeIntegration(Integer unprizeIntegration) {
		this.unprizeIntegration = unprizeIntegration;
	}

	public Integer getScanCount() {
		return scanCount;
	}

	public void setScanCount(Integer scanCount) {
		this.scanCount = scanCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Integer getUserDayMaxPrizeCount() {
		return userDayMaxPrizeCount;
	}

	public void setUserDayMaxPrizeCount(Integer userDayMaxPrizeCount) {
		this.userDayMaxPrizeCount = userDayMaxPrizeCount;
	}

	public Integer getUserMaxPrizeProcessType() {
		return userMaxPrizeProcessType;
	}

	public void setUserMaxPrizeProcessType(Integer userMaxPrizeProcessType) {
		this.userMaxPrizeProcessType = userMaxPrizeProcessType;
	}

	public Integer getUnactiviteProcessType() {
		return unactiviteProcessType;
	}

	public void setUnactiviteProcessType(Integer unactiviteProcessType) {
		this.unactiviteProcessType = unactiviteProcessType;
	}

	public Integer getFirstPrizeId() {
		return firstPrizeId;
	}

	public void setFirstPrizeId(Integer firstPrizeId) {
		this.firstPrizeId = firstPrizeId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getEstimateNum() {
		return estimateNum;
	}

	public void setEstimateNum(Integer estimateNum) {
		this.estimateNum = estimateNum;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Integer getBindStatus() {
		return bindStatus;
	}

	public void setBindStatus(Integer bindStatus) {
		this.bindStatus = bindStatus;
	}
    
    
    
}
