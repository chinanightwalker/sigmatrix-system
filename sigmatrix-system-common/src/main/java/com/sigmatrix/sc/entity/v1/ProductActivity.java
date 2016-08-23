package com.sigmatrix.sc.entity.v1;

import java.util.Date;


public class ProductActivity extends TablePrefix {
    private Integer id;

    private Integer activityId;

    private Integer productId;

    private Date createTime;

    private Date updateTime;

    private Integer createUserid;

    private Integer updateUserid;
    private ProductBase productBase;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

	public ProductBase getProductBase() {
		return productBase;
	}

	public void setProductBase(ProductBase productBase) {
		this.productBase = productBase;
	}
    
}
