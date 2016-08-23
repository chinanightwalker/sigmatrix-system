package com.sigmatrix.sc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.dao.mapper.v1.auto.BarcodeALevelMapper;
import com.sigmatrix.sc.entity.v1.BarcodeALevel;
import com.sigmatrix.sc.entity.v1.BarcodeALevelExample;
import com.sigmatrix.sc.service.BarcodeALevelService;

/**
 * @Description: 一级单品码表
 * @author zzw
 * @date 2016年7月14日 下午2:41:36
 */
@Service
public class BarcodeALevelServiceImpl implements BarcodeALevelService {
	private static Logger logger1 = Logger.getLogger(BarcodeALevelServiceImpl.class);
	
	@Autowired
	private BarcodeALevelMapper barcodeALevelMapper;
	
    //根据一级码 或者输入码 查询一级码信息
    public BarcodeALevel getBarcodeALevel(String encryptBarcodeALevel,String inputCode,String tablePrefix) throws Exception{
		if(!StringUtils.isEmpty(encryptBarcodeALevel)){
			return this.getBarcodeALevelByACode(encryptBarcodeALevel,tablePrefix);//一级码查询
		}else if(!StringUtils.isEmpty(inputCode)){
			return this.getBarcodeALevelByInputCode(inputCode,tablePrefix);//输入码查询
		}else{
			return null;
		}
    }

    
    //根据一级码  查询一级码信息
    public BarcodeALevel getBarcodeALevelByACode(String encryptBarcodeALevel,String tablePrefix) throws Exception{
    	logger1.info("查询一级单品码表  _encrypt_barcode_a_level ="+encryptBarcodeALevel);
		if(StringUtils.isEmpty(encryptBarcodeALevel)){
			return null;
		}
		BarcodeALevel barcodeALevel = barcodeALevelMapper.selectByPrimaryKey(encryptBarcodeALevel,tablePrefix);//一级码查询
		logger1.info("查询一级单品码表返回  "+JSONObject.toJSONString(barcodeALevel));
		return barcodeALevel;
    }
    
    
    //根据输入码 查询一级码信息
    public BarcodeALevel getBarcodeALevelByInputCode(String inputCode,String tablePrefix) throws Exception{
    	logger1.info("查询一级单品码表  inputCode ="+inputCode);
    	if(StringUtils.isEmpty(inputCode)){
    		return null;
		}
		List<BarcodeALevel> list = null;
		BarcodeALevelExample example = new BarcodeALevelExample();
		com.sigmatrix.sc.entity.v1.BarcodeALevelExample.Criteria cia = example.createCriteria();
		cia.andInputCodeEqualTo(inputCode);//输入码
		list = barcodeALevelMapper.selectByExample(example);
		logger1.info("查询一级单品码表返回  "+JSONObject.toJSONString(list));
		if(!CollectionUtils.isEmpty(list) && null!=list.get(0)){
			return list.get(0);
		}
		return null;
    }


	@Override
	public BarcodeALevel getBarcodeALevelById(String encryptBarcodeALevel, String tablePrefix)
			throws Exception {
		// TODO Auto-generated method stub
		return barcodeALevelMapper.selectByPrimaryKey(encryptBarcodeALevel, tablePrefix);
	}

}
