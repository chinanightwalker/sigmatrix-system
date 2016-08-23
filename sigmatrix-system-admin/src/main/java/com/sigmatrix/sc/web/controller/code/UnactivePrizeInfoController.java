package com.sigmatrix.sc.web.controller.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.BarcodeALevel;
import com.sigmatrix.sc.entity.v1.CustomerInfo;
import com.sigmatrix.sc.entity.v1.ScanTimeOrder;
import com.sigmatrix.sc.entity.v1.UnactivePrizeInfo;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.ActivityService;
import com.sigmatrix.sc.service.BarcodeALevelService;
import com.sigmatrix.sc.service.UnactivePrizeInfoService;
import com.sigmatrix.sc.utils.Utils;
import com.sigmatrix.sc.vo.ScanTimeOrderVO;
import com.sigmatrix.sc.vo.UnactivePrizeInfoVO;
import com.sigmatrix.sc.web.controller.common.BaseController;

/** 
 * @author  zln:
 * @date 创建时间：2016年8月9日 下午5:18:46 
 * @parameter   
 * @return 
 */
@Controller
@RequestMapping(value="/unactiveprizeinfo")
public class UnactivePrizeInfoController extends BaseController {
	private static Logger logger = Logger.getLogger(UnactivePrizeInfoController.class);
	@Autowired
	private UnactivePrizeInfoService unactivePrizeInfoService;
	@Autowired
	private BarcodeALevelService barcodeALevelService;
	@Autowired
	private ActivityService activityService;
	
	/**
	 * 未激活产品中奖表列表
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(UnactivePrizeInfo unactivePrizeInfo,HttpServletRequest request){		
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		Map<String,Object> map=new HashMap<String, Object>();
		unactivePrizeInfo.setTablePrefix(getTablePrefix(request));
		PageBean<UnactivePrizeInfo> page = new PageBean<UnactivePrizeInfo>(getPageNum(request));
//		page.setPageSize(2);
		try {
			page = unactivePrizeInfoService.getPageUnactivePrizeInfoByExample(page,unactivePrizeInfo,startDateStr,endDateStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询未激活产品中奖表列表出错",e);
			//e.printStackTrace();
		}
		List<UnactivePrizeInfoVO> unactivePrizeInfoVOList = new ArrayList<UnactivePrizeInfoVO>();
 		List<UnactivePrizeInfo> unactivePrizeInfoList = page.getDataList();
		if(unactivePrizeInfoList!=null){
			for(UnactivePrizeInfo upi:unactivePrizeInfoList){
				if(upi!=null && upi.getBarcode()!=null && !upi.getBarcode().equals("")){
					UnactivePrizeInfoVO upiVo = new UnactivePrizeInfoVO();
					upiVo.setUnactivePrizeInfo(upi);
					try {
						BarcodeALevel bal = barcodeALevelService.getBarcodeALevelById(upi.getBarcode(),getTablePrefix(request));
						if(bal!=null){
							upiVo.setEncryptBarcodeBLevelFl(bal.getEncryptBarcodeBLevelFl());
						}
						Activity activity = activityService.getActivityById(Integer.valueOf(upi.getActivityId()), getTablePrefix(request));
						if(activity!=null){
							upiVo.setName(activity.getName());
						}
						upiVo.setPrizeAmountStr(Utils.fenToYuan(upi.getPrizeAmount()));
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						logger.error("一级单品码表出错",e);
					}
					
					unactivePrizeInfoVOList.add(upiVo);
				}
			}		
			
		}
		map.put("unactivePrizeInfoVOList",unactivePrizeInfoVOList);
		map.put("page",page);
		map.put("startDate", startDateStr);
		map.put("endDate", endDateStr);
		return new ModelAndView(JSP_PREFIX+"unactiveprizeinfo/list",map);
	}
}
