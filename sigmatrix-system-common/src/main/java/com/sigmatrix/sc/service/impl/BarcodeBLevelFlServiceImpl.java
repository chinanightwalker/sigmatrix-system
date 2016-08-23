package com.sigmatrix.sc.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.BarcodeBLevelFlMapper;
import com.sigmatrix.sc.dao.mapper.v1.auto.BarcodeFlActiveInfoMapper;
import com.sigmatrix.sc.entity.v1.BarcodeBLevelFl;
import com.sigmatrix.sc.entity.v1.BarcodeBLevelFlExample;
import com.sigmatrix.sc.entity.v1.BarcodeFlActiveInfo;
import com.sigmatrix.sc.entity.v1.BarcodeFlActiveInfoExample;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.BarcodeBLevelFlService;
import com.sigmatrix.sc.utils.DateUtil;

@Service
public class BarcodeBLevelFlServiceImpl implements BarcodeBLevelFlService {
	private static Logger logger1 = Logger.getLogger(BarcodeBLevelFlServiceImpl.class);

	@Autowired
	private BarcodeBLevelFlMapper barcodeBlevelFlMapper;

	@Autowired
	private BarcodeFlActiveInfoMapper barcodeFlActiveInfoMapper;

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
	public BarcodeBLevelFl getBarcodeBlevelFl(String encryptBarcodeBLevelFl, String tablePrefix) throws Exception {
		logger1.info("查询辅料箱码表 _barcode_b_level_fl encryptBarcodeBLevelFl=" + encryptBarcodeBLevelFl);
		if (null == encryptBarcodeBLevelFl) {
			return null;
		}
		BarcodeBLevelFl barcodeBlevelFl = barcodeBlevelFlMapper.selectByPrimaryKey(encryptBarcodeBLevelFl, tablePrefix);
		logger1.info("查询辅料箱码表表返回 _barcode_b_level_fl " + JSONObject.toJSONString(barcodeBlevelFl));
		return barcodeBlevelFl;
	}

	@Override
	public PageBean<BarcodeFlActiveInfo> getBarcodeFlList(PageBean<BarcodeFlActiveInfo> page,
			BarcodeFlActiveInfo barcodeBLevelFlInfo, String startDateStr, String endDateStr) throws Exception {
		BarcodeFlActiveInfoExample barcodeFlActiveInfoExample = new BarcodeFlActiveInfoExample();
		barcodeFlActiveInfoExample.setTablePrefix(barcodeBLevelFlInfo.getTablePrefix());
		Date startDate = null;
		Date endDate = null;
		if (startDateStr != null && !startDateStr.equals("")) {
			startDate = DateUtil.getDate(startDateStr + " 00:00:00");
		}
		if (endDateStr != null && !endDateStr.equals("")) {
			endDate = DateUtil.getDate(endDateStr + " 23:59:59");
		}
		if (startDate != null && endDate != null) {
			barcodeFlActiveInfoExample.createCriteria().andAvtivateTimeBetween(startDate, endDate);
		} else if (startDate != null && endDate == null) {
			endDate = new Date();
			barcodeFlActiveInfoExample.createCriteria().andAvtivateTimeBetween(startDate, endDate);
		} else if (startDate == null && endDate != null) {
			startDate = DateUtil.getDate("1970-01-01 00:00:00");
			barcodeFlActiveInfoExample.createCriteria().andAvtivateTimeBetween(startDate, endDate);
		}
		if (barcodeBLevelFlInfo != null) {
			// 批次号查询 plancode 激活人员username"
			if (StringUtils.isNotBlank(barcodeBLevelFlInfo.getPlancode())) {
				barcodeFlActiveInfoExample.createCriteria().andPlancodeLike(barcodeBLevelFlInfo.getPlancode());
			}
			if (StringUtils.isNotBlank(barcodeBLevelFlInfo.getUsername())) {
				barcodeFlActiveInfoExample.createCriteria()
						.andUsernameLike("%" + barcodeBLevelFlInfo.getUsername() + "%");
			}

		}
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		barcodeFlActiveInfoExample.setOrderByClause("_avtivate_time DESC ");
		return PageBeanUtil.toPagedResult(barcodeFlActiveInfoMapper.selectByExample(barcodeFlActiveInfoExample));
	}

	@Override
	public PageBean<BarcodeFlActiveInfo> getBarcodeFlList(PageBean<BarcodeFlActiveInfo> page, Integer activateStatus,
			String tablePrefix) {
		BarcodeFlActiveInfoExample barcodeFlActiveInfoExample=new BarcodeFlActiveInfoExample();
		barcodeFlActiveInfoExample.setTablePrefix(tablePrefix);
		barcodeFlActiveInfoExample.createCriteria().andActivateStatusEqualTo(activateStatus);
		return PageBeanUtil.toPagedResult(barcodeFlActiveInfoMapper.selectByExample(barcodeFlActiveInfoExample));
	}

}
