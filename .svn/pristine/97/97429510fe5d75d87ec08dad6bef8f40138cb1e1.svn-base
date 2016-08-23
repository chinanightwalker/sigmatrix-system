package com.sigmatrix.sc.web.controller.userscancode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sigmatrix.sc.entity.v1.UserScanCodeTimePrize;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.service.UserScanCodeTimePrizeService;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.utils.Utils;
import com.sigmatrix.sc.vo.UserScanCodeTimePrizeVO;
import com.sigmatrix.sc.web.controller.common.BaseController;

/** 
 * @author  zln:
 * @date 创建时间：2016年8月2日 下午1:43:48 
 * @parameter   
 * @return 
 */
@Controller
@RequestMapping(value="/userScanPrize")
public class UserScanCodeTimePrizeController extends BaseController {
	
	private static Logger logger = Logger.getLogger(UserScanCodeTimePrizeController.class);
	@Autowired
	private UserScanCodeTimePrizeService userScanCodeTimePrizeService;
	
	/**
	 * 奖项设置表查询列表
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(UserScanCodeTimePrize userScanCodeTimePrize,HttpServletRequest request){		
		String scanTimePrizeName = request.getParameter("scanTimePrizeName");
		if(StringUtils.isNotBlank(scanTimePrizeName)){
			userScanCodeTimePrize.setScanTimePrizeName(scanTimePrizeName);
		}		
		Map<String,Object> map=new HashMap<String, Object>();
		userScanCodeTimePrize.setTablePrefix(getTablePrefix(request));
		List<UserScanCodeTimePrize> userScanCodeTimePrizeList = new ArrayList<UserScanCodeTimePrize>();
		try {
			userScanCodeTimePrizeList = userScanCodeTimePrizeService.getPageUserScanCodeTimePrizeByExample(userScanCodeTimePrize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询奖项设置出错",e);
			//e.printStackTrace();
		} 
		List<UserScanCodeTimePrizeVO> userScanCodeTimePrizeVOList = new ArrayList<UserScanCodeTimePrizeVO>();
		if(userScanCodeTimePrizeList!=null && userScanCodeTimePrizeList.size()>0){
			for(UserScanCodeTimePrize usctp : userScanCodeTimePrizeList){
				UserScanCodeTimePrizeVO userScanCodeTimePrizeVO = new UserScanCodeTimePrizeVO();
				userScanCodeTimePrizeVO.setUserScanCodeTimePrize(usctp);
				userScanCodeTimePrizeVO.setScanTimePrizeAmountStr(Utils.fenToYuan(usctp.getScanTimePrizeAmount()));
				userScanCodeTimePrizeVOList.add(userScanCodeTimePrizeVO);
			}
			
		}
		map.put("userScanCodeTimePrizeVOList",userScanCodeTimePrizeVOList);		
		map.put("scanTimePrizeName",scanTimePrizeName);
		map.put("userScanCodeTimePrize",userScanCodeTimePrize);
		return new ModelAndView(JSP_PREFIX+"userScanPrize/list",map);
	}
	
	
	/**
	 * 奖项设置管理-增加
	 */
	@RequestMapping(value = "/add")
	@RequiresPermissions("userscancodetimeprize:insert")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(JSP_PREFIX + "userScanPrize/add");
		return mav;
	}
	
	/**
	 * 奖项设置管理-修改
	 */
	@RequestMapping(value = "/edit")
	@RequiresPermissions("userscancodetimeprize:update")
	public ModelAndView edit(UserScanCodeTimePrize userScanCodeTimePrize,HttpServletRequest request) {
		String scanTimePrizeId = request.getParameter("scanTimePrizeId");
		try {
			userScanCodeTimePrize = userScanCodeTimePrizeService.getUserScanCodeTimePrizeBykey(Integer.parseInt(scanTimePrizeId), getTablePrefix(request));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			logger.error("查询单个奖项时转换金额出错", e);
			//e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询单个奖项出错",e);
			//e.printStackTrace();
		}
		String scanTimePrizeAmountStr = Utils.fenToYuan(userScanCodeTimePrize.getScanTimePrizeAmount());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userScanCodeTimePrize", userScanCodeTimePrize);
		map.put("scanTimePrizeAmountStr",scanTimePrizeAmountStr);
		return new ModelAndView(JSP_PREFIX + "userScanPrize/edit",map);
	}
	
	/*
	 * 添加奖项设置保存
	 */
	@RequestMapping(value = "/saveAdd")
	public @ResponseBody JsonEdit saveAdd(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		String scanTimePrizeName = request.getParameter("scanTimePrizeName");
		String scanTimePrizeAmount = request.getParameter("scanTimePrizeAmount");
		String useScanTime = request.getParameter("useScanTime");
		String scanTimePrizeType = request.getParameter("scanTimePrizeType");
		//String regexTem = "^-?\\d+(\\.\\d{1,2}+)?$";
		String regexTem = "^\\d+(\\.\\d{1,2}+)?$";
		if(!Pattern.compile(regexTem).matcher(scanTimePrizeAmount).matches()){
			return new JsonEdit("300","奖项金额不正确","","","", "");
		}
		if(Integer.parseInt(scanTimePrizeAmount.substring(0,1))==0){
			return new JsonEdit("300","奖项金额必须大于1元","","","", "");
		}
		//判断扫码次数不能与数据库中存在的正常奖项的次数相同
		if (StringUtils.isNotBlank(useScanTime)) {
			if (checkUseScanTime(Integer.valueOf(useScanTime), getTablePrefix(request))) {
				return new JsonEdit("300","扫码次数不能与其他奖项扫码次数相同，请重新输入！","","","", "");
			}
		}
		UserScanCodeTimePrize usctp = new UserScanCodeTimePrize();
		usctp.setStatus(1);
		usctp.setCreateTime(new Date());
		usctp.setScanTimePrizeName(scanTimePrizeName);
		usctp.setScanTimePrizeAmount(Integer.parseInt(Utils.yuanToFen(scanTimePrizeAmount)));
		usctp.setUseScanTime(Integer.parseInt(useScanTime));
		usctp.setScanTimePrizeType(Integer.parseInt(scanTimePrizeType));
		usctp.setTablePrefix(getTablePrefix(request));
		try {
			userScanCodeTimePrizeService.saveOrUpdateUserScanCodeTimePrize(usctp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("添加奖项设置出错", e);
			return new JsonEdit("300","保存失败","","","", "");
			//e.printStackTrace();
		}			
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "userScanPrize/list");
	}
	
	
	
	/*
	 * 修改奖项设置保存
	 */
	@RequestMapping(value = "/saveEdit")
	public @ResponseBody JsonEdit saveEdit(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		String scanTimePrizeId = request.getParameter("scanTimePrizeId");		
		String scanTimePrizeName = request.getParameter("scanTimePrizeName");
		String scanTimePrizeAmount = request.getParameter("scanTimePrizeAmount");
		String useScanTime = request.getParameter("useScanTime");
		String scanTimePrizeType = request.getParameter("scanTimePrizeType");
		//String regexTem = "^-?\\d+(\\.\\d{1,2}+)?$";
		String regexTem = "^\\d+(\\.\\d{1,2}+)?$";
		if(!Pattern.compile(regexTem).matcher(scanTimePrizeAmount).matches()){
			return new JsonEdit("300","奖项金额不正确","","","", "");
		}
		if(Integer.parseInt(scanTimePrizeAmount.substring(0,1))==0){
			return new JsonEdit("300","奖项金额必须大于1元","","","", "");
		}
		//判断扫码次数不能与数据库中存在的正常奖项的次数相同
		if (StringUtils.isNotBlank(useScanTime)) {
			if (checkUseScanTime(Integer.valueOf(useScanTime), getTablePrefix(request))) {
				return new JsonEdit("300","扫码次数不能与其他奖项扫码次数相同，请重新输入！","","","", "");
			}
		}
		UserScanCodeTimePrize usctp = null;
		try {
			usctp = userScanCodeTimePrizeService.getUserScanCodeTimePrizeBykey(Integer.parseInt(scanTimePrizeId), getTablePrefix(request));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			logger.error("主键ID转换出错", e1);
			//e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error("根据主键ID查询奖项设置出错", e1);
			//e1.printStackTrace();
		}
		
		usctp.setUpdateTime(new Date());
		usctp.setScanTimePrizeName(scanTimePrizeName);
		usctp.setScanTimePrizeAmount(Integer.parseInt(Utils.yuanToFen(scanTimePrizeAmount)));
		usctp.setUseScanTime(Integer.parseInt(useScanTime));
		usctp.setScanTimePrizeType(Integer.parseInt(scanTimePrizeType));
		usctp.setTablePrefix(getTablePrefix(request));
		try {
			userScanCodeTimePrizeService.saveOrUpdateUserScanCodeTimePrize(usctp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("修改奖项设置出错", e);
			return new JsonEdit("300","保存失败","","","", "");
			//e.printStackTrace();
		}			
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "userScanPrize/list");
	}
	
	
	/*
	 * 修改奖项设置保存
	 */
	@RequestMapping(value = "/delete")
	@RequiresPermissions("userscancodetimeprize:delete")
	public @ResponseBody JsonEdit delete(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		String scanTimePrizeId = request.getParameter("scanTimePrizeId");		
		UserScanCodeTimePrize usctp = null;
		try {
			usctp = userScanCodeTimePrizeService.getUserScanCodeTimePrizeBykey(Integer.parseInt(scanTimePrizeId), getTablePrefix(request));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			logger.error("主键ID转换出错", e1);
			//e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			logger.error("根据主键ID查询奖项设置出错", e1);
			//e1.printStackTrace();
		}
		
		usctp.setUpdateTime(new Date());
		usctp.setStatus(0);
		usctp.setTablePrefix(getTablePrefix(request));
		try {
			userScanCodeTimePrizeService.saveOrUpdateUserScanCodeTimePrize(usctp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("删除奖项设置出错", e);
			return new JsonEdit("300","保存失败","","","", "");
			//e.printStackTrace();
		}			
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "userScanPrize/list");
	}
	
	
	/**
	 * 奖项设置管理-查看
	 */
	@RequestMapping(value = "/detail")
//	@RequiresPermissions("product:update")
	public ModelAndView detail(UserScanCodeTimePrize userScanCodeTimePrize,HttpServletRequest request) {
		String scanTimePrizeId = request.getParameter("scanTimePrizeId");
		String scanTimePrizeName = request.getParameter("scanTimePrizeName");
		try {
			userScanCodeTimePrize = userScanCodeTimePrizeService.getUserScanCodeTimePrizeBykey(Integer.parseInt(scanTimePrizeId), getTablePrefix(request));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			logger.error("查询单个奖项时转换金额出错", e);
			//e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询单个奖项出错",e);
			//e.printStackTrace();
		}
		String scanTimePrizeAmountStr = Utils.fenToYuan(userScanCodeTimePrize.getScanTimePrizeAmount());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userScanCodeTimePrize", userScanCodeTimePrize);
		map.put("scanTimePrizeName",scanTimePrizeName);
		map.put("scanTimePrizeAmountStr",scanTimePrizeAmountStr);
		return new ModelAndView(JSP_PREFIX + "userScanPrize/detail",map);
	}
	
	/**
	 * 判断扫码次数是否在数据库中重复（判断奖项状态不为删除的奖项）
	 * @param useScanTime
	 * @return
	 */
	private boolean checkUseScanTime(Integer useScanTime, String tablePrefix){
		try {
			List<UserScanCodeTimePrize> list = userScanCodeTimePrizeService.getUserPrizeList(tablePrefix);
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					if (useScanTime == list.get(i).getUseScanTime()) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			logger.error("判断扫码次数是否在数据库中重复出错", e);
		}
		
		return false;
	}
}
