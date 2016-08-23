package com.sigmatrix.sc.utils;

import com.sigmatrix.sc.global.StateInfoEnum;

public class JsonEdit {
	
	private String statusCode = null;
	private String message = null;
	private String navTabId = null;
	private String callbackType = null;
	private String forwardUrl = null;
	private String errorCode = null;
	
	public JsonEdit() {
		super();
	}

  public JsonEdit(StateInfoEnum em, String forwardUrl) {
	    super();
	    this.statusCode = em.getRetCode();
	    this.message = em.getRetInfo();
	    this.navTabId = "system";
	    this.forwardUrl = forwardUrl;
	    initDefault();
	  }
	public JsonEdit(String statusCode, String message, String navTabId,
			String callbackType, String forwardUrl, String errorCode) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.navTabId = navTabId;
		this.callbackType = callbackType;
		this.forwardUrl = forwardUrl;
		this.errorCode = errorCode;
		initDefault();
	}
	
	private void initDefault() {
		if (statusCode==null) {
			statusCode = "";
		}
		if (message==null) {
			message = "";
		}
		if (navTabId==null) {
			navTabId = "";
		}
		if (callbackType==null) {
			callbackType = "";
		}
		if (forwardUrl==null) {
			forwardUrl = "";
		}
		if (errorCode==null) {
			errorCode = "";
		}
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	
}
