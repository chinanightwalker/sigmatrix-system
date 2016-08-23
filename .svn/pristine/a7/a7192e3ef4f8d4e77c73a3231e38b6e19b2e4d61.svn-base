package com.sigmatrix.sc.web.controller.prize;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityPrize;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.service.ActivityPrizeService;
import com.sigmatrix.sc.service.ActivityService;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.web.controller.common.BaseController;
import com.sigmatrix.sc.web.util.BigDecimalUtils;
import com.sigmatrix.sc.web.vo.ActivityPrizeVo;
import com.sigmatrix.sc.web.vo.ActivityVo;
import com.sigmatrix.sc.web.vo.TimeslotInfo;
@Controller
@RequestMapping("/prize")
public class ActivityPrizeController extends BaseController {
	
	private static Logger logger = Logger.getLogger(ActivityPrizeController.class);
	@Autowired
	private ActivityPrizeService activityPrizeService;
	@Autowired
	private ActivityService activityService;

	/**
	 * 获得奖项列表
	 * @param request
	 * @param prize
	 * @return
	 */
	@RequestMapping("/list")
	@RequiresPermissions(value={"prize:insert","prize:update","prize:delete"},logical=Logical.OR)
	public ModelAndView list(HttpServletRequest request,ActivityPrize activityPrize){
		Map<String,Object> map=new HashMap<String, Object>();
		// 传入企业表前缀
		activityPrize.setTablePrefix(getTablePrefix(request));
		// 查询正常状态的奖项
		activityPrize.setStatus(WebConstants.PRIZE_COMMON_STATUS);
		List<ActivityPrize> list = new ArrayList<ActivityPrize>();
		Activity activity = new Activity();
		// 传递给页面的对象
		List<ActivityPrizeVo> voList = new ArrayList<ActivityPrizeVo>();
		// 活动首次中奖奖项只取除定时红包和现金券之外的其他奖项
		List<ActivityPrize> firstPrizeList = new ArrayList<ActivityPrize>();
		ActivityVo activityVo = new ActivityVo();
		try {
			list = activityPrizeService.getPrizeListByExample(activityPrize);
			activity = activityService.getActivityByActivityId(activityPrize.getActivityId(), getTablePrefix(request));
			activityVo.setActivity(activity);
			ActivityPrizeVo prizeVo = null;
			if(list!=null && !list.isEmpty()){
				for(ActivityPrize item:list){
					prizeVo = new ActivityPrizeVo();
					prizeVo.setActivityPrize(item);
					// 处理奖项对象
					voList.add(handleActivityPrizeVo(prizeVo,false));
					// 活动首次中奖奖项只取除定时红包和现金券之外的其他奖项
					if(item.getPrizeType()!=null
							&&item.getPrizeType().intValue()!=6
							&&item.getPrizeType().intValue()!=7){
						firstPrizeList.add(item);
					}
				}
				activityVo = handleActivityVo(activityVo, voList,true);
			}
			map.put("voList",voList);
			map.put("firstPrizeList", firstPrizeList);
			map.put("activityVo",activityVo);
			map.put("activityId", activityPrize.getActivityId());
		} catch (Exception e) {
			logger.error("activityPrize list fail",e);
		}
		return new ModelAndView(JSP_PREFIX+"prize/list",map);
	}

	/**
	 * 添加修改奖项跳转
	 * @param request
	 * @param prize
	 * @return
	 */
	@RequestMapping("/input")
	@RequiresPermissions(value={"prize:insert","prize:update"},logical=Logical.OR)
	public ModelAndView input(HttpServletRequest request,ActivityPrize activityPrize){
		Map<String,Object> map=new HashMap<String, Object>();
		ActivityPrize prize = null;
		// 页面使用Vo对象
		ActivityPrizeVo activityPrizeVo = new ActivityPrizeVo();
		String pageName = "";
		String edit = "1"; // 1新增2修改
		try{
			if(activityPrize.getPrizeId()!=null){ // 修改奖项
				edit = "2";
				// 放入企业表前缀
				activityPrize.setTablePrefix(getTablePrefix(request));
				prize = activityPrizeService.getActivityPrizeByPrizeId(activityPrize.getPrizeId(), 
						getTablePrefix(request));
			}else{ // 根据奖项类型添加奖项
				prize = activityPrize;
				if(activityPrize.getPrizeType()!=null){
					prize.setPrizeType(activityPrize.getPrizeType());
				}
			}
			switch (prize.getPrizeType()) {
				case 1:
					pageName = "prize/input";
					break;
				case 2:
					pageName = "prize/red"; // 红包奖项
					break;
				case 3:
					pageName = "";
					break;
				case 4:
					pageName = "";
					break;
				case 5:
					pageName = "";
					break;
				case 6:
					pageName = "prize/timingRed"; // 定时红包奖项
					break;
				case 7:
					pageName = "prize/cashCoupon"; // 现金券
					break;
				default:
					break;
			}
			activityPrizeVo.setActivityPrize(prize);
			activityPrizeVo = handleActivityPrizeVo(activityPrizeVo,true);
			map.put("activityPrizeVo", activityPrizeVo);
			map.put("edit", edit);
		}catch(Exception e){
			logger.error("添加或修改奖项失败",e);
		}
		return new ModelAndView(JSP_PREFIX+pageName,map);
	}
	
	/**
	 * 新增或修改奖项,只支持post请求
	 * @param activityPrize
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST) 
	@RequiresPermissions(value={"prize:insert","prize:update"},logical=Logical.OR)
	public ModelAndView saveOrUpdate(ActivityPrizeVo activityPrizeVo,HttpServletRequest request){
		ActivityPrize activityPrize = activityPrizeVo.getActivityPrize();
		try{
			// 放入企业表前缀
			activityPrize.setTablePrefix(getTablePrefix(request));
			if(activityPrize.getActivityId()==null){
				throw new Exception("添加奖项时未获得活动id");
			}
			// 处理奖项中奖率,存库之前要/100
			Float prizeRate = activityPrize.getPrizeRate()==null?0:activityPrize.getPrizeRate();
			activityPrize.setPrizeRate(prizeRate/100);
			if(activityPrize.getPrizeType()==null){
				throw new Exception("添加奖项时未获得奖项类型");
			}else if(activityPrize.getPrizeType().intValue() == 2){ // 红包类型
				// 定额红包计算奖项总金额
				if(activityPrize.getRedBagType().intValue()==1){
					Long prizeTotalAmount = calculatePrizeTotalAmount(activityPrize.getPrizeAmount(),activityPrize.getPrizeCount());
					activityPrize.setPrizeTotalAmount(prizeTotalAmount);
				}else{ // 霸占红包和区间红包计算奖项总金额
					Long balance = activityPrizeVo.getBalance()==null?0l:activityPrizeVo.getBalance(); // 剩余金额
					Long prizeTotalAmount = BigDecimalUtils.addLong(balance, activityPrize.getPrizeLuckyAmount());
					activityPrize.setPrizeTotalAmount(prizeTotalAmount);
				}
			}else if(activityPrize.getPrizeType().intValue() == 6
					|| activityPrize.getPrizeType().intValue() == 7){ // 定时红包、现金券类型要处理时间段
				if(activityPrize.getPrizePeriodMode()!=null
						&&activityPrize.getPrizePeriodMode().intValue()==4){ // 按时段模式才设置该值
					List<TimeslotInfo> timeslotInfos = activityPrizeVo.getTimeslotInfos();
					activityPrize.setTimeslotInfo(handleTimeslotInfoToJsonArray(timeslotInfos));
				}else{
					activityPrize.setTimeslotInfo(""); // 非时间段模式设为空
				}
				// 定时红包、现金券的prizeCount属性和prizePeriodCount同步
				activityPrize.setPrizeCount(activityPrize.getPrizePeriodCount()==null?0:activityPrize.getPrizePeriodCount());
				// 总金额prizeTotalAmount属性
				Long prizeTotalAmount = calculatePrizeTotalAmount(activityPrize.getPrizeAmount(),activityPrize.getPrizePeriodCount());
				activityPrize.setPrizeTotalAmount(prizeTotalAmount);
			}
			
			if(activityPrize.getPrizeId()==null){ // 添加
				// 添加时,status已在调用的service方法中set入
				activityPrize.setCreateTime(new Date()); // 创建时间
				activityPrize.setCreateUserid(getSessionUserId(request)); // 创建人
				// 数字类型的默认值填充开始
				activityPrize.setLuckyCount(0); // 已中此奖项数量
				activityPrize.setPrizeLuckyAmount(0l); // 已中此奖项金额
				
				// 数字类型的默认值填充结束
				
			}else{ // 修改时绝对不能更新已中奖金额和已中奖数量
				/*************************************************************************/
				/*
				 * 由于Mapper.xml里的updateByPrimaryKeySelective方法是更新所有的不为null的值,
				 * 比如prizeLuckyAmount虽未主动set,但页面传递了0,所以要设为null
				 */
				activityPrize.setPrizeLuckyAmount(null); // 设为null就不会去修改该值了,将保持原值
				activityPrize.setLuckyCount(null);
				/*************************************************************************/
				
				activityPrize.setUpdateTime(new Date()); // 更新时间
				activityPrize.setUpdateUserid(getSessionUserId(request)); // 更改人
			}

	        activityPrizeService.saveOrUpdate(activityPrize);
		}catch(Exception e){
			logger.error("activityPrize saveOrUpdate fail",e);
			return new ModelAndView(JSP_PREFIX+"common/error"); //访问WEB-INF/jsp/error.jsp
		}
		return new ModelAndView("redirect:/prize/list?activityId="+activityPrize.getActivityId());//跳转到list页面
	}

	/**
	 * 计算定额红包金额的总金额=定额*投放量
	 * @param prizeAmount
	 * @param prizeCount
	 * @return
	 */
	private Long calculatePrizeTotalAmount(Integer prizeAmount,
			Integer prizeCount) throws Exception {
		return BigDecimalUtils.multiplyLong(prizeAmount,prizeCount);
	}

	/**
	 * 删除奖项（假删除）
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	@RequiresPermissions("prize:delete")
	public JsonEdit delete(HttpServletRequest request,Integer prizeId,Integer activityId){
		try{
			if(prizeId!=null){
				ActivityPrize activityPrize = new ActivityPrize();
				// 传入企业表前缀
				activityPrize.setTablePrefix(getTablePrefix(request));
				activityPrize.setPrizeId(prizeId);
				// 奖项状态置为删除状态
				activityPrize.setStatus(WebConstants.PRIZE_DELETE_STATUS);
				activityPrizeService.saveOrUpdate(activityPrize);
			}else{
				logger.error("删除奖项时未获得奖项id");
				return new JsonEdit(StateInfoEnum.DATA_FAILURE, "prize/list?activityId="+activityId);
			}
			
		}catch(Exception e){
			logger.error("奖项删除失败",e);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE, "prize/list?activityId="+activityId);
		}
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "prize/list?activityId="+activityId);
	}
	/**
	 * 验证中奖率是否超出100%
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/validatePrizeRateIsFull")
	@ResponseBody
	public JsonEdit validatePrizeRateIsFull(HttpServletRequest request){
		String activityId = request.getParameter("activityId"); // 活动id
		String prizeId = request.getParameter("prizeId"); // 奖项id
		// 中奖率,这里的格式请保证是100、80.8322 ......
		String prizeRateString = request.getParameter("prizeRate");
		try{
			if(StringUtils.isNotBlank(activityId)
					&&StringUtils.isNotBlank(prizeRateString)){
				// 将页面获得的中奖率,eg:100、80.8322 ......进行除以100操作
				Float prizeRateFloat = Float.parseFloat(prizeRateString)/100f;
				// 验证活动的中奖率是否超出100%,超出返回true,否则false
				boolean isFull = activityPrizeService.validatePrizeRateIsFull(Integer.parseInt(activityId), 
						StringUtils.isBlank(prizeId)?null:Integer.parseInt(prizeId),prizeRateFloat,getTablePrefix(request));
				if(isFull){ // 超出100%
					return new JsonEdit("300", "当前活动总中奖率不能超过100%，请检查", "", "", "", "");
				}else{
					return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "");
				}
			}else if(StringUtils.isBlank(activityId)){
				return new JsonEdit("300", "未识别当前活动", "", "", "", "");
			}else if(StringUtils.isBlank(prizeRateString)){
				return new JsonEdit("300", "中奖率不能为空", "", "", "", "");
			}else{
				return new JsonEdit("300", "验证中奖率失败,请联系管理员", "", "", "", "");
			}
		}catch(Exception e){
			logger.error("验证活动activityId:"+activityId+"的奖项activityId:"+prizeId+"中奖率是否超过100%失败",e);
			return new JsonEdit("300", "系统异常，请联系管理员或稍后重试！", "", "", "", "");
		}
	}
	/**
	 * 更新奖项总金额、总投放量（假删除）
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/toAddCount")
	@ResponseBody
	@RequiresPermissions("prize:update")
	public JsonEdit toAddCount(HttpServletRequest request){
		String activityId = request.getParameter("activityId");
		String prizeId = request.getParameter("prizeId"); // 奖项id
		String prizeUpdateVal = request.getParameter("prizeUpdateVal"); // 更新成的值
		String type = request.getParameter("type"); // 1编辑总投放量,2编辑总金额
		String prizeType = request.getParameter("prizeType"); // 奖项类型
		try{
			// 判断活动是否开启
			if(StringUtils.isNotBlank(activityId)){
				//return new JsonEdit(StateInfoEnum.DATA_FAILURE, "prize/list?activityId="+activityId);
				boolean isOpen = activityService.getActivityIsOpen(Integer.parseInt(activityId), getTablePrefix(request));
				if(isOpen){
					//return new JsonEdit(StateInfoEnum.DATA_FAILURE, "prize/list?activityId="+activityId);
					return new JsonEdit("300","活动已开启，不能进行操作","","","","");
				}
			}
			if(StringUtils.isNotBlank(prizeId)
					&&StringUtils.isNotBlank(prizeUpdateVal)
					&&StringUtils.isNotBlank(type)
					&&StringUtils.isNotBlank(prizeType)){
				ActivityPrize activityPrize = new ActivityPrize();
				// 传入企业表前缀
				activityPrize.setTablePrefix(getTablePrefix(request));
				activityPrize.setPrizeId(Integer.parseInt(prizeId));
				// 根据奖项id查询奖项
				ActivityPrize dataPrize = activityPrizeService.getActivityPrizeByPrizeId(Integer.parseInt(prizeId), getTablePrefix(request));
				if("1".equals(type)){
					if("6".equals(prizeType)||"7".equals(prizeType)){ // 定时红包更新总投放量是更新prizePeriodCount,同步也更新prizeCount
						activityPrize.setPrizePeriodCount(Integer.parseInt(prizeUpdateVal));
					}
					activityPrize.setPrizeCount(Integer.parseInt(prizeUpdateVal));
					// 定时红包、现金券和固定红包更新总投放量时必须更新总金额
					if("6".equals(prizeType)||"7".equals(prizeType)||
							("2".equals(prizeType)&&dataPrize.getRedBagType().intValue()==1)){
						activityPrize.setPrizeTotalAmount(BigDecimalUtils.multiplyLong(dataPrize.getPrizeAmount(), Integer.parseInt(prizeUpdateVal)));
					}
				}else{ // 更新总金额
					Long prizeTotalAmount = BigDecimalUtils.prizeAmountMultiplyLong(prizeUpdateVal, 100); // 页面为元转换为数据库中的分
					activityPrize.setPrizeTotalAmount(prizeTotalAmount);
				}
				// 根据奖项id,只更新实体中存在的属性值
				activityPrizeService.updateByPrimaryKeySelective(activityPrize);
			}else{
				logger.error("更新奖项总金额、总投放量时未获得完整参数,prizeId:"+prizeId+",prizeUpdateVal:"+prizeUpdateVal
						+",type:"+type+",prizeType"+prizeType);
				return new JsonEdit(StateInfoEnum.DATA_FAILURE, "prize/list?activityId="+activityId);
			}
		}catch(Exception e){
			logger.error("奖项列表更新总投放量/总金额失败",e);
			return new JsonEdit(StateInfoEnum.DATA_FAILURE, "prize/list?activityId="+activityId);
		}
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "prize/list?activityId="+activityId);
	}
	
	
	/**
	 * 处理页面需要的奖项里非存库的属性,比如剩余金额lessCount
	 * @param prizeVo
	 * @param isHandleTimeslotInfo 是否处理定时红包的时间段信息,这些信息只有input这些需要显示(而且一般是修改时需要),对于列表是不需要的
	 * @return
	 */
	private ActivityPrizeVo handleActivityPrizeVo(ActivityPrizeVo prizeVo,boolean isHandleTimeslotInfo) throws Exception {
		// 计算奖项剩余总金额
		Long balance = BigDecimalUtils.subLong(prizeVo.getActivityPrize().getPrizeTotalAmount(), prizeVo.getActivityPrize().getPrizeLuckyAmount());
		prizeVo.setBalance(balance);
		// 计算奖项剩余总数量
		prizeVo.setLessCount(BigDecimalUtils.subInteger(prizeVo.getActivityPrize().getPrizeCount(), prizeVo.getActivityPrize().getLuckyCount()));
		if(isHandleTimeslotInfo
				&&(prizeVo.getActivityPrize().getPrizeType().intValue()==6
				||prizeVo.getActivityPrize().getPrizeType().intValue()==7)){ // 定时红包奖项和现金券奖项处理时间段属性供页面显示
			if(StringUtils.isNotBlank(prizeVo.getActivityPrize().getTimeslotInfo())){
				prizeVo.setTimeslotInfos(handleJsonArrayToTimeslotInfoList(prizeVo.getActivityPrize().getTimeslotInfo()));
			}
		}
		return prizeVo;
	}
	/**
	 * 处理页面需要的活动里非存库的属性,比如活动的总金额prizeTotalCount、总中奖量prizeTotalLuckyCount之类的
	 * @param activityVo
	 * @param prizeVoList
	 * @param isConvertMoney 方法里的金额是从数据库中获得,存的都是分,是否要进行分转元操作,true的话则拿到数据库值/100转为元,否则返回的金额都为分
	 * @return
	 * @throws Exception
	 */
	private ActivityVo handleActivityVo(ActivityVo activityVo,List<ActivityPrizeVo> prizeVoList,boolean isConvertMoney) throws Exception{
		// 本次活动的总投放量=该活动下的所有奖项的投放量prizeCount之和 
		Integer prizeTotalCount = 0;
		// 本次活动的总中奖量=该活动下的所有奖项的中奖量luckyCount之和
		Integer prizeTotalLuckyCount = 0;
		// 本次活动的总剩余量=该活动下的所有奖项的剩余量lessCount(奖项Vo中定义)
		Integer prizeTotalLessCount = 0;
		// 本次活动的总金额=该活动下的所有奖项的金额prizeTotalAmount之和
		Long prizeTotalAmount = 0l;
		// 本次活动的总中奖金额=该活动下的所有奖项的中奖金额prizeLuckyAmount之和
		Long prizeTotalLuckyAmount = 0l;
		// 本次活动的总剩余金额=该活动下的所有奖项的剩余金额balance(奖项Vo中定义)之和
		Long prizeTotalBalance = 0l;
		if(prizeVoList!=null && !prizeVoList.isEmpty()){
			ActivityPrize activityPrize = null;
			for(ActivityPrizeVo prizeVo:prizeVoList){
				activityPrize = prizeVo.getActivityPrize();
				prizeTotalCount = BigDecimalUtils.addInteger(prizeTotalCount,activityPrize.getPrizeCount());
				prizeTotalLuckyCount = BigDecimalUtils.addInteger(prizeTotalLuckyCount,activityPrize.getLuckyCount());
				prizeTotalLessCount = BigDecimalUtils.addInteger(prizeTotalLessCount,prizeVo.getLessCount());
				prizeTotalAmount = BigDecimalUtils.addLong(prizeTotalAmount,activityPrize.getPrizeTotalAmount());
				prizeTotalLuckyAmount = BigDecimalUtils.addLong(prizeTotalLuckyAmount,activityPrize.getPrizeLuckyAmount());
				prizeTotalBalance = BigDecimalUtils.addLong(prizeTotalBalance,prizeVo.getBalance());
			}
		}
		activityVo.setPrizeTotalCount(prizeTotalCount); // 活动总数量
		activityVo.setPrizeTotalLuckyCount(prizeTotalLuckyCount); // 活动总中奖量
		activityVo.setPrizeTotalLessCount(prizeTotalLessCount); // 活动总剩余量
		if(isConvertMoney){ // 进行分转元操作,即除以100
			activityVo.setPrizeTotalAmount(BigDecimalUtils.prizeAmountDivide(prizeTotalAmount, 100l)); // 活动总金额
			activityVo.setPrizeTotalLuckyAmount(BigDecimalUtils.prizeAmountDivide(prizeTotalLuckyAmount,100l)); // 活动总中奖金额
			activityVo.setPrizeTotalBalance(BigDecimalUtils.prizeAmountDivide(prizeTotalBalance,100l)); // 活动总剩余金额
		}else{
			activityVo.setPrizeTotalAmount(prizeTotalAmount); // 活动总金额
			activityVo.setPrizeTotalLuckyAmount(prizeTotalLuckyAmount); // 活动总中奖金额
			activityVo.setPrizeTotalBalance(prizeTotalBalance); // 活动总剩余金额
		}
		return activityVo;
	}
	/**
	 * 定时红包处理时间段
	 * @param timeslotInfos
	 * @return
	 */
	private String handleTimeslotInfoToJsonArray(List<TimeslotInfo> timeslotInfos) throws Exception{
		logger.error("*******************保存时取页面List转换成JSONArray开始**********************");
		try{
			List<TimeslotInfo> list = new ArrayList<TimeslotInfo>();
			// 过滤掉空的
			for(TimeslotInfo item:timeslotInfos){
				if(item!=null 
						&& StringUtils.isNotBlank(item.getStarttime())
						&& StringUtils.isNotBlank(item.getEndtime())){
					list.add(item);
				}
			}
			if(list!=null && !list.isEmpty()){
				JSONArray jsonArray = JSONArray.fromObject(list);
				logger.error("*******************保存时取页面List转换成JSONArray成功结束**********************");
				return jsonArray.toString();
			}
		}catch(Exception e){
			logger.error("定时红包保存时取页面List转换成JSONArray失败",e);
			// 失败了抛出异常,不让信息保存成功
			throw new Exception("定时红包保存时取页面List转换成JSONArray失败");
		}
		return "";
	}
	/**
	 * 定时红包时间段转JSONArray换成List以方便页面显示
	 * @param jsonArrayStr
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<TimeslotInfo> handleJsonArrayToTimeslotInfoList(String jsonArrayStr) throws Exception{
		List<TimeslotInfo> list = new ArrayList<TimeslotInfo>();
		try{
			JSONArray jsonarray = JSONArray.fromObject(jsonArrayStr);
			logger.error("***************定时红包时间段转JSONArray换成List以方便页面显示,时间段信息为:"+jsonArrayStr+"****************");
	        list = (List<TimeslotInfo>)JSONArray.toList(jsonarray, TimeslotInfo.class);
	        logger.error("***************定时红包时间段转JSONArray换成List以方便页面显示,转换成功结束****************");
		}catch(Exception e){
			logger.error("定时红包时间段转JSONArray换成List以方便页面显示转换失败",e);
			// 转换失败抛出异常,因为页面肯定要显示此信息,失败就跳到错误页面
			throw new Exception("定时红包时间段转JSONArray换成List以方便页面显示转换失败");
		}
        return list;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("*****************List转换成jsonArray*******************************");
		ActivityPrizeController cont = new ActivityPrizeController();
		List<TimeslotInfo> list = new ArrayList<TimeslotInfo>();
		TimeslotInfo info1 = new TimeslotInfo("10:00:00", "11:00:00");
		TimeslotInfo info2 = new TimeslotInfo("12:00:00", "13:00:00");
		TimeslotInfo info3 = new TimeslotInfo("14:00:00", "15:00:00");
		list.add(info1);
		list.add(info2);
		list.add(info3);
		String jsonArray = cont.handleTimeslotInfoToJsonArray(list);
		System.out.println(jsonArray);
		System.out.println("*****************jsonArray转换成List*******************************");
		String jsonArray2 = "[{\"endtime\":\"11:00:00\",\"starttime\":\"10:00:00\"},{\"endtime\":\"13:00:00\",\"starttime\":\"12:00:00\"},{\"endtime\":\"15:00:00\",\"starttime\":\"14:00:00\"}]";
		JSONArray jsonarray = JSONArray.fromObject(jsonArray2);
		System.out.println(jsonarray); 
        List list2 = (List)JSONArray.toList(jsonarray, TimeslotInfo.class);  
        Iterator it = list.iterator();  
        while(it.hasNext()){  
        	TimeslotInfo p = (TimeslotInfo)it.next();  
            System.out.println(p.getStarttime()+","+p.getEndtime());  
        }
	}
}
