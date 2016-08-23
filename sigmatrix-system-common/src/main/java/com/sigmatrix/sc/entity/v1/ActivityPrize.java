package com.sigmatrix.sc.entity.v1;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ActivityPrize extends TablePrefix {
    private Integer prizeId;

    private Integer activityId;

    private String prizeName;

    private Integer isBoxPrize;

    private Integer prizeType;

    private String prizeDesc;

    private String prizeGetAddress;

    private Float prizeRate;

    private Integer integration;

    private Integer prizeCount;

    private Integer prizeAmount;

    private Float isFirstPrizeRate;

    private Integer luckyCount;

    private Date createTime;

    private Date updateTime;

    private Integer createUserid;

    private Integer updateUserid;

    private Integer productId;

    private Integer status;

    private String prizePicUrl;

    private String prizePicPath;

    private Integer redBagType;

    private Integer minAmount;

    private Integer maxAmount;

    private Integer firstMinAmount;

    private Long prizeLuckyAmount;

    private Long prizeTotalAmount;

    private Integer prizeForciblyCount;

    private Integer prizeForciblyAmount;

    private String redbagHint;

    //直接在date类型上加入注解，同时指定格式样式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Integer prizePeriodMode;

    private Integer prizePeriodCount;

    private String timeslotInfo;

    private Integer validDays;

    private Integer cashGetMinPrizeAmount;

    private Integer prizeFactor;

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Integer getIsBoxPrize() {
        return isBoxPrize;
    }

    public void setIsBoxPrize(Integer isBoxPrize) {
        this.isBoxPrize = isBoxPrize;
    }

    public Integer getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }

    public String getPrizeDesc() {
        return prizeDesc;
    }

    public void setPrizeDesc(String prizeDesc) {
        this.prizeDesc = prizeDesc;
    }

    public String getPrizeGetAddress() {
        return prizeGetAddress;
    }

    public void setPrizeGetAddress(String prizeGetAddress) {
        this.prizeGetAddress = prizeGetAddress;
    }

    public Float getPrizeRate() {
        return prizeRate;
    }

    public void setPrizeRate(Float prizeRate) {
        this.prizeRate = prizeRate;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getPrizeCount() {
        return prizeCount;
    }

    public void setPrizeCount(Integer prizeCount) {
        this.prizeCount = prizeCount;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(Integer prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public Float getIsFirstPrizeRate() {
        return isFirstPrizeRate;
    }

    public void setIsFirstPrizeRate(Float isFirstPrizeRate) {
        this.isFirstPrizeRate = isFirstPrizeRate;
    }

    public Integer getLuckyCount() {
        return luckyCount;
    }

    public void setLuckyCount(Integer luckyCount) {
        this.luckyCount = luckyCount;
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

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public Integer getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Integer updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrizePicUrl() {
        return prizePicUrl;
    }

    public void setPrizePicUrl(String prizePicUrl) {
        this.prizePicUrl = prizePicUrl;
    }

    public String getPrizePicPath() {
        return prizePicPath;
    }

    public void setPrizePicPath(String prizePicPath) {
        this.prizePicPath = prizePicPath;
    }

    public Integer getRedBagType() {
        return redBagType;
    }

    public void setRedBagType(Integer redBagType) {
        this.redBagType = redBagType;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getFirstMinAmount() {
        return firstMinAmount;
    }

    public void setFirstMinAmount(Integer firstMinAmount) {
        this.firstMinAmount = firstMinAmount;
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

    public Integer getPrizeForciblyCount() {
        return prizeForciblyCount;
    }

    public void setPrizeForciblyCount(Integer prizeForciblyCount) {
        this.prizeForciblyCount = prizeForciblyCount;
    }

    public Integer getPrizeForciblyAmount() {
        return prizeForciblyAmount;
    }

    public void setPrizeForciblyAmount(Integer prizeForciblyAmount) {
        this.prizeForciblyAmount = prizeForciblyAmount;
    }

    public String getRedbagHint() {
        return redbagHint;
    }

    public void setRedbagHint(String redbagHint) {
        this.redbagHint = redbagHint;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPrizePeriodMode() {
        return prizePeriodMode;
    }

    public void setPrizePeriodMode(Integer prizePeriodMode) {
        this.prizePeriodMode = prizePeriodMode;
    }

    public Integer getPrizePeriodCount() {
        return prizePeriodCount;
    }

    public void setPrizePeriodCount(Integer prizePeriodCount) {
        this.prizePeriodCount = prizePeriodCount;
    }

    public String getTimeslotInfo() {
        return timeslotInfo;
    }

    public void setTimeslotInfo(String timeslotInfo) {
        this.timeslotInfo = timeslotInfo;
    }

    public Integer getValidDays() {
        return validDays;
    }

    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
    }

    public Integer getCashGetMinPrizeAmount() {
        return cashGetMinPrizeAmount;
    }

    public void setCashGetMinPrizeAmount(Integer cashGetMinPrizeAmount) {
        this.cashGetMinPrizeAmount = cashGetMinPrizeAmount;
    }

    public Integer getPrizeFactor() {
        return prizeFactor;
    }

    public void setPrizeFactor(Integer prizeFactor) {
        this.prizeFactor = prizeFactor;
    }
}
