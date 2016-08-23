package com.sigmatrix.sc.svcEntity.req;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @Description: 抽奖请求实体
 * @author zzw
 * @date 2016年2月24日 下午2:53:49
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class LotteryPrizeSvcReq implements Serializable {
	private static final long serialVersionUID = 4643203106445649745L;
	
	private String qrCode;//抽奖吗 扫码 输入
	private String codeType;//码类型 1-扫码  2-输入码
	private String clientType;//客户端类型
	//加密后的
	private String aCode;//一级码
	private String inputCode;//输入码
	//用户扫码输入
	private String userACode;
	private String userInputCode;
	private String openId;
	private Integer userId;
	private String custFirstScan;//用户是否是首次扫码
	private String notWinWay; //未中奖是否需要处理
	private String lotteryWayNoWin;//未中奖 抽奖方式
	private String lotteryWayNoAct;//一级码未激活 抽奖方式
	private String projectFlag;//项目标识
	
	public LotteryPrizeSvcReq() {
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getCustFirstScan() {
		return custFirstScan;
	}

	public void setCustFirstScan(String custFirstScan) {
		this.custFirstScan = custFirstScan;
	}

	public String getaCode() {
		return aCode;
	}

	public void setaCode(String aCode) {
		this.aCode = aCode;
	}

	public String getUserACode() {
		return userACode;
	}

	public void setUserACode(String userACode) {
		this.userACode = userACode;
	}

	public String getUserInputCode() {
		return userInputCode;
	}

	public void setUserInputCode(String userInputCode) {
		this.userInputCode = userInputCode;
	}
	
	public String getNotWinWay() {
		return notWinWay;
	}

	public void setNotWinWay(String notWinWay) {
		this.notWinWay = notWinWay;
	}
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

	public String getProjectFlag() {
		return projectFlag;
	}

	public void setProjectFlag(String projectFlag) {
		this.projectFlag = projectFlag;
	}

	public String getLotteryWayNoWin() {
		return lotteryWayNoWin;
	}

	public void setLotteryWayNoWin(String lotteryWayNoWin) {
		this.lotteryWayNoWin = lotteryWayNoWin;
	}

	public String getLotteryWayNoAct() {
		return lotteryWayNoAct;
	}

	public void setLotteryWayNoAct(String lotteryWayNoAct) {
		this.lotteryWayNoAct = lotteryWayNoAct;
	}

	@Override
	public String toString() {
		return "LotteryPrizeSvcReq [qrCode=" + qrCode + ", codeType=" + codeType + ", clientType=" + clientType
				+ ", aCode=" + aCode + ", inputCode=" + inputCode + ", userACode=" + userACode + ", userInputCode="
				+ userInputCode + ", openId=" + openId + ", userId=" + userId + ", custFirstScan=" + custFirstScan
				+ ", notWinWay=" + notWinWay + ", lotteryWayNoWin=" + lotteryWayNoWin + ", lotteryWayNoAct="
				+ lotteryWayNoAct + ", projectFlag=" + projectFlag + "]";
	}

}
