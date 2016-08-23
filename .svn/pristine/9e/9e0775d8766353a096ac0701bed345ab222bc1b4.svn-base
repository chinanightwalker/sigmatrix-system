package com.sigmatrix.sc.web.controller.scan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sigmatrix.sc.entity.v1.CustomerInfo;
import com.sigmatrix.sc.entity.v1.ScanTimeOrder;
import com.sigmatrix.sc.entity.v1.UserScanCodeTimePrize;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.CustomerInfoService;
import com.sigmatrix.sc.service.ScanTimeOrderService;
import com.sigmatrix.sc.service.UserScanCodeTimePrizeService;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.vo.ScanTimeOrderVO;
import com.sigmatrix.sc.web.controller.common.BaseController;

/** 
 * @author  zln:
 * @date 创建时间：2016年8月1日 下午5:12:51 
 * @parameter   
 * @return 
 */ 
@Controller
@RequestMapping(value="/scanTimeOrder")
public class ScanTimeOrderController extends BaseController {
	private static Logger logger = Logger.getLogger(ScanTimeOrderController.class);
	@Autowired
	private ScanTimeOrderService scanTimeOrderService;
	@Autowired
	private CustomerInfoService customerInfoService;
	@Autowired
	private UserScanCodeTimePrizeService userScanCodeTimePrizeService;
	
	/**
	 * 分页查询累计扫码兑奖列表
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(ScanTimeOrder scanTimeOrder,HttpServletRequest request){		
		String scanCodeOrderId = request.getParameter("scanCodeOrderId");
		String status = request.getParameter("status");
		String tel = request.getParameter("tel");
		String duijiangStatus = request.getParameter("duijiangStatus");
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		if(StringUtils.isNotBlank(scanCodeOrderId)){
			scanTimeOrder.setScanCodeOrderId(scanCodeOrderId);
		}
		if(StringUtils.isNotBlank(status)){
			scanTimeOrder.setStatus(Integer.parseInt(status));
		}
		if(StringUtils.isNotBlank(tel)){			
			scanTimeOrder.setTel(tel);
		}
		if(StringUtils.isNotBlank(duijiangStatus)){
			scanTimeOrder.setDuijiangStatus(Integer.parseInt(duijiangStatus));
		}
		
		Map<String,Object> map=new HashMap<String, Object>();
		scanTimeOrder.setTablePrefix(getTablePrefix(request));
		PageBean<ScanTimeOrder> page = new PageBean<ScanTimeOrder>(getPageNum(request));
//		page.setPageSize(2);
		try {
			page = scanTimeOrderService.getPageScanTimeOrderByExample(page,scanTimeOrder,startDateStr,endDateStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询累计扫码次数出错",e);
			//e.printStackTrace();
		}
		List<ScanTimeOrderVO> scanTimeOrderVOList = new ArrayList<ScanTimeOrderVO>();
 		List<ScanTimeOrder> scanTimeOrderList = page.getDataList();
//		if(scanTimeOrderList!=null){
//			for(ScanTimeOrder sto:scanTimeOrderList){
//				if(sto!=null && sto.getUserId()!=null && sto.getUserId()!=0){
//					ScanTimeOrderVO stoVo = new ScanTimeOrderVO();
//					try {
//						CustomerInfo ci = customerInfoService.getCustomerInfoById(sto.getUserId(),getTablePrefix(request));
//						if(ci!=null && ci.getCustomerName()!=null){
//							stoVo.setUserName(ci.getCustomerName());
//						}
//						stoVo.setScanTimeOrder(sto);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					scanTimeOrderVOList.add(stoVo);
//				}
//			}		
//			
//		}
		//map.put("scanTimeOrderVOList",scanTimeOrderVOList);
 		map.put("scanTimeOrderList",scanTimeOrderList);
		map.put("page",page);
		map.put("startDate", startDateStr);
		map.put("endDate", endDateStr);
		map.put("scanTimeOrder", scanTimeOrder);
		return new ModelAndView(JSP_PREFIX+"scan/list",map);
	}
	
	
	@RequestMapping(value="/detail")
	public ModelAndView detail(ScanTimeOrder scanTimeOrder,HttpServletRequest request){	
		String tel = request.getParameter("tel");
		String duijiangStatus = request.getParameter("duijiangStatus");
		String scanCodeOrderIdTem = request.getParameter("scanCodeOrderIdTem");
		String scanCodeOrderId = request.getParameter("scanCodeOrderId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		ScanTimeOrder sto = null;
		try {
			sto = scanTimeOrderService.getScanTimeOrderByKey(scanCodeOrderId, getTablePrefix(request));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error("查询累计扫码次数出错",e1);
			//e1.printStackTrace();
		}
		ScanTimeOrderVO stoVO = new ScanTimeOrderVO();
		try {
			if(sto!=null){			
				CustomerInfo ci = customerInfoService.getCustomerInfoById(sto.getUserId(),getTablePrefix(request));
				if(ci!=null && ci.getOpenId()!=null){
					stoVO.setOpenId(ci.getOpenId());
					stoVO.setUserName(ci.getCustomerName());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("累计扫码兑奖详情查询消费者信息报错",e);
			//e.printStackTrace();
		}
		UserScanCodeTimePrize usctp = null;
		try {
			usctp = userScanCodeTimePrizeService.getUserScanCodeTimePrizeBykey(sto.getScanTimePrizeId(), getTablePrefix(request));
			if(usctp!=null){
				stoVO.setScanTimePrizeName(usctp.getScanTimePrizeName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询奖项设置出错",e);
			//e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stoVO",stoVO);
		map.put("sto",sto);
		map.put("tel",tel);
		map.put("duijiangStatus",duijiangStatus);
		map.put("scanCodeOrderIdTem",scanCodeOrderIdTem);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		return new ModelAndView(JSP_PREFIX+"scan/detail",map);
	}
	
	
	@RequestMapping(value="/sendDelivery")
	@RequiresPermissions("scantimeorder:update")
	public ModelAndView sendDelivery(ScanTimeOrder scanTimeOrder,HttpServletRequest request){	
		String tel = request.getParameter("tel");
		String duijiangStatus = request.getParameter("duijiangStatus");
		String scanCodeOrderIdTem = request.getParameter("scanCodeOrderIdTem");
		String scanCodeOrderId = request.getParameter("scanCodeOrderId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		ScanTimeOrder sto = null;
		try {
			sto = scanTimeOrderService.getScanTimeOrderByKey(scanCodeOrderId, getTablePrefix(request));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error("累计扫码兑奖详情查询信息报错",e1);
			//e1.printStackTrace();
		}
		ScanTimeOrderVO stoVO = new ScanTimeOrderVO();
		try {
			if(sto!=null){			
				CustomerInfo ci = customerInfoService.getCustomerInfoById(sto.getUserId(),getTablePrefix(request));
				if(ci!=null){
					stoVO.setOpenId(ci.getOpenId());
					stoVO.setUserName(ci.getCustomerName());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("累计扫码兑奖详情查询消费者信息报错",e);
			//e.printStackTrace();
		}
		UserScanCodeTimePrize usctp = null;
		try {
			usctp = userScanCodeTimePrizeService.getUserScanCodeTimePrizeBykey(sto.getScanTimePrizeId(), getTablePrefix(request));
			if(usctp!=null){
				stoVO.setScanTimePrizeName(usctp.getScanTimePrizeName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询奖项设置出错",e);
			//e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stoVO",stoVO);
		map.put("sto",sto);
		map.put("tel",tel);
		map.put("duijiangStatus",duijiangStatus);
		map.put("scanCodeOrderIdTem",scanCodeOrderIdTem);
		map.put("scanCodeOrderId",scanCodeOrderId);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		return new ModelAndView(JSP_PREFIX+"scan/sendDelivery",map);
	}
	
	
	/*
	 * 修改发货状态保存
	 */
	@RequestMapping(value = "/save")
	@RequiresPermissions("scantimeorder:update")
	public @ResponseBody JsonEdit save(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		String tel = request.getParameter("tel");
		String duijiangStatus = request.getParameter("duijiangStatus");
		String scanCodeOrderIdTem = request.getParameter("scanCodeOrderIdTem");
		String scanCodeOrderId = request.getParameter("scanCodeOrderId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		ScanTimeOrder sto = null;
		try {
			sto = scanTimeOrderService.getScanTimeOrderByKey(scanCodeOrderId, getTablePrefix(request));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("累计扫码兑奖查询出错",e);
			//e.printStackTrace();
		}
		sto.setStatus(1);
		sto.setTablePrefix(getTablePrefix(request));
		try {
			scanTimeOrderService.saveOrUpdateScanTimeOrder(sto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("修改发货状态报错",e);
			//e.printStackTrace();
			return new JsonEdit("300","保存失败","","","", "");
		}		
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "scanTimeOrder/list?tel="+tel+"&duijiangStatus="+duijiangStatus+"&scanCodeOrderId="+scanCodeOrderIdTem+"&startDate="+startDate+"&endDate="+endDate);
	}
}
