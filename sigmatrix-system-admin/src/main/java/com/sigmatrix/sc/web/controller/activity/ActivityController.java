package com.sigmatrix.sc.web.controller.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityPrize;
import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.service.ActivityPrizeService;
import com.sigmatrix.sc.service.ActivityService;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.web.controller.common.BaseController;
import com.sigmatrix.sc.web.vo.ActivityAddVo;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/activity")
public class ActivityController extends BaseController {

	private static Logger logger = Logger.getLogger(ActivityController.class);
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivityPrizeService activityPrizeService;
	
	/**
	 * 查询活动列表
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Activity activity,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String, Object>();
		activity.setTablePrefix(getTablePrefix(request));
		List<Activity> activityList = new ArrayList<Activity>(getPageNum(request));
		try {
			activityList = activityService.getListActivityByExample(activity);
		} catch (Exception e) {
			logger.error("activity list fail",e);
		}
		map.put("activityList",activityList);
		return new ModelAndView(JSP_PREFIX+"activity/list",map);
	}
	/**
	 * 删除活动（修改状态）
	 * @param activityId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete")
	@RequiresPermissions("activity:delete")
	public @ResponseBody JsonEdit  delete(HttpServletRequest request){
		String activityId = request.getParameter("activityId");
		if (StringUtils.isNotBlank(activityId)) {
			try {
				//如果活动打开，不做修改
				if (activityService.getActivityIsOpen(Integer.valueOf(activityId),getTablePrefix(request))) {
					return new JsonEdit(StateInfoEnum.ACTIVITY_NOTFULL.getRetCode(),"活动已开启，禁止删除！","","","","");
				}
				Activity activity = activityService.getActivityById(Integer.valueOf(activityId), getTablePrefix(request));
				activity.setTablePrefix(getTablePrefix(request));
				activityService.deleteActivity(activity);
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "activity/list");
			} catch (Exception e) {
				logger.error("activity remove fail",e);
				return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
			}
		}else {
			logger.error("activity remove activityId="+activityId);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
		}
	}
	/**
	 * 跳转新增页面
	 * @return
	 */
	@RequestMapping(value="/toEdit")
	@RequiresPermissions(value={"activity:insert", "activity:update"})
	public String toEdit( HttpServletRequest request){
		try{
			String step = request.getParameter("step");
			String activityId = request.getParameter("activityId");
			String editFlag = request.getParameter("editFlag");
			if (StringUtils.isBlank(step)) {
				step = "";
			}
			if (StringUtils.isBlank(activityId)) {
				activityId = "";
			}
			if (StringUtils.isBlank(editFlag)) {
				editFlag = "";
			}
			if (StringUtils.equalsIgnoreCase(step, "2")) {
				logger.error("activity toEdit activityId="+activityId);
				return "redirect:/prize/list?activityId="+activityId+"&editFlag=2"+"&step="+step;
			}else {
				logger.error("activity toEdit activityId="+activityId+"&step="+step+"&editFlag"+editFlag);
				return "redirect:/activity/toEditJSP?step="+step+"&activityId="+activityId+"&editFlag="+editFlag;
			}
		}catch(Exception e){
			logger.error("activity toEdit fail",e);
			return "redirect:/activity/list";
		}
	}
	/**
	 * 处理跳转页面
	 * @param step
	 * @param activityId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/toEditJSP")
	@RequiresPermissions(value={"activity:insert", "activity:update"})
	public ModelAndView toEditJSP(HttpServletRequest request){
		String step = request.getParameter("step");
		String activityId = request.getParameter("activityId");
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			if (StringUtils.isNotBlank(activityId)) {
				Activity activity = activityService.getActivityById(Integer.valueOf(activityId), getTablePrefix(request));
				map.put("activity", activity);
				map.put("activityId", activityId);
				
			}
			ArrayList<ActivityTemplate> activityTemplateList = activityService.getActivityTemplateList(getTablePrefix(request));
			if (activityTemplateList != null) {
				map.put("activityTemplateList", activityTemplateList);
			}
			if (StringUtils.isBlank(step)) {
				logger.error("activity toEditJSP edit01");
				return new ModelAndView(JSP_PREFIX+"activity/edit01",map);
			}else if (StringUtils.equalsIgnoreCase(step, "1")) {
				logger.error("activity toEditJSP edit02");
				return new ModelAndView(JSP_PREFIX+"activity/edit02",map);
			}else if (StringUtils.equalsIgnoreCase(step, "3")) {
				map = activityProduct(map, Integer.valueOf(activityId),getTablePrefix(request));
				logger.error("activity toEditJSP edit04");
				return new ModelAndView(JSP_PREFIX+"activity/edit04",map);
			}else if(StringUtils.equalsIgnoreCase(step, "4")){
				logger.error("activity toEditJSP edit05");
				return new ModelAndView(JSP_PREFIX+"activity/edit05",map);
			}else{
				logger.error("activity toEditJSP edit01");
				return new ModelAndView(JSP_PREFIX+"activity/edit01",map);
			}
		}catch(Exception e){
			logger.error("activity toEditJSP fail",e);
			return new ModelAndView(JSP_PREFIX+"activity/list",map);
		}
	}
	/**
	 * 活动第四步设置活动
	 * @param map
	 * @return
	 */
	private Map<String, Object> activityProduct(Map<String, Object>  map, Integer activityId,String tablePrefix) throws Exception{
		// 活动已绑定产品 productBaseList
		List<ProductActivity> activityBindProduct = activityService
				.getActivityBindProduct(activityId,tablePrefix);
		map.put("activityBindProduct", activityBindProduct);
		// 活动可绑定产品
		List<ProductBase> activityCanBindProduct = activityService
				.activityCanBindProduct(tablePrefix);
		map.put("activityCanBindProduct", activityCanBindProduct);
		// 没有可选产品,页面提示
		if((activityBindProduct==null||activityBindProduct.isEmpty())
				&&(activityCanBindProduct==null||activityCanBindProduct.isEmpty())){
			boolean isNotProduct = true;
			map.put("isNotProduct",isNotProduct);
		}
		return map;
	}
	/**
	 * 开启/关闭活动
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/openOrClose")
	@RequiresPermissions("activity:switch")
	public @ResponseBody JsonEdit openOrClose(HttpServletRequest request){
		String activityId = request.getParameter("activityId");
		String isOpen = request.getParameter("isOpen");
		try{
			if (StringUtils.isBlank(activityId)) {
				return new JsonEdit(StateInfoEnum.ACTIVITY_NULL.getRetCode(),StateInfoEnum.ACTIVITY_NULL.getRetInfo(),"","","","");
			}
			Activity oldActivity = activityService.getActivityById(Integer.valueOf(activityId), getTablePrefix(request));
			if (oldActivity == null) {
				return new JsonEdit(StateInfoEnum.ACTIVITY_NULL.getRetCode(),StateInfoEnum.ACTIVITY_NULL.getRetInfo(),"","","","");
			}
			if (StringUtils.isBlank(isOpen)) {
				return new JsonEdit(StateInfoEnum.ACTIVITY_OPENORCLOSE_UNUSUAL.getRetCode(),StateInfoEnum.ACTIVITY_OPENORCLOSE_UNUSUAL.getRetInfo(),"","","","");
			}
			if (StringUtils.equalsIgnoreCase(isOpen, "0")) {
				//关闭活动
				oldActivity.setIsOpen(Integer.valueOf(isOpen));
			}else {
				if (oldActivity.getStep() == null) {
					return new JsonEdit(StateInfoEnum.ACTIVITY_NOTFULL.getRetCode(),StateInfoEnum.ACTIVITY_NOTFULL.getRetInfo(),"","","","");
				}
				if (oldActivity.getStep() == 1) {
					return new JsonEdit(StateInfoEnum.ACTIVITY_NO_INFO.getRetCode(),StateInfoEnum.ACTIVITY_NO_INFO.getRetInfo(),"","","","");
				}
				if (oldActivity.getStep() == 2) {
					return new JsonEdit(StateInfoEnum.ACTIVITY_NO_PRIZES.getRetCode(),StateInfoEnum.ACTIVITY_NO_PRIZES.getRetInfo(),"","","","");
				}
				if (oldActivity.getStep() == 3) {
					return new JsonEdit(StateInfoEnum.ACTIVITY_NO_PRODUCT.getRetCode(),StateInfoEnum.ACTIVITY_NO_PRODUCT.getRetInfo(),"","","","");
				}
				oldActivity.setIsOpen(Integer.valueOf(isOpen));
			}
			oldActivity.setUpdateTime(new Date());
			oldActivity.setTablePrefix(getTablePrefix(request));
			activityService.saveActivity(oldActivity);
		}catch(Exception e){
			logger.error("activity openOrClose fail",e);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
		}
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS.getRetCode(),StateInfoEnum.DATA_SUCCESS.getRetInfo(),"","","","");
	}
	/**
	 * 保存活动类型
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveActivityType")
	public @ResponseBody JsonEdit saveActivityType(HttpServletRequest request){
		String activityId = request.getParameter("activityId");
		String type = request.getParameter("type");
		String isIntegral = request.getParameter("isIntegral");
		try{
			if (StringUtils.isBlank(activityId)) {
				//新增
				Activity NewActivity = new Activity();
				NewActivity.setTablePrefix(getTablePrefix(request));
				//判断活动类型是否选择
				if (StringUtils.isNotBlank(type)) {
					if (StringUtils.equalsIgnoreCase(type, "1")) {
						NewActivity.setIsIntegral(0);//扫码类型活动，非积分抽奖
					}else if (StringUtils.equalsIgnoreCase(type, "4")) {
						NewActivity.setIsIntegral(1);//积分类型活动，积分抽奖
					}else {
						NewActivity.setIsIntegral(0);//即开即中、轮盘，暂时为非积分抽奖
					}
					NewActivity.setIsOpen(0);//关闭
					NewActivity.setType(Integer.valueOf(type));
					NewActivity.setAccountId(getSessionUserId(request));
					NewActivity.setCreateTime(new Date());
					NewActivity.setStatus(1);//正常
					NewActivity.setStep(1);//保存到活动类型步
					activityService.saveActivity(NewActivity);
					//返回结果
					logger.error("activity saveActivityType NewActivity="+NewActivity);
					return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "activity/toEdit?step=1&activityId="+NewActivity.getActivityId());
				}else {
					//未选择活动类型，提示选择活动类型
					return new JsonEdit(StateInfoEnum.ACTIVITY_TYPE_FAILURE.getRetCode(),StateInfoEnum.ACTIVITY_TYPE_FAILURE.getRetInfo(),"","","", "");
				}
			}else {
				//修改
				//如果活动打开，不做修改
				if (activityService.getActivityIsOpen(Integer.valueOf(activityId),getTablePrefix(request))) {
					return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "activity/toEdit?step=1&activityId="+Integer.valueOf(activityId));
				}
				Activity OldActivity = activityService.getActivityById(Integer.valueOf(activityId), getTablePrefix(request));
				if (OldActivity!=null) {
					OldActivity.setTablePrefix(getTablePrefix(request));
					//判断是否选择活动类型
					if (StringUtils.isNotBlank(type)) {
						if (StringUtils.equalsIgnoreCase(type, "1")) {
							OldActivity.setIsIntegral(0);//扫码类型活动，非积分抽奖
						}else if (StringUtils.equalsIgnoreCase(type, "4")) {
							OldActivity.setIsIntegral(1);//积分类型活动，积分抽奖
						}else {
							OldActivity.setIsIntegral(0);//即开即中、轮盘，暂时为非积分抽奖
						}
						OldActivity.setType(Integer.valueOf(type));
						OldActivity.setIsIntegral(Integer.valueOf(isIntegral));
						OldActivity.setAccountId(getSessionUserId(request));
						OldActivity.setUpdateTime(new Date());
						activityService.saveActivity(OldActivity);
						//返回结果
						logger.error("activity saveActivityType OldActivity="+OldActivity);
						return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "activity/toEdit?step=1&activityId="+OldActivity.getActivityId());
					}else {
						//未选择活动类型，提示选择活动类型
						return new JsonEdit(StateInfoEnum.ACTIVITY_TYPE_FAILURE.getRetCode(),StateInfoEnum.ACTIVITY_TYPE_FAILURE.getRetInfo(),"","","", "");
					}
				}else {
					return new JsonEdit(StateInfoEnum.ACTIVITY_TYPE_ERROR.getRetCode(),StateInfoEnum.ACTIVITY_TYPE_ERROR.getRetInfo(),"","","", "");
				}
			}
		}catch(Exception e){
			logger.error("activity saveActivityType fail",e);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
		}
	}
	/**
	 * 保存活动信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveActivityInfo")
	@ResponseBody
	public JsonEdit saveActivityInfo(@Valid ActivityAddVo activity,BindingResult result, HttpServletRequest request){
		try{
			//如果活动打开，不做修改
			if (activityService.getActivityIsOpen(activity.getActivityId(),getTablePrefix(request))) {
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "activity/toEdit?step=2&activityId="+activity.getActivityId());
			}
			String error = "";
			if(result.hasErrors()){
				error = result.getAllErrors().get(0).getDefaultMessage();
				return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),error,"","","","");
			}
			//判断库中是否有此信息
			Activity OldActivity = activityService.getActivityById(activity.getActivityId(), getTablePrefix(request));
			if (OldActivity == null) {
				return new JsonEdit(StateInfoEnum.ACTIVITY_INFO_ERROR.getRetCode(),StateInfoEnum.ACTIVITY_INFO_ERROR.getRetInfo(),"","","","");
			}
			//活动起止日期验证
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
			Date startDate = sdf.parse(activity.getStartDate());
			Date endDate= sdf.parse(activity.getEndDate());
			Date awardEndDate = sdf.parse(activity.getAwardEndDate());
			Integer validDateType = activity.getValidDateType();
			if (startDate.getTime() > endDate.getTime()) {
				 return new JsonEdit(StateInfoEnum.ACTIVITY_STARTTIME_ENDTIME.getRetCode(),StateInfoEnum.ACTIVITY_STARTTIME_ENDTIME.getRetInfo(),"","","","");
			}
			//兑奖日期验证，当活动有效期设置为：2 按按活动有效期抽奖
			if (validDateType != null && validDateType.intValue() == 2 && awardEndDate == null || "".equals(awardEndDate)) {
			 	 return new JsonEdit(StateInfoEnum.ACTIVITY_EXPRIYTIME_NULL.getRetCode(),StateInfoEnum.ACTIVITY_EXPRIYTIME_NULL.getRetInfo(),"","","","");
			}
			if (endDate.getTime() > awardEndDate.getTime()) {
				 return new JsonEdit(StateInfoEnum.ACTIVITY_ENDTIME_EXPRIYTIME.getRetCode(),StateInfoEnum.ACTIVITY_ENDTIME_EXPRIYTIME.getRetInfo(),"","","","");
			}
			//验证正整数
			String regZplus = "^\\d+$";
			//验证消耗积分
			if (activity.getIsIntegral()!=null && activity.getIsIntegral()== 1) {
				if (activity.getUseIntegral() == null) {
					return new JsonEdit(StateInfoEnum.ACTIVITY_INTEGRAL_NULL.getRetCode(),StateInfoEnum.ACTIVITY_INTEGRAL_NULL.getRetInfo(),"","","","");
				}
				if (activity.getUseIntegral() != null && activity.getUseIntegral().toString().matches(regZplus)) {
					return new JsonEdit(StateInfoEnum.ACTIVITY_INTEGRAL_NUM.getRetCode(),StateInfoEnum.ACTIVITY_INTEGRAL_NUM.getRetInfo(),"","","","");
				}
			}
			OldActivity.setTablePrefix(getTablePrefix(request));
			OldActivity.setName(activity.getName());
			OldActivity.setActivityTitle(activity.getActivityTitle());
			OldActivity.setStartDate(startDate);
			OldActivity.setEndDate(endDate);
			OldActivity.setAwardEndDate(awardEndDate);
			OldActivity.setIsForceCollect(activity.getIsForceCollect());
			OldActivity.setActivityRole(activity.getActivityRole());
			OldActivity.setUnprizeIntegration(activity.getUnprizeIntegration());
			OldActivity.setTemplateId(activity.getTemplateId());
			OldActivity.setEstimateNum(activity.getEstimateNum());
			OldActivity.setComments(activity.getComments());
			OldActivity.setUseIntegral(activity.getUseIntegral());
			OldActivity.setIsArea(activity.getIsArea());
			OldActivity.setUpdateTime(new Date());
			// 未激活处理方式
//			OldActivity.setUnactiviteProcessType(activity.getUnactiviteProcessType());
			// 设置用户每天最大中奖数量和用户达到中奖数量上限处理方式
			OldActivity.setUserDayMaxPrizeCount(activity.getUserDayMaxPrizeCount());
			OldActivity.setUserMaxPrizeProcessType(activity.getUserMaxPrizeProcessType());
			// 设置活动有效期判断方式
			OldActivity.setValidDateType(activity.getValidDateType());
			if (OldActivity.getStep()<2) {
				OldActivity.setStep(2);
			}
			activityService.saveActivity(OldActivity);
			logger.error("activity saveActivityInfo OldActivity="+OldActivity);
			return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "activity/toEdit?step=2&activityId="+OldActivity.getActivityId());
		}catch(Exception e){
			logger.error("activity saveActivityInfo fail",e);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
		}
	}
	/**
	 * 设置活动首次中奖奖项
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveFirstPrizeId")
	public @ResponseBody JsonEdit saveFirstPrizeId(HttpServletRequest request){
		String activityId = request.getParameter("activityId");
		String prizeId = request.getParameter("prizeId");
		// prizeId可为空,为空说明页面不设置首次中奖奖项
		if (StringUtils.isNotBlank(activityId)) {
			try {
//				Activity updateActivity = new Activity();
//				updateActivity.setTablePrefix(getTablePrefix(request));
//				updateActivity.setActivityId(Integer.parseInt(activityId));
//				updateActivity.setFirstPrizeId(StringUtils.isBlank(prizeId)?:Integer.parseInt(prizeId));
//				// 根据活动id更新首次中奖奖项firstPrizeId属性
//				activityService.updateByPrimaryKeySelective(updateActivity);
				
				activityService.updateActivityFirstPrizeId(Integer.parseInt(activityId),
						StringUtils.isBlank(prizeId)?null:Integer.parseInt(prizeId),getTablePrefix(request));
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "activity/list");
			} catch (Exception e) {
				logger.error("设置活动首次中奖奖项失败",e);
				//return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
				return new JsonEdit("300","系统异常,请联系管理员或稍后重试","","","","");
			}
		}else {
			logger.error("设置活动首次中奖奖项失败,接收到的activityId="+activityId+",接收到的首次中奖prizeId="+prizeId);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
		}
	}
	/**
	 * 奖项列表下一步,需做的操作有:
	 * 1、检查是否设置了奖项
	 * 2、若当前未激活处理方式发生了改变应更新该值
	 * 3、若step值<3设为3
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/prizeNext")
	public @ResponseBody JsonEdit prizeNext(HttpServletRequest request){
		String activityId = request.getParameter("activityId"); // 活动id
		String unactiviteProcessType = request.getParameter("unactiviteProcessType"); // 未激活处理方式
		if (StringUtils.isNotBlank(activityId)) {
			try {
				/******************************1、检查是否设置了奖项*****************************/
				// 根据活动id查询正常状态的奖项列表
				ActivityPrize activityPrize = new ActivityPrize();
				activityPrize.setTablePrefix(getTablePrefix(request));
				activityPrize.setStatus(WebConstants.PRIZE_COMMON_STATUS);
				activityPrize.setActivityId(Integer.parseInt(activityId));
				List<ActivityPrize> list = activityPrizeService.getPrizeListByExample(activityPrize);
				// 活动没有设置奖项不让进入下一步
				if(list==null || list.isEmpty()){
					// 提示请设置奖项
					return new JsonEdit(StateInfoEnum.ACTIVITY_NO_PRIZE,"");
				}
				
				Activity activity = activityService.getActivityByActivityId(Integer.parseInt(activityId), getTablePrefix(request));
				if(activity==null){
					return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),"未能找到相关奖项","","","","");
				}
				
				/******************************2、活动是关闭的前提下:若当前未激活处理方式发生了改变应更新该值*****************************/
				// 0 关闭， 1 开启
				if(activity.getIsOpen()!=null&&activity.getIsOpen().intValue()!=1){
					if(StringUtils.isBlank(unactiviteProcessType)){
						return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),"请选择未激活处理方式","","","","");
					}
					Integer currentUnactiviteProcessType = activity.getUnactiviteProcessType(); // 新建的活动该值可能为null
					// 如果当前值和传递的值不同,说明发生了更改,更新该值
					if(currentUnactiviteProcessType == null 
							|| currentUnactiviteProcessType.intValue()!=Integer.parseInt(unactiviteProcessType)){
						Activity updateActivityUnactivite = new Activity();
						updateActivityUnactivite.setActivityId(Integer.parseInt(activityId));
						updateActivityUnactivite.setTablePrefix(getTablePrefix(request));
						updateActivityUnactivite.setUnactiviteProcessType(Integer.parseInt(unactiviteProcessType));
						activityService.updateByPrimaryKeySelective(updateActivityUnactivite);
					}
				}
				/******************************3、若step值<3设为3*****************************/
				if(activity.getStep()!=null&&activity.getStep().intValue()<3){
					Activity updateActivity = new Activity();
					updateActivity.setTablePrefix(getTablePrefix(request));
					updateActivity.setActivityId(Integer.parseInt(activityId));
					// 根据活动id更新step属性
					updateActivity.setStep(3);
					activityService.updateByPrimaryKeySelective(updateActivity);
				}
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "activity/list");
			} catch (Exception e) {
				logger.error("奖项列表下一步操作失败",e);
				return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
			}
		}else {
			logger.error("奖项列表下一步操作失败,接收到的activityId="+activityId);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),"未获得活动标识,请检查","","","","");
		}
	}
	/**
	 * 活动第四步“解除绑定”
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/removeProductBindActivity")
	@ResponseBody
	public String removeProductBindActivity(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		String productActivityId = request.getParameter("productActivityId");
		String activityId = request.getParameter("activityId");
		try{
			if (StringUtils.isNotBlank(activityId)) {
				//如果活动打开，不做修改
				if (activityService.getActivityIsOpen(Integer.valueOf(activityId),getTablePrefix(request))) {
					map.put("statusCode", 300);
					map.put("message", "活动已开启，禁止解绑定！");
					JSONObject json = JSONObject.fromBean(map);
					return json.toString();
				}
			}
			if (StringUtils.isNotBlank(productActivityId)) {
				ProductActivity productActivity = activityService.getProductActivityById(Integer.valueOf(productActivityId),getTablePrefix(request));
				if (productActivity != null) {
					if (productActivity.getProductId() != null) {
						ProductBase productBase = activityService.getProductBaseById(productActivity.getProductId(), getTablePrefix(request));
						if (productBase != null) {
							map.put("productBase", productBase);
							map.put("statusCode", 200);
						}
					}
					activityService.removeProdcutActivityById(productActivity.getId(),getTablePrefix(request));
				}
			}else {
				map.put("statusCode", 300);
				map.put("message", "操作失败");
			}
		}catch(Exception e){
			logger.error("activity removeProductBindActivity fail",e);
			map.put("statusCode", 300);
			map.put("message", "操作失败");
		}
		JSONObject json = JSONObject.fromBean(map);
		return json.toString();
	}
	/**
	 * 活动第四步保存产品绑定关系（成功跳转第五步成功页面）
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveProduct")
	@ResponseBody
	public JsonEdit saveProduct(HttpServletRequest request){
		String activityId = request.getParameter("activityId");
		String productIds = request.getParameter("productIds");
		Integer userId = getSessionUserId(request);
		if (StringUtils.isNotBlank(activityId) && userId != null) {
			try{
				//如果活动打开，不做修改
				if (activityService.getActivityIsOpen(Integer.valueOf(activityId),getTablePrefix(request))) {
					return new JsonEdit(StateInfoEnum.DATA_SUCCESS,"activity/toEdit?step=4&activityId="+activityId);
				}
				if (StringUtils.isNotBlank(productIds)) {
					activityService.saveProductActivity(Integer.valueOf(activityId), productIds, getTablePrefix(request), userId);
				}else {
					// 验证是否绑定了产品
					List<ProductActivity> productActivities = activityService.getActivityBindProduct(Integer.valueOf(activityId), getTablePrefix(request));
					if (productActivities == null || productActivities.size() == 0) {
						return new JsonEdit(StateInfoEnum.ACTIVITY_BIND_NULL.getRetCode(),StateInfoEnum.ACTIVITY_BIND_NULL.getRetInfo(),"","","","");
					}
				}
				//修改活动表中step
				Activity OldActivity = activityService.getActivityByActivityId(Integer.valueOf(activityId), getTablePrefix(request));
				if (OldActivity != null) {
					OldActivity.setTablePrefix(getTablePrefix(request));
					if (OldActivity.getStep() < 4) {
						OldActivity.setStep(4);
					}
					OldActivity.setUpdateTime(new Date());
					activityService.saveActivity(OldActivity);
					return new JsonEdit(StateInfoEnum.DATA_SUCCESS,"activity/toEdit?step=4&activityId="+activityId);
				}
			}catch(Exception e){
				logger.error("activity saveProduct fail",e);
			}
		}
		return new JsonEdit(StateInfoEnum.DATA_FAILURE.getRetCode(),StateInfoEnum.DATA_FAILURE.getRetInfo(),"","","","");
	}
}
