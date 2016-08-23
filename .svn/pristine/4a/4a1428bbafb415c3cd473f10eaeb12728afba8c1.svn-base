package com.sigmatrix.sc.web.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.sigmatrix.sc.web.util.EnterpriseUtils;

/**
 * 系统初始化类
 * @author youjun
 *
 */
public class InitServlet implements ServletContextListener {
	private static Logger logger = Logger.getLogger(InitServlet.class);
	
	public static ServletContext context;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("系统初始化开始...");
		context = sce.getServletContext();
		
		// 初始化所有企业信息  
        //EnterpriseUtils.init();
		
		logger.info("系统初始化结束...");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}