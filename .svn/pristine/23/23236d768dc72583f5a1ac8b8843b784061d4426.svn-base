package com.sigmatrix.sc.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sigmatrix.sc.entity.v1.Settings;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.SettingsService;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.web.controller.activity.ActivityController;
import com.sigmatrix.sc.web.controller.common.BaseController;
@Controller
@RequestMapping(value = "/settings")
public class SettingsController extends BaseController {
	private static Logger logger = Logger.getLogger(SettingsController.class);
	@Autowired
	SettingsService settingsService;

	/**
	 * 系统配置管理-查询
	 */
	@RequestMapping(value = "/list")
	public ModelAndView SettingsList(HttpServletRequest request, Settings settings) {
		PageBean<Settings> page = new PageBean<>(getPageNum(request));
		settings.setTablePrefix(getTablePrefix(request));
		settings.setStatus(1);
		Map<String, Object> map = new HashMap<String, Object>();	
		try {
			page = settingsService.selectSettingsList(page, settings);
			logger.debug("select settingsList is success");
		} catch (Exception e) {
			logger.error("select settingsList is fail", e);
			e.printStackTrace();
		}
		map.put("page", page);
		map.put("settings", settings);
		logger.debug(map.toString());
		return new ModelAndView(JSP_PREFIX + "settings/list", map);
	}

	/**
	 * 系统配置管理-增加
	 */
	@RequestMapping(value = "/add")
    @RequiresPermissions("settings:insert")
	public ModelAndView addView() {
		ModelAndView mav = new ModelAndView(JSP_PREFIX + "settings/input");
		return mav;
	}

	/**
	 * 系统配置管理-修改
	 */
	@RequestMapping(value = "/edit")
	@RequiresPermissions("settings:update")
	public ModelAndView editView(Integer settingId,HttpServletRequest request) {
		Settings settings = new Settings();
		settings.setTablePrefix(getTablePrefix(request));
		ModelAndView mav = new ModelAndView(JSP_PREFIX + "settings/input");
		if (settingId != null) {
			try {
				settings = settingsService.getSettingsById(settingId, settings.getTablePrefix());
				logger.debug("by id selectsettings is success");
			} catch (Exception e) {
				logger.error("by id selectsettings is fail", e);
				e.printStackTrace();
			}
		}

		mav.addObject("settings", settings);
		return mav;

	}

	/**
	 * 系统配置管理-保存
	 */
	@RequestMapping(value = "/save")
	public @ResponseBody JsonEdit saveView(HttpServletRequest request, Settings settings) {
		settings.setTablePrefix(getTablePrefix(request));
		settings.setStatus(1);
				int i = 0;
				if (settings.getId() == null) {// 增加
					settings.setCreateTime(new Date());
					try {
						i = settingsService.insertSelective(settings);
						if (i > 0) {
							logger.debug("settings add is success");
							return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "settings/list");

						} else {
							logger.error("settings add is fail");
							return new JsonEdit(StateInfoEnum.DATA_FAILURE, "settings/add");

						}
					} catch (Exception e) {
						logger.error("settings add is fail", e);
						e.printStackTrace();
					}

				} else {// 修改更新
					settings.setUpdateTime(new Date());
					try {
						i = settingsService.updataSelective(settings);
						logger.debug("settings updata is success");
					} catch (Exception e) {
						logger.error("settings updata is fail", e);
						e.printStackTrace();
					}
				}

				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "settings/list");

	}

	/**
	 * 系统配置管理-删除
	 * 
	 * @param templateId
	 * @return
	 */
	@RequestMapping(value = "/delete{settingId}")
	@RequiresPermissions("settings:delete")
	public @ResponseBody JsonEdit deleteView(Integer settingId,HttpServletRequest request) {
		Settings settings = new Settings();
		settings.setTablePrefix(getTablePrefix(request));
		settings.setId(settingId);
		settings.setStatus(0);
		try {
			int i = settingsService.updataSettingsbyId(settings);
			if (i > 0) {
				logger.debug("Settings delete is success");
				new JsonEdit(StateInfoEnum.DATA_SUCCESS, "settings/list");
			}
		} catch (Exception e) {
			logger.error("settings delete is fail", e);
			e.printStackTrace();
		}
		return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "settings/list");
	}

}
