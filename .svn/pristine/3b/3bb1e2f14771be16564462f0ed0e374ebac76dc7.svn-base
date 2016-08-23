package com.sigmatrix.sc.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sigmatrix.sc.dao.mapper.v1.auto.SettingsMapper;
import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.entity.v1.ActivityTemplateExample;
import com.sigmatrix.sc.entity.v1.Settings;
import com.sigmatrix.sc.entity.v1.SettingsExample;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.page.PageBeanUtil;
import com.sigmatrix.sc.service.SettingsService;

//系统设置表
@Service
public class SettingsServiceImpl implements SettingsService {
	
	private static Logger logger1 = Logger.getLogger(SettingsServiceImpl.class);
	
	@Autowired
	private SettingsMapper settingsMapper;
	
    //根据key查询系统信息
    public Settings getSettingsByKey(String key,Integer status){
    	logger1.info("query Settings by key,key="+key+" status="+status);
    	if(null == key){
    		return null;
    	}
		SettingsExample example = new SettingsExample();
		SettingsExample.Criteria cia = example.createCriteria();
		cia.andKeyEqualTo(key);
		cia.andStatusEqualTo(status);//状态 0删除1正常
		 List<Settings> list = settingsMapper.selectByExample(example);
		logger1.info("query Settings return "+JSONObject.toJSONString(list));
		if (!CollectionUtils.isEmpty(list) && null != list.get(0)){
			return list.get(0);
		}
		return null;
    }

    //根据key查询value值
	public String getValueByKey(String key, Integer status) {
		Settings s = this.getSettingsByKey(key, status);
		if(null != s){
			return s.getValue();
		}
		return null;
	}

	@Override
	public PageBean<Settings> selectSettingsList(PageBean<Settings> page, Settings settings)
			throws Exception {
		SettingsExample exa =new SettingsExample();
		exa.setTablePrefix(settings.getTablePrefix());	
			if (StringUtils.isNotBlank(settings.getName())) {
				exa.createCriteria().andNameLike("%" + settings.getName() + "%");
			}
			if (StringUtils.isNotBlank(settings.getKey())) {
				exa.createCriteria().andKeyLike("%" + settings.getKey() + "%");
			}
			exa.createCriteria().andStatusEqualTo( settings.getStatus());

		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		return PageBeanUtil.toPagedResult(settingsMapper.selectByExample(exa));
	}

	@Override
	public Settings getSettingsById(Integer settingId, String tablePrefix) throws Exception {
		if(null == settingId){
			return null;
		}
		Settings settings =settingsMapper.selectByPrimaryKey(settingId,tablePrefix);
		logger1.info("查询活动模板返回 "+JSONObject.toJSONString(settings));
		return settings;
	}

	@Override
	public int updataSettingsbyId(Settings settings) throws Exception{
		return settingsMapper.updateByPrimaryKeySelective(settings);	
	}

	@Override
	public int insertSelective(Settings settings) throws Exception {
		return settingsMapper.insertSelective(settings);
	}

	@Override
	public int updataSelective(Settings settings) throws Exception {
		return settingsMapper.updateByPrimaryKeySelective(settings);
	}
    
}
