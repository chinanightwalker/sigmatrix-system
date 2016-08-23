package com.sigmatrix.sc.entity.v1;

import java.util.Date;

public class BarcodeALevel extends TablePrefix {
    private String encryptBarcodeALevel;

    private Integer enterpriseId;

    private Integer productId;

    private String encryptBarcodeBLevel;

    private String outsideCode;

    private String inputCode;

    private String barcode;

    private Integer validationNumber;

    private Integer queryNumber;

    private Date firstValidationTime;

    private Date lastValidationTime;

    private Integer continueValidationNumber;

    private Integer activateStatus;

    private Integer isStatus;

    private Date createTime;

    private Date errorLastValidationTime;

    private String batchCode;

    private String encryptBarcodeBLevelFl;

    private Date updateTime;

    public String getEncryptBarcodeALevel() {
        return encryptBarcodeALevel;
    }

    public void setEncryptBarcodeALevel(String encryptBarcodeALevel) {
        this.encryptBarcodeALevel = encryptBarcodeALevel;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getEncryptBarcodeBLevel() {
        return encryptBarcodeBLevel;
    }

    public void setEncryptBarcodeBLevel(String encryptBarcodeBLevel) {
        this.encryptBarcodeBLevel = encryptBarcodeBLevel;
    }

    public String getOutsideCode() {
        return outsideCode;
    }

    public void setOutsideCode(String outsideCode) {
        this.outsideCode = outsideCode;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getValidationNumber() {
        return validationNumber;
    }

    public void setValidationNumber(Integer validationNumber) {
        this.validationNumber = validationNumber;
    }

    public Integer getQueryNumber() {
        return queryNumber;
    }

    public void setQueryNumber(Integer queryNumber) {
        this.queryNumber = queryNumber;
    }

    public Date getFirstValidationTime() {
        return firstValidationTime;
    }

    public void setFirstValidationTime(Date firstValidationTime) {
        this.firstValidationTime = firstValidationTime;
    }

    public Date getLastValidationTime() {
        return lastValidationTime;
    }

    public void setLastValidationTime(Date lastValidationTime) {
        this.lastValidationTime = lastValidationTime;
    }

    public Integer getContinueValidationNumber() {
        return continueValidationNumber;
    }

    public void setContinueValidationNumber(Integer continueValidationNumber) {
        this.continueValidationNumber = continueValidationNumber;
    }

    public Integer getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(Integer activateStatus) {
        this.activateStatus = activateStatus;
    }

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getErrorLastValidationTime() {
        return errorLastValidationTime;
    }

    public void setErrorLastValidationTime(Date errorLastValidationTime) {
        this.errorLastValidationTime = errorLastValidationTime;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getEncryptBarcodeBLevelFl() {
        return encryptBarcodeBLevelFl;
    }

    public void setEncryptBarcodeBLevelFl(String encryptBarcodeBLevelFl) {
        this.encryptBarcodeBLevelFl = encryptBarcodeBLevelFl;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
