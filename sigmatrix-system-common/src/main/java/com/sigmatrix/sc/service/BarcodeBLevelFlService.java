package com.sigmatrix.sc.service;

import com.sigmatrix.sc.entity.v1.BarcodeBLevelFl;
import com.sigmatrix.sc.entity.v1.BarcodeFlActiveInfo;
import com.sigmatrix.sc.page.PageBean;

public interface BarcodeBLevelFlService {

	/**
	 * @Method: getBarcodeBlevelFl
	 * @Description: 根据辅料箱码Id查询辅料箱码信息
	 * @param encryptBarcodeBLevelFl
	 * @return
	 * @throws Exception
	 * @return BarcodeBLevelFl
	 * @author zzw
	 * @date 2016年7月14日 下午1:58:33
	 */
	public BarcodeBLevelFl getBarcodeBlevelFl(String encryptBarcodeBLevelFl, String tablePrefix) throws Exception;

	/**
	 * 辅料箱码查询 根据时间倒序
	 * 
	 * @param page
	 * @param barcodeBLevelFl
	 * @return
	 */
	public PageBean<BarcodeFlActiveInfo> getBarcodeFlList(PageBean<BarcodeFlActiveInfo> page,
			BarcodeFlActiveInfo barcodeBLevelFlInfo, String startDateStr, String endDateStr) throws Exception;

	/**
	 * 辅料项目激活成功 激活失败 激活重复的总数
	 * 
	 * @param page
	 * @return
	 */
	public PageBean<BarcodeFlActiveInfo> getBarcodeFlList(PageBean<BarcodeFlActiveInfo> page, Integer activateStatus,
			String tablePrefix);

}