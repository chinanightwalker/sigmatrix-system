package com.sigmatrix.sc.entity.v1;

import java.util.Date;

public class UserDayPrize extends TablePrefix {
    private Integer id;

    private Integer userId;

    private Integer activityId;

    private Date lastPrizeTime;

    private Integer prizeCount;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Date getLastPrizeTime() {
        return lastPrizeTime;
    }

    public void setLastPrizeTime(Date lastPrizeTime) {
        this.lastPrizeTime = lastPrizeTime;
    }

    public Integer getPrizeCount() {
        return prizeCount;
    }

    public void setPrizeCount(Integer prizeCount) {
        this.prizeCount = prizeCount;
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
