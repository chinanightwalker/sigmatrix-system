package com.sigmatrix.sc.entity.v1;

import java.util.Date;

public class BarcodeBLevelFl extends TablePrefix {
    private String encryptBarcodeBLevelFl;

    private Integer suppliersId;

    private Integer productId;

    private String boxBarcode;

    private String productionPlanCode;

    private String productionPlanFlCode;

    private Integer barcodeALevelNumber;

    private Integer activateStatus;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Date packingTime;

    private Date inTime;

    private Date outTime;

    private Integer warehouseId;

    private Integer dealersId;

    private Date activiteTime;

    public String getEncryptBarcodeBLevelFl() {
        return encryptBarcodeBLevelFl;
    }

    public void setEncryptBarcodeBLevelFl(String encryptBarcodeBLevelFl) {
        this.encryptBarcodeBLevelFl = encryptBarcodeBLevelFl;
    }

    public Integer getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Integer suppliersId) {
        this.suppliersId = suppliersId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getBoxBarcode() {
        return boxBarcode;
    }

    public void setBoxBarcode(String boxBarcode) {
        this.boxBarcode = boxBarcode;
    }

    public String getProductionPlanCode() {
        return productionPlanCode;
    }

    public void setProductionPlanCode(String productionPlanCode) {
        this.productionPlanCode = productionPlanCode;
    }

    public String getProductionPlanFlCode() {
        return productionPlanFlCode;
    }

    public void setProductionPlanFlCode(String productionPlanFlCode) {
        this.productionPlanFlCode = productionPlanFlCode;
    }

    public Integer getBarcodeALevelNumber() {
        return barcodeALevelNumber;
    }

    public void setBarcodeALevelNumber(Integer barcodeALevelNumber) {
        this.barcodeALevelNumber = barcodeALevelNumber;
    }

    public Integer getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(Integer activateStatus) {
        this.activateStatus = activateStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getPackingTime() {
        return packingTime;
    }

    public void setPackingTime(Date packingTime) {
        this.packingTime = packingTime;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getDealersId() {
        return dealersId;
    }

    public void setDealersId(Integer dealersId) {
        this.dealersId = dealersId;
    }

    public Date getActiviteTime() {
        return activiteTime;
    }

    public void setActiviteTime(Date activiteTime) {
        this.activiteTime = activiteTime;
    }
}
