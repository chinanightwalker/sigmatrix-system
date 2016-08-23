package com.sigmatrix.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityPrizeMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ActivityTemplateMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ProductActivityMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ProductBaseMapper;
import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityExample;
import com.sigmatrix.sc.entity.v1.ActivityPrize;
import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.entity.v1.ActivityTemplateExample;
import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductActivityExample;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ProductBaseExample;
import com.sigmatrix.sc.entity.v1.ProductBaseExample.Criteria;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.ActivityService;
@Service
public class ActivityServiceImpl implements ActivityService {
	
	private static Logger logger = Logger.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private ActivityTemplateMapper activityTemplateMapper;
	@Autowired
	private ProductActivityMapper productActivityMapper;
	@Autowired
	private ProductBaseMapper productBaseMapper;
	@Autowired
	private ActivityPrizeMapper activityPrizeMapper;
	
	public PageBean<Activity> getPageActivityByExample(PageBean<Activity> page,Activity example) throws Exception{
		List<Activity> list = new ArrayList<Activity>();
		ActivityExample exa = new ActivityExample();
		exa.setTablePrefix(example.getTablePrefix());
		ActivityExample.Criteria criteria = exa.createCriteria();
		if(StringUtils.isNotBlank(example.getActivityTitle())){
			criteria.andActivityTitleLike("%"+example.getActivityTitle()+"%");
		}
		if(null!=example.getActivityId()){
			criteria.andActivityIdEqualTo(example.getActivityId());
		}
		criteria.andStatusEqualTo(1);
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		return PageBeanUtil.toPagedResult(activityMapper.selectByExample(exa));

		
	}
	
	//根据活动ID查询活动信息
	@Override
	public Activity getActivityById(Integer activityId,String tablePrefix) {
    	logger.info("查询活动信息 activityId="+activityId);
		if(null == activityId){
			return null;
		}
		Activity activity = activityMapper.selectByPrimaryKey(activityId,tablePrefix);
		logger.info("查询活动信息返回  "+JSONObject.toJSONString(activity));
		return activity;
	}
	
   /* //查询活动信息 抽奖使用
    public Activity getActivity(Integer activityId){
    	logger.info("查询活动信息 activityId="+activityId);
		//活动是否有效  活动表_activity
		if(null == activityId){
			return null;
		}
		List<Activity> activityLists = null;
		ActivityExample activityExample = new ActivityExample();
		com.sigmatrix.sc.entity.v1.ActivityExample.Criteria activityCia = activityExample.createCriteria();
		activityCia.andActivityIdEqualTo(activityId);//活动ID
		activityCia.andStatusEqualTo(1);//_status 活动数据状态0删除1正常
		activityCia.andIsOpenEqualTo(1);//_is_open : 活动开关0 关闭， 1 开启
		activityCia.andTypeEqualTo(1);//_type 活动类型  1 扫码 2 轮盘 3 即开即中 4 九宫格
		activityCia.andIsIntegralEqualTo(0);//_is_integral 是否积分抽奖 0非积分抽奖 1 积分抽奖
		activityLists = activityMapper.selectByExample(activityExample);
		logger.info("查询活动信息返回 List "+JSONObject.toJSONString(activityLists));
		if(!CollectionUtils.isEmpty(activityLists) && null != activityLists.get(0)){
			return activityLists.get(0);
		}
		return null;
    }*/
	
    //更新活动表 部分值
    public void updateByPrimaryKeySelective(Activity activity) throws Exception{
		logger.info("更新活动表  ="+JSONObject.toJSONString(activity));
		int flag = activityMapper.updateByPrimaryKeySelective(activity);
		if(1 != flag){
			logger.error("更新活动表失败 flag="+flag);
			throw new RuntimeException("update _activity fail");
		}
    }

	@Override
	public PageBean<Activity> getPageActivityByExampleWinningInformation(
			PageBean<Activity> page, Activity example) {
		// TODO Auto-generated method stub
		List<Activity> list = new ArrayList<Activity>();
		ActivityExample exa = new ActivityExample();
		exa.setTablePrefix(example.getTablePrefix());
		if(StringUtils.isNotBlank(example.getActivityTitle())){
			exa.createCriteria().andActivityTitleLike("%"+example.getActivityTitle()+"%");
		}
		try {
			PageHelper.startPage(page.getPageNo(), page.getPageSize());
			return PageBeanUtil.toPagedResult(activityMapper.selectByExample(exa));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Activity getActivityByActivityId(Integer activtyId,
			String tablePrefix) throws Exception {
		return getActivityById(activtyId, tablePrefix);
	}

	/**
	 * 查询活动列表集(活动管理)
     * ZYC
	 */
	@Override
	public List<Activity> getListActivityByExample(Activity example) throws Exception {
		ActivityExample exa = new ActivityExample();
		exa.setTablePrefix(example.getTablePrefix());
		exa.createCriteria().andStatusEqualTo(1);
		List<Activity> list = activityMapper.selectByExample(exa);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getUnactiviteProcessType() != null) {
					if (list.get(i).getUnactiviteProcessType().intValue() == 0) {
						list.get(i).setFirstPrizeIdName("显示产品介绍");
					}else {
						ActivityPrize activityPrize = activityPrizeMapper.selectByPrimaryKey(list.get(i).getUnactiviteProcessType(), example.getTablePrefix());
						if (activityPrize != null && activityPrize.getPrizeName() != null) {
						//	System.out.println("id="+list.get(i).getUnactiviteProcessType()+"prizeName="+activityPrize);
							list.get(i).setFirstPrizeIdName(activityPrize.getPrizeName());
						}
					}
				}else{
				list.get(i).setFirstPrizeIdName("未设置");}
			}
		}
		
		return list;
	}

	/**
	 * 删除活动（修改状态）
	 */
	@Override
	public void deleteActivity(Activity activity) throws Exception {
		activity.setStatus(0);
		logger.error(" 删除活动（修改状态）信息activity======="+activity);
		activityMapper.updateByPrimaryKeySelective(activity);
	}
	/**
	 * 保存活动设置
	 */
	@Override
	public void saveActivity(Activity activity) throws Exception {
		if (activity.getActivityId() == null) {
			logger.error("已保存活动设置信息activity======="+activity);
			activityMapper.insertSelective(activity);
		}else {
			logger.error("已保存活动设置信息activity======="+activity);
			activityMapper.updateByPrimaryKeySelective(activity);
		}
	}

	@Override
	public ArrayList<ActivityTemplate> getActivityTemplateList(String tablePrefix) throws Exception {
		ActivityTemplateExample example = new ActivityTemplateExample();
		example.setTablePrefix(tablePrefix);
		
		return (ArrayList<ActivityTemplate>) activityTemplateMapper.selectByExample(example);
	}

	/**
	 * 获得活动已绑定的产品
	 */
	@Override
	public List<ProductActivity> getActivityBindProduct(Integer activityId,String tablePrefix) throws Exception {
		ProductActivityExample activityExample = new ProductActivityExample();
		activityExample.setTablePrefix(tablePrefix);
		activityExample.createCriteria().andActivityIdEqualTo(activityId);
		List<ProductActivity> productActivities = productActivityMapper.selectByExample(activityExample);
		for (ProductActivity productActivity : productActivities) {
			if (productActivity.getProductId() != null) {
				ProductBase productBase = productBaseMapper.selectByPrimaryKey(productActivity.getProductId().toString(), tablePrefix);
				if (productBase != null) {
					productActivity.setProductBase(productBase);
				}
			}
		}
		
		return productActivities;
	}

	/**
	 * 获得活动可绑定的产品
	 */
	@Override
	public List<ProductBase> activityCanBindProduct(String tablePrefix) throws Exception {
		ProductActivityExample activityExample = new ProductActivityExample();
		activityExample.setTablePrefix(tablePrefix);
		activityExample.createCriteria().andProductIdIsNotNull();
		List<ProductActivity> productActivities = productActivityMapper.selectByExample(activityExample);
		
		ProductBaseExample baseExample = new ProductBaseExample();
		baseExample.setTablePrefix(tablePrefix);
		Criteria criteria = baseExample.createCriteria();
		List<String> productIdList = new ArrayList<String>();
		if (productActivities != null && !productActivities.isEmpty()) {
			for (int i = 0; i < productActivities.size(); i++) {
				if (productActivities.get(i).getProductId() != null) {
					productIdList.add(productActivities.get(i).getProductId().toString());
				}
			}
			criteria.andProductIdNotIn(productIdList);
		}
		criteria.andStatusEqualTo(1);
		List<ProductBase> productBasesList = productBaseMapper.selectByExample(baseExample);
		return productBasesList;
	}

	/**
	 * 通过ID查询 已绑定产品
	 */
	@Override
	public ProductActivity getProductActivityById(Integer id, String tablePrefix) throws Exception {
		return productActivityMapper.selectByPrimaryKey(id, tablePrefix);
	}

	/**
	 * 删除产品关系表
	 */
	@Override
	public void removeProdcutActivityById(Integer id, String tablePrefix) throws Exception {
		logger.error("已删除产品关系信息productActivityId======="+id);
		productActivityMapper.deleteByPrimaryKey(id, tablePrefix);
	}

	/**
	 * 通过ID获取产品
	 */
	@Override
	public ProductBase getProductBaseById(Integer productId, String tablePrefix) throws Exception {
		return productBaseMapper.selectByPrimaryKey(productId.toString(), tablePrefix);
	}

	/**
	 * 活动第四步保存产品绑定关系
	 */
	@Override
	public void saveProductActivity(Integer activityId, String productIds, String tablePrefix, Integer accountId) throws Exception {
		if (null != productIds) {
			String[] pIds = null;
			pIds = productIds.split(",");
			for (String str : pIds) {
				ProductActivity productActivity = new ProductActivity();
				productActivity.setActivityId(activityId);
				productActivity.setCreateTime(new Date());
				productActivity.setCreateUserid(Integer.valueOf(accountId));
				productActivity.setProductId(Integer.valueOf(str));
				productActivity.setTablePrefix(tablePrefix);
				productActivity.setUpdateTime(new Date());
				productActivity.setUpdateUserid(activityId);
				logger.error("(活动第四步保存产品绑定关系)已保存产品关系信息productActivity======="+productActivity);
				productActivityMapper.insertSelective(productActivity);
			}
		}
	}

	@Override
	public boolean getActivityIsOpen(Integer activityId, String tablePrefix)
			throws Exception {
		
		Activity activity = getActivityById(activityId, tablePrefix);
		if(activity==null){
			return false;
		}
		if(activity.getIsOpen()!=null 
				&& activity.getIsOpen().intValue()==1){
			return true;
		}
		return false;
	}

	@Override
	public int updateActivityFirstPrizeId(int activityId, Integer firstPrizeId,
			String tablePrefix) throws Exception {
		return activityMapper.updateActivityFirstPrizeId(activityId, firstPrizeId, tablePrefix);
	}

}
