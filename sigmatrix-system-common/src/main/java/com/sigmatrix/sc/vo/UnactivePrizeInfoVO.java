package com.sigmatrix.sc.vo;

import com.sigmatrix.sc.entity.v1.UnactivePrizeInfo;

/** 
 * @author  zln:
 * @date 创建时间：2016年8月9日 下午5:37:41 
 * @parameter   
 * @return 
 */
public class UnactivePrizeInfoVO {
	public UnactivePrizeInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private UnactivePrizeInfo unactivePrizeInfo;
	public UnactivePrizeInfo getUnactivePrizeInfo() {
		return unactivePrizeInfo;
	}
	public void setUnactivePrizeInfo(UnactivePrizeInfo unactivePrizeInfo) {
		this.unactivePrizeInfo = unactivePrizeInfo;
	}
	public String getEncryptBarcodeBLevelFl() {
		return encryptBarcodeBLevelFl;
	}
	public void setEncryptBarcodeBLevelFl(String encryptBarcodeBLevelFl) {
		this.encryptBarcodeBLevelFl = encryptBarcodeBLevelFl;
	}
	private String encryptBarcodeBLevelFl;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String prizeAmountStr;
	public String getPrizeAmountStr() {
		return prizeAmountStr;
	}
	public void setPrizeAmountStr(String prizeAmountStr) {
		this.prizeAmountStr = prizeAmountStr;
	}
}
