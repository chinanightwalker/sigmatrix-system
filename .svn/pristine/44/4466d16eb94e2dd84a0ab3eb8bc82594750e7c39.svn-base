package com.sigmatrix.sc.service;
import com.sigmatrix.sc.entity.v1.Settings;
import com.sigmatrix.sc.page.PageBean;

//系统设置表
public interface SettingsService {
	
	//根据key查询系统信息
    public Settings getSettingsByKey(String key,Integer status);
    //根据key查询value值
    public String getValueByKey(String key,Integer status);
    //系统配置管理-查询
	public PageBean<Settings> selectSettingsList(PageBean<Settings> page, Settings settings) throws Exception;
	//根据id 查询系统配置信息
	public Settings getSettingsById(Integer settingId, String tablePrefix) throws Exception;
	//根据id 删除系统信息 假删除 时为更新status
	public int updataSettingsbyId(Settings settings) throws Exception;
	//系统配置管理-增加保存
	public int insertSelective(Settings settings) throws Exception;
	//系统配置管理-修改保存
	public int updataSelective(Settings settings) throws Exception;
}
