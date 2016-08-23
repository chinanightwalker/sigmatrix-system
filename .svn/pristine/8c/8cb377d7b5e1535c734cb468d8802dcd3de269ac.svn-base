package com.sigmatrix.sc.web.controller.winningInformation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;





import com.sigmatrix.sc.web.util.ExcelModel;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.BarcodePrizeConsumer;
import com.sigmatrix.sc.entity.v1.CashCouponRecord;
import com.sigmatrix.sc.entity.v1.CustomerInfo;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.ActivityService;
import com.sigmatrix.sc.service.BarcodePrizeConsumerService;
import com.sigmatrix.sc.service.CashCouponRecordService;
import com.sigmatrix.sc.service.CustomerInfoService;
import com.sigmatrix.sc.service.ProductBaseService;
import com.sigmatrix.sc.utils.DateUtil;
import com.sigmatrix.sc.utils.Utils;
import com.sigmatrix.sc.vo.BarcodePrizeConsumerVO;
import com.sigmatrix.sc.web.controller.activity.ActivityController;
import com.sigmatrix.sc.web.controller.common.BaseController;
@Controller
@RequestMapping(value="/winningInformation")
public class WinningIInformationController extends BaseController {

	private static Logger logger = Logger.getLogger(WinningIInformationController.class);
	@Autowired
	private ActivityService activityService;
	@Autowired
	private BarcodePrizeConsumerService barcodePrizeConsumerService;	
	@Autowired
	private ProductBaseService productBaseService;
	@Autowired
	private CustomerInfoService customerInfoService;
	@Autowired
	private CashCouponRecordService cashCouponRecordService;
	
	Map<String, String[]> searchCondit;
	public Map<String, String[]> getSearchCondit() {
		return searchCondit;
	}
	public void setSearchCondit(Map<String, String[]> searchCondit) {
		this.searchCondit = searchCondit;
	}
	//导出
		private ExcelModel model;

	/**
	 * 分页查询活动列表
	 * @return
	 */
	@RequestMapping(value="/activelist")
	public ModelAndView list(Activity activity,HttpServletRequest request){
		String activityTitle = request.getParameter("activityTitle");
		Map<String,Object> map=new HashMap<String, Object>();
		activity.setTablePrefix(getTablePrefix(request));
		activity.setActivityTitle(activityTitle);
		PageBean<Activity> page = new PageBean<Activity>(getPageNum(request));
		try {
			page = activityService.getPageActivityByExample(page,activity);
		} catch (Exception e) {
			logger.error("activity list fail",e);
		}
		map.put("page",page);
		return new ModelAndView(JSP_PREFIX+"winningInformation/list",map);
	}
	
	
	/**
	 * 分页查询中奖记录模块
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(BarcodePrizeConsumer barcodePrizeConsumer,HttpServletRequest request){
		String activityId = request.getParameter("activityId");
		String userId = request.getParameter("userId");
		String prizeType = request.getParameter("prizeType");
		String isType = request.getParameter("isType");
		String isStatus = request.getParameter("isStatus");
		if(StringUtils.isNotBlank(userId)){
			barcodePrizeConsumer.setUserId(userId);
		}
		if(StringUtils.isNotBlank(prizeType)){
			barcodePrizeConsumer.setPrizeType(Integer.parseInt(prizeType));
		}
		if(StringUtils.isNotBlank(isType)){
			barcodePrizeConsumer.setIsType(Integer.parseInt(isType));
		}
		if(StringUtils.isNotBlank(isStatus)){
			barcodePrizeConsumer.setIsStatus(Integer.parseInt(isStatus));
		}
		
//		String activityTitle = request.getParameter("activityId");
		Activity activity = activityService.getActivityById(Integer.parseInt(activityId),getTablePrefix(request));	
		barcodePrizeConsumer.setActivityId(Integer.parseInt(activityId));
		barcodePrizeConsumer.setTablePrefix(getTablePrefix(request));
		Map<String,Object> map=new HashMap<String, Object>();
		PageBean<BarcodePrizeConsumer> page = new PageBean<BarcodePrizeConsumer>(getPageNum(request));
//		page.setPageSize(2);
		searchCondit= request.getParameterMap();
		try {
			page = barcodePrizeConsumerService.getPageBarcodePrizeConsumerByExample(page,barcodePrizeConsumer,searchCondit);
		} catch (Exception e) {
			logger.error("barcodePrizeConsumer list fail",e);
		}
		List<BarcodePrizeConsumer> bpcTemList = page.getDataList();
		List<BarcodePrizeConsumerVO> barcodePrizeConsumerList = new ArrayList<BarcodePrizeConsumerVO>();
		try {
			for (BarcodePrizeConsumer bpc : bpcTemList) {
				if (bpc.getProductId() != null) {
					ProductBase pb = productBaseService
							.getProductBaseByProductId(bpc.getProductId(),
									getTablePrefix(request));
					//BarcodePrizeConsumer bpcTem = bpc;
					BarcodePrizeConsumerVO bpcTem = new BarcodePrizeConsumerVO();
					bpcTem.setBarcodePrizeConsumer(bpc);
					bpcTem.setProductName(pb.getProductName());
					bpcTem.setActivityName(activity.getName());
					bpcTem.setPrizeAmountStr(Utils.fenToYuan(bpc
							.getTotalAmount()));
					barcodePrizeConsumerList.add(bpcTem);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = null;
		for(BarcodePrizeConsumer bpc:bpcTemList){
			//jsonObject = new JSONObject();
			jsonObject = JSONObject.fromBean(bpc);
			jsonObject.put("productName2", "xxxxx");
			jsonArray.put(jsonObject);
		}
		map.put("barcodeJson", jsonArray);*/
		//page.setDataList(barcodePrizeConsumerList);
		map.put("barcodePrizeConsumerList",barcodePrizeConsumerList);
		map.put("page",page);
		map.put("barcodePrizeConsumer",barcodePrizeConsumer);
		Iterator it = searchCondit.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key == "startDate" || key.equals("startDate")) {
				if (!searchCondit.get("startDate")[0].equals("")
						&& searchCondit.get("startDate")[0] != null) {
					map.put("startDate", searchCondit.get("startDate")[0]);
					}
				}
			if (key == "endDate" || key.equals("endDate")) {
				if (!searchCondit.get("endDate")[0].equals("")
						&& searchCondit.get("endDate")[0] != null) {
					map.put("endDate", searchCondit.get("endDate")[0]);
					}
				}
		}
		
		//map.put("endDate", searchCondit.get("endDate")[0]);
		return new ModelAndView(JSP_PREFIX+"winningInformation/winningInformationList",map);
	}
	/**
	 * 查看中奖信息模块
	 * @param barcodePrizeConsumer
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/detail")
	public ModelAndView detail(BarcodePrizeConsumer barcodePrizeConsumer,HttpServletRequest request){		
		String prizeOrderId = request.getParameter("prizeOrderId");
		String userId = request.getParameter("userId");
		String prizeType = request.getParameter("prizeType");
		String isType = request.getParameter("isType");
		String isStatus = request.getParameter("isStatus");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		BarcodePrizeConsumerVO bvo = new BarcodePrizeConsumerVO();
		try {
			barcodePrizeConsumer = barcodePrizeConsumerService.getBarcodePrizeConsumerById(prizeOrderId, getTablePrefix(request));
			bvo.setBarcodePrizeConsumer(barcodePrizeConsumer);
			Activity activity = activityService.getActivityById(barcodePrizeConsumer.getActivityId(),getTablePrefix(request));
			bvo.setActivityName(activity.getName());
			ProductBase pb = productBaseService.getProductBaseByProductId(barcodePrizeConsumer.getProductId(), getTablePrefix(request));
			bvo.setProductName(pb.getProductName());
			CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(Integer.parseInt(barcodePrizeConsumer.getUserId()), getTablePrefix(request));
			if(customerInfo!=null){
			bvo.setUserName(customerInfo.getCustomerName());}
			bvo.setPrizeAmountXianjinStr("0");
			if(barcodePrizeConsumer.getPrizeType()==2 ){
				if(barcodePrizeConsumer.getPrizeAmount().intValue()==barcodePrizeConsumer.getTotalAmount().intValue()){//红包
					bvo.setPrizeAmountStr(Utils.fenToYuan(barcodePrizeConsumer.getTotalAmount()));				
				}else if(barcodePrizeConsumer.getPrizeAmount().intValue()!=barcodePrizeConsumer.getTotalAmount().intValue()){//红包加现金券
					bvo.setPrizeAmountStr(Utils.fenToYuan(barcodePrizeConsumer.getTotalAmount()));
					CashCouponRecord cashCouponRecord = cashCouponRecordService.getCashCouponRecord(barcodePrizeConsumer.getPrizeOrderId(),getTablePrefix(request));
					if(cashCouponRecord!=null){
					bvo.setPrizeAmountXianjinStr(Utils.fenToYuan(cashCouponRecord.getCashPrizeAmount()));}
				}
			}else{
				bvo.setPrizeAmountStr(Utils.fenToYuan(barcodePrizeConsumer.getTotalAmount()));
			}
			bvo.setPrizeAmountStr(Utils.fenToYuan(barcodePrizeConsumer.getTotalAmount()));
		}catch (Exception e) {
			logger.error("fail",e);
		}
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("barcodePrizeConsumerVO", bvo);
		
		map.put("userId", userId);
		map.put("prizeType", prizeType);
		map.put("isType", isType);
		map.put("isStatus", isStatus);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		
		return new ModelAndView(JSP_PREFIX+"winningInformation/detail",map);
	}
	
	
	@RequestMapping(value="/exportData")
	@RequiresPermissions("winningInformation:export")
	public ModelAndView exportData(BarcodePrizeConsumer barcodePrizeConsumer,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String, Object>();
		String activityId = request.getParameter("activityId");
//		System.out.println("activityId="+activityId);
		String userId = request.getParameter("userId");
//		System.out.println("userId="+userId);
		String prizeType = request.getParameter("prizeType");
//		System.out.println("prizeType="+prizeType);
		String isType = request.getParameter("isType");
//		System.out.println("isType="+isType);
		String isStatus = request.getParameter("isStatus");
//		System.out.println("isStatus="+isStatus);
		if(StringUtils.isNotBlank(userId)){
			barcodePrizeConsumer.setUserId(userId);
		}
		if(StringUtils.isNotBlank(prizeType)){
			barcodePrizeConsumer.setPrizeType(Integer.parseInt(prizeType));
		}
		if(StringUtils.isNotBlank(isType)){
			barcodePrizeConsumer.setIsType(Integer.parseInt(isType));
		}
		if(StringUtils.isNotBlank(isStatus)){
			barcodePrizeConsumer.setIsStatus(Integer.parseInt(isStatus));
		}
		
		Activity activity = activityService.getActivityById(Integer.parseInt(activityId),getTablePrefix(request));	
		barcodePrizeConsumer.setActivityId(Integer.parseInt(activityId));
		barcodePrizeConsumer.setTablePrefix(getTablePrefix(request));
		List<BarcodePrizeConsumer> bpcTemList = new ArrayList<BarcodePrizeConsumer>();
		searchCondit= request.getParameterMap();
		try {
			bpcTemList = barcodePrizeConsumerService.getPageBarcodePrizeConsumerListByExample(barcodePrizeConsumer,searchCondit);
		} catch (Exception e) {
			logger.error("barcodePrizeConsumer list fail",e);
		}
		List<BarcodePrizeConsumerVO> barcodePrizeConsumerList = new ArrayList<BarcodePrizeConsumerVO>();
		try {
			for (BarcodePrizeConsumer bpc : bpcTemList) {
				if (bpc.getProductId() != null) {
					ProductBase pb = productBaseService
							.getProductBaseByProductId(bpc.getProductId(),
									getTablePrefix(request));
					BarcodePrizeConsumerVO bpcTem = new BarcodePrizeConsumerVO();
					bpcTem.setBarcodePrizeConsumer(bpc);
					bpcTem.setProductName(pb.getProductName());
					bpcTem.setActivityName(activity.getName());
					bpcTem.setPrizeAmountStr(Utils.fenToYuan(bpc
							.getTotalAmount()));
					bpcTem.getBarcodePrizeConsumer().setPrizeAmount(bpc.getPrizeAmount());
					barcodePrizeConsumerList.add(bpcTem);
				}
			}
			
			model = new ExcelModel();
			model.setSheetName("中奖明细");
			model.setXlsName("activity_"+ DateFormatUtils.format(new Date(), "yyyyMMddhhmmss")+ "_" + System.nanoTime() + ".xls");
			Integer numSize = null;
			if (barcodePrizeConsumerList == null) {
				numSize = 0;
			}else {
				numSize = barcodePrizeConsumerList.size();
			}
			String[][] data = new String[numSize+1][9];
			String[] row = new String[9];
			row[0] = "用户编号";
			row[1] = "单品码内容";
			row[2] = "活动";
			row[3] = "奖项金额(元)/积分";
			row[4] = "奖项类型";
			row[5] = "产品";
			row[6] = "奖项状态";
			row[7] = "活动类型";
			row[8] = "更新时间";
			data[0] = row;
			if( barcodePrizeConsumerList !=null && !barcodePrizeConsumerList.isEmpty()){
				 for (int i = 0; i < barcodePrizeConsumerList.size(); i++) {
						String[] dataRow = new String[9];
						BarcodePrizeConsumerVO bpcvo = barcodePrizeConsumerList.get(i);
						dataRow[0] = bpcvo.getBarcodePrizeConsumer().getUserId();
						dataRow[1] = bpcvo.getBarcodePrizeConsumer().getBarcode();
						dataRow[2] = bpcvo.getActivityName();
						if (bpcvo.getBarcodePrizeConsumer().getPrizeType() != null ) {
							if (bpcvo.getBarcodePrizeConsumer().getPrizeType() == 4) {
								dataRow[3] = bpcvo.getBarcodePrizeConsumer().getPrizeIntegration().toString();
							}else {
								dataRow[3] = bpcvo.getPrizeAmountStr();
							} 
						}
						int prizeTypeTem = bpcvo.getBarcodePrizeConsumer().getPrizeType()==null?0:bpcvo.getBarcodePrizeConsumer().getPrizeType().intValue();
						String prizeTypeStr = null;
						switch(prizeTypeTem){					
							case 2:
								prizeTypeStr = "红包";
								break;
							case 4:
								prizeTypeStr = "积分";
								break;
							case 6:
								prizeTypeStr = "定时红包";
								break;
							case 7:
								prizeTypeStr = "现金券";
								break;
							default:
								prizeTypeStr = "";
								break;
						}
						if(!Utils.fenToYuan(bpcvo.getBarcodePrizeConsumer().getPrizeAmount()).equals(bpcvo.getPrizeAmountStr())){
							prizeTypeStr=null;
							prizeTypeStr="红包+现金券";
						}
						dataRow[4] = prizeTypeStr;
						dataRow[5] = bpcvo.getProductName();
						int isStatusTem = bpcvo.getBarcodePrizeConsumer().getIsStatus();
						String isStatusStr = null;
						switch(isStatusTem){					
						case 0:
							isStatusStr = "已抽奖";
							break;
						case 1:
							isStatusStr = "已领奖";
							break;
						case 2:
							isStatusStr = "已兑奖";
							break;
						case 3:
							isStatusStr = "放弃领奖";
							break;
						case 4:
							isStatusStr = "红包领取失败";
							break;
						case 5:
							isStatusStr = "霸占红包分享中";
							break;
						case 6:
							isStatusStr = "所有人已参与";
							break;							
						default:
							isStatusStr = "";
							break;
					}
						dataRow[6] = isStatusStr;
						int IsType = bpcvo.getBarcodePrizeConsumer().getIsType();
						String IsTypeStr = null;  
						switch(IsType){					
						case 1:
							IsTypeStr = "扫码抽奖";
							break;
						case 2:
							IsTypeStr = "积分抽奖";
							break;
						default:
							IsTypeStr = "";
							break;
						}
						dataRow[7] = IsTypeStr;						
						dataRow[8] = DateUtil.getDateValue(bpcvo.getBarcodePrizeConsumer().getUpdateTime(),DateUtil.YMDHMS);
						data[i+1] = dataRow;
						model.setData(data);
					}		
			}else {
				model.setData(data);
			}
		} catch (Exception e) {
			logger.error("导出EXCEL错误", e);
		}
		request.setAttribute("model", model);
		return new ModelAndView(JSP_PREFIX+"common/excel",map);
	}
	
}
