package com.sigmatrix.sc.service;

import java.util.List;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityExample;
import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.page.PageBean;

/**
 * 活动模版管理Service
 * @author jiangjun
 *
 */
public interface ActivityTemplateService {
	// 根据活动Id查询模板信息 待定
	public ActivityTemplate getActTemByActId(Integer activityId, String tablePrefix);

	// 根据模板Id查询模板信息 待定
	public ActivityTemplate getActTemById(Integer templateId, String tablePrefix);
    //活动模版管理-查询
	public PageBean<ActivityTemplate> selectActivityTemplateList(PageBean<ActivityTemplate> page, ActivityTemplate activityTemplate) throws Exception;
    //活动模版管理-增加
	public int insertSelective(com.sigmatrix.sc.entity.v1.ActivityTemplate activityTemplate) throws Exception;
	// 活动模版管理-修改更新
	public int updataSelective(com.sigmatrix.sc.entity.v1.ActivityTemplate activityTemplate) throws Exception;
	// 根据模板Id查询模板信息
	public com.sigmatrix.sc.entity.v1.ActivityTemplate getActTempById(Integer templateId, String tablePrefix)  throws Exception;
    //活动模版 根据id　删除信息
	public int deleteactivityTemplatebyId(com.sigmatrix.sc.entity.v1.ActivityTemplate activityTemplate) throws Exception;
	//根据id 查询该模版是否被活动使用
	public List<Activity> selectActivitybyId(ActivityExample ae) throws Exception;

}
