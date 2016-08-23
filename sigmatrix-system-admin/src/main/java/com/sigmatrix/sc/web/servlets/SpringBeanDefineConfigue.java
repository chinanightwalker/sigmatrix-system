package com.sigmatrix.sc.web.servlets;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.sigmatrix.sc.service.SpringBeanDefineService;

public class SpringBeanDefineConfigue implements ApplicationListener<ContextRefreshedEvent> {
	
	private SpringBeanDefineService appService;

	/**
	 * 当一个ApplicationContext被初始化或刷新触发
	 */
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
			if(appService != null){
				appService.initApplicationCacheData();
			}
        }  
	}

	public SpringBeanDefineService getAppService() {
		return appService;
	}

	public void setAppService(SpringBeanDefineService appService) {
		this.appService = appService;
	}
	
	
}
