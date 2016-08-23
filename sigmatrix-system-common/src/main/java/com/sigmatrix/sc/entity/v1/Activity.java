package com.sigmatrix.sc.entity.v1;

import java.util.Date;

public class Activity extends TablePrefix {
    private Integer activityId;

    private Integer type;

    private Integer isIntegral;

    private Integer isArea;

    private Integer isOpen;

    private String activityImgUrl;

    private String activityTitle;

    private Date startDate;

    private Date endDate;

    private Date awardEndDate;

    private Integer isForceCollect;

    private Integer useIntegral;

    private Integer activityRole;

    private Date createTime;

    private Date updateTime;

    private Integer unprizeIntegration;

    private Integer scanCount;

    private Integer status;

    private String name;

    private String comments;

    private Integer templateId;

    private String picUrl;

    private String picPath;

    private Integer userDayMaxPrizeCount;

    private Integer userMaxPrizeProcessType;

    private Integer unactiviteProcessType;

    private Integer validDateType;

    private Integer firstPrizeId;

    private Integer accountId;

    private Integer estimateNum;

    private Integer step;

    private Integer bindStatus;

    private String firstPrizeIdName;
    
    public String getFirstPrizeIdName() {
		return firstPrizeIdName;
	}

	public void setFirstPrizeIdName(String firstPrizeIdName) {
		this.firstPrizeIdName = firstPrizeIdName;
	}

	public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public Integer getIsArea() {
        return isArea;
    }

    public void setIsArea(Integer isArea) {
        this.isArea = isArea;
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

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getAwardEndDate() {
        return awardEndDate;
    }

    public void setAwardEndDate(Date awardEndDate) {
        this.awardEndDate = awardEndDate;
    }

    public Integer getIsForceCollect() {
        return isForceCollect;
    }

    public void setIsForceCollect(Integer isForceCollect) {
        this.isForceCollect = isForceCollect;
    }

    public Integer getUseIntegral() {
        return useIntegral;
    }

    public void setUseIntegral(Integer useIntegral) {
        this.useIntegral = useIntegral;
    }

    public Integer getActivityRole() {
        return activityRole;
    }

    public void setActivityRole(Integer activityRole) {
        this.activityRole = activityRole;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
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

    public Integer getValidDateType() {
        return validDateType;
    }

    public void setValidDateType(Integer validDateType) {
        this.validDateType = validDateType;
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
