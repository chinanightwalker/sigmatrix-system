package com.sigmatrix.sc.svcEntity.req;


import org.codehaus.jackson.map.annotate.JsonSerialize;
/*
 * 当零钱宝的回调时候会返回的信息
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BidsBackUrlSvcReq {
  private String PlatformOrder;
  private String ResultCode;
  private String  ResultMsg;
  private String serialNumber;
  public String getPlatformOrder() {
    return PlatformOrder;
  }
  public void setPlatformOrder(String platformOrder) {
    PlatformOrder = platformOrder;
  }
  public String getResultCode() {
    return ResultCode;
  }
  public void setResultCode(String resultCode) {
    ResultCode = resultCode;
  }
  public String getResultMsg() {
    return ResultMsg;
  }
  public void setResultMsg(String resultMsg) {
    ResultMsg = resultMsg;
  }
  public String getserialNumber() {
    return serialNumber;
  }
  public void setserialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }
  @Override
  public String toString() {
    return "BidsBackUrlVo [PlatformOrder=" + PlatformOrder + ", ResultCode=" + ResultCode + ", ResultMsg=" + ResultMsg
        + ", serialNumber=" + serialNumber + "]";
  }

  
  
}
