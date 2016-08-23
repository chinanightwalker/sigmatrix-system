package com.sigmatrix.sc.entity.v1;

public class BoxPrizeCount extends TablePrefix {
    private String encryptBarcodeBLevel;

    private String id;

    private Integer prizeId;

    private Integer prizeCount;

    public String getEncryptBarcodeBLevel() {
        return encryptBarcodeBLevel;
    }

    public void setEncryptBarcodeBLevel(String encryptBarcodeBLevel) {
        this.encryptBarcodeBLevel = encryptBarcodeBLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getPrizeCount() {
        return prizeCount;
    }

    public void setPrizeCount(Integer prizeCount) {
        this.prizeCount = prizeCount;
    }
}
