package com.sigmatrix.sc.svcEntity.res;

import java.util.Date;

public class QDOpenIDANDCookie {
	/** 公众号 */
	private String openID;
	/** 获取授权的url */
	private String url;
	/** 0:拉取授权失败；1：拉取授权成功;-1:未进行拉取授权操作 */
	private Integer status =-1;
	/** 分页时间标识 */
	private Date createTime;
	
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
}
