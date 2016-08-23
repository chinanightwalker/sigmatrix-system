package com.sigmatrix.sc.vo;

import java.util.Date;

import com.sigmatrix.sc.entity.v1.BarcodePrizeConsumer;



public class BarcodePrizeConsumerVO{
	
	private BarcodePrizeConsumer barcodePrizeConsumer;
	

    public BarcodePrizeConsumer getBarcodePrizeConsumer() {
		return barcodePrizeConsumer;
	}

	public void setBarcodePrizeConsumer(BarcodePrizeConsumer barcodePrizeConsumer) {
		this.barcodePrizeConsumer = barcodePrizeConsumer;
	}

	//添加activityName,productName,prizeAmountStr,userName 4个字段vo
    private String activityName;    
	private String productName;
	private String prizeAmountStr;
	private String userName;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrizeAmountStr() {
		return prizeAmountStr;
	}

	public void setPrizeAmountStr(String prizeAmountStr) {
		this.prizeAmountStr = prizeAmountStr;
	}
	
	private String prizeAmountXianjinStr;


	public String getPrizeAmountXianjinStr() {
		return prizeAmountXianjinStr;
	}

	public void setPrizeAmountXianjinStr(String prizeAmountXianjinStr) {
		this.prizeAmountXianjinStr = prizeAmountXianjinStr;
	}
}
