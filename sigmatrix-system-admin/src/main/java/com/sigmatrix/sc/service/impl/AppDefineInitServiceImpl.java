package com.sigmatrix.sc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.service.SettingsService;
import com.sigmatrix.sc.service.SpringBeanDefineService;
import com.sigmatrix.sc.web.servlets.InitServlet;



/**
 * 系统启动时自动加载，把一些配置文件信息加入到ServletContext属性中
 */
public class AppDefineInitServiceImpl implements SpringBeanDefineService {
	

//	@Value("${COME_IN_BIDS_URL}")
//	private String COME_IN_BIDS_URL;
//	@Value("${wechat.addr}")
//	private String wechatAddr;
//	@Value("${wxAccount}")
//	private String wxAccount;
//	@Autowired
//	private SettingsService settingsService;
	
	//@Value("${usercenter.base.domian}")
	public static String userCenterBaseUrl; // 用户中心接口主域名,形如:http://www.baidu.com

	public void initApplicationCacheData() {
//		String servicePhone = settingsService.getValueByKey("servicePhone", 1);
//		InitServlet.context.setAttribute("servicePhone",servicePhone);//客服电话
//		WebConstants.DEFAULT_ACT_TEMP_PATH=WebConstants.GDXH_ACT_TEMP_PATH;
//		InitServlet.context.setAttribute("COME_IN_BIDS_URL",COME_IN_BIDS_URL);
//		InitServlet.context.setAttribute("wechatAddr",wechatAddr);
//		InitServlet.context.setAttribute("wxAccount",wxAccount);
		System.out.println(userCenterBaseUrl);
	}

	public static String getUserCenterBaseUrl() {
		return userCenterBaseUrl;
	}

	public static void setUserCenterBaseUrl(String userCenterBaseUrl) {
		AppDefineInitServiceImpl.userCenterBaseUrl = userCenterBaseUrl;
	}

}
