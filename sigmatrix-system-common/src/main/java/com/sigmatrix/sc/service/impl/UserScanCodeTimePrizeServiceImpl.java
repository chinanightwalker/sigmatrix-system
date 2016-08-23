package com.sigmatrix.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.UserScanCodeTimePrizeMapper;
import com.sigmatrix.sc.entity.v1.UserScanCodeTimePrize;
import com.sigmatrix.sc.entity.v1.UserScanCodeTimePrizeExample;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.UserScanCodeTimePrizeService;

@Service
public class UserScanCodeTimePrizeServiceImpl implements
		UserScanCodeTimePrizeService {
	@Autowired
	private UserScanCodeTimePrizeMapper userScanCodeTimePrizeMapper;

	@Override
	public List<UserScanCodeTimePrize> getPageUserScanCodeTimePrizeByExample(
			UserScanCodeTimePrize userScanCodeTimePrize) throws Exception {
		// TODO Auto-generated method stub
		UserScanCodeTimePrizeExample usctpe = new UserScanCodeTimePrizeExample();
		usctpe.setTablePrefix(userScanCodeTimePrize.getTablePrefix());
		UserScanCodeTimePrizeExample.Criteria criteria = usctpe.createCriteria();
		criteria.andStatusNotEqualTo(0);
		if (userScanCodeTimePrize.getScanTimePrizeName()!= null && !userScanCodeTimePrize.getScanTimePrizeName().equals("")) {
			criteria.andScanTimePrizeNameLike("%"+userScanCodeTimePrize.getScanTimePrizeName()+"%");
		}
			
		
		return userScanCodeTimePrizeMapper.selectByExample(usctpe);
	}

	@Override
	public UserScanCodeTimePrize getUserScanCodeTimePrizeBykey(
			Integer scanTimePrizeId, String tablePrefix) throws Exception {
		// TODO Auto-generated method stub
		return userScanCodeTimePrizeMapper.selectByPrimaryKey(scanTimePrizeId, tablePrefix);
	}

	@Override
	public void saveOrUpdateUserScanCodeTimePrize(UserScanCodeTimePrize usctp) throws Exception {
		// TODO Auto-generated method stub
		if(usctp.getScanTimePrizeId()==null){
			userScanCodeTimePrizeMapper.insertSelective(usctp);
		}else{
			userScanCodeTimePrizeMapper.updateByPrimaryKeySelective(usctp);
		}
	}

	//查询正常状态的所有奖项
	@Override
	public List<UserScanCodeTimePrize> getUserPrizeList(String tablePrefix) throws Exception {
		UserScanCodeTimePrizeExample usctpe = new UserScanCodeTimePrizeExample();
		usctpe.setTablePrefix(tablePrefix);
		UserScanCodeTimePrizeExample.Criteria criteria = usctpe.createCriteria();
		criteria.andStatusNotEqualTo(0);
		return userScanCodeTimePrizeMapper.selectByExample(usctpe);
	}

}
