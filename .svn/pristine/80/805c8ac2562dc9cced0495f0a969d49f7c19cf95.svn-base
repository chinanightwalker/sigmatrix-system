package com.sigmatrix.sc.web.controller.common;

import java.util.Map;
import java.util.UUID;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.sigmatrix.sc.web.global.CommonConstants;
import com.sigmatrix.sc.web.response.EnterpriseSearch;
import com.sigmatrix.sc.web.vo.AccountProfile;
import com.sigmatrix.sc.web.vo.Enterprise;


public abstract class BaseController extends MultiActionController {
	private static Logger logger = Logger.getLogger(BaseController.class);
	/**
	 * 返回页面前缀:WEB-INF/jsp/
	 * <br>
	 * 页面是在/WEB-INF/jsp/下的使用
	 */
	protected static String JSP_PREFIX = "WEB-INF/jsp/";
	
	 @Autowired
	  protected HttpServletResponse response;
	/**
	 * 获得session里存储的当前登录用户
	 * @param request
	 * @return
	 */
	public AccountProfile getSessionAccount(HttpServletRequest request){
		AccountProfile account = (AccountProfile) request.getSession().getAttribute(CommonConstants.CURR_ACCOUNT_INFO);
		return account;
	}
	/**
	 * 获得session里存储的当前企业
	 * @param request
	 * @return
	 */
	public Enterprise getSessionEnterprise(HttpServletRequest request){
		Enterprise enterprise = (Enterprise) request.getSession().getAttribute(CommonConstants.CURR_ENTERPRISE_INFO);
		return enterprise;
	}
	/**
	 * 从session中获得当前登录用户的useId
	 * @param request
	 * @return
	 */
	public Integer getSessionUserId(HttpServletRequest request){
		Integer userId = Integer.parseInt(request.getSession().getAttribute(CommonConstants.CURR_USERID).toString());
		return userId;
	}

	/**
	 * 获得公司前缀
	 * @return
	 */
	protected String getTablePrefix(HttpServletRequest request) {
		
		return "_" + getEnterpriseCode(request);
	}
	
	protected String getEnterpriseCode(HttpServletRequest request){
		return getSessionEnterprise(request).getCode();		
	}
	protected HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	
	/**
	 * 获得页面传递的当前页
	 * @param request
	 * @return
	 */
	public Integer getPageNum(HttpServletRequest request){
		int num=1;
		String index=request.getParameter("pageNum");
		try {
			if(StringUtils.isNotBlank(index)){
				num=Integer.valueOf(index);
			}
		} catch (Exception e) {
			logger.error("getPageNum fail",e);
		}
		return num;
	}
}
