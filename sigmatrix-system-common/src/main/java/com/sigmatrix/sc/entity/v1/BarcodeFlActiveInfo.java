package com.sigmatrix.sc.entity.v1;

import java.util.Date;

public class BarcodeFlActiveInfo extends TablePrefix {
    private Integer barcodeFlActiveInfo;

    private Integer avtiveInfoId;

    private Date avtivateTime;

    private String usercode;

    private String username;

    private String plancode;

    private Integer activateStatus;

    private String barcodeBLevelFl;

    private String activateResult;

    public Integer getBarcodeFlActiveInfo() {
        return barcodeFlActiveInfo;
    }

    public void setBarcodeFlActiveInfo(Integer barcodeFlActiveInfo) {
        this.barcodeFlActiveInfo = barcodeFlActiveInfo;
    }

    public Integer getAvtiveInfoId() {
        return avtiveInfoId;
    }

    public void setAvtiveInfoId(Integer avtiveInfoId) {
        this.avtiveInfoId = avtiveInfoId;
    }

    public Date getAvtivateTime() {
        return avtivateTime;
    }

    public void setAvtivateTime(Date avtivateTime) {
        this.avtivateTime = avtivateTime;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlancode() {
        return plancode;
    }

    public void setPlancode(String plancode) {
        this.plancode = plancode;
    }

    public Integer getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(Integer activateStatus) {
        this.activateStatus = activateStatus;
    }

    public String getBarcodeBLevelFl() {
        return barcodeBLevelFl;
    }

    public void setBarcodeBLevelFl(String barcodeBLevelFl) {
        this.barcodeBLevelFl = barcodeBLevelFl;
    }

    public String getActivateResult() {
        return activateResult;
    }

    public void setActivateResult(String activateResult) {
        this.activateResult = activateResult;
    }
}
