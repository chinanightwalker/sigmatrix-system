package com.sigmatrix.sc.web.shiro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.sigmatrix.sc.service.ActivityService;
import com.sigmatrix.sc.service.impl.AppDefineInitServiceImpl;
import com.sigmatrix.sc.utils.HttpClientUtil;
import com.sigmatrix.sc.web.global.CommonConstants;
import com.sigmatrix.sc.web.global.UserCenterPortConstants;
import com.sigmatrix.sc.web.response.AuthcToAuthorityMiddle;
import com.sigmatrix.sc.web.response.EnterpriseSearch;
import com.sigmatrix.sc.web.vo.Enterprise;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private HttpServletRequest request;
  /**
   * 授权方法,当请求要访问的目标（可以是个按钮，也可以是个方法）是要被授权才能访问的（按钮需要用shiro标签库包起来，方法需要用shiro注解），那么shiro会自动回调此方法
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	  SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	  //之前登录成功后，保存的对象，可以从此方法中获取
	  AuthcToAuthorityMiddle userInfo = (AuthcToAuthorityMiddle) principals.getPrimaryPrincipal();
//	  info.addStringPermission("*");
//	  info.addRole("*");
	  //info.addRole(userInfo.getRoleList());
	  //info.addStringPermission(userInfo.getAuthList());
	  String roles = userInfo.getRoleList();
	  // 角色权限
	  if(StringUtils.isNotBlank(roles)&&!"*".equals(roles)){
		  String[] roleArray = roles.split(",");
		  for(String role:roleArray){
			  info.addRole(role);
		  }
	  }else{
		  info.addRole(roles);
	  }
	  // 资源权限
	  String auths = userInfo.getAuthList();
	  if(StringUtils.isNotBlank(auths)&&!"*".equals(auths)){
		  String[] authArray = auths.split(",");
		  for(String auth:authArray){
			  info.addStringPermission(auth);
		  }
	  }else{
		  info.addStringPermission(auths);
	  }
	  return info;
  }

  /**
   * 认证方法
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
    Map<String, Object> bodyMap = new HashMap<String, Object>();
    bodyMap.put("userName", token.getUsername());
    bodyMap.put("passWord", String.valueOf(token.getPassword()));
    List<NameValuePair> headerParams = new ArrayList<NameValuePair>();
    		
    headerParams.add(new BasicNameValuePair("appKey",UserCenterPortConstants.APPKEY));
    headerParams.add(new BasicNameValuePair("Content-Type","application/json"));
    headerParams.add(new BasicNameValuePair("Client-Type","web"));
    Enterprise eps = (Enterprise)request.getSession().getAttribute(CommonConstants.CURR_ENTERPRISE_INFO);
//    headerParams.add(new BasicNameValuePair("enterpriseCode","scld01"));//动态获取的
    headerParams.add(new BasicNameValuePair("enterpriseCode", eps.getCode()));//动态获取的
    // 调用户中心登录方法
    String userLoginUrl = AppDefineInitServiceImpl.userCenterBaseUrl + UserCenterPortConstants.ACCOUNT_AUTHORITY_PORT;
    //String responseStr = HttpClientUtil.postForInter("http://dev1.usercenter.v5q.cn:9001/sigmatrix-auth-server/authcToAuthority", JSONObject.toJSONString(bodyMap), headerParams);
    String responseStr = HttpClientUtil.postForInter(userLoginUrl, JSONObject.toJSONString(bodyMap), headerParams);
    JSONObject bodyJson = JSONObject.parseObject(responseStr);
    //00000表示登录成功
    if (StringUtils.equalsIgnoreCase("00000", bodyJson.getString("resultState"))) {
      AuthcToAuthorityMiddle userInfo = JSONObject.toJavaObject(bodyJson.getJSONObject("resultList"), AuthcToAuthorityMiddle.class);
      SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, token.getPassword(), getName());
      return authenticationInfo;
    }
    throw new AuthenticationException(bodyJson.getString("resultMsg"));
  }

  public void clearCachedAuthorizationInfo(String principal) {
    SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
    clearCachedAuthorizationInfo(principals);
  }
}
