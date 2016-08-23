package com.sigmatrix.sc.entity.v1;

import java.util.Date;

public class CashCouponRecord extends TablePrefix {
    private Integer id;

    private Integer cashPrizeId;

    private Integer cashPrizeAmount;

    private String getPrizeOrderId;

    private String prizeOrderId;

    private Integer userId;

    private String openId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCashPrizeId() {
        return cashPrizeId;
    }

    public void setCashPrizeId(Integer cashPrizeId) {
        this.cashPrizeId = cashPrizeId;
    }

    public Integer getCashPrizeAmount() {
        return cashPrizeAmount;
    }

    public void setCashPrizeAmount(Integer cashPrizeAmount) {
        this.cashPrizeAmount = cashPrizeAmount;
    }

    public String getGetPrizeOrderId() {
        return getPrizeOrderId;
    }

    public void setGetPrizeOrderId(String getPrizeOrderId) {
        this.getPrizeOrderId = getPrizeOrderId;
    }

    public String getPrizeOrderId() {
        return prizeOrderId;
    }

    public void setPrizeOrderId(String prizeOrderId) {
        this.prizeOrderId = prizeOrderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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
}
