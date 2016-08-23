package com.sigmatrix.sc.global;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author 海龙
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BaseResponse extends Response {

	public BaseResponse() {
	}

	public BaseResponse(String resultState, String resultMsg) {
		this.resultState = resultState;
		this.resultMsg = resultMsg;
	}

	public BaseResponse(String resultState, String resultMsg, Object resultList) {
		this.resultState = resultState;
		this.resultMsg = resultMsg;
		this.resultList = resultList;
	}

	public BaseResponse(StateInfoEnum StateInfoEnum) {
		this.resultState = StateInfoEnum.getRetCode();
		this.resultMsg = StateInfoEnum.getRetInfo();
	}

	public BaseResponse(StateInfoEnum StateInfoEnum, Object resultList) {
		this.resultState = StateInfoEnum.getRetCode();
		this.resultMsg = StateInfoEnum.getRetInfo();
		this.resultList = resultList;
	}

	public BaseResponse(StateInfoEnum StateInfoEnum, String msg, Object resultList) {
		this.resultState = StateInfoEnum.getRetCode();
		this.resultMsg = StateInfoEnum.getRetInfo() + "！"+msg;
		this.resultList = resultList;
	}
	
	public BaseResponse(StateInfoEnum StateInfoEnum, String msg) {
		this.resultState = StateInfoEnum.getRetCode();
		this.resultMsg = StateInfoEnum.getRetInfo() +"！"+ msg;
	}

	
	private Object resultList;

	

	public Object getResultList() {
		return resultList;
	}

	public void setResultList(Object resultList) {
		this.resultList = resultList;
	}

	@Override
	public String toString() {
		return "BaseResponse [resultState=" + resultState + ", resultMsg=" + resultMsg + ", resultList=" + resultList
				+ "]";
	}

}
