package com.sigmatrix.sc.service;

import com.sigmatrix.sc.entity.v1.CashCouponRecord;

public interface CashCouponRecordService {

	public CashCouponRecord getCashCouponRecord(String prizeOrderId, String tablePrefix) throws Exception;
	
}