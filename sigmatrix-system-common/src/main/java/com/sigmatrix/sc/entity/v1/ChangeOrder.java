package com.sigmatrix.sc.entity.v1;

import java.util.Date;

public class ChangeOrder extends TablePrefix {
    private String changeOrderId;

    private String prizeOrderId;

    private Integer activityId;

    private Integer userId;

    private Integer changeAmount;

    private Integer status;

    private String result;

    private String resultMsg;

    private String changePlatformOrderId;

    private Date createTime;

    private Date updateTime;

    public String getChangeOrderId() {
        return changeOrderId;
    }

    public void setChangeOrderId(String changeOrderId) {
        this.changeOrderId = changeOrderId;
    }

    public String getPrizeOrderId() {
        return prizeOrderId;
    }

    public void setPrizeOrderId(String prizeOrderId) {
        this.prizeOrderId = prizeOrderId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(Integer changeAmount) {
        this.changeAmount = changeAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getChangePlatformOrderId() {
        return changePlatformOrderId;
    }

    public void setChangePlatformOrderId(String changePlatformOrderId) {
        this.changePlatformOrderId = changePlatformOrderId;
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
