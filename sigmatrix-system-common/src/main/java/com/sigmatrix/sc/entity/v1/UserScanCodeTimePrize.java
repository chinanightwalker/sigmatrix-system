package com.sigmatrix.sc.entity.v1;

import java.util.Date;

public class UserScanCodeTimePrize extends TablePrefix {
    private Integer scanTimePrizeId;

    private String scanTimePrizeName;

    private Integer useScanTime;

    private Integer scanTimePrizeType;

    private Integer scanTimePrizeAmount;

    private Integer status;

    private String prizePicUrl;

    private String prizePicPath;

    private Integer luckyCount;

    private Date createTime;

    private Date updateTime;

    public Integer getScanTimePrizeId() {
        return scanTimePrizeId;
    }

    public void setScanTimePrizeId(Integer scanTimePrizeId) {
        this.scanTimePrizeId = scanTimePrizeId;
    }

    public String getScanTimePrizeName() {
        return scanTimePrizeName;
    }

    public void setScanTimePrizeName(String scanTimePrizeName) {
        this.scanTimePrizeName = scanTimePrizeName;
    }

    public Integer getUseScanTime() {
        return useScanTime;
    }

    public void setUseScanTime(Integer useScanTime) {
        this.useScanTime = useScanTime;
    }

    public Integer getScanTimePrizeType() {
        return scanTimePrizeType;
    }

    public void setScanTimePrizeType(Integer scanTimePrizeType) {
        this.scanTimePrizeType = scanTimePrizeType;
    }

    public Integer getScanTimePrizeAmount() {
        return scanTimePrizeAmount;
    }

    public void setScanTimePrizeAmount(Integer scanTimePrizeAmount) {
        this.scanTimePrizeAmount = scanTimePrizeAmount;
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
}
