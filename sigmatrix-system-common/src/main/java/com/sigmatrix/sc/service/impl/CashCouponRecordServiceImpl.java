package com.sigmatrix.sc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmatrix.sc.dao.mapper.v1.auto.CashCouponRecordMapper;
import com.sigmatrix.sc.entity.v1.CashCouponRecord;
import com.sigmatrix.sc.entity.v1.CashCouponRecordExample;
import com.sigmatrix.sc.service.CashCouponRecordService;

@Service
public class CashCouponRecordServiceImpl implements CashCouponRecordService {
	@Autowired
	private CashCouponRecordMapper cashCouponRecordMapper;
	@Override
	public CashCouponRecord getCashCouponRecord(String prizeOrderId,
			String tablePrefix) throws Exception {
		// TODO Auto-generated method stub
		List<CashCouponRecord> cashCouponRecordList = new ArrayList<CashCouponRecord>();
		CashCouponRecordExample ccre = new CashCouponRecordExample();
		ccre.setTablePrefix(tablePrefix);
		CashCouponRecordExample.Criteria criteria = ccre.createCriteria();
		criteria.andPrizeOrderIdEqualTo(prizeOrderId);	
		cashCouponRecordList = cashCouponRecordMapper.selectByExample(ccre);
		if(cashCouponRecordList!=null && cashCouponRecordList.size()>0){
			return cashCouponRecordList.get(0);
		}
		return null;
	}

}
