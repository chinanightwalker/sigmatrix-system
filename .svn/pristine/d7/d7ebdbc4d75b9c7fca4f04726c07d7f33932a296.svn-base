package com.sigmatrix.sc.web.controller;

import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.service.impl.AppDefineInitServiceImpl;
import com.sigmatrix.sc.utils.HttpClientUtil;
import com.sigmatrix.sc.utils.MD5Utils;
import com.sigmatrix.sc.web.controller.common.BaseController;
import com.sigmatrix.sc.web.global.CommonConstants;
import com.sigmatrix.sc.web.global.UserCenterPortConstants;
import com.sigmatrix.sc.web.response.AuthcToAuthorityMiddle;
import com.sigmatrix.sc.web.response.AuthcToAuthorityResult;
import com.sigmatrix.sc.web.response.EnterpriseSearch;
import com.sigmatrix.sc.web.vo.Enterprise;
import com.sigmatrix.sc.web.vo.MenuAuth;

@Controller
public class LoginController extends BaseController {

	private static Logger logger = Logger.getLogger(LoginController.class);
	public static Map<String, Enterprise> enterpriseCacheMap = new HashMap<String, Enterprise>();

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = "";
		JSONObject jsonObject = new JSONObject();
		System.out.println(request.getRequestURL());
		String str = "" + request.getRequestURL();
		String s = str.substring(str.indexOf("http://") + 7, str.indexOf("/login"));
		System.out.println(s);
		jsonObject.put("word", s);
		jsonObject.put("type", "0");
		String enterpriseInfo = AppDefineInitServiceImpl.userCenterBaseUrl
				+ UserCenterPortConstants.SINGLE_ENTERPRISE_INFO_PORT;
		String resultSearch = "";
		// 若是调用企业接口失败,则后续操作无法进行,所以必须跳入获取失败页面
		try {
			resultSearch = HttpClientUtil.post(enterpriseInfo, jsonObject.toString(), null);
			if(resultSearch==null){
				throw new Exception("用户中心调用企业接口超时等原因引起的异常，请检查");
			}
		}catch (Exception e) {
			logger.error("通过域名:" + (s == null ? "" : s) + "调用用户中心获取企业接口失败", e);
			return new ModelAndView(JSP_PREFIX + "common/getEnterpriseError", map);
		}
//		JSONObject jsonObjL = JSONObject.fromString(resultSearch);
		JSONObject jsonObjL = JSONObject.parseObject(resultSearch);
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", EnterpriseSearch.class);
		EnterpriseSearch er = new EnterpriseSearch();
//		er = (EnterpriseSearch) jsonObjL.toBean(jsonObjL, EnterpriseSearch.class, classMap);
		er = JSONObject.toJavaObject(jsonObjL, EnterpriseSearch.class);
		String resultState = er.getResultState();
		// 调用用户中心接口成功返回企业信息则存入session否则返回getEnterpriseError.jsp页面
		if (StringUtils.isNotBlank(resultState) && "00000".equals(resultState)) {
			if (er.getResultList()== null) {
				map.put("domain", s);
				return new ModelAndView(JSP_PREFIX + "common/noBoundDomainError", map);			
			}
			logger.debug("用户中心接口查询企业信息成功,返回信息：" + resultState);
			HttpSession session = request.getSession();
			// 将企业对象放入session
			session.setAttribute(CommonConstants.CURR_ENTERPRISE_INFO, er.getResultList());
		} else {
			logger.error("用户中心接口查询企业信息失败,返回信息：" + resultState);
			return new ModelAndView(JSP_PREFIX + "common/getEnterpriseError", map);
		}

		Integer rememberPwd = null; // 是否记住密码
		String loginNameTemp = null; // 登陆名
		String passwordTemp = null; // 登陆密码
		String coverPwd = ""; // 给用户显示的密码
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName() != null && cookie.getName().equals("loginName")) {
					try {
						loginNameTemp = URLDecoder.decode(cookie.getValue(), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else if (cookie.getName() != null && cookie.getName().equals("password")) {
					passwordTemp = cookie.getValue();
				} else if (cookie.getName() != null && cookie.getName().equals("rememberPwd")) {
					String rememberPwdTemp = cookie.getValue();
					if (rememberPwdTemp != null && rememberPwdTemp.length() > 0) {
						rememberPwd = Integer.parseInt(rememberPwdTemp);
					}
				} else if (cookie.getName() != null && cookie.getName().equals("coverPwd")) {
					coverPwd = cookie.getValue();
				}
			}
		}
		if (rememberPwd != null && rememberPwd == 1) {
			// 记住密码
			map.put("loginName", loginNameTemp);
			map.put("passWord", passwordTemp);
		} else {
			// 一般登录
			map.put("loginName", "");
		}
		map.put("rememberPwd", rememberPwd);
		map.put("coverPwd", coverPwd);
		return new ModelAndView(JSP_PREFIX + "login", map);
	}

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("menuAuthList", getMenuList());
		AuthcToAuthorityMiddle user = (AuthcToAuthorityMiddle) SecurityUtils.getSubject().getPrincipal();
		List<MenuAuth> menuAuthList = new ArrayList<MenuAuth>();
		// 获得菜单
		menuAuthList = user.getMenuList();
		Collections.sort(menuAuthList, new Comparator<MenuAuth>() {
			@Override
			public int compare(MenuAuth o1, MenuAuth o2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(o1.getWeight())-Integer.parseInt(o2.getWeight());
			}
		});

		map.put("menuAuthList",menuAuthList);
		return new ModelAndView("dwz/index", map);
	}

	@RequestMapping(value = "/submitLogin")
	public ModelAndView submitLogin(HttpServletRequest request) {
		// 验证码
		String authCode = "";
		if (request.getSession() != null) {
			authCode = request.getSession().getAttribute("authCode") == null ? ""
					: request.getSession().getAttribute("authCode").toString();
		}
		ModelAndView mav = new ModelAndView();
		String uname = request.getParameter("loginName");
		String pwd = request.getParameter("passWord");
		String pwdTem = pwd;
		String remeberPwd = request.getParameter("rememberPwd");
		// 如果用户选择记录密码，处理cookies。。。。。。

		if (null != remeberPwd && "1".equals(remeberPwd)) {

			Cookie cookie1 = new Cookie("loginName", uname);
			cookie1.setMaxAge(30 * 24 * 60 * 60);
			Cookie cookie2 = new Cookie("password", pwd);
			cookie2.setMaxAge(30 * 24 * 60 * 60);
			Cookie cookie3 = new Cookie("rememberPwd", remeberPwd);
			cookie3.setMaxAge(30 * 24 * 60 * 60);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			String coverPwd = "";
			for (int i = 0; i < pwd.length(); i++) {
				coverPwd += "*";
			}
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if (cookie.getName() != null && cookie.getName().equals("coverPwd")) {
						coverPwd = cookie.getValue();
					}
				}
			}
			Cookie cookie4 = new Cookie("coverPwd", coverPwd);
			cookie4.setMaxAge(30 * 24 * 60 * 60);
			response.addCookie(cookie4);
		} else {
			Cookie cookie1 = new Cookie("loginName", uname);
			cookie1.setMaxAge(30 * 24 * 60 * 60);
			Cookie cookie2 = new Cookie("password", "");
			cookie2.setMaxAge(0);
			Cookie cookie3 = new Cookie("rememberPwd", "");
			cookie3.setMaxAge(0);
			Cookie cookie4 = new Cookie("coverPwd", "");
			cookie4.setMaxAge(30 * 24 * 60 * 60);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.addCookie(cookie4);
		}
		String validCode = request.getParameter("validCode");
		if (validCode != null && authCode.equals(validCode)) {
			UsernamePasswordToken token = null;
			try {
				pwdTem = MD5Utils.GetMD5Code(pwd);
				Subject currentUser = SecurityUtils.getSubject();
				token = new UsernamePasswordToken(uname, pwdTem);
				List<MenuAuth> menuAuthList = new ArrayList<MenuAuth>();
				currentUser.login(token);
				// 从shiro中拿用户信息
				AuthcToAuthorityMiddle user = (AuthcToAuthorityMiddle) SecurityUtils.getSubject().getPrincipal();
				// 保存用户相关值userId，token，securityCode，nickname
				request.getSession().setAttribute(CommonConstants.CURR_USERID, user.getUserId());
				request.getSession().setAttribute(CommonConstants.CURR_TOKEN, user.getToken());
				request.getSession().setAttribute(CommonConstants.CURR_SECURITYCODE, user.getSecurityCode());
				request.getSession().setAttribute(CommonConstants.NICKNAME, user.getNickname());
				// 获得菜单
//				menuAuthList = user.getMenuList();
				// String nickname = user.getNickname();
				// 代表登录成功
				if (currentUser.isAuthenticated()) {
					request.getSession().removeAttribute("shiroLoginFailure");
					mav.setViewName("redirect:/index");
					

//					if (menuAuthList == null || menuAuthList.isEmpty()) {
//						menuAuthList = getMenuList();
//					}
//					mav.addObject("menuAuthList", menuAuthList);
					return mav;
				} 
				else {
					// 登录失败
					token.clear();
					mav.addObject("err","LOGIN_FAILURE");
					mav.setViewName("redirect:/login");
					return mav;
				}
			} catch (Exception e) {
				logger.error("登录异常："+e);
				if (token != null) {
					token.clear();
				}
				mav.addObject("err","LOGIN_FAILURE");
				mav.setViewName("redirect:/login");
				return mav;
			}
		} else if(validCode != null &&!authCode.equals(validCode)){

			// 验证码错误
			mav.addObject("err","CODE_FAILURE");
			mav.setViewName("redirect:/login");
			return mav;
		}else{
		mav.setViewName("redirect:/login");
		
		return mav;
		}
		
	}

	/**
	 * 获得菜单集合
	 * 
	 * @return
	 */
	private List<MenuAuth> getMenuList() { 

		String result1 = "{\"resultState\": \"00000\",\"resultMsg\":\"成功\",\"resultList\":{ \"tokenTimeout\":\"1469204228279\",\"userId\":1,\"nickname\":\"青岛啤酒管理员\",\"securityCode\":\"df2a7fc584fa0bda4afab734615b0e24b3598\",\"token\":\"2e7d4c1a51d0072744d261d000fb2ded\",\"roleList\":\"asdf,opiuio\",\"authList\":\"account:insert,account:update,account:search,role:*,information:*\","
				+ "\"menuList\":[{\"menuId\": 1,     \"menuName\":\"基础信息模块\",\"menuUrl\":\"\",\"parentMenuId\":\"0\",\"weight\":\"1\"},"
				+ "{\"menuId\": 2,\"menuName\":\"我的信息\",\"menuUrl\":\"account/profile\",\"parentMenuId\":\"1\",\"weight\":\"1\"},"

		+ "{\"menuId\": 3,\"menuName\":\"修改密码\",\"menuUrl\":\"account/chgPasswd\",\"parentMenuId\":\"1\",\"weight\":\"1\"},"

		+ "{\"menuId\": 4,\"menuName\":\"权限管理\",\"menuUrl\":\"permission/list\",\"parentMenuId\":\"1\",\"weight\":\"1\"},"
				+ "{\"menuId\": 5,\"menuName\":\"账户管理\",\"menuUrl\":\"account/list\",\"parentMenuId\":\"1\",\"weight\":\"1\"},"
				+ "{\"menuId\": 6,\"menuName\":\"资源管理\",\"menuUrl\":\"resource/list\",\"parentMenuId\":\"1\",\"weight\":\"1\"},"
				+ "{\"menuId\": 7,\"menuName\":\"角色管理\",\"menuUrl\":\"role/list\",\"parentMenuId\":\"1\",\"weight\":\"1\"},"

		+ "{\"menuId\":8,\"menuName\":\"产品管理\",\"menuUrl\":\"\",\"parentMenuId\":\"0\",\"weight\":\"1\"},"
				+ "{\"menuId\":9,\"menuName\":\"产品管理\",\"menuUrl\":\"product/list\",\"parentMenuId\":\"8\",\"weight\":\"1\"},"
				+ "{\"menuId\":10,\"menuName\":\"过渡页管理\",\"menuUrl\":\"productTransitionage/list\",\"parentMenuId\":\"8\",\"weight\":\"2\"},"
				+ "{\"menuId\": 11,\"menuName\":\"活动管理\",\"menuUrl\":\"\",\"parentMenuId\":\"0\",\"weight\":\"1\"},"
				+ "{\"menuId\": 12,\"menuName\":\"活动管理\",\"menuUrl\":\"activity/list\",\"parentMenuId\":\"11\",\"weight\":\"1\"},"
				//+ "{\"menuId\": 18,\"menuName\":\"奖项管理\",\"menuUrl\":\"prize/list\",\"parentMenuId\":\"11\",\"weight\":\"2\"},"
				+ "{\"menuId\": 13,\"menuName\":\"活动模板管理\",\"menuUrl\":\"ActivityTemplate/list\",\"parentMenuId\":\"11\",\"weight\":\"2\"},"
				+ "{\"menuId\": 14,\"menuName\":\"中奖信息\",\"menuUrl\":\"\",\"parentMenuId\":\"0\",\"weight\":\"1\"},"
				+ "{\"menuId\":15,\"menuName\":\"中奖信息查询\",\"menuUrl\":\"winningInformation/activelist\",\"parentMenuId\":\"14\",\"weight\":\"1\"},"
				+ "{\"menuId\":16,\"menuName\":\"系统配置管理\",\"menuUrl\":\"\",\"parentMenuId\":\"0\",\"weight\":\"1\"},"
				+ "{\"menuId\":17,\"menuName\":\"系统配置管理\",\"menuUrl\":\"settings/list\",\"parentMenuId\":\"16\",\"weight\":\"1\"}]}}";

//		JSONObject jsonObjL = JSONObject.fromString(result1);
		JSONObject jsonObjL = JSONObject.parseObject(result1);
		AuthcToAuthorityResult ator = new AuthcToAuthorityResult();
		AuthcToAuthorityMiddle resultList = null;
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", AuthcToAuthorityMiddle.class);
//		classMap.put("menuList", MenuAuth.class);
//		ator = (AuthcToAuthorityResult) jsonObjL.toBean(jsonObjL, AuthcToAuthorityResult.class, classMap);
		ator = JSONObject.toJavaObject(jsonObjL, AuthcToAuthorityResult.class);
		resultList = ator.getResultList();
		List<MenuAuth> menuAuthList = null;
		if (resultList != null) {
			menuAuthList = resultList.getMenuList();
			for (MenuAuth ma : menuAuthList) {
				System.out.println(ma.getMenuId());
			}
		}

		return menuAuthList;
	}

	/*
	 * 退出系统
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != getSession(request)) {
			HttpSession session = getSession(request);
			session.removeAttribute(CommonConstants.CURR_ENTERPRISE_INFO);
			session.removeAttribute(CommonConstants.CURR_USERID);
			session.removeAttribute(CommonConstants.CURR_ACCOUNT_INFO);
			session.removeAttribute(CommonConstants.CURR_SECURITYCODE);
			session.removeAttribute(CommonConstants.CURR_TOKEN);
			session.removeAttribute(CommonConstants.NICKNAME);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/login");
		return mav;

	}

}
