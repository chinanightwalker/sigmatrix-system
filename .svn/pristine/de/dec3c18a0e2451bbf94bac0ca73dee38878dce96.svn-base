//package com.sigmatrix.sc.service.impl;
//
//
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLContextBuilder;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.github.pagehelper.StringUtil;
//import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityPrizeMapper;
//import com.sigmatrix.sc.dao.mapper.v1.auto.BarcodePrizeConsumerMapper;
//import com.sigmatrix.sc.dao.mapper.v1.auto.ChangeOrderMapper;
//import com.sigmatrix.sc.dao.mapper.v1.auto.ChangeOrderRecordMapper;
//import com.sigmatrix.sc.dao.mapper.v1.auto.UserPrizeTotalMapper;
//import com.sigmatrix.sc.entity.v1.ActivityPrize;
//import com.sigmatrix.sc.entity.v1.BarcodePrizeConsumer;
//import com.sigmatrix.sc.entity.v1.BarcodePrizeConsumerExample;
//import com.sigmatrix.sc.entity.v1.ChangeOrder;
//import com.sigmatrix.sc.entity.v1.ChangeOrderExample;
//import com.sigmatrix.sc.entity.v1.ChangeOrderRecord;
//import com.sigmatrix.sc.entity.v1.UserPrizeTotal;
//import com.sigmatrix.sc.global.StateInfoEnum;
//import com.sigmatrix.sc.global.WebConstants;
//import com.sigmatrix.sc.service.DibsService;
//import com.sigmatrix.sc.svcEntity.req.BidsBackUrlSvcReq;
//import com.sigmatrix.sc.svcEntity.req.BidsServerSvcReq;
//import com.sigmatrix.sc.svcEntity.req.BidsTimeRoundSvcReq;
//import com.sigmatrix.sc.utils.CommonUtils;
//import com.sigmatrix.sc.utils.DecryptDes;
//import com.sigmatrix.sc.utils.HttpClientUtil;
//@Service
//public class DibsServiceImpl implements DibsService{
//  private static Logger logger=Logger.getLogger(DibsServiceImpl.class);
//  @Autowired
//  private ChangeOrderMapper changeOrderMapper;
//  @Autowired
//  private ChangeOrderRecordMapper changeOrderRecordMapper;
//  @Autowired
//  private ActivityPrizeMapper activityPrizeMapper;
//  @Autowired
//  private UserPrizeTotalMapper userPrizeTotalMapper;
//  @Autowired
//  private BarcodePrizeConsumerMapper barcodePrizeConsumerMapper;
//  
//  @Value("${BIDS_PLATFORM_SID}")
//  private String BIDS_PLATFORM_SID;//零钱罐平台id
//  @Value("${DECODE_STRING_KEY}")
//  private String DECODE_STRING_KEY;//加密密钥
//  @Value("${QUERY_BIDS_URL}")
//  private String QUERY_BIDS_URL;//查询地址
//  
//  @Value("${BIDS_ACTIVITY_DESC}")
//  private String BIDS_ACTIVITY_DESC;//红包描述
//  
//  private String tablePrefix="_scld001";//表名前缀
//  
//  /**
//   * 
//   * @Method: saveDibsAndSendDibsRequest
//   * @Description: 插入零钱订单 并且零钱宝请求平台订单
//   * @param Integer prizeOrderId
//   * @return ModelAndView
//   * @author Wy
//   * @throws Exception 
//   * @throws  
//   * @date 2016年4月19日15:19:43
//   */
//  @Override
//  public JSONObject saveDibsAndSendDibsRequest(String prizeOrderId,Integer userID,BidsServerSvcReq bidsServerSvcReq) throws Exception  {
//	JSONObject result = new JSONObject();
//    //放置重复点击   进入方法的时候首先查一下 这条数据的状态  如果是已经兑奖成功的话 那么就不让点击 直接跳转页面
//    ChangeOrderExample ex=new ChangeOrderExample();
//    ex.setTablePrefix(tablePrefix);
//    ex.createCriteria().andPrizeOrderIdEqualTo(prizeOrderId);
//    
//    List<ChangeOrder> list=changeOrderMapper.selectByExample(ex);
//    //首先根据prizeOrderId查询订单信息
//    BarcodePrizeConsumer barcodePrizeConsumer=null; 
//    barcodePrizeConsumer = barcodePrizeConsumerMapper.selectByPrimaryKey(prizeOrderId,tablePrefix);
//    if(barcodePrizeConsumer==null){
//    	logger.info("======================查询兑换记录表查询为空！prizeOrderId="+prizeOrderId);
//        result.put("response",StateInfoEnum.SYSTEM_ERROR);
//        result.put("activityId", "");
//        return result;
//    }
//    result.put("activityId", barcodePrizeConsumer.getActivityId());
//    ActivityPrize ap =activityPrizeMapper.selectByPrimaryKey(barcodePrizeConsumer.getPrizeId(),tablePrefix);
//    if(ap==null){
//    	logger.info("======================奖项设置为空，对应！barcodePrizeConsumer="+JSONObject.toJSONString(barcodePrizeConsumer));
//        result.put("response",StateInfoEnum.SYSTEM_ERROR);
//        return result;
//    }else{
//    	if(StringUtil.isEmpty(ap.getRedbagHint())){
//    		result.put("tishi",WebConstants.HONGBAO_TISHI);
//    	}else{
//    		result.put("tishi",ap.getRedbagHint());
//    	}
//    }
//    
//    if(!CollectionUtils.isEmpty(list)){
//		for (ChangeOrder o : list) {
//			if (o.getStatus() == WebConstants.BIDS_RED_SEND_SUCCESS) {
//				logger.info("====================查到本地零钱订单信息，状态为已经存入零钱宝");
//					// 默认只有一条对应数据
//				result.put("hongbao", String.format("%.2f", (double) list
//							.get(0).getChangeAmount() / 100));
//				result.put("response",StateInfoEnum.SUCCESS);
//				return result;
//			}
//		}
//		logger.info("=====================查询本地零钱订单信息为存入零钱宝！");
//		// 如果没申请成功就重新申请
//		result = updateReSendMsgToBids(prizeOrderId, userID,bidsServerSvcReq);
//		return result;
//    }
//    //根据订单查不到信息，先根据传来的userID查出是否是第一次进入零钱宝
//    boolean isFirst = checkIsFirst(userID);
//    
//   
//    ChangeOrder changeOrder=new ChangeOrder();
//    ChangeOrderRecord orderRecorde=new ChangeOrderRecord();
//    //生成零钱的订单主键     在插入零钱订单的同时 也要插入到订单流水表中的数据
//    changeOrder.setChangeOrderId(CommonUtils.getBusinessOrderID("lq"));//生成零钱订单主键
//    changeOrder.setPrizeOrderId(barcodePrizeConsumer.getPrizeOrderId());
//    changeOrder.setActivityId(barcodePrizeConsumer.getActivityId());
//
//    if(barcodePrizeConsumer.getUserId()!=null&&!barcodePrizeConsumer.getUserId().equals("")){
//      changeOrder.setUserId(Integer.parseInt(barcodePrizeConsumer.getUserId()));
//    }
//    changeOrder.setChangeAmount(barcodePrizeConsumer.getPrizeAmount());
//    changeOrder.setStatus(WebConstants.BIDS_UN_TAKE);
//    changeOrder.setCreateTime(new Date());
//    changeOrder.setUpdateTime(new Date());
//    
//    
//    orderRecorde.setPayId(CommonUtils.getBusinessOrderID("ddlsh"));//生成订单流水号
//    orderRecorde.setChangeOrderId(changeOrder.getChangeOrderId());
//    orderRecorde.setStatus(WebConstants.BIDS_UN_TAKE);
//    orderRecorde.setCreateTime(new Date());
//    orderRecorde.setUpdateTime(new Date());              
//    Map map=null;
//    try {
//      map = SendMsgToDibsInterface(changeOrder,barcodePrizeConsumer.getUserPhone(),bidsServerSvcReq);
//      //零钱宝接口调用失败时候也要继续下去
//      if(map!=null&&map.get("returnCode")!=null&&!map.get("returnCode").toString().equals(StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//        logger.info("===============零钱宝接口调用失败！失败原因"+map.get("returnMsg"));
//        changeOrder.setResult(WebConstants.BIDS_STATUS_UNSAVE.toString());
//        changeOrder.setResultMsg(map.get("returnMsg").toString());
//        
//        orderRecorde.setResultCode(map.get("returnCode").toString());
//        orderRecorde.setResultMsg(map.get("returnMsg").toString());
//      }else if(map!=null&&map.get("returnCode")!=null){
//        logger.info("===============零钱宝接口调用成功！零钱宝订单号为PlatformOrder");
//        changeOrder.setChangePlatformOrderId(map.get("platformOrder").toString());
//        changeOrder.setResult(WebConstants.BIDS_STATUS_SAVED.toString());
//        changeOrder.setResultMsg(map.get("returnMsg").toString());
//        
//        orderRecorde.setChangePlatformOrderId(map.get("platformOrder").toString());
//        orderRecorde.setResultCode(map.get("returnCode").toString());
//        orderRecorde.setResultMsg(map.get("returnMsg").toString());
//      }else{
//        logger.info("==================零钱宝接口调用失败！无返回信息！");
//      }
//    } catch (Exception e1) {
//      logger.info("==================零钱宝接口调用失败！错误原因："+e1.getMessage());
//    }
//    
//    //插入零钱流水号表
//    orderRecorde.setTablePrefix(tablePrefix);
//    int resultInt=changeOrderRecordMapper.insert(orderRecorde);
//    if(resultInt>0){
//      logger.info("===============插入订单流水表成功！orderRecorde="+orderRecorde);
//    }else{
//      logger.info("===============插入订单流水表失败！orderRecorde="+orderRecorde);
//      result.put("response",StateInfoEnum.SYSTEM_ERROR);
////      mav.setViewName(WebConstants.QD_TEMP_PATH+"/lotteryPrizeCommonError");
//      return result;
//    }
//    
//    
//    //插入零钱订单表
//    changeOrder.setTablePrefix(tablePrefix);
//    int resultState= changeOrderMapper.insert(changeOrder);
//    if(resultState>0){
//      logger.info("===============插入零钱订单表成功！ "+changeOrder.toString());
//    }else{
//      logger.info("===============插入零钱订单表失败！ "+changeOrder.toString());
//      throw new Exception("零钱订单插入成功！零钱流水订单插入失败，手动抛异常回滚零钱订单！  ");
//    }
//   
//    
//   if(map!=null&&map.get("returnCode")!=null&&map.get("returnCode").toString().equals(StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//     try {
//    	 //成功跳转页面
////       String backStr="orderId="+URLEncoder.encode(DecryptDes.encrypt(map.get("platformOrder").toString(),DECODE_STRING_KEY),"utf-8")
////       +"&serialNumber="+URLEncoder.encode(DecryptDes.encrypt(orderRecorde.getPayId(),DECODE_STRING_KEY),"utf-8")+"&backType="
////           +URLEncoder.encode(DecryptDes.encrypt(isFirst==false?WebConstants.REDIRECT_BACKTYPE_VALUE_1:WebConstants.REDIRECT_BACKTYPE_VALUE_2,DECODE_STRING_KEY),"utf-8")+"&sid="+BIDS_PLATFORM_SID;
////       mav.setViewName("redirect:"+REDIRECT_URL+"/sendRed/sendRedProcess?"+backStr);
//      logger.info("====================重定向参数："+map);
//    	 result.put("response",StateInfoEnum.SUCCESS);
//    	 result.put("redirect","lingqianbao");
//    	 result.put("platformOrder",map.get("platformOrder").toString());
//    	 result.put("payId",orderRecorde.getPayId());
//    	 result.put("isFirst",isFirst);
//    	 logger.info("====================重定向参数：229"+JSONObject.toJSONString(result));
//    	 return result;
//     } catch (Exception e) {
//       //调用失败的时候也不能回滚  事物要继续下去
//      logger.error("===================重定向到零钱宝页面失败！");
//      logger.error(e);
//     }
//   }
//   logger.info("====================重定向参数236："+map);
//   //转发失败的时候也要插入每条的信息
//   result.put("response",StateInfoEnum.SYSTEM_ERROR);
////   mav.setViewName(WebConstants.QD_TEMP_PATH+"/lotteryPrizeCommonError");
//   logger.info("=======================重定向零钱宝失败！！");
//   return result;
//  }
//  
//  //在进入到零钱宝之前查一下是不是第一次进入零钱宝
//  private boolean checkIsFirst(Integer userID) {
//    ChangeOrderExample ex=new ChangeOrderExample();
//    ex.setTablePrefix(tablePrefix);
//    ex.createCriteria().andUserIdEqualTo(userID);
//    List<ChangeOrder>orders=changeOrderMapper.selectByExample(ex);
//    boolean ret=true;
//    if(!CollectionUtils.isEmpty(orders)){
//      for(ChangeOrder o:orders){
//        if(o.getChangePlatformOrderId()!=null){
//          ret=false;
//        }
//      }
//    }
//    return ret;
//       
//  }
//  /**
//   * 
//   * @Method: SendMsgToDibsInterface
//   * @Description: 向零钱宝发送信息 得到零钱宝订单号
//   * @param Sid
//   * @param TPOrder
//   * @param Amount
//   * @param Desc
//   * @param Phone
//   * @param BackUrl
//   * @return ModelAndView
//   * @author Wy
//   * @throws MalformedURLException 
//   * @throws Exception 
//   * @date 2016年4月19日15:19:43
//   */
//  public Map<String,Object> SendMsgToDibsInterface(ChangeOrder changeOrder,String phone,BidsServerSvcReq bidsServerSvcReq) throws Exception{
//    logger.info("====================开始向零钱宝发送请求，请求参数："+changeOrder.toString()+"  "+phone);
//    //向零钱宝接口发送请求
//   // CloseableHttpClient httpClient =createSSLClientDefault();
//    HttpPost post = new HttpPost();
//    post.setURI(new URI(bidsServerSvcReq.getApply_url()));
//    Map<String,Object> map=new HashMap<String,Object>();
//    map.put("sid",bidsServerSvcReq.getBids_platform_sid());
//    map.put("scanQRCode",DecryptDes.encrypt(WebConstants.SCAN_QR_CODE,bidsServerSvcReq.getDecode_string_key()));
//    map.put("tpOrder",DecryptDes.encrypt(changeOrder.getChangeOrderId(),bidsServerSvcReq.getDecode_string_key()));
//    map.put("amount",DecryptDes.encrypt(changeOrder.getChangeAmount()+"",bidsServerSvcReq.getDecode_string_key()));
//    map.put("desc",DecryptDes.encrypt(BIDS_ACTIVITY_DESC,bidsServerSvcReq.getDecode_string_key()));
//    if(phone!=null){
//      map.put("phone",DecryptDes.encrypt(phone,bidsServerSvcReq.getDecode_string_key()));
//    }
//    map.put("backUrl",DecryptDes.encrypt(bidsServerSvcReq.getBack_url(),bidsServerSvcReq.getDecode_string_key()));
//    String json="";
//    try {
//      json=JSON.toJSONString(map);
//      logger.info("==================调用零钱宝接口参数转化json："+json);
//    } catch (Exception e) {
//    logger.info("==================调用零钱宝接口参数转化json出错！");
//    }
//   /* StringEntity se = new StringEntity(map.toString(), "UTF-8");
//    post.setEntity(se);
//    HttpEntity entity= httpClient.execute(post).getEntity();
//    String returnStr=EntityUtils.toString(entity, "UTF-8");*/
//    String returnStr= HttpClientUtil.post(bidsServerSvcReq.getApply_url(), json.toString());
//    logger.info("====================零钱宝返回信息为："+returnStr);
//    JSONObject obj=JSONObject.parseObject(returnStr);
//    logger.info("====================零钱宝返回信息为转json后为："+obj.toString());
//    if(null!=obj.get("platformOrder")){
////     byte[] str=Base64Util.decode(obj.get("PlatformOrder").toString());
////     String decodeStr=DESUtils.encrypt(str.toString());
//     map.put("platformOrder",DecryptDes.decrypt(obj.get("platformOrder").toString(),bidsServerSvcReq.getDecode_string_key()));
//    }
//    map.put("returnMsg", obj.get("returnMsg").toString());
//    map.put("returnCode", obj.get("returnCode").toString());
//    map.put("isFirst",obj.get("isFirst").toString());
//    logger.info("===========================解析零钱宝传来的信息为："+map.get("platformOrder")+"|||||"+map.get("returnMsg")+"|||||"+map.get("returnCode")+"|||||"+map.get("isFirst")+"|||||");
//    return map;
//  }
//  
//  
//  public static void main(String[] args) {
//    ChangeOrder order=new ChangeOrder();
//    order.setChangeOrderId("");
//    order.setChangeAmount(1);
//  }
//  /**
//   * 
//   * @Method: createSSLClientDefault
//   * @Description: https的请求发送工具
//   * @param String data
//   * @return 包装后的httpClient代理对象
//   * @author Wy
//   * @throws  
//   * @date 2016年4月19日15:19:43
//   */
//  public static CloseableHttpClient createSSLClientDefault(){
//    try { 
//    	SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {//信任所有
//		    public boolean isTrusted(X509Certificate[] chain,String authType) throws CertificateException {
//			    return true;
//		    }
//    	}).build();
//	    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
//	    return HttpClients.custom().setSSLSocketFactory(sslsf).build();
//    } catch (KeyManagementException e) {
//    	e.printStackTrace();
//    } catch (NoSuchAlgorithmException e) {
//    	e.printStackTrace();
//    } catch (KeyStoreException e) {
//    	e.printStackTrace();
//    }
//    	return  HttpClients.createDefault();
//    }
//  
//  /**
//   * 
//   * @Method: updateState
//   * @Description: 根据返回信息更新状态 操作时间和兑奖时间   更新本地的订单状态
//   * @param BidsBackUrlVo
//   * @return 
//   * @author Wy
//   * @throws Exception 
//   * @date 2016年4月19日15:19:43
//   * 零钱宝返回信息规则未定义  当前自行判断 并且只定义一种情况模拟
//   */
//  @Override
//  public JSONObject updateState(BidsBackUrlSvcReq bidsBackUrlVo) throws Exception {
//    //如果为成功时候 更新状态
//    JSONObject result = new JSONObject();
//    String platformOrder=bidsBackUrlVo.getPlatformOrder();
//    String serialNumber=bidsBackUrlVo.getserialNumber();
//    String resultCode =bidsBackUrlVo.getResultCode()==null?"":bidsBackUrlVo.getResultCode();
//    String resultMsg=bidsBackUrlVo.getResultMsg()==null?"":bidsBackUrlVo.getResultMsg();
//    logger.info("==================back_url返回信息解密后状态为："+platformOrder+"||||||"+serialNumber+"||||||"+resultCode+"||||||"+resultMsg+"||||||");
//  //直接根据零钱宝平台id更新本地表的状态
//      ChangeOrderExample ex=new ChangeOrderExample();
//      ex.createCriteria().andChangePlatformOrderIdEqualTo(platformOrder);
//      ChangeOrder order=new ChangeOrder();
//      order.setUpdateTime(new Date());
//      order.setResultMsg(resultMsg);
//      //根据返回信息的不同 更新不同的状态
//      if(resultCode.equals(StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//        order.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);//设置红包领取成功
//        order.setResult(WebConstants.BIDS_STATUS_SAVED.toString());
//      }else if(resultCode.equals(StateInfoEnum.DIBS_STATUS_NO_ORDER.getRetCode())){
//        order.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);//设置红包领取成功
//        order.setResult(WebConstants.BIDS_STATUS_SAVED.toString());
//      }else{
//        order.setResult(WebConstants.BIDS_STATUS_UNSAVE.toString());
//        order.setStatus(WebConstants.BIDS_RED_SEND_FAILURE);//失败
//      }
//     order.setTablePrefix(tablePrefix);
//    int resultInt=  changeOrderMapper.updateByExampleSelective(order, ex);
//    if(resultInt>0){
//      logger.info("=================更新零钱订单表成功！更新平台订单号为："+order.getChangePlatformOrderId()+"  更新红包状态为："+order.getStatus());
//    }else{
//      logger.info("=================更新零钱订单表失败！更新平台订单号为："+order.getChangePlatformOrderId()+"  更新红包状态为："+order.getStatus());
//      result.put("response",StateInfoEnum.SYSTEM_ERROR);
//      return result;
//    }
//    //更新订单流水表
////    byte[] st=Base64Util.decode(bidsBackUrlVo.getserialNumber().toString());
////    String decodeString=DESUtils.encrypt(bidsBackUrlVo.getserialNumber()+"");
//    ChangeOrderRecord record=new ChangeOrderRecord();
//    record.setPayId(serialNumber);
//    record.setResultCode(resultCode);
//    record.setResultMsg(resultMsg);
//    //设置领取红包的状态
//    if(resultCode.equals(StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//      record.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);//设置红包领取成功
//    }else if(resultCode.equals(StateInfoEnum.DIBS_STATUS_NO_ORDER.getRetCode())){
//      record.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);
//    }else{
//      record.setStatus(WebConstants.BIDS_RED_SEND_FAILURE);//失败
//    }
//    record.setUpdateTime(new Date());
//    record.setTablePrefix(tablePrefix);
//    int recordReturnInt=changeOrderRecordMapper.updateByPrimaryKeySelective(record);
//    if(recordReturnInt>0){
//      logger.info("==================更新订单流水号表成功！ChangeOrderRecord="+record.toString()+"更新状态为"+record.getStatus());
//    }
//    else{
//      logger.info("==================更新订单流水号表失败！ChangeOrderRecord="+record.toString()+"更新状态为"+record.getStatus()); 
//      throw new Exception("回调方法中，更新零钱订单表成功，更新流水表失败，手动回滚！");
//    }
//    //更新消费者兑换表的信息状态和操作时间,首先根据平台的订单号 查询到奖品订单的主键
//    ex.setTablePrefix(tablePrefix);
//    List<ChangeOrder> changorders=changeOrderMapper.selectByExample(ex);
//    if(changorders!=null&&changorders.get(0)!=null&&!StringUtils.isEmpty(changorders.get(0).getPrizeOrderId())){
//        //更新不同的订单状态   
//      Integer state=null;
//	    if(resultCode.equals(StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//	      state=WebConstants.BIDS_BIG_DATA_SUCCESS;
//	    }else if(resultCode.equals(StateInfoEnum.DIBS_STATUS_NO_ORDER.getRetCode())){
//	      state=WebConstants.BIDS_BIG_DATA_SUCCESS;
//	    }
//	    else{
//	      state=WebConstants.BIDS_BIG_DATA_FAILTURE;
//	    }
//	    //============更新用户中奖统计表==============
//	    BarcodePrizeConsumer barcodePrizeConsumer = barcodePrizeConsumerMapper.selectByPrimaryKey(changorders.get(0).getPrizeOrderId(),tablePrefix);
//	    if(barcodePrizeConsumer==null){
//	    	 logger.info("=================查询出错！更新信息为：changeOrder="+JSONObject.toJSONString(changorders.get(0))+"更新状态为："+state);
//			 throw new Exception("查询出错");
//	    }
//	    result.put("activityId", barcodePrizeConsumer.getActivityId());
//	    if(state.equals(WebConstants.BIDS_BIG_DATA_SUCCESS)){
//			if(!barcodePrizeConsumer.getIsStatus().equals(2)){
//				boolean re = this.updateUserPrizeTotal(barcodePrizeConsumer);
//				if(re==false){
//					 logger.info("=================更新用户中奖统计表出错！更新信息为：barcodePrizeConsumer="+JSONObject.toJSONString(barcodePrizeConsumer)+"更新状态为："+state);
//					 throw new Exception("更新用户中奖统计表出错");
//				}
//			}
//			barcodePrizeConsumer.setIsStatus(state);
//			barcodePrizeConsumer.setGetTime(new Date());
//			barcodePrizeConsumer.setUpdateTime(new Date());
//			barcodePrizeConsumer.setTablePrefix(tablePrefix);
//			int updateCount = barcodePrizeConsumerMapper.updateByPrimaryKey(barcodePrizeConsumer);
//			   //最后一步三个表整体都更新完的时候才可以认为领取成功
//			if(updateCount!=1){
//			      //必须保证三个更新完整性 不然全部回退 
//			      throw new Exception("零钱宝回调backUrl的时候，更新兑换记录时更新失败，出现错误！");
//			}  
//			    
//			if(updateCount==1){
//			      logger.info("=================更新兑奖表成功！更新信息为：prizeOrderId="+changorders.get(0).getPrizeOrderId()+"更新状态为："+state);
//			      result.put("hongbao",String.format("%.2f", (double)changorders.get(0).getChangeAmount()/100));
//			      result.put("tishi", this.getTishiById(changorders.get(0).getPrizeOrderId()));
//			      result.put("activityId", changorders.get(0).getActivityId());
//			      result.put("prizeOrderId", changorders.get(0).getPrizeOrderId());
//			      result.put("response",StateInfoEnum.SUCCESS);
//			      return result;
//			}else{
//			      logger.info("=================更新兑奖表失败！更新信息为：prizeOrderId="+changorders.get(0).getPrizeOrderId()+"更新状态为："+state);
//			      result.put("response",StateInfoEnum.SYSTEM_ERROR);
//			      return result;
//			}
//			
//		}else{
//			//失败的更新要看远来是否成功过，成功过不更新
//			if(!barcodePrizeConsumer.getIsStatus().equals(WebConstants.BIDS_BIG_DATA_SUCCESS)){
//				BarcodePrizeConsumerExample example = new BarcodePrizeConsumerExample();
//				example.setTablePrefix(tablePrefix);
//				//更新不等于2的
//				example.createCriteria().andIsStatusNotEqualTo(2);
//				barcodePrizeConsumer.setIsStatus(state);
//				barcodePrizeConsumer.setGetTime(new Date());
//				barcodePrizeConsumer.setUpdateTime(new Date());
//				int updateCount = barcodePrizeConsumerMapper.updateByExample(barcodePrizeConsumer, example);
//				   //最后一步三个表整体都更新完的时候才可以认为领取成功
//				    if(updateCount!=1){
//				      //必须保证三个更新完整性 不然全部回退 
//				      throw new Exception("零钱宝回调backUrl的时候，更新兑换记录时更新失败，出现错误！");
//				    }  
//				    
//				    if(updateCount==1){
//				      logger.info("=================更新兑奖表成功！更新信息为：prizeOrderId="+changorders.get(0).getPrizeOrderId()+"更新状态为："+state);
//				      result.put("hongbao",String.format("%.2f", (double)changorders.get(0).getChangeAmount()/100));
//				      result.put("tishi", this.getTishiById(changorders.get(0).getPrizeOrderId()));
//				      result.put("activityId", changorders.get(0).getActivityId());
//				      result.put("response",StateInfoEnum.SUCCESS);
//				      result.put("prizeOrderId", changorders.get(0).getPrizeOrderId());
//				      return result;
//				    }else{
//				      logger.info("=================更新兑奖表失败！更新信息为：prizeOrderId="+changorders.get(0).getPrizeOrderId()+"更新状态为："+state);
//				      result.put("response",StateInfoEnum.SYSTEM_ERROR);
//				      return result;
//				    }
//			}
//		}
//	    result.put("response",StateInfoEnum.SYSTEM_ERROR);
//	    return result; 
//    }else{
//      logger.info("==========================更新兑换表时候查询失败！查不到记录PrizeOrderId()="+changorders.get(0).getPrizeOrderId());
////      mav.addObject("response",StateInfoEnum.SYSTEM_ERROR);
////      mav.setViewName(WebConstants.QD_TEMP_PATH+"/lotteryPrizeCommonError");
//      result.put("activityId", "");
//      result.put("response",StateInfoEnum.SYSTEM_ERROR);
//      return result;
//    }
//    
//  }
//  /**
//   * 
//   * @Method: ReSendMsgToBids
//   * @Description: 首先查询零钱订单中的 零钱宝平台id是否存在 如果存在直接重定向到零钱宝   如果不存在那么重新申请平台id
//   * @param prizeOrderId
//   * @return ModelAndView
//   * @author Wy
//   * @throws Exception 
//   * @date 2016年4月20日14:07:11
//   */
//  @Override
//  public JSONObject updateReSendMsgToBids(String prizeOrderId,Integer userID,BidsServerSvcReq bidsServerSvcReq) throws Exception {
//    
//    //先跟传来的userID查出是否是第一次进入零钱宝
//    boolean isFirst = checkIsFirst(userID);
//    JSONObject result =new JSONObject();
//    BarcodePrizeConsumer barcodePrizeConsumer = barcodePrizeConsumerMapper.selectByPrimaryKey(prizeOrderId,tablePrefix);
//    if(barcodePrizeConsumer!=null){
//    	result.put("activityId", barcodePrizeConsumer.getActivityId());
//    }else{
//    	result.put("activityId", "");
//    }
//    
//    //查询零钱订单中是否存在平台订单id
//    ChangeOrderExample ex=new ChangeOrderExample();
//    ex.setTablePrefix(tablePrefix);
//    ex.createCriteria().andPrizeOrderIdEqualTo(prizeOrderId);
//    List<ChangeOrder> orders=changeOrderMapper.selectByExample(ex);
//    if(CollectionUtils.isEmpty(orders)){
//      logger.info("11111111111111111111111111111111111111111");
//      logger.info("====================兑奖记录重新兑换时候，还未存入零钱订单表，回调第一个接口！");
//      result =  saveDibsAndSendDibsRequest(prizeOrderId,userID,bidsServerSvcReq);
//      return result;
//    }else{
//      logger.info("222222222222222222222222222222222222222222");
//      
//      //有订单先查询订单状态，订单状态为退款成功的如何处理
//      boolean refund = false;
//      if(orders.get(0).getChangePlatformOrderId()!=null){
//    	  Map<String,Object> queryMap= QueryMsgToDibsInterface(orders.get(0).getChangePlatformOrderId());
//    	 
//    	  if(queryMap.get("returnCode")==null|| queryMap.get("orderStatus")==null||queryMap.get("orderResultCode")==null){
//    		  logger.info("===============订单申请查询失败！参数："+JSONObject.toJSONString(orders.get(0)));
//              result.put("response",StateInfoEnum.SYSTEM_ERROR);
//              return result;
//    	  }
//    	  String returnCode = queryMap.get("returnCode").toString();
//    	  //String orderStatus = queryMap.get("OrderStatus").toString();
//    	  String orderResultCode = queryMap.get("orderResultCode").toString();
//    	  if(StringUtils.isEmpty(returnCode)||StringUtils.isEmpty(orderResultCode)){
//    		  logger.info("===============查询结果失败！参数："+JSONObject.toJSONString(orders.get(0))+"错误码："+returnCode);
//    		  result.put("response",StateInfoEnum.SYSTEM_ERROR);
//              return result;
//    	  }
//    	  //如果返回账单为退款成功
//    	  if(returnCode.equals(StateInfoEnum.DIBS_RETURN_SUCCESS)){
//    		  if(orderResultCode.equals(StateInfoEnum.DIBS_QUERY_STATE_BACK_MONEY)){
//    			  //如果为订单已经退款完成状态
//    			  ChangeOrder order = orders.get(0);
//    			  order.setStatus(WebConstants.BIDS_RED_REFUND_SUCCESS);//设置红包退款成功
//    		      order.setResult(WebConstants.BIDS_STATUS_UNSAVE.toString());
//    		      order.setTablePrefix(tablePrefix);
//    		      int resultInt=  changeOrderMapper.updateByExampleSelective(order, ex);
//    		      if(resultInt>0){
//    		    	  refund = true;
//    		    	  logger.info("===============更新退款成功状态："+JSONObject.toJSONString(orders.get(0))+"  更新红包状态为："+order.getStatus());
//    		      }else{
//    		    	  logger.info("===============查询结果失败！参数："+JSONObject.toJSONString(orders.get(0))+"错误码："+returnCode);
//    		    	  result.put("response",StateInfoEnum.SYSTEM_ERROR);
//    	              return result;
//    		      }
//    		  }
//    	  }
//    	  //不是退款不处理
//    	  /*else{
//    		  logger.info("===============查询结果失败！参数："+JSONObject.toJSONString(orders.get(0))+"错误码："+returnCode);
//              mav.addObject("response",StateInfoEnum.SYSTEM_ERROR);
//              mav.setViewName(WebConstants.QD_TEMP_PATH+"/lotteryPrizeCommonError");
//              return mav;
//    	  }*/
//      }
//      
//      
//      
//      //退款成功再次申请的处理，状态为7或者
//      if(orders.get(0).getStatus().equals(WebConstants.BIDS_RED_REFUND_SUCCESS)){
//      	logger.info("====================兑奖记录重新兑换时候，退款成功的需要重新生成订单，从新创建changeOrder！");
//        String errorMsg="";
//        barcodePrizeConsumer = barcodePrizeConsumerMapper.selectByPrimaryKey(prizeOrderId,tablePrefix);
//        if(barcodePrizeConsumer==null){
//          logger.info("======================查询兑换记录表查询为空！prizeOrderId="+prizeOrderId);
//          result.put("response",StateInfoEnum.SYSTEM_ERROR);
//          return result;
//        }
//        ChangeOrder changeOrder=new ChangeOrder();
//        ChangeOrderRecord orderRecorde=new ChangeOrderRecord();
//        //生成零钱的订单主键     在插入零钱订单的同时 也要插入到订单流水表中的数据
//        changeOrder.setChangeOrderId(CommonUtils.getBusinessOrderID("lq"));//生成零钱订单主键
//        changeOrder.setPrizeOrderId(barcodePrizeConsumer.getPrizeOrderId());
//        changeOrder.setActivityId(barcodePrizeConsumer.getActivityId());
//        if(barcodePrizeConsumer.getUserId()!=null&&!barcodePrizeConsumer.getUserId().equals("")){
//          changeOrder.setUserId(Integer.parseInt(barcodePrizeConsumer.getUserId()));
//        }
//        changeOrder.setChangeAmount(barcodePrizeConsumer.getPrizeAmount());
//        changeOrder.setStatus(WebConstants.BIDS_UN_TAKE);
//        changeOrder.setCreateTime(new Date());
//        changeOrder.setUpdateTime(new Date());
//        orderRecorde.setPayId(CommonUtils.getBusinessOrderID("ddlsh"));//生成订单流水号
//        orderRecorde.setChangeOrderId(changeOrder.getChangeOrderId());
//        orderRecorde.setStatus(WebConstants.BIDS_UN_TAKE);
//        orderRecorde.setCreateTime(new Date());
//        orderRecorde.setUpdateTime(new Date());              
//        Map map=null;
//        try {
//          map = SendMsgToDibsInterface(changeOrder,barcodePrizeConsumer.getUserPhone(),bidsServerSvcReq);
//          //零钱宝接口调用失败时候也要继续下去
//          if(map!=null&&map.get("returnCode")!=null&&!map.get("returnCode").toString().equals(StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//            logger.info("===============零钱宝接口调用失败！失败原因"+map.get("returnMsg"));
//            changeOrder.setResult(WebConstants.BIDS_STATUS_UNSAVE.toString());
//            changeOrder.setResultMsg(map.get("returnMsg").toString());
//            orderRecorde.setResultCode(map.get("returnCode").toString());
//            orderRecorde.setResultMsg(map.get("returnMsg").toString());
//          }else if(map!=null&&map.get("returnCode")!=null){
//            logger.info("===============零钱宝接口调用成功！零钱宝订单号为PlatformOrder");
//            changeOrder.setChangePlatformOrderId(map.get("platformOrder").toString());
//            changeOrder.setResult(WebConstants.BIDS_STATUS_SAVED.toString());
//            changeOrder.setResultMsg(map.get("returnMsg").toString());
//            orderRecorde.setChangePlatformOrderId(map.get("platformOrder").toString());
//            orderRecorde.setResultCode(map.get("returnCode").toString());
//            orderRecorde.setResultMsg(map.get("returnMsg").toString());
//          }else{
//            logger.info("==================零钱宝接口调用失败！无返回信息！");
//          }
//        } catch (Exception e1) {
//          logger.info("==================零钱宝接口调用失败！错误原因："+e1.getMessage());
//        }
//        
//        //插入零钱流水号表
//        orderRecorde.setTablePrefix(tablePrefix);
//        int resultInt=changeOrderRecordMapper.insert(orderRecorde);
//        if(resultInt>0){
//          logger.info("===============插入订单流水表成功！orderRecorde="+orderRecorde);
//        }else{
//          logger.info("===============插入订单流水表失败！orderRecorde="+orderRecorde);
//          result.put("response",StateInfoEnum.SYSTEM_ERROR);
//          return result;
//        }
//        
//        
//        //插入零钱订单表
//        changeOrder.setTablePrefix(tablePrefix);
//        int resultState= changeOrderMapper.insert(changeOrder);
//        if(resultState>0){
//          logger.info("===============插入零钱订单表成功！ "+changeOrder.toString());
//        }else{
//          logger.info("===============插入零钱订单表失败！ "+changeOrder.toString());
//          throw new Exception("零钱订单插入成功！零钱流水订单插入失败，手动抛异常回滚零钱订单！  ");
//        }
//       
//        
//       if(map!=null&&map.get("returnCode")!=null&&map.get("returnCode").toString().equals(StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//         try {
//        	 result.put("response",StateInfoEnum.SUCCESS);
//        	 result.put("redirect","lingqianbao");
//        	 result.put("platformOrder",map.get("platformOrder").toString());
//        	 result.put("payId",orderRecorde.getPayId());
//        	 result.put("isFirst",isFirst);
//        	 return result;
//         } catch (Exception e) {
//           //调用失败的时候也不能回滚  事物要继续下去
//          logger.info("===================重定向到零钱宝页面失败！错误原因："+e);
//         }
//       }
//       //转发失败的时候也要插入每条的信息
//       result.put("response",StateInfoEnum.SYSTEM_ERROR);
//       logger.info("=======================重定向零钱宝失败！！");
//       return result;
//      }
//      
//      
//      
//	    //先生成一个流水号的订单数据
//	    ChangeOrderRecord record=new ChangeOrderRecord();
//	    record.setPayId(CommonUtils.getBusinessOrderID("ddlsh"));//生成订单流水号
//	    record.setChangeOrderId(orders.get(0).getChangeOrderId());
//	    record.setStatus(WebConstants.BIDS_UN_TAKE);
//	    record.setCreateTime(new Date());
//	    record.setUpdateTime(new Date());
//	    logger.info("===================查询零钱订单表成功！查询内容为："+orders.get(0).toString());
//	    if(StringUtils.isEmpty(orders.get(0).getChangePlatformOrderId())){
//	      //如果还未申请到平台的订单id那么重新发送请求
//	      Map<String,Object> map=SendMsgToDibsInterface(orders.get(0),null,bidsServerSvcReq);
//	      //如果第二次请求的时候直接报错 那么就不继续请求了拋異常到controller進行處理   如果不报错 但是没生产成功的话 那么也要更新订单状态 和流水号的表状态 
//	      if( map!=null&&map.get("returnCode")!=null&&map.get("returnCode").toString().equals(
//	          StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//	        //如果请求参数成功的话 那么更新零钱订单的状态  如果不成功则不更新
//		        orders.get(0).setChangePlatformOrderId(map.get("platformOrder").toString());
//		        orders.get(0).setResult(WebConstants.BIDS_STATUS_SAVED.toString());
//		        orders.get(0).setResultMsg(map.get("returnMsg").toString());
//		        int returnStr= 0;
//			    try {
//			    	orders.get(0).setTablePrefix(tablePrefix);
//			       returnStr= changeOrderMapper.updateByPrimaryKeySelective(orders.get(0));
//			    } catch (Exception e) {
//			    	//出现异常可以接受！继续下去
//			    	logger.info("====================重新生成平台订单成功时更新零钱订单中的平台订单和状态异常！changeOrder="+orders.get(0).toString());
//			    }
//		       if(returnStr>0){
//		        logger.info("===================重新生成平台订单成功时更新零钱订单中的平台订单和状态成功！PlatformOrder="+map.get("platformOrder"));
//		       }else{
//		        logger.info("===================重新生成平台订单成功时更新零钱订单中的平台订单和状态失败！PlatformOrder="+map.get("platformOrder"));
//		        //此时更新失败 但是可以继续 不需要停止运行
//		       }
//	      //申请零钱宝订单成功时候更新零钱流水信息
//	      //每次生成的流水订单只是为了给redirect用  但是如果申请过程不发生Exception就要把每次请求的结果记录到流水表
//	      record.setChangePlatformOrderId(map.get("platformOrder").toString());
//	      record.setResultCode(map.get("returnCode").toString());
//	      record.setResultMsg(map.get("returnMsg").toString());
//	      record.setTablePrefix(tablePrefix);
//	      int recordInt=changeOrderRecordMapper.insert(record);
//	      //零钱流水表在插入失败的时候要回滚  因为如果更新零钱表的状态的时候失败  但是可以不定时的告知订单状态   但是如果插入流水表不成功    不定期的告知时携带的流水信息就不能同步更新 零钱表和流水表
//	      if(recordInt>0){
//	        logger.info("===================重新生成平台订单成功时插入零钱流水表成功！ ChangeOrderRecord="+record.toString());
//	      }else{
//	        logger.info("===================重新生成平台订单成功时插入零钱流水表失败！ ChangeOrderRecord="+record.toString());
//	        throw new Exception("重新生成平台订单成功时插入零钱流水表失败，手动回滚两个表！");
//	        //此时更新失败 但是可以继续 不需要停止运行
//	      }
//	
//	      //重新生成订单号成功的时候 流水号也生成成功的时候发送零钱宝的redirect请求
//		 	 result.put("tishi", this.getTishiById(prizeOrderId));
//		 	 result.put("response",StateInfoEnum.SUCCESS);
//		   	 result.put("redirect","lingqianbao");
//		   	 result.put("platformOrder",map.get("platformOrder").toString());
//		   	 result.put("payId",record.getPayId());
//		   	 result.put("isFirst",isFirst);
//		   	 return result;
//	      } else if(map!=null&&map.get("returnCode")!=null&&!map.get("returnCode").toString().equals(
//	          StateInfoEnum.DIBS_STATUS_SUCCESS.getRetCode())){
//	        //请求不发生异常  但是生成失败的时候
//	
//	        //生成平台订单号失败的时候同样要更新 订单表数据和流水号表的数据  零钱订单中的数据本来就应该是失败的状态 所以只要更新失败原因就可以
//	        orders.get(0).setResultMsg(map.get("returnMsg").toString());
//	        orders.get(0).setTablePrefix(tablePrefix);
//	      int returnStr= changeOrderMapper.updateByPrimaryKeySelective(orders.get(0));
//	      if(returnStr>0){
//	        logger.info("===================重新生成平台订单失败时更新零钱订单中失败原因成功！platformOrder="+map.get("platformOrder"));
//	      }else{
//	        logger.info("===================重新生成平台订单失败时更新零钱订单中失败原因失败！platformOrder="+map.get("platformOrder"));
//	        //此时更新失败 但是可以继续 不需要停止运行
//	      }
//	      //申请零钱宝订单成功时候更新零钱流水信息
//	      //每次生成的流水订单只是为了给redirect用  但是如果申请过程不发生Exception就要把每次请求的结果记录到流水表
//	      record.setResultCode(map.get("returnCode").toString());
//	      record.setResultMsg(map.get("returnMsg").toString());
//	      record.setTablePrefix(tablePrefix);
//	      int recordInt=changeOrderRecordMapper.insert(record);
//	     //如果初心问题不用回滚  因为更新的都是失败的信息  重新申请的时候会携带新的流水号
//	      if(recordInt>0){
//	        logger.info("====================重新申请平台订单号时，平台订单号申请失败，插入新的流水数据成功！ChangeOrderRecord="+record.toString());
//	      }else{
//	        logger.info("====================重新申请平台订单号时，平台订单号申请失败，插入新的流水数据时失败！ChangeOrderRecord="+record.toString());
//	      }
//	      }
//	      else{
//	        //此时都没有返回状态 和信息 所以直接抛出异常
//	        logger.info("====================第二次申请平台订单时返回值异常："+map.toString());
//	        result.put("response",StateInfoEnum.SYSTEM_ERROR);
//	        return result;
//	      }
//	    }
//	    //如果存在信息的话 那么也要增加一条流水记录
//	    record.setChangePlatformOrderId(orders.get(0).getChangePlatformOrderId());
//	    record.setTablePrefix(tablePrefix);
//	   int orderRecordInt= changeOrderRecordMapper.insert(record);
//	   if(orderRecordInt<1){
//	     logger.info("=====================中奖记录中重新兑奖时插入流水表失败！record="+record);
//	     result.put("response",StateInfoEnum.SYSTEM_ERROR);
//	     return result;
//	   }
//	    //如果生成过零钱宝订单 直接回调零钱宝的接口  
//	    logger.info("==============================重新领奖平台订单不为空时候，重定向！");
//	     result.put("tishi", this.getTishiById(prizeOrderId));
//		 result.put("response",StateInfoEnum.SUCCESS);
//	   	 result.put("redirect","lingqianbao");
//	   	 result.put("platformOrder",orders.get(0).getChangePlatformOrderId().toString());
//	   	 result.put("payId",record.getPayId());
//	   	 return result;
//	    }
////    logger.info("==============================重新领奖平台订单不为空时候，重定向！发送！！！！");
//  }
//  @Override
//  public Map<String, Object> updateBidsTableState(BidsTimeRoundSvcReq bidsTimeRoundVo) throws Exception {
//    Map<String,Object>map=new HashMap<String,Object>();
//    String platformOrder=bidsTimeRoundVo.getPlatformOrder();
//    String serialNumber=bidsTimeRoundVo.getSerialNumber();
//    String resultCode =bidsTimeRoundVo.getOrderResultCode();
//    String resultMsg=bidsTimeRoundVo.getOrderResultMsg();
//    logger.info("====================解析不定时更新的信息为：platformOrder"+platformOrder+"serialNumber:"+serialNumber+"resultCode"+resultCode+"resultMsg"+resultMsg);
//  //直接根据零钱宝平台id更新本地表的状态
//    ChangeOrderExample ex=new ChangeOrderExample();
//    ex.createCriteria().andChangePlatformOrderIdEqualTo(platformOrder);
//    ChangeOrder order=new ChangeOrder();
//    order.setUpdateTime(new Date());
//    order.setResultMsg(resultMsg);
//    //根据返回信息的不同 更新不同的状态
//    if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_SUCCESS.getRetCode())){
//      order.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);//设置红包领取成功
//      order.setResult(WebConstants.BIDS_STATUS_SAVED.toString());
//    }else  if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_BACK_MONEY.getRetCode())){
//        order.setStatus(WebConstants.BIDS_RED_REFUND_SUCCESS);//设置红包退款成功
//        order.setResult(WebConstants.BIDS_STATUS_UNSAVE.toString());
//      }
//    else{
//      order.setStatus(WebConstants.BIDS_RED_SEND_FAILURE);//失败
//      order.setResult(WebConstants.BIDS_STATUS_UNSAVE.toString());
//    }
//   order.setTablePrefix(tablePrefix);
//  int resultInt=  changeOrderMapper.updateByExampleSelective(order, ex);
//  if(resultInt>0){
//    logger.info("=================更新零钱订单表成功！更新平台订单号为："+platformOrder+"  更新红包状态为："+order.getStatus());
//  }else{
//    logger.info("=================更新零钱订单表失败！更新平台订单号为："+platformOrder+"  更新红包状态为："+order.getStatus());
//    map.put("returnCode",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetCode());
//    map.put("returnMsg",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetInfo());
//    return map;
//  }
//  //更新订单流水表
//  ChangeOrderRecord record=new ChangeOrderRecord();
//  record.setPayId(serialNumber);
//  record.setResultCode(resultCode);
//  record.setResultMsg(resultMsg);
//  //设置领取红包的状态
//  if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_SUCCESS.getRetCode())){
//    record.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);//设置红包领取成功
//  }else if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_BACK_MONEY.getRetCode())){
//	    record.setStatus(WebConstants.BIDS_RED_REFUND_SUCCESS);//设置红包退款成功
//  }else{
//    record.setStatus(WebConstants.BIDS_RED_SEND_FAILURE);//失败
//  }
//  record.setUpdateTime(new Date());
//  record.setTablePrefix(tablePrefix);
//  int recordReturnInt=changeOrderRecordMapper.updateByPrimaryKeySelective(record);
//  if(recordReturnInt>0){
//    logger.info("==================更新订单流水号表成功！ChangeOrderRecord="+record.toString()+"更新状态为"+record.getStatus());
//  }
//  else{
//    logger.info("==================更新订单流水号表失败！ChangeOrderRecord="+record.toString()+"更新状态为"+record.getStatus()); 
//    throw new Exception("告知订单状态的时候更新流水表失败！手动回滚流水表和零钱订单表！");
//  }
//  //更新消费者兑换表的信息状态和操作时间,首先根据平台的订单号 查询到奖品订单的主键
//  ex.setTablePrefix(tablePrefix);
//  List<ChangeOrder> changorders=changeOrderMapper.selectByExample(ex);
//  BarcodePrizeConsumer barcodePrizeConsumer = barcodePrizeConsumerMapper.selectByPrimaryKey(changorders.get(0).getPrizeOrderId(),tablePrefix);
//  if(changorders!=null&&changorders.get(0)!=null&&!StringUtils.isEmpty(changorders.get(0).getPrizeOrderId())){
//      //更新不同的订单状态   
//    Integer state=null;
//  if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_SUCCESS.getRetCode())){
//    state=WebConstants.BIDS_BIG_DATA_SUCCESS;
//  }else  if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_BACK_MONEY.getRetCode())){
//	  //如果退款成功不修改状态
//	    state=barcodePrizeConsumer.getIsStatus();
//  }else if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_FAILTURE.getRetCode())){
//	//授权失败状态为未兑奖
//      state=WebConstants.BIDS_BIG_DATA_UNAWARD;
//  }
//  else{ 
//    state=WebConstants.BIDS_BIG_DATA_FAILTURE;
//  }
//  //============更新用户中奖统计表==============
//  
//  if(barcodePrizeConsumer==null){
//	     logger.info("=================消费者兑换表查询出错！更新信息为：changorder="+JSONObject.toJSONString(changorders.get(0))+"更新状态为："+state);
//		 throw new Exception("消费者兑换表查询出错");
//  }
//  if(state.equals(WebConstants.BIDS_BIG_DATA_SUCCESS)){
//		if(!barcodePrizeConsumer.getIsStatus().equals(2)){
//			boolean re = this.updateUserPrizeTotal(barcodePrizeConsumer);
//			if(re==false){
//				 logger.info("=================更新用户中奖统计表出错！更新信息为：barcodePrizeConsumer="+JSONObject.toJSONString(barcodePrizeConsumer)+"更新状态为："+state);
//				 throw new Exception("更新用户中奖统计表出错");
//			}
//			barcodePrizeConsumer.setIsStatus(state);
//			barcodePrizeConsumer.setGetTime(new Date());
//			barcodePrizeConsumer.setUpdateTime(new Date());
//			barcodePrizeConsumer.setTablePrefix(tablePrefix);
//			int updateCount = barcodePrizeConsumerMapper.updateByPrimaryKey(barcodePrizeConsumer);
//			  
//			  if(updateCount!=1){
//			    //必须保证三个更新完整性 不然全部回退 
//			    throw new Exception("零钱宝回调backUrl的时候，更新三个表不同步，出现错误！");
//			  }
//			  if(updateCount==1){
//			    logger.info("=================更新消费者兑换表成功！更新信息为：prizeOrderId="+changorders.get(0).getPrizeOrderId()+"更新状态为："+state);
//			    map.put("returnCode",StateInfoEnum.DIBS_RETURN_SUCCESS.getRetCode());
//			    map.put("returnMsg",StateInfoEnum.DIBS_RETURN_SUCCESS.getRetInfo());
//			    map.put("prizeOrderId", changorders.get(0).getPrizeOrderId());
//			    return map;
//			  }else{
//			    logger.info("=================更新消费者兑换表失败！更新信息为：prizeOrderId="+changorders.get(0).getPrizeOrderId()+"更新状态为："+state);
//			    map.put("returnCode",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetCode());
//			    map.put("returnMsg",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetInfo());
//			    return map;
//			  }
//		}
//	}else{
//		if(!barcodePrizeConsumer.getIsStatus().equals(2)){
//			BarcodePrizeConsumerExample example = new BarcodePrizeConsumerExample();
//			
//			//更新不等于2的
//			example.createCriteria().andIsStatusNotEqualTo(2);
//			barcodePrizeConsumer.setIsStatus(state);
//			barcodePrizeConsumer.setGetTime(new Date());
//			barcodePrizeConsumer.setUpdateTime(new Date());
//			barcodePrizeConsumer.setTablePrefix(tablePrefix);
//			int updateCount = barcodePrizeConsumerMapper.updateByExample(barcodePrizeConsumer, example);
//		  if(updateCount!=1){
//		    //必须保证三个更新完整性 不然全部回退 
//		    throw new Exception("零钱宝回调backUrl的时候，更新三个表不同步，出现错误！");
//		  }
//		  if(updateCount==1){
//		    logger.info("=================更新消费者兑换表成功！更新信息为：prizeOrderId="+changorders.get(0).getPrizeOrderId()+"更新状态为："+state);
//		    map.put("returnCode",StateInfoEnum.DIBS_RETURN_SUCCESS.getRetCode());
//		    map.put("returnMsg",StateInfoEnum.DIBS_RETURN_SUCCESS.getRetInfo());
//		    return map;
//		  }else{
//		    logger.info("=================更新消费者兑换表失败！更新信息为：prizeOrderId="+changorders.get(0).getPrizeOrderId()+"更新状态为："+state);
//		    map.put("returnCode",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetCode());
//		    map.put("returnMsg",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetInfo());
//		    return map;
//		  }
//		}
//	}
// 
//  }
//  
//  map.put("returnCode",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetCode());
//  map.put("returnMsg",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetInfo());
//  return map;
//}	
//  	//根据prizeOrderId 获得提示语
//	private String getTishiById(String prizeOrderId){
//		BarcodePrizeConsumer barcodePrizeConsumer = barcodePrizeConsumerMapper.selectByPrimaryKey(prizeOrderId,tablePrefix);
//		if(barcodePrizeConsumer==null){
//			logger.info("查不到对应的消费者兑换表记录");
//	    	return WebConstants.HONGBAO_TISHI;
//		}
//		ActivityPrize ap =activityPrizeMapper.selectByPrimaryKey(barcodePrizeConsumer.getPrizeId(),tablePrefix);
//		if(ap==null){
//	    	logger.info("奖项设置为空，对应！barcodePrizeConsumer="+JSONObject.toJSONString(barcodePrizeConsumer));
//	    	return WebConstants.HONGBAO_TISHI;
//	    }else{
//	    	if(StringUtil.isEmpty(ap.getRedbagHint())){
//	    		return WebConstants.HONGBAO_TISHI;
//	    	}else{
//	    		return ap.getRedbagHint();
//	    	}
//	    }
//	}
//	//根据消费者奖项表更新消费者统计表内容
//	private boolean updateUserPrizeTotal(BarcodePrizeConsumer bpc){
//		  if(bpc==null){
//			  logger.info("====================参数BarcodePrizeConsumer为空");
//			  return false;
//		  }
//		  if(bpc.getUserId()==null){
//			  logger.info("====================参数BarcodePrizeConsumer中userId为空");
//			  return false;
//		  }
//		  Integer userId;
//		try {
//			userId = Integer.parseInt(bpc.getUserId());
//		} catch (Exception e) {
//			 return false;
//		}
//		  UserPrizeTotal upt = userPrizeTotalMapper.selectByPrimaryKey(userId,tablePrefix);
//		  if(upt==null){
//			  //空值返回错误
//			  logger.info("====================参数BarcodePrizeConsumer中userId在表userPrizeTotal中值为空");
//			  return false;
//		  }else{
//			  //有值更新
//			  if(upt.getChangeSuccessAmount()==null){
//				  upt.setChangeSuccessAmount(bpc.getPrizeAmount());
//			  }else{
//				  upt.setChangeSuccessAmount(upt.getChangeSuccessAmount()+bpc.getPrizeAmount());
//			  }
//			  if(upt.getChangeSuccessCount()==null){
//				  upt.setChangeSuccessCount(1);
//			  }else{
//				  upt.setChangeSuccessCount(upt.getChangeSuccessCount()+1);
//			  }
//			  upt.setUpdateTime(new Date());
//			  upt.setTablePrefix(tablePrefix);
//			  userPrizeTotalMapper.updateByPrimaryKey(upt);
//			  return true;
//		  }
//		 
//	  }
//	/**
//	 * 根据零钱罐不定时回调信息对大数据表，订单，订单流水表进行修改
//	 * @param platformOrderId
//	 * @param serialNumber
//	 * @param resultCode
//	 * @param resultMsg
//	 * @return
//	 * @throws Exception
//	 */
//	private Map<String, Object> updateOrderState(String platformOrderId,String serialNumber,String resultCode,String resultMsg) throws Exception{
//		 Map<String,Object> result=new HashMap<String,Object>();
//		//根据零钱罐平台上订单Id查询本地订单，没有返回失败
//		 ChangeOrderExample ex=new ChangeOrderExample();
//		 ex.createCriteria().andChangePlatformOrderIdEqualTo(platformOrderId);
//		 List<ChangeOrder> cos = changeOrderMapper.selectByExample(ex);
//		 if(!CollectionUtils.isEmpty(cos)){
//			 result.put("returnCode",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetCode());
//			 result.put("returnMsg",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetInfo());
//			 return result;
//		 }
//		 ChangeOrder co = cos.get(0);
//		 if(co!=null&&co.getStatus()!=null&&co.getResult()!=null&&
//				 co.getStatus().equals(WebConstants.BIDS_RED_SEND_SUCCESS)
//				 &&co.getResult().equals(WebConstants.BIDS_STATUS_SAVED)){
//			 //存入零钱罐并且领取成功不作操作
//			 result.put("returnCode",StateInfoEnum.DIBS_RETURN_SUCCESS.getRetCode());
//			 result.put("returnMsg",StateInfoEnum.DIBS_RETURN_SUCCESS.getRetInfo());
//			 return result;
//		 }
//		 ChangeOrderRecord cor = new ChangeOrderRecord();
//		 cor.setChangeOrderId(co.getChangeOrderId());
//		 cor.setChangePlatformOrderId(platformOrderId);
//		 cor.setCreateTime(new Date());
//		 cor.setPayId(serialNumber);
//		 cor.setResultCode(resultCode);
//		 cor.setResultMsg(resultMsg);
//		 cor.setUpdateTime(new Date());
//		 
//		 //返回状态修改订单状态
//		 if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_SUCCESS.getRetCode())){
//			 co.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);//设置红包领取成功
//			 co.setResult(WebConstants.BIDS_STATUS_SAVED.toString());
//			 cor.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);
//		 }else if(resultCode.equals(StateInfoEnum.DIBS_STATUS_NO_ORDER.getRetCode())){
//			 co.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);//设置红包领取成功
//			 co.setResult(WebConstants.BIDS_STATUS_SAVED.toString());
//			 cor.setStatus(WebConstants.BIDS_RED_SEND_SUCCESS);
//		 }else{
//			 co.setStatus(WebConstants.BIDS_RED_SEND_FAILURE);//失败
//			 co.setResult(WebConstants.BIDS_STATUS_UNSAVE.toString());
//			 cor.setStatus(WebConstants.BIDS_RED_SEND_FAILURE);
//		 }
//		 
//		 int resultInt =  changeOrderMapper.updateByExampleSelective(co, ex);
//		 int recordReturnInt = changeOrderRecordMapper.updateByPrimaryKeySelective(cor);
//		 if(resultInt<1&&recordReturnInt<1){
//		    logger.info("=================更新零钱订单表失败！更新平台订单号为："+co.getChangePlatformOrderId()+"  更新红包状态为："+co.getStatus());
//		    result.put("returnCode",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetCode());
//			result.put("returnMsg",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetInfo());
//		    return result;
//		 }
//		 logger.info("=================更新零钱订单表成功！更新平台订单号为："+co.getChangePlatformOrderId()+"  更新红包状态为："+co.getStatus());
//		 //预先加载更新大数据准备信息
//		 if(co!=null&&!StringUtils.isEmpty(co.getPrizeOrderId())){
//		      //更新不同的订单状态   
//		      Integer state=null;
//			  if(resultCode.equals(StateInfoEnum.DIBS_RESEND_STATE_SUCCESS.getRetCode())){
//			      state=WebConstants.BIDS_BIG_DATA_SUCCESS;
//			  }else if(resultCode.equals(StateInfoEnum.DIBS_STATUS_NO_ORDER.getRetCode())){
//			      state=WebConstants.BIDS_BIG_DATA_SUCCESS;
//			  }else{ 
//				  state=WebConstants.BIDS_BIG_DATA_FAILTURE;
//			  }
//			  
//			  BarcodePrizeConsumer barcodePrizeConsumer = barcodePrizeConsumerMapper.selectByPrimaryKey(co.getPrizeOrderId(),tablePrefix);
//			  if(!barcodePrizeConsumer.getIsStatus().equals(WebConstants.BIDS_BIG_DATA_SUCCESS)&&state.equals(WebConstants.BIDS_BIG_DATA_SUCCESS)){
//				  	//大数据记录状态不为已兑换并且零钱罐推送消息为成功的时候进行用户统计更新
//					boolean re = this.updateUserPrizeTotal(barcodePrizeConsumer);
//					if(re==false){
//						 throw new Exception("更新用户中奖统计表出错");
//					}
//			  }
//			  
//			  barcodePrizeConsumer.setIsStatus(state);
//			  barcodePrizeConsumer.setGetTime(new Date());
//			  barcodePrizeConsumer.setUpdateTime(new Date());
//			  barcodePrizeConsumer.setTablePrefix(tablePrefix);
//			  int updateCount = barcodePrizeConsumerMapper.updateByPrimaryKey(barcodePrizeConsumer);
//			  if(updateCount!=1){
//				    //必须保证三个更新完整性 不然全部回退 
//				    throw new Exception("零钱宝不定时回调更新三个表不同步，出现错误！");
//			  }
//			  result.put("returnCode",StateInfoEnum.DIBS_RETURN_SUCCESS.getRetCode());
//			  result.put("returnMsg",StateInfoEnum.DIBS_RETURN_SUCCESS.getRetInfo());
//			  return result;
//		 }else{
//			  logger.info("=================更新零钱订单表失败！更新平台订单号为："+co.getChangePlatformOrderId()+"  更新红包状态为："+co.getStatus());
//			  result.put("returnCode",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetCode());
//		      result.put("returnMsg",StateInfoEnum.DIBS_SYSTEM_ERROR.getRetInfo());
//		      return result;
//		 }
//	}
//	  /**
//	   * 
//	   * @Method: QueryMsgToDibsInterface
//	   * @Description: 向零钱宝发送信息 得到零钱宝订单状态
//	   * @param Sid
//	   * @param platformOrder
//	   */
//	  private Map<String,Object> QueryMsgToDibsInterface(String platformOrder) throws Exception{
//	    logger.info("====================开始向零钱宝发送请求，请求参数："+platformOrder);
//	    //向零钱宝接口发送请求
////	    CloseableHttpClient httpClient =createSSLClientDefault();
////	    HttpPost post = new HttpPost();
////	    post.setURI(new URI(APPLY_URL));
//	    Map<String,Object> map=new HashMap<String,Object>();
//	    map.put("sid",BIDS_PLATFORM_SID);
//	    map.put("platformOrder",DecryptDes.encrypt(platformOrder,DECODE_STRING_KEY));
//	    String json=JSON.toJSONString(map);
//		logger.info("==================调用零钱宝接口参数转化json："+json);
//	    String returnStr= HttpClientUtil.post(QUERY_BIDS_URL, json.toString());
//	    logger.info("====================零钱宝返回信息为："+returnStr);
//	    JSONObject obj=JSONObject.parseObject(returnStr);
//	    logger.info("====================零钱宝返回信息为转json后为："+obj.toString());
//	    map.put("tpOrder",DecryptDes.decrypt(obj.get("tpOrder").toString(),DECODE_STRING_KEY));
//	    map.put("returnCode",obj.get("returnCode").toString());
//	    map.put("orderStatus",DecryptDes.decrypt(obj.get("orderStatus").toString(),DECODE_STRING_KEY) );
//	    map.put("orderResultCode",DecryptDes.decrypt(obj.get("orderResultCode").toString(),DECODE_STRING_KEY));
//	    logger.info("解析零钱宝传来的信息为："+map.get("tpOrder")+"|||||"+map.get("returnCode")+"|||||"+map.get("orderStatus")+"|||||"+map.get("orderResultCode")+"|||||");
//	    return map;
//	  }
//}
