package com.sigmatrix.sc.service;

import com.sigmatrix.sc.entity.v1.BarcodeBLevel;
import com.sigmatrix.sc.page.PageBean;

public interface BarcodeBLevelService {
    //根据箱码查询箱码信息
    public BarcodeBLevel getBarcodeBLevelByBCode(String bCode,String tablePrefix) throws Exception;

	public PageBean<BarcodeBLevel> getBarcodeBLeveLList(PageBean<BarcodeBLevel> page, BarcodeBLevel barcodeBLevel,
			String startDateStr, String endDateStr) throws Exception;
    

}