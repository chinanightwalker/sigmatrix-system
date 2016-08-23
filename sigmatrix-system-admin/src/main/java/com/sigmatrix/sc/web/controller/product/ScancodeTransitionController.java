package com.sigmatrix.sc.web.controller.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.ScancodeTransitionService;
import com.sigmatrix.sc.utils.DateUtil;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.web.controller.common.BaseController;
import com.sigmatrix.sc.web.vo.ScancodeTransitionVo;





/**
  * 产品过渡页管理	 
  * @author zyc 作者 E-mail: 
  * @date 创建时间：2016年7月19日 上午9:30:19
  * @version 1.0
  * @parameter
  * @since
  * @return
  */
@Controller
@RequestMapping(value="/productTransitionage")
public class ScancodeTransitionController extends BaseController {

	private static Logger logger = Logger.getLogger(ScancodeTransitionController.class);
	@Autowired
	private ScancodeTransitionService scancodeTransitionService;
	/**
	 * 获取产品过渡页管理列表
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView List(ScancodeTransition transition ,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String, Object>();
		transition.setTablePrefix(getTablePrefix(request));
		PageBean<ScancodeTransition> page = new PageBean<ScancodeTransition>(getPageNum(request));
		List<ProductBase> productList = new ArrayList<ProductBase>();
		try {
			productList = scancodeTransitionService.queryProductBaseList(getTablePrefix(request));
			page = scancodeTransitionService.queryScanCodeTransitionList(page,transition);
		} catch (Exception e) {
			logger.error("transition list fail",e);
		}
		map.put("page",page);
		map.put("productList",productList);
		map.put("transition",transition);
		return new ModelAndView(JSP_PREFIX+"scancodeTransition/list",map);
	}
	/**
	 * 去添加界面
	 * @return
	 */
	@RequestMapping(value="/toEdit")
	@RequiresPermissions("productTransitionage:insert")
	public ModelAndView toEdit(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String, Object>();
		List<ProductBase> productList = new ArrayList<ProductBase>();
		try {
			productList = scancodeTransitionService.queryProductBaseList(getTablePrefix(request));
		} catch (Exception e) {
			logger.error("transition toEdit fail",e);
		}
		map.put("productList",productList);
		return new ModelAndView(JSP_PREFIX+"scancodeTransition/edit", map);
	}
	/**
	 * 去修改页面
	 * @return
	 */
	@RequestMapping(value="/toUpdate/{transitionId}")
	@RequiresPermissions("productTransitionage:update")
	public ModelAndView toUpdate(@PathVariable("transitionId") Integer transitionId,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String, Object>();
		List<ProductBase> productList = new ArrayList<ProductBase>();
		ScancodeTransition transition = null;
		try {
			transition = scancodeTransitionService.queryScanCodeTransitionByTransitionId(transitionId,getTablePrefix(request));
			productList = scancodeTransitionService.queryProductBaseList(getTablePrefix(request));
		} catch (Exception e) {
			logger.error("transition toUpdate fail",e);
		}
		map.put("productList",productList);
		map.put("transition",transition);
	    return new ModelAndView(JSP_PREFIX+"scancodeTransition/edit", map);
	}
	/**
	 * 删除过渡页
	 */
	@RequestMapping(value="/remove/{transitionId}")
	@RequiresPermissions("productTransitionage:delete")
	public @ResponseBody JsonEdit remove(@PathVariable Integer transitionId,HttpServletRequest request){

		if (transitionId != null) {
			try {
				ScancodeTransition transition = scancodeTransitionService.queryScanCodeTransitionByTransitionId(transitionId, getTablePrefix(request));
				transition.setTablePrefix(getTablePrefix(request));
				scancodeTransitionService.removeTransition(transition);
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "productTransitionage/list");
			} catch (Exception e) {
				logger.error("transition remove fail",e);
				return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(), StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
			}
		}else {
			return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(), StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
		}
	}
	/**
	 * 保存或修改产品过渡页
	 * @param transitionVo
	 * @return
	 */
	@RequestMapping(value="/saveOrUpdate")
	public @ResponseBody JsonEdit saveOrUpdate(HttpServletRequest request, ScancodeTransitionVo transitionVo){
		try {
			//transitionVo.getTransitionId()不为空修改，为空新增
			if (transitionVo.getTransitionId() != null) {
				Integer transitionId = transitionVo.getTransitionId();
				ScancodeTransition transitionOld = scancodeTransitionService.queryScanCodeTransitionByTransitionId(transitionId, getTablePrefix(request));
				transitionOld.setProductId(transitionVo.getProductId());
				transitionOld.setTablePrefix(getTablePrefix(request));
				transitionOld.setIsOpen(transitionVo.getIsOpen());
				transitionOld.setPicPath(transitionVo.getPicPath());
				transitionOld.setPicUrl(transitionVo.getPicUrl());
				transitionOld.setEndTime(DateUtil.getDateByStr(transitionVo.getEndTime()));
				transitionOld.setStartTime(DateUtil.getDateByStr(transitionVo.getStartTime()));
				transitionOld.setUpdateTime(new Date());
				transitionOld.setUpdateUserid(getSessionUserId(request));
				scancodeTransitionService.saveOrUpdateTransition(transitionOld);
			}else {
				//新增
				ScancodeTransition transitionNew = new ScancodeTransition();
				transitionNew.setTablePrefix(getTablePrefix(request));
				transitionNew.setIsOpen(transitionVo.getIsOpen());
				transitionNew.setPicPath(transitionVo.getPicPath());
				transitionNew.setPicUrl(transitionVo.getPicUrl());
				transitionNew.setProductId(transitionVo.getProductId());
				transitionNew.setEndTime(DateUtil.getDateByStr(transitionVo.getEndTime()));
				transitionNew.setStartTime(DateUtil.getDateByStr(transitionVo.getStartTime()));
				transitionNew.setCreateTime(new Date());
				transitionNew.setCreateUserid(getSessionUserId(request));
				transitionNew.setStatus(1);
				scancodeTransitionService.saveOrUpdateTransition(transitionNew);
			}
		} catch (Exception e) {
			logger.error("transition saveOrUpdate fail",e);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(), StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
		}
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "productTransitionage/list");
	}
}
