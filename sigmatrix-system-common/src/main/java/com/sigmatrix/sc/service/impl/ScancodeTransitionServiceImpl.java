package com.sigmatrix.sc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ProductBaseMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.ScancodeTransitionMapper;
import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ProductBaseExample;
import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.entity.v1.ScancodeTransitionExample;
import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.ScancodeTransitionService;
import com.sigmatrix.sc.utils.DateUtil;
@Service
public class ScancodeTransitionServiceImpl implements ScancodeTransitionService {
	
	private static Logger logger1 = Logger.getLogger(ScancodeTransitionServiceImpl.class);

	@Autowired
	private ScancodeTransitionMapper scancodeTransitionMapper;
	@Autowired
	private ProductBaseMapper productBaseMapper;
	
	//查询过渡页
    public ScancodeTransition queryScanCodeTransition(Integer productId){
    	logger1.info("查询过渡页 productId="+productId);
		if(null == productId){
			return null;
		}
		List<ScancodeTransition> lists = null;
		ScancodeTransitionExample sctE = new ScancodeTransitionExample();
		sctE.setOrderByClause("_start_time DESC");
		com.sigmatrix.sc.entity.v1.ScancodeTransitionExample.Criteria sctEC = sctE.createCriteria();
		sctEC.andProductIdEqualTo(productId);
		sctEC.andStatusEqualTo(1);//_status 数据状态0删除1正常
		sctEC.andIsOpenEqualTo(1);//开关0 关闭， 1 开启
		lists = scancodeTransitionMapper.selectByExample(sctE);
		logger1.info("查询过渡页返回 "+JSONObject.toJSONString(lists));
		if(CollectionUtils.isEmpty(lists)){
			logger1.info("过渡页返回为空");
			return null;
		}
		for(ScancodeTransition sct:lists){
			String nowDateStatus = DateUtil.nowDateStatus(sct.getStartTime(), sct.getEndTime());//判断过渡页日期是否有效
			if(WebConstants.SCT_IS_RUNNING.equals(nowDateStatus)){//过渡页日期有效
				return sct;
			}
		}
		logger1.info("过渡页使用开始结束日期不在有效期内");
		return null;
    }

    //查询过渡页列表
	@Override
	public PageBean<ScancodeTransition> queryScanCodeTransitionList(PageBean<ScancodeTransition> page,
			ScancodeTransition transition) throws Exception{
		ScancodeTransitionExample exa = new ScancodeTransitionExample();
		exa.setTablePrefix(transition.getTablePrefix());
		exa.createCriteria().andStatusNotEqualTo(0);
		if(transition.getProductId() != null){
			exa.createCriteria().andProductIdEqualTo(transition.getProductId());
		}
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		List<ScancodeTransition> transitionList = scancodeTransitionMapper.selectByExample(exa);
		if (transitionList != null && !transitionList.isEmpty()) {
			Map<Integer, String> productMap = new HashMap<Integer, String>();
			for(ScancodeTransition item:transitionList){
				Integer productId = item.getProductId();
				if(productMap.containsKey(productId)){
					item.setProductName(productMap.get(productId));
				}else{
					ProductBase product = (ProductBase) productBaseMapper.selectByPrimaryKey(productId.toString(), transition.getTablePrefix());
					if(product!=null && product.getProductName() != null){
						item.setProductName(product.getProductName());
						productMap.put(productId, product.getProductName()); // 存入productMap
					}else{
						item.setProductName("");
					}
				}
			}
		}
		return PageBeanUtil.toPagedResult(transitionList);
	}

	//查询产品列表
	@Override
	public List<ProductBase> queryProductBaseList(String tablePrefix) throws Exception {
		ProductBaseExample exa = new ProductBaseExample();
		exa.setTablePrefix(tablePrefix);
		exa.createCriteria().andStatusNotEqualTo(0);
		List<ProductBase> productBaseList = productBaseMapper.selectByExample(exa);
		return productBaseList;
	}

	//查询过渡页
	@Override
	public ScancodeTransition queryScanCodeTransitionByTransitionId(Integer transitionId, String tablePrefix) throws Exception {
		logger1.info("查询过渡页 transitionId="+transitionId);
		if(null == transitionId){
			return null;
		}
		ScancodeTransition transition = scancodeTransitionMapper.selectByPrimaryKey(transitionId, tablePrefix);
		return transition;
	}

	//删除产品过渡页（状态置为0）
	@Override
	public void removeTransition(ScancodeTransition transition) throws Exception {
		transition.setStatus(0);
		logger1.info("删除产品过渡页（状态置为0） transition="+transition);
		scancodeTransitionMapper.updateByPrimaryKeySelective(transition);
	}

	//保存或修改产品过渡页
	@Override
	public void saveOrUpdateTransition(ScancodeTransition transition) throws Exception {
		if (transition.getTransitionId() == null) {
			logger1.info("保存或修改产品过渡页 transition="+transition);
			scancodeTransitionMapper.insertSelective(transition);
		}else {
			logger1.info("保存或修改产品过渡页 transition="+transition);
			scancodeTransitionMapper.updateByPrimaryKeySelective(transition);
		}
	}
	
}
