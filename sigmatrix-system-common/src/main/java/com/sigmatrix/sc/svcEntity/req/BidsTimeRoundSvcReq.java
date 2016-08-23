package com.sigmatrix.sc.svcEntity.req;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BidsTimeRoundSvcReq {
	@NotNull(message = "平台订单号不能为空！")
	private String platformOrder;
	@NotNull(message = "平台订单流水号不能为空！")
	private String serialNumber;
	@NotNull(message = "状态码不能为空！")
	private String orderResultCode;
	@NotNull(message = "状态信息不能为空")
	private String orderResultMsg;

	public String getPlatformOrder() {
		return platformOrder;
	}

	public void setPlatformOrder(String platformOrder) {
		this.platformOrder = platformOrder;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getOrderResultCode() {
		return orderResultCode;
	}

	public void setOrderResultCode(String orderResultCode) {
		this.orderResultCode = orderResultCode;
	}

	public String getOrderResultMsg() {
		return orderResultMsg;
	}

	public void setOrderResultMsg(String orderResultMsg) {
		this.orderResultMsg = orderResultMsg;
	}

	@Override
	public String toString() {
		return "BidsTimeRoundVo [platformOrder=" + platformOrder
				+ ", serialNumber=" + serialNumber + ", orderResultCode="
				+ orderResultCode + ", orderResultMsg=" + orderResultMsg + "]";
	}

}
