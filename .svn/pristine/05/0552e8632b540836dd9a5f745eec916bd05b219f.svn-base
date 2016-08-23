package com.sigmatrix.sc.service;

import java.util.List;

import com.sigmatrix.sc.entity.v1.UserScanCodeTimePrize;

public interface UserScanCodeTimePrizeService {

	public List<UserScanCodeTimePrize> getPageUserScanCodeTimePrizeByExample(
			UserScanCodeTimePrize userScanCodeTimePrize) throws Exception;
	
	public UserScanCodeTimePrize getUserScanCodeTimePrizeBykey(Integer scanTimePrizeId,String tablePrefix) throws Exception;

	public void saveOrUpdateUserScanCodeTimePrize(UserScanCodeTimePrize usctp) throws Exception ;

	/**
	 * 查询正常状态的所有奖项
	 * @return
	 */
	public List<UserScanCodeTimePrize> getUserPrizeList(String tablePrefix) throws Exception;
	
}