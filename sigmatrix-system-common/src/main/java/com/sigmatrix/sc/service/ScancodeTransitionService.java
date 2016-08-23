package com.sigmatrix.sc.service;


import com.sigmatrix.sc.entity.v1.ProductBase;
import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.page.PageBean;

public interface ScancodeTransitionService {
	//查询过渡页
	public ScancodeTransition queryScanCodeTransition(Integer productId) throws Exception;
	//查询过渡页列表
	public PageBean<ScancodeTransition> queryScanCodeTransitionList(PageBean<ScancodeTransition> page,
			ScancodeTransition transition) throws Exception;
	//查询产品列表
	public java.util.List<ProductBase> queryProductBaseList(String tablePrefix) throws Exception;
	//查询过渡页
	public ScancodeTransition queryScanCodeTransitionByTransitionId(Integer id, String tablePrefix) throws Exception;
	//删除过渡页某一条
	public void removeTransition(ScancodeTransition transition) throws Exception;
	//保存或修改产品过渡页
	public void saveOrUpdateTransition(ScancodeTransition transition) throws Exception;
	
	
}