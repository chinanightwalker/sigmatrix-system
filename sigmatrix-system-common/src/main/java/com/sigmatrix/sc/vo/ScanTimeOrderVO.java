package com.sigmatrix.sc.vo;

import com.sigmatrix.sc.entity.v1.ScanTimeOrder;

public class ScanTimeOrderVO{
    private ScanTimeOrder scanTimeOrder;
    
    public ScanTimeOrder getScanTimeOrder() {
		return scanTimeOrder;
	}

	public void setScanTimeOrder(ScanTimeOrder scanTimeOrder) {
		this.scanTimeOrder = scanTimeOrder;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName;
	private String openId;
	private String scanTimePrizeName;

	public String getScanTimePrizeName() {
		return scanTimePrizeName;
	}

	public void setScanTimePrizeName(String scanTimePrizeName) {
		this.scanTimePrizeName = scanTimePrizeName;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
