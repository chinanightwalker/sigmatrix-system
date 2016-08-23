package com.sigmatrix.sc.service;


import java.util.ArrayList;
import java.util.List;

import com.sigmatrix.sc.entity.v1.Activity;
import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.entity.v1.ProductActivity;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.page.PageBean;

public interface ActivityService {
	
	public PageBean<Activity> getPageActivityByExample(PageBean<Activity> page,Activity example) throws Exception;
	
	//根据活动ID查询活动信息
	public Activity getActivityById(Integer activtyId,String tablePrefix);
	
	/*//查询活动信息 抽奖使用
    public Activity getActivity(Integer activityId);*/
    
    /**
     * 根据活动id更新活动表部分值
     * @param activity 要更新的活动,必有属性:activityId、tablePrefix,其余属性凡是不为null都将更新
     * @throws Exception
     */
    public void updateByPrimaryKeySelective(Activity activity) throws Exception;
   //中奖信息查询活动列表分页 
    public PageBean<Activity> getPageActivityByExampleWinningInformation(PageBean<Activity> page,Activity example);
    /**
     * 根据活动id获得活动对象,若遇异常将抛出
     * @param activtyId 活动id
     * @param tablePrefix 表前缀
     * @return
     * @throws Exception
     */
    public Activity getActivityByActivityId(Integer activtyId,String tablePrefix) throws Exception;
    /**
     * 查询活动列表集(活动管理)
     * ZYC
     * @param activity
     * @return
     * @throws Exception
     */
	public List<Activity> getListActivityByExample(Activity activity) throws Exception;

	/**
	 * 删除活动（修改状态）
	 * @param activity
	 */
	public void deleteActivity(Activity activity) throws Exception;

	/**
	 * 保存活动设置
	 * @param activity
	 */
	public void saveActivity(Activity activity) throws Exception;

	/**
	 * 获得活动模板List
	 * @param tablePrefix
	 * @return
	 */
	public ArrayList<ActivityTemplate> getActivityTemplateList(String tablePrefix) throws Exception;

	/**
	 * 获得活动已绑定的产品
	 * @param activityId
	 * @return
	 */
	public List<ProductActivity> getActivityBindProduct(Integer activityId,String tablePrefix) throws Exception;

	/**
	 * 获得活动可绑定的产品
	 * @param activityId
	 * @return
	 */
	public List<ProductBase> activityCanBindProduct(String tablePrefix) throws Exception;

	/**
	 * 
	 * @param valueOf
	 * @param tablePrefix
	 * @return
	 */
	public ProductActivity getProductActivityById(Integer valueOf, String tablePrefix) throws Exception;

	/**
	 * 删除产品关系表
	 * @param id
	 */
	public void removeProdcutActivityById(Integer id, String tablePrefix) throws Exception;

	/**
	 * 通过ID获取产品
	 * @param productId
	 * @param tablePrefix
	 * @return
	 */
	public ProductBase getProductBaseById(Integer productId, String tablePrefix) throws Exception;

	/**
	 * 活动第四步保存产品绑定关系
	 * @param valueOf
	 * @param productIds
	 * @param tablePrefix
	 */
	public void saveProductActivity(Integer valueOf, String productIds, String tablePrefix, Integer accountId) throws Exception;
	/**
	 * 根据奖项id获得活动是否开启,当活动的属性isOpen为1时才为开启,其他情况一律为关闭,开启返回true,否则返回false
	 * @param activityId 活动id
	 * @param tablePrefix 表前缀
	 * @return 
	 * @throws Exception
	 */
	public boolean getActivityIsOpen(Integer activityId, String tablePrefix) throws Exception;
	/**
     * 更新活动的首次中奖奖项
     * @param activityId 活动id
     * @param firstPrizeId 首次中奖奖项id,可为null(即不设置)
     * @param tablePrefix 表前缀
	 */
	public int updateActivityFirstPrizeId(int activityId, Integer firstPrizeId,
			String tablePrefix) throws Exception;
}