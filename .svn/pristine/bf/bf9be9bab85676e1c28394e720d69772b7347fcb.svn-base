package com.sigmatrix.sc.web.controller.usercenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.global.StateInfoEnum;
import com.sigmatrix.sc.page.PageBean;
import com.sigmatrix.sc.service.impl.AppDefineInitServiceImpl;
import com.sigmatrix.sc.utils.HttpClientUtil;
import com.sigmatrix.sc.utils.JsonEdit;
import com.sigmatrix.sc.utils.MD5Utils;
import com.sigmatrix.sc.web.controller.common.BaseController;
import com.sigmatrix.sc.web.global.CommonConstants;
import com.sigmatrix.sc.web.global.UserCenterPortConstants;
import com.sigmatrix.sc.web.response.AccountResult;
import com.sigmatrix.sc.web.response.AccountRoleResult;
import com.sigmatrix.sc.web.response.AccountSearchResult;
import com.sigmatrix.sc.web.response.CommonUserResponse;
import com.sigmatrix.sc.web.response.RoleSearchResult;
import com.sigmatrix.sc.web.vo.AccountAddVo;
import com.sigmatrix.sc.web.vo.AccountAddVoPo;
import com.sigmatrix.sc.web.vo.AccountSearch;
import com.sigmatrix.sc.web.vo.AccountSearchMiddle;
import com.sigmatrix.sc.web.vo.AccountUpdateVo;
import com.sigmatrix.sc.web.vo.AccountUpdateVoPo;
import com.sigmatrix.sc.web.vo.Role;


/** 
 * @author  zln:
 * @date 创建时间：2016年7月23日 下午12:59:44 
 * @parameter   
 * @return 
 */
@Controller
@RequestMapping(value="/account")
public class AccountController extends BaseController {
	private static Logger logger = Logger.getLogger(AccountController.class);
	
	
	@RequestMapping(value = "/list")
	public ModelAndView list(AccountSearch account, HttpServletRequest request){
		String userName = request.getParameter("userName");
		String roleId = request.getParameter("roleId");
		PageBean<AccountSearch> page = new PageBean<AccountSearch>(getPageNum(request));
		JSONObject jb = new JSONObject();
		jb.put("userName",userName);
		jb.put("roleId",roleId);	
		jb.put("pageNum",page.getPageNo());
		jb.put("pageSize",page.getPageSize());
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
	    String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ACCOUNT_CHGPWD;
	    List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		String accountUrl = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ACCOUNT_SEARCH;
		String accountInfo = HttpClientUtil.postForInter(accountUrl,jb.toString(),headerParams);
		JSONObject bodyJson = JSONObject.parseObject(accountInfo);
		Map <String,Object> map = new HashMap<String,Object>();
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", AccountSearchMiddle.class);
//		classMap.put("accountList", AccountSearch.class);	
		AccountSearchResult asr = new AccountSearchResult();
		
		AccountSearchMiddle asm = new AccountSearchMiddle();
		List<AccountSearch> accountList = new ArrayList<AccountSearch>();
//		asr = (AccountSearchResult)bodyJson.toBean(bodyJson, AccountSearchResult.class, classMap);
		asr = JSONObject.toJavaObject(bodyJson, AccountSearchResult.class);
		    if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){
		    	asm = asr.getResultList();
		    	page.setTotal(Long.parseLong(asm.getTotalCount()));
		    	accountList = asm.getAccountList();
		    	map.put("list",accountList);
		    	map.put("userName",userName);
		    	map.put("roleId",roleId);
		    	map.put("page",page);
		    	//map.put("roleId",roleId);
		    	return	new ModelAndView(JSP_PREFIX+"account/list",map);
		    }else {
		    	
		    }
	    
		
		
		return new ModelAndView();
	}
	
	
	/*
	 * 添加用户信息
	 */
	@RequestMapping(value = "/add")
	@RequiresPermissions("account:insert")
	public ModelAndView add(HttpServletRequest request){
		
//		List<NameValuePair> bodyParams = new ArrayList<NameValuePair>();
//		bodyParams.add(BasicNameValuePair("name",""));
		JSONObject jb = new JSONObject();
		jb.put("name", "");
		String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ROLE_SEARCH;
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		String info = HttpClientUtil.post(url,jb.toString(),headerParams);
		//JSONObject bodyJson = JSONObject.fromString(info);
		JSONObject bodyJson = JSONObject.parseObject(info);
		RoleSearchResult roleSearchResult = new RoleSearchResult();
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", Role.class);
//		roleSearchResult = (RoleSearchResult) bodyJson.toBean(bodyJson, RoleSearchResult.class,classMap);
		roleSearchResult = JSONObject.toJavaObject(bodyJson, RoleSearchResult.class);
		List<Role> roleList = new ArrayList<Role>();
		roleList = roleSearchResult.getResultList();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rolesList",roleList);
		return new ModelAndView(JSP_PREFIX+"account/addAccount",map);
	}
	
	/*
	 * 修改用户信息
	 */
	@RequestMapping(value = "/edit")
	@RequiresPermissions(value="account:update")
	public ModelAndView edit(HttpServletRequest request){
		//查询所有角色
		JSONObject jb = new JSONObject();
		jb.put("name", "");
		String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ROLE_SEARCH;
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		String info = HttpClientUtil.post(url,jb.toString(),headerParams);
//		JSONObject bodyJson = JSONObject.fromString(info);
		JSONObject bodyJson = JSONObject.parseObject(info);
		RoleSearchResult roleSearchResult = new RoleSearchResult();
//		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("resultList", Role.class);
//		roleSearchResult = (RoleSearchResult) bodyJson.toBean(bodyJson, RoleSearchResult.class,classMap);
		roleSearchResult = JSONObject.toJavaObject(bodyJson, RoleSearchResult.class);
		List<Role> roleList = new ArrayList<Role>();
		roleList = roleSearchResult.getResultList();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rolesList",roleList);
		
		
		//根据用户ID查询角色
		List<NameValuePair> bodyParams = new ArrayList<NameValuePair>();
		bodyParams.add(new BasicNameValuePair("name",""));
		String id = request.getParameter("id");
		String urlAccountRole = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ACCOUNT_GETROLES;
		String infoAccountRole = HttpClientUtil.sendget(urlAccountRole,Integer.parseInt(id),headerParams);
//		JSONObject infoAccountRoleJson = JSONObject.fromString(infoAccountRole);
		JSONObject infoAccountRoleJson = JSONObject.parseObject(infoAccountRole);
		AccountRoleResult arr = new AccountRoleResult();
//		Map<String, Class> classMapAccount = new HashMap<String, Class>();
//		arr = (AccountRoleResult) infoAccountRoleJson.toBean(infoAccountRoleJson, AccountRoleResult.class,classMap);
		arr = JSONObject.toJavaObject(infoAccountRoleJson, AccountRoleResult.class);
		List<Role> rList = new ArrayList<Role>();
		rList = arr.getResultList();
//		String rols = arr.getResultList();
//		String rols = infoAccountRoleJson.getString("resultList");
		List<String> roleIds = new ArrayList<String>();
		if(rList!=null && rList.size()>0){
//			String[] roles = rols.split(",");
			for(Role r:rList){		
			          roleIds.add(String.valueOf(r.getId()));

			}
		}
		
//		RoleSearchResult roleSearchResultAccount = new RoleSearchResult();
//		Map<String, Class> classMapAccount = new HashMap<String, Class>();
//		classMap.put("resultList", Role.class);
//		roleSearchResult = (RoleSearchResult) infoAccountRoleJson.toBean(infoAccountRoleJson, RoleSearchResult.class,classMap);
//		List<Role> roleListAccount = new ArrayList<Role>();
//		roleListAccount = roleSearchResult.getResultList();
//		List<Integer> roleIds = new ArrayList<Integer>();
//		for(int i=0; i<roleListAccount.size();i++){
//			roleIds.add(Integer.parseInt(roleListAccount.get(i).getId())) ;
//		}
		
//		map.put("rolesListAccount",roleListAccount);
		StringBuffer sb = new StringBuffer();		
		for(Role r:roleList){
			if(roleIds.contains(r.getId())){
				sb.append("<input type='checkbox' name='roles' value='"+r.getId() + "' checked='checked'>"+r.getName());
			}else{
				sb.append("<input type='checkbox' name='roles' value='"+r.getId() + "' >"+r.getName());
			}							
		}
		
		map.put("roleBox",sb.toString());
		
		
		//根据id查询用户
		String accountId = request.getParameter("id");
		String urlAccountSingle = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ACCOUNT_GETACCOUNT;
		String infoAccountSingle = HttpClientUtil.sendget(urlAccountSingle,Integer.parseInt(accountId),headerParams);
//		JSONObject jj = JSONObject.fromString(infoAccountSingle);
		JSONObject jj = JSONObject.parseObject(infoAccountSingle);
		AccountResult ar = new AccountResult();
//		Map<String, Class> mapAccount = new HashMap<String, Class>();
//		classMap.put("resultList", AccountSearch.class);
//		ar = (AccountResult) jj.toBean(jj, AccountResult.class,mapAccount);
		ar = JSONObject.toJavaObject(jj, AccountResult.class);
		map.put("account",ar.getResultList());
		return new ModelAndView(JSP_PREFIX+"account/updateAccount",map);
	}


	/*
	 * 添加用户保存
	 */
	@RequestMapping(value = "/save")
	public @ResponseBody JsonEdit save(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		String userName = request.getParameter("userName");
		String mobilePhoneNumber = request.getParameter("mobilePhoneNumber");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		String admin = "false";//request.getParameter("admin");
		String[] roleBox = request.getParameterValues("roles");
		StringBuffer roleStr = new StringBuffer();
		AccountAddVo advo = new AccountAddVo();
		AccountAddVoPo accountSearch = new AccountAddVoPo();
		accountSearch.setUserName(userName);
		accountSearch.setMobilePhoneNumber(mobilePhoneNumber);
		accountSearch.setPassword(MD5Utils.GetMD5Code(password));
		accountSearch.setNickname(nickname);
		accountSearch.setEmail(email);
		accountSearch.setStatus(status);
		accountSearch.setAdmin(admin);
		if(roleBox!=null && roleBox.length>0){
			for(int i=0 ; i<roleBox.length;i++){
				if(i!=roleBox.length-1 && roleBox.length>1){
					roleStr.append(roleBox[i]).append(",");
				}else{
					roleStr.append(roleBox[i]);
				}
			}			
		}
		advo.setRoleIds(roleStr.toString());
//		advo.setRoleIds("");
		advo.setAccount(accountSearch);
//		JSONObject jb =JSONObject.fromBean(advo);
		String jb = JSON.toJSONString(advo);
		String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ACCOUNT_ADD;
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		String accountInfo = HttpClientUtil.postForInter(url,jb.toString(),headerParams);
//		JSONObject bodyJson = JSONObject.fromString(accountInfo);
		JSONObject bodyJson = JSONObject.parseObject(accountInfo);
		
		if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){		
			return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "account/list");
		}else{
			return new JsonEdit("300",bodyJson.getString("resultMsg"),"","","","");
		}
		
	}
	
	/*
	 * 修改用户保存
	 */
	@RequestMapping(value = "/saveUpdate")
	public @ResponseBody JsonEdit saveUpdate(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String passwrodMd5 = request.getParameter("passwordMd5");
//		String userName = request.getParameter("userName");
		String mobilePhoneNumber = request.getParameter("mobilePhoneNumber");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		String admin = request.getParameter("admin");
		String[] roleBox = request.getParameterValues("roles");
		StringBuffer roleStr = new StringBuffer();
		AccountUpdateVo auvo = new AccountUpdateVo();
		AccountUpdateVoPo accountSearch = new AccountUpdateVoPo();
//		accountSearch.setUserName(userName);
		accountSearch.setMobilePhoneNumber(mobilePhoneNumber);
		if(StringUtils.isNotEmpty(password) && StringUtils.isNotBlank(password)){
			accountSearch.setPassword(MD5Utils.GetMD5Code(password));		
		}else{
			accountSearch.setPassword(passwrodMd5);
		}
		
		accountSearch.setNickname(nickname);
		accountSearch.setEmail(email);
		accountSearch.setStatus(status);
		accountSearch.setAdmin(admin);
		accountSearch.setId(id);
		if(roleBox!=null && roleBox.length>0){
			for(int i=0 ; i<roleBox.length;i++){
				if(i!=roleBox.length-1 && roleBox.length>1){
					roleStr.append(roleBox[i]).append(",");
				}else{
					roleStr.append(roleBox[i]);
				}
			}			
		}
		auvo.setRoleIds(roleStr.toString());
//		advo.setRoleIds("");
		auvo.setAccount(accountSearch);
//		JSONObject jb =JSONObject.fromBean(auvo);
		String jb =JSON.toJSONString(auvo);
		String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ACCOUNT_UPDATE;
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
		List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
		headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
		String accountInfo = HttpClientUtil.postForInter(url,jb.toString(),headerParams);
//		JSONObject bodyJson = JSONObject.fromString(accountInfo);
		JSONObject bodyJson = JSONObject.parseObject(accountInfo);
		
		if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){		
			return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "account/list");
		}else{
			return new JsonEdit("300",bodyJson.getString("resultMsg"),"","","","");
		}
		
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping(value="/remove")
	@RequiresPermissions(value="account:delete")
	public @ResponseBody JsonEdit remove(HttpServletRequest request){
		String id = request.getParameter("id");
		JSONObject bodyJson = new JSONObject();
		if (id!= null) {
			List<NameValuePair> bodyParams = new ArrayList<NameValuePair>();
			String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ACCOUNT_DELETE;
			String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
			String enterpriseCode = getEnterpriseCode(request);
			String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
			String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
			List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
		    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
		    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
		    headerParams.add(new BasicNameValuePair("Client-Type","web"));
		    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
		    headerParams.add(new BasicNameValuePair("userId",userid));
		    headerParams.add(new BasicNameValuePair("token",token));
		    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
			headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
			String info = HttpClientUtil.getForInter(url+id,bodyParams,headerParams);
//			bodyJson = JSONObject.fromString(info);
			bodyJson = JSONObject.parseObject(info);
			if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){		
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "account/list");
			}
		}
		return new JsonEdit("300",bodyJson.getString("resultMsg"),"","","","");
	}
	 /**
	   * 修改密码页面
	   * 
	   * @return
	   */
	  @RequestMapping(value = "/chgPasswd")
	  public ModelAndView chgPasswd(HttpServletRequest request) {
		  Map<String,Object> map=new HashMap<String, Object>();
		  return new ModelAndView(JSP_PREFIX+"account/ChgPasswd",map);
	  }
	  
	  /**
	   * 修改密码
	   * 
	   * @param request
	   * @return
	   */
	  @RequestMapping(value = "/savePasswd", method = RequestMethod.POST)
	  public @ResponseBody JsonEdit savePasswd(HttpServletRequest request) {

	    String oldPasswd = request.getParameter("oldPasswd");
	    String password = request.getParameter("password");
	    String confirmPwd = request.getParameter("confirmPwd");
	    
		String userid = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
		String enterpriseCode = getEnterpriseCode(request);
		String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
		String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);

	    String url = AppDefineInitServiceImpl.userCenterBaseUrl+UserCenterPortConstants.ACCOUNT_CHGPWD;
	    List<NameValuePair> headerParams = new ArrayList<NameValuePair>();		
	    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
	    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
	    headerParams.add(new BasicNameValuePair("Client-Type","web"));
	    headerParams.add(new BasicNameValuePair("enterpriseCode",enterpriseCode));
	    headerParams.add(new BasicNameValuePair("userId",userid));
	    headerParams.add(new BasicNameValuePair("token",token));
	    String signInfoTem = securityCode+UserCenterPortConstants.APPKEY+enterpriseCode+userid+token;
	    headerParams.add(new BasicNameValuePair("signInfo",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(signInfoTem)));
	    JSONObject jb = new JSONObject();
	    jb.put("pwd",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(oldPasswd));
	    jb.put("newPwd",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(password));
	    jb.put("confirmPwd",com.sigmatrix.sc.utils.MD5Utils.GetMD5Code(confirmPwd));
	    String responseStr = HttpClientUtil.postForInter(url, jb.toString(), headerParams);
//	    JSONObject bodyJson = JSONObject.fromString(responseStr);
	    JSONObject bodyJson = JSONObject.parseObject(responseStr);
	    if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))){
	    	return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "account/chgPasswd");
	    }else {
	    	return new JsonEdit(StateInfoEnum.DATA_FAILURE, "account/chgPasswd");
	    }
	  }
		/**
		 * 我的信息模块
		 */
		@RequestMapping(value = "/profile")
		public ModelAndView accountProfile(HttpServletRequest request) {
			Map<String, Object> map = new HashMap<String, Object>();
			AccountSearch account = new AccountSearch();
			String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
			String enterpriseCode = getEnterpriseCode(request);
			String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
			String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);
			String url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ACCOUNT_INFO_PORT;
			List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
			headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
			headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
			headerParams.add(new BasicNameValuePair("Client-Type", "web"));
			headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
			headerParams.add(new BasicNameValuePair("userId", userId));
			headerParams.add(new BasicNameValuePair("token", token));
			String signInfoTem = MD5Utils.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
			headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
			String accountInfo = HttpClientUtil.getForInterBody(url,headerParams);
			String ACCOUNT_GETROLES_URL=AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ACCOUNT_GETROLES;
			String accountRoleInfo=HttpClientUtil.sendget(ACCOUNT_GETROLES_URL,Integer.valueOf(userId), headerParams);

		//	System.out.println(accountInfo);
//			JSONObject json = JSONObject.fromString(accountInfo);
			JSONObject json = JSONObject.parseObject(accountInfo);
			JSONObject jsons=json.getJSONObject("resultList");
			System.out.println(jsons);
			String roles="";
			if (null != json.get("resultState") && "00000".equals(json.get("resultState"))) {
				logger.debug("获得当前登录用户信息成功");
				account.setId(jsons.getString("id"));
				account.setEmail(jsons.getString("email"));
				account.setMobilePhoneNumber(jsons.getString("mobilePhoneNumber"));
				account.setUserName(jsons.getString("userName"));
				account.setNickname(jsons.getString("nickname"));
				map.put("account", account);
				//判断是是否为超管和普通用户
				if(jsons.getString("admin").equals("true")){
					roles="管理员";
				}else{
					JSONObject jsonRole=JSONObject.parseObject(accountRoleInfo);					
					if(jsonRole.getJSONArray("resultList") !=null){
						if (null != json.get("resultState") && "00000".equals(json.get("resultState"))) {
							JSONArray RoleList =jsonRole.getJSONArray("resultList");
							for (int i = 0; i < RoleList.size(); i++) {
								JSONObject jsonro = JSONObject.parseObject(String.valueOf(RoleList.get(i)));
								System.out.println(jsonro);
								roles+=jsonro.getString("name")+"\t;";
							}}				
					}					
				}
				map.put("roles",roles);
			} else {
				logger.error("获得当前登录用户信息失败");
			}



			return new ModelAndView(JSP_PREFIX + "account/editAccount", map);
		}
		/**
		 * 修改、保存我的信息
		 * @param request
		 * @param account
		 * @return
		 */
		@RequestMapping(value="saveProfile")
		public @ResponseBody JsonEdit saveView(HttpServletRequest request,AccountSearch account) {
			System.out.println(account.getId()+"********"+account.getEmail());
			if(null!=account){
			String userId = (String) request.getSession().getAttribute(CommonConstants.CURR_USERID);
			String enterpriseCode = getEnterpriseCode(request);
			String token = (String) request.getSession().getAttribute(CommonConstants.CURR_TOKEN);
			String securityCode = (String) request.getSession().getAttribute(CommonConstants.CURR_SECURITYCODE);

			String url = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ACCOUNT_MODIFY_PORT;
			List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
			headerParams.add(new BasicNameValuePair("appKey", UserCenterPortConstants.APPKEY));
			headerParams.add(new BasicNameValuePair("Content-Type", "application/json"));
			headerParams.add(new BasicNameValuePair("Client-Type", "web"));
			headerParams.add(new BasicNameValuePair("enterpriseCode", enterpriseCode));
			headerParams.add(new BasicNameValuePair("userId", userId));
			headerParams.add(new BasicNameValuePair("token", token));
			String signInfoTem = MD5Utils.GetMD5Code(securityCode + UserCenterPortConstants.APPKEY + enterpriseCode + userId + token);
			headerParams.add(new BasicNameValuePair("signInfo", signInfoTem));
			JSONObject json = new JSONObject();
			json.put("email", account.getEmail());
			json.put("mobilePhoneNumber",account.getMobilePhoneNumber());
			json.put("nickname",account.getNickname());
			String responseStr = HttpClientUtil.postForInter(url,json.toString(), headerParams);
//			JSONObject bodyJson = JSONObject.fromString(responseStr);
			JSONObject bodyJson = JSONObject.parseObject(responseStr);
			if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))) {
				logger.debug("保存我的信息成功");
				return new JsonEdit(StateInfoEnum.DATA_SUCCESS, "account/profile");
			} else {
				logger.error("保存我的信息成功");
				return new JsonEdit(StateInfoEnum.DATA_FAILURE, "account/profile");
			}}
		   return new JsonEdit(StateInfoEnum.DATA_SUCCESS,"account/profile");
		}
		

		
}
