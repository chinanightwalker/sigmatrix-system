package com.sigmatrix.sc.service.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityTemplateMapper;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityExample;
import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.entity.v1.ActivityTemplateExample;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.ActivityService;
import com.sigmatrix.sc.service.ActivityTemplateService;

//活动模板
@Service
public class ActivityTemplateServiceImpl implements ActivityTemplateService {
	
	private static Logger logger1 = Logger.getLogger(ActivityTemplateServiceImpl.class);

	@Autowired
	private ActivityService activityService; 
	@Autowired
	private ActivityTemplateMapper activityTemplateMapper; 
	@Autowired
	private ActivityMapper activityMapper ;
	
	//根据活动Id查询模板信息
	@Override
	public ActivityTemplate getActTemByActId(Integer activityId,String tablePrefix) {
		Activity activity = activityService.getActivityById(activityId,tablePrefix);
		if(null == activity || null == activity.getTemplateId()){
			return null;
		}
		return this.getActTemById(activity.getTemplateId(),tablePrefix);
		
	}

	//根据模板Id查询模板信息
	@Override
	public ActivityTemplate getActTemById(Integer templateId,String tablePrefix) {
    	logger1.info("查询活动模板  templateId="+templateId);
		if(null == templateId){
			return null;
		}
		ActivityTemplate at = activityTemplateMapper.selectByPrimaryKey(templateId,tablePrefix);
		logger1.info("查询活动模板返回 "+JSONObject.toJSONString(at));
		return at;
	}

	@Override
	public PageBean<ActivityTemplate> selectActivityTemplateList(PageBean<ActivityTemplate> page,ActivityTemplate activityTemplate) throws Exception {
		ActivityTemplateExample exa =new ActivityTemplateExample();
		exa.setTablePrefix(activityTemplate.getTablePrefix());
		if (null != activityTemplate) {
			if (StringUtils.isNotBlank(activityTemplate.getTemplateName())) {
				exa.createCriteria().andTemplateNameLike("%" + activityTemplate.getTemplateName() + "%");
			}
		}
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		return PageBeanUtil.toPagedResult(activityTemplateMapper.selectByExample(exa));
	}

	@Override
	public int insertSelective(ActivityTemplate activityTemplate) throws Exception {
		
		return activityTemplateMapper.insertSelective(activityTemplate);
	}

	@Override
	public int updataSelective(ActivityTemplate activityTemplate) throws Exception {
		return activityTemplateMapper.updateByPrimaryKeySelective(activityTemplate);
	}

	@Override
	public ActivityTemplate getActTempById(Integer templateId, String tablePrefix) throws Exception {
		if(null == templateId){
			return null;
		}
		ActivityTemplate at = activityTemplateMapper.selectByPrimaryKey(templateId,tablePrefix);
		logger1.info("查询活动模板返回 "+JSONObject.toJSONString(at));
		return at;
	}

	@Override
	public int deleteactivityTemplatebyId(ActivityTemplate activityTemplate) throws Exception {
		return activityTemplateMapper.deleteByPrimaryKey(activityTemplate.getTemplateId(),activityTemplate.getTablePrefix());
		
	}

	@Override
	public List<Activity> selectActivitybyId(ActivityExample ae) throws Exception {
		return activityMapper.selectByExample(ae);
	}

	
}
