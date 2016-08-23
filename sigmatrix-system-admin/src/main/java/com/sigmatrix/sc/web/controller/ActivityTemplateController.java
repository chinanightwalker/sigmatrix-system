package com.sigmatrix.sc.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityExample;
import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.ActivityService;
import com.sigmatrix.sc.service.ActivityTemplateService;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.web.controller.activity.ActivityController;
import com.sigmatrix.sc.web.controller.common.BaseController;

@Controller
@RequestMapping(value = "/ActivityTemplate")
public class ActivityTemplateController extends BaseController {
	private static Logger logger = Logger.getLogger(ActivityTemplateController.class);
	@Autowired
	ActivityTemplateService activityTemplateService;
	@Autowired
	private ActivityService activityService;
	/**
	 * 活动模版-查询
	 */
	@RequestMapping(value = "/list")
	public ModelAndView ActivityTemplateList(HttpServletRequest request, ActivityTemplate activityTemplate) {
		PageBean<ActivityTemplate> page = new PageBean<>(getPageNum(request));
		activityTemplate.setTablePrefix(getTablePrefix(request));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			page = activityTemplateService.selectActivityTemplateList(page, activityTemplate);
		} catch (Exception e) {
			logger.error("select ActivityTemplateList is fail", e);
			e.printStackTrace();
		}
		map.put("page", page);
		map.put("activityTemplate", activityTemplate);
		logger.debug(map.toString());
		return new ModelAndView(JSP_PREFIX + "ActivityTemplate/list", map);

	}

	/**
	 * 活动模版管理-增加
	 */
	@RequestMapping(value = "/add")
	@RequiresPermissions("activityTemplate:insert")
	public ModelAndView addView() {
		ModelAndView mav = new ModelAndView(JSP_PREFIX + "ActivityTemplate/edit");
		return mav;
	}

	/**
	 * 活动模版管理-修改
	 */
	@RequestMapping(value = "/edit")
	@RequiresPermissions("activityTemplate:update")
	public ModelAndView editView(Integer templateId,HttpServletRequest request) {
		//System.out.println("templateId==" + templateId);
		ActivityTemplate activityTemplate = new ActivityTemplate();
		activityTemplate.setTablePrefix(getTablePrefix(request));
		ModelAndView mav = new ModelAndView(JSP_PREFIX + "ActivityTemplate/edit");
		if (templateId != null) {
			try {
				activityTemplate = activityTemplateService.getActTempById(templateId,activityTemplate.getTablePrefix());
				logger.debug("by id selectactivitutemplate is success");
			} catch (Exception e) {
				logger.error("by id selectactivitutemplate is fail", e);
				e.printStackTrace();
			}
		}

		mav.addObject("activityTemplate", activityTemplate);
		return mav;

	}

	/**
	 * 活动模版管理-保存
	 */
	@RequestMapping(value = "/save")
	public @ResponseBody JsonEdit saveView(HttpServletRequest request, ActivityTemplate activityTemplate) {
		//System.out.println("&**&*&" + activityTemplate.getTemplateName() + "*" + activityTemplate.getTemplatePath()
		//		+ "*" + activityTemplate.getTemplateRealPath());
		activityTemplate.setTablePrefix(getTablePrefix(request));
		int i = 0;
		if (activityTemplate.getTemplateId() == null) {// 增加
			activityTemplate.setCreateTime(new Date());
			try {
				i = activityTemplateService.insertSelective(activityTemplate);
				if (i > 0) {
					logger.debug("activityTemplate add is success");
					return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "ActivityTemplate/list");

				} else {
					logger.error("activityTemplate add is fail");
					return new JsonEdit(StateInfoEnum.DATA_FAILURE, "ActivityTemplate/add");

				}
			} catch (Exception e) {
				logger.error("activityTemplate add is fail", e);
				e.printStackTrace();
			}

		} else {// 修改更新
			activityTemplate.setUpdateTime(new Date());
			try {
				i = activityTemplateService.updataSelective(activityTemplate);
				logger.debug("activityTemplate updata is success");
			} catch (Exception e) {
				logger.error("activityTemplate updata is fail", e);
				e.printStackTrace();
			}
		}

		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "ActivityTemplate/list");
	}

	/**
	 * 活动模版管理-删除
	 * 
	 * @param templateId
	 * @return
	 */
	@RequestMapping(value = "/delete{templateId}")
	@RequiresPermissions("activityTemplate:delete")
	public @ResponseBody JsonEdit deleteView(Integer templateId,HttpServletRequest request) {
		//查询该模版是否被活动使用
		ActivityExample ae= new ActivityExample();
		ae.setTablePrefix(getTablePrefix(request));
		ae.createCriteria().andTemplateIdEqualTo(templateId);
		try {
		List<Activity> list= activityTemplateService.selectActivitybyId(ae);
		
		 if(list.size()==0){
		ActivityTemplate activityTemplate = new ActivityTemplate();
		activityTemplate.setTablePrefix(getTablePrefix(request));
		activityTemplate.setTemplateId(templateId);
		
		try {
			int i = activityTemplateService.deleteactivityTemplatebyId(activityTemplate);
			if (i > 0) {
				logger.error("activityTemplate delete is success");
				new JsonEdit(StateInfoEnum.DATA_SUCCESS, "ActivityTemplate/list");
			}
		} catch (Exception e) {
			logger.error("activityTemplate delete is fail", e);
			e.printStackTrace();
		}
		 }else{
			logger.error("deleteActivityTemplate is fail");
			return new JsonEdit(StateInfoEnum.DATA_BeUsed, "ActivityTemplate/list");
		}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "ActivityTemplate/list");
	}

}
