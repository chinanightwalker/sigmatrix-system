package com.sigmatrix.sc.utils;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.github.pagehelper.StringUtil;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.global.WebConstants;
import com.sigmatrix.sc.svcEntity.res.QDOpenIDANDCookie;

public class OpenIDANDCookieUtil{
	private static Logger logger = Logger.getLogger("OpenIDANDCookieUtil");
	/**
	 * 获取微信授权
	 * @param request
	 * @param response
	 * @param thisUrl 回调url
	 * @param wexiUrl 微信授权url
	 * @param wxAccount 公众号
	 * @return
	 */
	public static QDOpenIDANDCookie getOpenIDANDCookie(HttpServletRequest request,HttpServletResponse response,String thisUrl,String wexiUrl,String wxAccount){
		// 判断openID 是否存在
		String openID = request.getParameter("openId");
		String status = request.getParameter("status"); // 0:拉取授权失败；1：拉取授权成功
		String createTime = request.getParameter("createTime");
		if(StringUtils.isEmpty(openID)){
			if(StringUtil.isNotEmpty(status)){
				if("0".equals(status)){ // 拉取授权失败
					logger.error("微信服务器返回授权失败。status="+status);
					QDOpenIDANDCookie qd = new QDOpenIDANDCookie();
					qd.setStatus(Integer.valueOf(status));
					qd.setCreateTime(DateUtil.formatStrToDate(createTime, DateUtil.YMDHMS));
					return qd;
				}
			}
			// 如果openID为空，则检查cookie中是否存在openID
			Cookie[] cookie = request.getCookies();
			if(cookie!=null && cookie.length>0){
				for(Cookie cook : cookie){
					if(cook!=null && cook.getName().equals(StateInfoEnum.CUSTOMER_COOKIE_OPENID.getRetInfo())){
						QDOpenIDANDCookie qd = new QDOpenIDANDCookie();
						try {
							openID = DESUtils.decrypt(cook.getValue());
							qd.setOpenID(openID);
							qd.setCreateTime(DateUtil.formatStrToDate(createTime, DateUtil.YMDHMS));
						} catch (Exception e) {
							logger.error("openID解密失败。"+e.getMessage());
							return null;
						}
						logger.info("cookie 中存在openID,openID="+qd.getOpenID());
						return qd;
					}
				}
			}
			// 如果openID为空，且cookie中不存在openID，则需要拉取授权，获得openID
			// 微信认证回调, 传入三个参数，微信公众号、授权范围、回调地址
			String url=null;
			QDOpenIDANDCookie qd = new QDOpenIDANDCookie();
			try {
				url = String.format(wexiUrl, wxAccount,WebConstants.SNSAPI_BASE,URLEncoder.encode(thisUrl, "utf-8"));
				logger.info("微信登陆授权回调地址："+url);
				System.out.println(url);
				qd.setUrl(url);
				qd.setCreateTime(DateUtil.formatStrToDate(createTime, DateUtil.YMDHMS));
			} catch (Exception e) {
				logger.error("url地址加密失败。"+e.getMessage());
				return null;
			}
			return qd;
		}
		// openID 不为空，说明已经拉取了授权
		else{
			// 将openID写入cookie
			try {
				CookieUtil.addCookie(response, StateInfoEnum.CUSTOMER_COOKIE_OPENID.getRetInfo(), DESUtils.encrypt(openID),5*365*24*60*60);
			} catch (Exception e) {
				logger.error("openID写入cookie时，加密失败。openID="+openID+",错误消息："+e.getMessage());
			}
			QDOpenIDANDCookie qd = new QDOpenIDANDCookie();
			qd.setOpenID(openID);
			qd.setStatus(1); // 拉取授权成功
			qd.setCreateTime(DateUtil.formatStrToDate(createTime, DateUtil.YMDHMS));
			logger.info("openID授权成功，openID="+openID);
			return qd;
		}
	}
	
}