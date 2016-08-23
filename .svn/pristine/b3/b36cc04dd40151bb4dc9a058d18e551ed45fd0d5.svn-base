package com.sigmatrix.sc.service;

import java.util.Map;






import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.svcEntity.req.BidsBackUrlSvcReq;
import com.sigmatrix.sc.svcEntity.req.BidsServerSvcReq;
import com.sigmatrix.sc.svcEntity.req.BidsTimeRoundSvcReq;


public interface DibsService {


  /**
   * 
   * @Method: lotteryPrize
   * @Description: 生成零钱订单  并且向零钱宝发送求情
   * @param String prizeOrderId,Integer userID
   * @return JSONObject
   * @throws Exception 
   */
  JSONObject saveDibsAndSendDibsRequest(String prizeOrderId,Integer userID,BidsServerSvcReq bidsServerSvcReq) throws Exception;
  /**
   * 
   * @Method: updateState
   * @Description: 根据零钱宝返回信息 更新表的状态
   * @param BidsBackUrlSvcReq
   * @return JSONObject
   * @throws Exception 
   */
  JSONObject updateState(BidsBackUrlSvcReq bidsBackUrlVo) throws Exception;
  /**
   * 
   * @Method: ReSendMsgToBids
   * @Description: 首先查询零钱订单中的 零钱宝平台id是否存在 如果存在直接重定向到零钱宝   如果不存在那么重新申请平台id
   * @param prizeOrderId
   * @return JSONObject
   * @throws Exception 
   */
  
  JSONObject updateReSendMsgToBids(String prizeOrderId,Integer userID,BidsServerSvcReq bidsServerSvcReq) throws Exception;
  /**
   * 
   * @Method: updateBidsTableState
   * @Description:零钱宝不定期的向第三方发送请求  告知零钱的领取状态
   * @param bidsTimeRoundVo
   * @return Map
   * @throws Exception 
   */
  Map<String, Object> updateBidsTableState(BidsTimeRoundSvcReq bidsTimeRoundVo) throws Exception;
}
